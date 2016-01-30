package com.dot.live.comm.exp;

public class CommException extends RuntimeException{

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
	public CommException(ErrorCode errorCode){
		super(errorCode.name());
		this.errorCode = errorCode;

	}
	
	/**
	 * @param errorCode
	 * @param args
	 */
	public CommException(ErrorCode errorCode, Object[] args) {
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
