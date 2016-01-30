package com.dot.live.weixin.domain;

/**
 * 
 * @author hesq1
 * @date 2015年10月9日
 * @desc 被动回复用户消息 - 回复文本消息
 */

public class ReplyTextMsg extends ReplyBaseMsg {
	
	//回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	private String Content;
	
	
	public String getContent() {
		return Content;
	}


	public void setContent(String content) {
		Content = content;
	}

//	@Override
//	public String toString(){
//		return "<xml>"
//			 + "<ToUserName><![CDATA["+this.ToUserName+"]]></ToUserName>"
//			 +"<FromUserName><![CDATA["+this.FromUserName+"]]></FromUserName>"
//		 	 +"<CreateTime>"+this.CreateTime+"</CreateTime>"
//		 	 +"<MsgType><![CDATA[text]]></MsgType>"
//		 	 +"<Content><![CDATA["+this.Content+"]]></Content>"
//		 	 +"</xml>";
//	}
}
