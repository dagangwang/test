/**
 * 
 */
package com.dot.live.weixin.enums;

/**
 * @author hesq1
 * @date 2015年10月18日
 * @desc 入口类型
 */
public enum GuideType {
	
	VALID("校验入口 "),
	REPLY("普通回复入口");
	
	GuideType(String message) {
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
