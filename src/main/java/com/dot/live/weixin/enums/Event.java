/**
 * 
 */
package com.dot.live.weixin.enums;

/**
 * @author hesq1
 * @date 2015年10月9日
 * @desc 
 */
public enum Event {
	subscribe("关注事件"),
	unsubscribe("取消关注事件"),
	LOCATION("上报地理位置事件"),
	CLICK("点击菜单拉取消息时的事件推送 "),
	VIEW("点击菜单跳转链接时的事件推送");
	
	Event(String message) {
		this.message=message;
	}
	
	private String message;
	
	public String getMessage(){
		return message;
	}
	public void setMessage(String message){
		this.message = message;
	}
}
