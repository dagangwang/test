package com.dot.live.utils.valid.exp;

public class ValidateException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4828753161437529814L;
	
	private ErrorCode errorCode;
	private Object[] args;

	/**
	 * 
	 * @param errorCode
	 */
	public ValidateException(ErrorCode errorCode){
		super(errorCode.name());
		this.errorCode = errorCode;

	}
	
	/**
	 * @param errorCode
	 * @param args
	 */
	public ValidateException(ErrorCode errorCode, Object[] args) {
		super(errorCode.name()+":"+ args);
		this.errorCode = errorCode;
		this.args=args;
	}

	public ErrorCode getErrorCode(){
		return errorCode;
	}
	
	public Object[] getExtraArgs() {
		return args;
	}
   
}
