package com.dot.live.weixin.exp;

@SuppressWarnings("serial")
public class WeiXinException extends Exception{
	
	public final static int OK = 0;
	public final static int xmlParserError = -30001;
	public final static int MsgTypeNull = -30002;
	public final static int WithoutEvent = -30003;
	public final static int WithoutMsgType = -30004;
	
	private int code;

	private static String getMessage(int code) {
		switch (code) {
		case xmlParserError:
			return "接收内容解析失败";
		case MsgTypeNull:
			return "MsgType为空";
		case WithoutEvent:
			return "收到未知事件";
		case WithoutMsgType:
			return "收到未知消息类型";
		default:
			return null; // cannot be
		}
	}

	public int getCode() {
		return code;
	}

	public WeiXinException(int code) {
		super(getMessage(code));
		this.code = code;
	}

}
