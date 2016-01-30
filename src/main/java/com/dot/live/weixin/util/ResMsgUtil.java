package com.dot.live.weixin.util;

import com.dot.live.weixin.domain.RecComTextMsg;
import com.dot.live.weixin.domain.RecEventMenuClickMsg;
import com.dot.live.weixin.domain.RecEventSubMsg;
import com.dot.live.weixin.exp.WeiXinException;

public class ResMsgUtil {
	
	public static Object  parseToBean(String xmlStr){
		try {
			XmlParser parser = new XmlParser(xmlStr);
			String toUserName = parser.getTextByTag("ToUserName");
			String createTime = parser.getTextByTag("CreateTime");
			String fromUserName = parser.getTextByTag("FromUserName");
			String picUrl = parser.getTextByTag("PicUrl");
			String content = parser.getTextByTag("Content");
			String msgType =  parser.getTextByTag("MsgType");
			String msgId =  parser.getTextByTag("MsgId");
			String event = parser.getTextByTag("Event");
			String eventKey = parser.getTextByTag("EventKey");
			if(null != msgType){
				//如果接收的是事件信息
				if(msgType.equals("event")){
					if(null != event){
						//如果是关注/取消关注公众号事件
						if("subscribe".equals(event)){
							RecEventSubMsg msg = new RecEventSubMsg();
							msg.setCreateTime(Long.parseLong(createTime));
							msg.setFromUserName(fromUserName);
							msg.setToUserName(toUserName);
							return msg;
						}
						
						//如果是点击菜单事件
						if("VIEW".equals(event)){
							RecEventMenuClickMsg msg = new RecEventMenuClickMsg();
							msg.setCreateTime(Long.parseLong(createTime));
							msg.setFromUserName(fromUserName);
							msg.setToUserName(toUserName);
							return msg;
						}
						throw new WeiXinException(WeiXinException.WithoutEvent);
					}
				}
				//如果收到的是普通文本消息
				if(msgType.equals("text")){
					RecComTextMsg msg = new RecComTextMsg();
					msg.setFromUserName(fromUserName);
					msg.setToUserName(toUserName);
					msg.setCreateTime(Long.parseLong(createTime));
					msg.setContent(content);
//					msg.setMsgId(msgId);
					return msg;
				}
				//如果收到的 是图片消息
				if(msgType.equals("image")){
					
				}
				//如果收到的 是语音消息
				if(msgType.equals("voice")){
					
				}
				//如果收到的 是视频消息
				if(msgType.equals("video")){
					
				}
				//如果是地理位置消息
				if(msgType.equals("location")){
					
				}
				//如果是链接消息
				if(msgType.equals("link")){
					
				}
				throw new WeiXinException(WeiXinException.WithoutMsgType);
			}else{
				throw new WeiXinException(WeiXinException.MsgTypeNull);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		parseToBean("<xml><URL><![CDATA[http://www.shunyilive.com/comm/reply.do]]></URL><ToUserName><![CDATA[ykt_query]]></ToUserName><FromUserName><![CDATA[1234565122144]]></FromUserName><CreateTime>1241714545</CreateTime><MsgType><![CDATA[event]]></MsgType><Event><![CDATA[subscribe]]></Event><Latitude></Latitude><Longitude></Longitude><Precision></Precision><MsgId>4145245</MsgId></xml>");
	}

}
