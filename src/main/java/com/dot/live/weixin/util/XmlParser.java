package com.dot.live.weixin.util;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.dot.live.weixin.exp.WeiXinException;


public class XmlParser {
	
	Logger logger = LoggerFactory.getLogger(XmlParser.class); 
	
	private Element root = null;
	
	public XmlParser(String xmlStr) throws WeiXinException{
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db;
			db = dbf.newDocumentBuilder();
			StringReader sr = new StringReader(xmlStr);
			InputSource is = new InputSource(sr);
			Document document = db.parse(is);
			root = document.getDocumentElement();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("XmlParser occur error  upon construction,xmlStr: ");
			logger.info(xmlStr);
			logger.info("can not be pase to dom object");
			throw new WeiXinException(WeiXinException.xmlParserError);
		}
		
		
	}
	
	/**
	 * 获取xml中对应tagName的textContent的值
	 * @param tag
	 * @return
	 */
	public String getTextByTag(String tag){
//		if(null != root){
//			NodeList tagNodes = root.getElementsByTagName(tag);
//			if(null != tagNodes && tagNodes.getLength() > 0 ){
//				String value = tagNodes.item(0).getTextContent();
//				return value;
//			}else{
//				return null;
//			}
//		}else{
//			return null;
//		}
		return null;
	}
}
