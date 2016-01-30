package com.dot.live.weixin.domain;

/**
 * 
 * @author hesq1
 * @date 2015年10月9日
 * @desc 微信接收的文本消息
 */
public class RecComTextMsg extends RecBaseMsg {

	//文本消息内容
	private String Content;

	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}

}
