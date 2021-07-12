package com.cosmax.apktool.utils;

import cn.wjdiankong.main.XmlEditor;

/**
 * @program: apktool
 * @description: AndroidManifest.xml编辑操作
 * @author: Cosmax
 * @create: 2020/11/30 11:01
 */
public class AXMLEditorUtils {

    /**
     * 删除一个tag，删除tag时必须指定tag名称和name值，这样才能唯一确定一个tag信息
     * XmlEditor.removeTag("uses-permission", "android.permission.INTERNET");
     * XmlEditor.removeTag("activity", ".MainActivity");
     */
    public static void removeTag(String tagName, String name){
        XmlEditor.removeTag(tagName, name);
    }

    /**
     *
     * 删除属性，必须要指定属性对应的tag名称和name值，然后就是属性名称
     * XmlEditor.removeAttr("activity", ".MainActivity", "name");
     * XmlEditor.removeAttr("uses-permission", "android.permission.INTERNET", "name");
     */
    public static void removeAttr(String tag, String tagName, String attrName){}

    /**
     * 添加标签，直接在xml中配置即可，需要注意的是配置信息：manifest下面的标签必须在application标签的后面
     * XmlEditor.addTag();
     */
    public static void addTag(String insertXml){
        XmlEditor.addTag(insertXml);
    }


    /**
     * 添加属性，必须指定标签内容
     * XmlEditor.addAttr("activity", ".MainActivity", "jiangwei", "fourbrother");
     */
    public static void addAttr(String tag, String tagName, String attrName, String attrValue){
        XmlEditor.addAttr(tag, tagName, attrName, attrValue);
    }

    /**
     * 更改属性，这里直接采用先删除，再添加策略完成
     * XmlEditor.modifyAttr("application", "package", "debuggable", "true");
     */
    public static void modifyAttr(String tag, String tagName, String attrName, String attrValue){
        XmlEditor.modifyAttr(tag, tagName, attrName, attrValue);
    }

}
