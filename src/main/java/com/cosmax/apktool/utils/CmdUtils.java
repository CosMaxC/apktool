package com.cosmax.apktool.utils;

import com.cosmax.apktool.entity.MessageStatus;
import com.cosmax.apktool.thread.CmdThread;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: apktool
 * @description: 调用cmd命令
 * @author: Cosmax
 * @create: 2020/11/24 19:07
 */
public class CmdUtils {

    private String invokePath = this.getClass().getClassLoader().getResource("d2j_invoke.bat").getPath();
    private String jdGuiPath = this.getClass().getClassLoader().getResource("jd-gui.exe").getPath();
    private String fileSeekPath = this.getClass().getClassLoader().getResource("FileSeek").getPath();

    private String mainPath;
    {
        try {
            mainPath = new File("").getCanonicalPath() + "/";
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static MessageStatus runbat(String batName) {
        String cmd = "cmd.exe /c "+batName;
//        String cmd = batName;
        try {
            Process process = Runtime.getRuntime().exec(cmd);
//            InputStream in = process.getInputStream();
//            while (in.read() != -1) {
//                System.out.println(in.read());
//            }
//            in.close();
            process.waitFor();
            return MessageStatus.success();
        }  catch (Exception e) {
            return MessageStatus.fail("cmdUtils error: " + e.getMessage());
        }
    }

    public MessageStatus dex2jar(String path) {
        if (!new File(path).exists()) {
            return MessageStatus.fail("文件不存在！");
        }
        String fileName = FilenameUtils.getBaseName(path) + "-dex2jar.jar";
        String dex2jarCmd = " com.googlecode.dex2jar.tools.Dex2jarCmd ";
        String cmdPath = invokePath + dex2jarCmd + path + " -f";
        MessageStatus runbat = runbat(cmdPath.substring(1));
        if (runbat.getCode() == 200){
            File mvSrcFile = new File(mainPath + fileName);
            String basePath = FilenameUtils.getFullPath(path) + "dex2jar/" + FilenameUtils.getBaseName(path) + ".jar";
            try {
                FileUtils.moveFile(mvSrcFile, new File(basePath));
                return MessageStatus.success("编译成功！");
            } catch (IOException e) {
                return MessageStatus.fail("cmdUtils error: " + e.getMessage());
            }
        }
        return MessageStatus.fail("失败");
    }

    private List<String> getSuffixList(String path, final String suffix) {
        File file = new File(path);
        if (!file.exists()) {
            return null;
        }
        File[] files = file.listFiles(pathname -> {
            if (pathname.isFile()) {
                String fileName = pathname.getName();
                return fileName.endsWith("." + suffix);
            }
            return false;
        });
        List<String> list = new ArrayList<>();
        if (files == null || files.length <= 0){
            return null;
        }
        for (File file1 : files) {
            list.add(file1.getAbsolutePath());
        }
        return list;
    }

    public MessageStatus apk2jar(String path) {
        StringBuilder message = new StringBuilder();
        File file = new File(path);
        if (file.isDirectory()){
            // 复制jd-gui到所在dex转出文件夹
            try {
                FileUtils.copyFileToDirectory(new File(jdGuiPath), new File(path + "/" + "dex2jar/"));

            } catch (IOException e) {
                MessageStatus.fail("复制jd-gui失败:" + e.toString());
            }
            // 复制jd-gui到所在dex转出文件夹
            try {
                FileUtils.copyDirectoryToDirectory(new File(fileSeekPath), new File(path + "/"));

            } catch (IOException e) {
                MessageStatus.fail("复制jd-gui失败:" + e.toString());
            }
            List<String> dexs = getSuffixList(path, "dex");
            for (String dex : dexs) {
                CmdThread cmdThread = new CmdThread(dex);
                Thread thread = new Thread(cmdThread);
                thread.start();
                while (cmdThread.getMessageStatus() == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignored) {

                    }
                }
                MessageStatus messageStatus = cmdThread.getMessageStatus();
                if (messageStatus.getCode() != 200){
                    message.append(messageStatus.getMessage()).append(";");
                }
            }
            return MessageStatus.success(message.toString());

        }else if (FilenameUtils.isExtension(path, "dex")) {
            return dex2jar(path);
        }else {
            return MessageStatus.fail("输入文件不是dex或含dex文件夹！");
        }

    }

}
