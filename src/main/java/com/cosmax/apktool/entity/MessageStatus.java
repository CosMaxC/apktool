package com.cosmax.apktool.entity;

import lombok.Data;

/**
 * @program: apktool
 * @description: 反馈描述
 * @author: Cosmax
 * @create: 2020/11/24 17:24
 */

@Data
public class MessageStatus {

    // 状态码
    private int code;
    // 反馈信息
    private String message;

    private static MessageStatus createMessageStatus(int code, String message){
        MessageStatus messageStatus = new MessageStatus();
        messageStatus.setCode(code);
        messageStatus.setMessage(message);
        return messageStatus;
    }


    public static MessageStatus success(String message){
        return MessageStatus.createMessageStatus(200, message);
    }

    public static MessageStatus success(){
        return MessageStatus.createMessageStatus(200, "成功!");
    }

    public static MessageStatus fail(int code, String message){
        return MessageStatus.createMessageStatus(code, message);
    }

    public static MessageStatus fail(String message){
        return MessageStatus.createMessageStatus(400, message);
    }

    public static MessageStatus fail(){
        return MessageStatus.createMessageStatus(400, "失败");
    }
}
