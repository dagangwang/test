package com.dot.live.comm.exp;

public class ErrorResult {
	
	private String code;
	
	private Object msg;
	
	public ErrorResult(){
	}
	
	public ErrorResult(String code, Object msg){
		this.code = code;
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Object getMsg() {
		return msg;
	}

	public void setMsg(Object msg) {
		this.msg = msg;
	}

	
	
}
