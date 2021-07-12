package com.cosmax.apktool.thread;

import com.cosmax.apktool.entity.MessageStatus;
import com.cosmax.apktool.utils.CmdUtils;
import lombok.Data;

/**
 * @program: apktool
 * @description: cmd线程
 * @author: Cosmax
 * @create: 2020/11/29 19:42
 */

@Data
public class CmdThread implements Runnable {

    private String path;
    private MessageStatus messageStatus;


    public CmdThread(String path) {
        this.path = path;
    }

    @Override
    public void run() {
        this.messageStatus = new CmdUtils().dex2jar(path);
    }
}
