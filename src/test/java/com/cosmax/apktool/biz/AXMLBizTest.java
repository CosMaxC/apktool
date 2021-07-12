package com.cosmax.apktool.biz;
import com.cosmax.apktool.entity.AXMLEntity.MODE;

import com.cosmax.apktool.entity.AXMLEntity;
import org.junit.Test;


public class AXMLBizTest {

    @Test
    public void modifyAXML() {
        AXMLEntity axmlEntity = new AXMLEntity();
        axmlEntity.setSrcPath("D:\\apk-break\\AXMLPrinter2.jar\\AndroidManifest.xml");
        axmlEntity.setDestPath("D:\\apk-break\\AXMLPrinter2.jar\\AndroidManifest2.xml");
        axmlEntity.setTag("manifest");
        axmlEntity.setTagName("cos");
        axmlEntity.setAttrName("package");
        axmlEntity.setAttrValue("com.cosmax.test");
        axmlEntity.setInsertXml("");
//        axmlEntity.setMode(MODE.MODIFY_ATTR);
        axmlEntity.setMode(MODE.ADD_ATTR);
        AXMLBiz axmlBiz = new AXMLBiz();
        axmlBiz.modifyAXML(axmlEntity);

    }
}
