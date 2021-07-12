package com.cosmax.apktool.entity;

import lombok.Data;

/**
 * @program: apktool
 * @description: androidManifest.xml实体
 * @author: Cosmax
 * @create: 2020/11/30 11:32
 */
@Data
public class AXMLEntity {

    // 源文件
    private String srcPath;
    // 修改后文件
    private String destPath;

    private String tag;

    private String tagName;

    private String attrName;

    private String attrValue;

    // 插入xml
    private String insertXml;

    /**
     * 模式：
     *      0.删除一个tag
     *      1.删除属性
     *      2.添加标签
     *      3.添加属性
     *      4.更改属性
      */
    private MODE mode;

    public enum MODE {
        REMOVE_TAG, REMOVE_ATTR, ADD_TAG, ADD_ATTR, MODIFY_ATTR
    }
}
