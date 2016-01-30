package com.dot.live.comm.exp;

import org.springframework.http.HttpStatus;

public enum ErrorCode{

	SUCCESS("000000", HttpStatus.OK),
	
	//--------------------Parameter---------------\\
	//请求无效
	INVALID_REQUEST("PMT3N1000", HttpStatus.BAD_REQUEST),

	//参数无效
	INVALID_PARAMETERS("PMT3N1001", HttpStatus.BAD_REQUEST),
	
	//JSON格式错误
	WRONG_JSON_FORMAT("PMT3N1002", HttpStatus.BAD_REQUEST),
	
	//参数不能为空
	PARAMETER_NOT_NULL("PMT3N1004", HttpStatus.BAD_REQUEST),

	//HTTP Method not supported 
	TSM_HTTP_METHOD_NOT_SUPPORTED_EXCEPTION("PMT3N2002", HttpStatus.METHOD_NOT_ALLOWED),
	
	//服务器内部错误
	INTERNAL_SERVER_ERROR("999999", HttpStatus.INTERNAL_SERVER_ERROR);
	
	private String code;
	private HttpStatus statusCode;
	
	private ErrorCode(String code, HttpStatus statusCode) {
		this.code = code;
		this.statusCode = statusCode;
	}
	
	public String getCode(){
		return code;
	}

	public HttpStatus getStatusCode(){
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}
	
}
