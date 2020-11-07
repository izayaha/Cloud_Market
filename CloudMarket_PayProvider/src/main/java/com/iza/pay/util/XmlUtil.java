package com.iza.pay.util;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * projectName:  CloudMarket
 *
 * @author: xuwei
 * time:  2020/11/7 16:16
 * description:
 */
public class XmlUtil {
    //生成xml
    public static String createXml(Map<String ,Object> map){
        //1.创建文档对象
        Document document = DocumentHelper.createDocument();
        //2.创建根节点
        Element root = document.addElement("xml");
        //3.创建子节点 遍历集合
        for (String k : map.keySet()) {
            root.addElement(k).setText(map.get(k).toString());
        }
        //4.写出 字符串
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            XMLWriter writer = new XMLWriter(baos);
            writer.write(document);
            return new String(baos.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    //解析xml
    public static  Map<String  ,Object> parseXml(String xml){
        Map<String ,Object> map = new HashMap<>();
        SAXReader reader = new SAXReader();

        try {
            Document document = reader.read(new ByteArrayInputStream(xml.getBytes()));
            //获取根节点
            Element  root =document.getRootElement();
            //获取子节点
            List<Element> list = root.elements();
            for (Element e : list) {
                map.put(e.getName(),e.getTextTrim());
            }
            return map;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }


}
