package com.dot.live.weixin.exp;

public enum ErrorCode {
	
	INVALID_PARAMETERS("100001"),
	/**
	 * httpclient throw SocketTimeoutException
	 */
	CONNECTION_TIMOUT_ERROR("200001"),
	/**
	 * httpclient response parse throw org.apache.http.ParseException
	 */
	RESPONSE_MSG_PARSE_ERROR("200002"),
	/**
	 * httpclient throw UnsupportedEncodingException
	 */
	UNSUPPORTED_ENCODING_EXCEPTION("200003"),
	/**
	 * httpclient throw other Exception
	 */
	HTTP_OTHER_EXCEPTION("200004"),
	/**
	 * httpclient http status code is not ok
	 */
	HTTP_STATUS_CODE_NO_OK("200005");
	
	
	
	private String code;
	
	private ErrorCode(String code) {
		this.code = code;
	}
	
	public String getCode(){
		return code;
	}

}
