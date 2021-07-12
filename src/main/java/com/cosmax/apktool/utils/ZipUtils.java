package com.cosmax.apktool.utils;

import lombok.Data;
import org.apache.commons.io.FilenameUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import com.cosmax.apktool.entity.MessageStatus;

/**
 * @program: apktool
 * @description: 解压工具类
 * @author: Cosmax
 * @create: 2020/11/24 17:16
 */
@Data
public class ZipUtils {

    private static int BUFFER_SIZE = 1024;

    /**
     * 解压(需填写目录)
     * @param srcPath  源文件
     * @param destPath 解压目录
     */
    public static MessageStatus unZip(String srcPath, String destPath) {

        File srcFile = new File(srcPath);

        if (!srcFile.exists()) {
            return MessageStatus.fail("源文件[" + srcPath + "]不存在!");
        }

        // 开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                // 如果是文件夹，就创建个文件夹
                if (entry.isDirectory()) {
                    String dirPath = destPath + "/" + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                    File targetFile = new File(destPath + "/" + entry.getName());
                    // 保证这个文件的父文件夹必须要存在
                    if (!targetFile.getParentFile().exists()) {
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    // 将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream fos = new FileOutputStream(targetFile);
                    int len;
                    byte[] buf = new byte[BUFFER_SIZE];
                    while ((len = is.read(buf)) != -1) {
                        fos.write(buf, 0, len);
                    }
                    // 关流顺序，先打开的后关闭
                    fos.close();
                    is.close();
                }
            }
            return MessageStatus.success();
        } catch (Exception e) {
            return MessageStatus.fail("unzip error from ZipUtils:" + e);

        } finally {
            if (zipFile != null) {
                try {
                    zipFile.close();

                } catch (IOException e) {
                    e.printStackTrace();

                }

            }

        }
    }

    /**
     * 解压至当前目录
     * @param srcPath 源地址
     */
    public static MessageStatus unZipApk(String srcPath, String destPath){
        if (destPath == null || destPath.length() <=0) {
            destPath = FilenameUtils.removeExtension(srcPath);
        }
        if (!FilenameUtils.isExtension(srcPath, "zip", "apk", "apks")) {
            return MessageStatus.fail("后缀有误！");
        }
        destPath += "/" + FilenameUtils.getBaseName(srcPath);
        return ZipUtils.unZip(srcPath, destPath);
    }
}
