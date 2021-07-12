package com.cosmax.apktool.biz;

import com.cosmax.apktool.entity.MessageStatus;
import com.cosmax.apktool.utils.CmdUtils;
import com.cosmax.apktool.utils.ZipUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * @program: apktool
 * @description: apk相关功能
 * @author: Cosmax
 * @create: 2020/11/29 18:47
 */
public class ApkBiz {

    public MessageStatus apk2Jar(String srcPath, String destPath) {
        MessageStatus messageStatus = ZipUtils.unZipApk(srcPath, destPath);
        if (messageStatus.getCode() != 200){
            return messageStatus;
        }
        String fileName = FilenameUtils.getBaseName(srcPath);
        CmdUtils cmdUtils = new CmdUtils();
        return cmdUtils.apk2jar(destPath + "/" + fileName);
    }
}
