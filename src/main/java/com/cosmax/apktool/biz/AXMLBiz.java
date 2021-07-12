package com.cosmax.apktool.biz;

import cn.wjdiankong.main.ParserChunkUtils;
import com.cosmax.apktool.entity.AXMLEntity;
import com.cosmax.apktool.entity.MessageStatus;
import com.cosmax.apktool.utils.AXMLEditorUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @program: apktool
 * @description: AXML读写修改操作
 * @author: Cosmax
 * @create: 2020/11/30 11:54
 */
public class AXMLBiz {

    public MessageStatus modifyAXML(AXMLEntity axmlEntity){
        MessageStatus messageStatus = checkAXMLEnity(axmlEntity);
        if (messageStatus.getCode() != 200) {
            return messageStatus;
        }
        // 读取文件，读取改后文件
        File inputFile = new File(axmlEntity.getSrcPath());
        File outputFile = new File(axmlEntity.getDestPath());
        if(!inputFile.exists()){
            return MessageStatus.fail("输入文件不存在...");
        }

        //读文件
        try (FileInputStream fis = new FileInputStream(inputFile); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            ParserChunkUtils.xmlStruct.byteSrc = bos.toByteArray();
        } catch (Exception e) {
            return MessageStatus.fail("parse xml error:" + e.toString());
        }
        // 寻找格式
        setMode(axmlEntity);
        // 输出文件

        //写文件
        if(!outputFile.exists()){
            outputFile.delete();
        }
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(ParserChunkUtils.xmlStruct.byteSrc);
        }catch(Exception ignored){
        }

        return MessageStatus.success();
    }

    /**
     * 设置模式
     * @param axmlEntity
     */
    private void setMode(AXMLEntity axmlEntity){
        if (axmlEntity.getMode() == AXMLEntity.MODE.ADD_ATTR){
            AXMLEditorUtils.addAttr(
                    axmlEntity.getTag(),
                    axmlEntity.getTagName(),
                    axmlEntity.getAttrName(),
                    axmlEntity.getAttrValue());
        }

        if (axmlEntity.getMode() == AXMLEntity.MODE.MODIFY_ATTR){
            AXMLEditorUtils.modifyAttr(
                    axmlEntity.getTag(),
                    axmlEntity.getTagName(),
                    axmlEntity.getAttrName(),
                    axmlEntity.getAttrValue());
        }
        if (axmlEntity.getMode() == AXMLEntity.MODE.ADD_TAG){
           AXMLEditorUtils.addTag(axmlEntity.getInsertXml());
        }
        if (axmlEntity.getMode() == AXMLEntity.MODE.REMOVE_TAG){
            AXMLEditorUtils.removeTag(axmlEntity.getTag(), axmlEntity.getAttrName());
        }
        if (axmlEntity.getMode() == AXMLEntity.MODE.REMOVE_ATTR){
            AXMLEditorUtils.removeAttr(axmlEntity.getTag(), axmlEntity.getTagName(), axmlEntity.getAttrName());
        }
    }

    private MessageStatus checkAXMLEnity(AXMLEntity axmlEntity) {
        if (axmlEntity == null){
            return MessageStatus.fail("实体不能为空");
        }

        if (axmlEntity.getMode() == null){
            return MessageStatus.fail("模式未填");
        }

        if (StringUtils.isBlank(axmlEntity.getSrcPath())
                || StringUtils.isBlank(axmlEntity.getDestPath())) {
            return MessageStatus.fail("路径未填");
        }

        if (axmlEntity.getMode() == AXMLEntity.MODE.ADD_ATTR){
            if (StringUtils.isBlank(axmlEntity.getAttrName())
                    || StringUtils.isBlank(axmlEntity.getAttrValue())
                    || StringUtils.isBlank(axmlEntity.getTag())
                    || StringUtils.isBlank(axmlEntity.getTagName())){
                return MessageStatus.fail("添加属性参数入参有误");
            }
        }

        if (axmlEntity.getMode() == AXMLEntity.MODE.MODIFY_ATTR){
            if (StringUtils.isBlank(axmlEntity.getAttrName())
                    || StringUtils.isBlank(axmlEntity.getAttrValue())
                    || StringUtils.isBlank(axmlEntity.getTag())
                    || StringUtils.isBlank(axmlEntity.getTagName())){
                return MessageStatus.fail("更改属性参数入参有误");
            }
        }
        if (axmlEntity.getMode() == AXMLEntity.MODE.ADD_TAG){
            if (StringUtils.isBlank(axmlEntity.getInsertXml())){
                return MessageStatus.fail("添加tag参数入参有误");
            }
        }
        if (axmlEntity.getMode() == AXMLEntity.MODE.REMOVE_TAG){
            if (StringUtils.isBlank(axmlEntity.getTag())
                    || StringUtils.isBlank(axmlEntity.getTagName())){
                return MessageStatus.fail("删除tag参数入参有误");
            }
        }
        if (axmlEntity.getMode() == AXMLEntity.MODE.REMOVE_ATTR){
            if (StringUtils.isBlank(axmlEntity.getAttrName())
                    || StringUtils.isBlank(axmlEntity.getTag())
                    || StringUtils.isBlank(axmlEntity.getTagName())){
                return MessageStatus.fail("删除属性参数入参有误");
            }
        }
        return MessageStatus.success();

    }
}
