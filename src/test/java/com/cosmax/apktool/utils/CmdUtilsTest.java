package com.cosmax.apktool.utils;

import com.cosmax.apktool.entity.MessageStatus;
import com.cosmax.apktool.utils.CmdUtils;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import static org.junit.Assert.*;

public class CmdUtilsTest {

    @Test
    public void runbat() {
    }

    @Test
    public void dex2jar() {
        CmdUtils cmdUtils = new CmdUtils();
        MessageStatus messageStatus = cmdUtils.apk2jar("C:\\Users\\Conanbin\\Desktop\\ky\\Sky_Gold_0.6.7_155705_obt_netease_encrypted_minify");
        System.out.println(messageStatus.getMessage());

    }
}
