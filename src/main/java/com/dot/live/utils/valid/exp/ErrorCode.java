package com.dot.live.utils.valid.exp;

import org.springframework.http.HttpStatus;

public enum ErrorCode{
	
	//参数不能为空
	PARAMETER_NOT_NULL("PMT3N1004", HttpStatus.BAD_REQUEST),

	//参数长度大于指定的最大长度
	PARAMETER_LENGTH_BIGGER_THAN_MAX("PMT3N1005", HttpStatus.BAD_REQUEST),
	
	//参数长度小于指定的最小长度
	PARAMETER_LENGTH_LESS_THAN_MIN("PMT3N1006", HttpStatus.BAD_REQUEST),
	
	//时间格式不对
	PARAMETER_DATE_PATTERN("PMT3N1007", HttpStatus.BAD_REQUEST),
	
	//不能抛单
	THROW_ORDERS_ERROR("313", HttpStatus.BAD_REQUEST);
	
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
