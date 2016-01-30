package com.dot.live.weixin.domain;

import com.dot.live.weixin.enums.Event;
import com.dot.live.weixin.enums.MsgType;
/**
 * 
 * @author hesq1
 * @date 2015年10月9日
 * @desc 自定义菜单事件-点击菜单拉取消息时的事件推送
 */
public class RecEventMenuClickMsg {
	
	//开发者微信号
	private String ToUserName;
	
	//发送方帐号（一个OpenID）
	private String FromUserName;
	
	//消息创建时间 （整型）
	private Long CreateTime;
	
	//消息类型，event
	private MsgType MsgType;
	
	//事件类型，CLICK
	private Event Event;
	
	//事件KEY值，与自定义菜单接口中KEY值对应
	private String EventKey;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public MsgType getMsgType() {
		return MsgType;
	}

	public void setMsgType(MsgType msgType) {
		MsgType = msgType;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public Event getEvent() {
		return Event;
	}

	public void setEvent(Event event) {
		Event = event;
	}
	
	

}
