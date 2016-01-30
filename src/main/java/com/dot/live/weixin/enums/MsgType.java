/**
 * 
 */
package com.dot.live.weixin.enums;

/**
 * @author hesq1
 * @date 2015年10月9日
 * @desc 微信接收消息类型
 */
public enum MsgType {
	
	text("普通消息 "),
	event("事件推送");
	
	MsgType(String message) {
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
