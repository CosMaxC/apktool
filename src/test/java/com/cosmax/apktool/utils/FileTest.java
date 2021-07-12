package com.cosmax.apktool.utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: apktool
 * @description:
 * @author: Cosmax
 * @create: 2020/12/08 11:18
 */
public class FileTest {

    @Test
    public void getFsb(){
        String path = "D:\\apk-break\\QuickBMS\\1";
        File docFiles = new File(path);
        if (!docFiles.exists()){
            System.out.println("文件不存在！");
        }
        String decryptPath = path + "\\decrypt";
        File decryptFiles = new File(decryptPath);
        if (!decryptFiles.exists()) {
            decryptFiles.mkdirs();
        }
        File[] files = docFiles.listFiles();
        List<File> docs = new ArrayList<>();
        for (File file : files) {
            if (file.isDirectory() && !file.getAbsolutePath().contains("decrypt")) {
                docs.add(file);
            }
        }

        File dlFile = new File("D:\\apk-break\\QuickBMS\\fmodL.dll");
        File fsbFile = new File("D:\\apk-break\\QuickBMS\\fsb_aud_extr.exe");



        docs.forEach(doc -> {
            try {
                FileUtils.copyFileToDirectory(dlFile, doc);
                FileUtils.copyFileToDirectory(fsbFile, doc);

                String absolutePath = doc.getAbsolutePath();
                String baseName = FilenameUtils.getBaseName(absolutePath);

                String cmd = absolutePath + "\\fsb_aud_extr.exe "
                        + absolutePath + "\\00000000.fsb";
                System.out.println("当前目录：" + absolutePath);
                printBuff(cmd);

                RmAllWav(baseName);

            } catch (IOException e) {
                System.out.println("复制错误：" + e );
            }
        });
    }

    private void RmAllWav(String preName){
        File file = new File("D:\\idea_workstation\\apktool");
        File[] files = file.listFiles();
        String fullPath = FilenameUtils.getFullPath("D:\\idea_workstation\\apktool");

        for (int i = 0; i < files.length; i++) {
            if (!files[i].isFile()){
                continue;
            }
            String absolutePath = files[i].getAbsolutePath();
            if (absolutePath.contains(".wav")) {
                String baseName = FilenameUtils.getBaseName(absolutePath);
                String finalName = "D:\\apk-break\\QuickBMS\\1\\decrypt\\" + preName + "_" + baseName + ".wav";
                try {
                    FileUtils.moveFile(new File(absolutePath),
                            new File(finalName));
                } catch (IOException e) {
                    System.out.println("RmAllWav错误： " + e.toString());
                }
            }
        }
    }

    @Test
    public void testBuilder(){
        Process exec = null;
        try {
            exec = new ProcessBuilder("D:\\apk-break\\QuickBMS\\1\\Music_CollectQuest.streams\\fsb_aud_extr.exe",
                    "D:\\apk-break\\QuickBMS\\1\\Music_CollectQuest.streams\\00000000.fsb").start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert exec != null;
        InputStream is = exec.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String str = null;
        while (true) {
            try {
                if ((str = reader.readLine()) == null) break;
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(str);
        }
        try {
            exec.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        exec.destroy();
    }

    private void printBuff(String cmd){
        try {

            Process exec = Runtime.getRuntime().exec(cmd);
            InputStream is = exec.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String str = null;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }
            try {
                exec.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            is.close();
            reader.close();
            exec.destroy();
        } catch (IOException e) {
            System.out.println("printBuff错误： " + e );
        }
    }
    @Test
    public void getDir(){
        System.out.println(FilenameUtils.getBaseName("D:\\apk-break\\QuickBMS\\1\\Music_CollectQuest.streams"));
//        printBuff("cmd.exe /c cd D:\\apk-break\\QuickBMS\\1\\Music_CollectQuest.streams");
//        printBuff("cmd.exe /c D:");
//        printBuff("cmd.exe /c dir");

    }
}
