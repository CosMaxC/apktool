package com.cosmax.apktool.biz;

import com.cosmax.apktool.entity.MessageStatus;
import org.junit.Test;


public class ApkBizTest {

    @Test
    public void apk2Jar() {
        ApkBiz apkBiz = new ApkBiz();
        MessageStatus messageStatus = apkBiz.apk2Jar("D:\\apk-break\\new\\demo.apk", "D:\\apk-break\\new");
        System.out.println(messageStatus.getCode() + "---" + messageStatus.getMessage());
    }
}
