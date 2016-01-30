package com.dot.live.weixin.exp;

public class ServiceException extends RuntimeException implements ErrorResultInterface{

	private static final long serialVersionUID = 4485526288479929676L;
	
	private ErrorCode errorCode;
	
	private Object[] args;
	
	public ServiceException(ErrorCode errorCode, Object... args) {
		this.errorCode = errorCode;
		this.args = args;
	}

	public ErrorResult getErrorResult() {
		ErrorResult rs = new ErrorResult();
		rs.setCode(errorCode.getCode());
		rs.setMessage(getMessage());
		return rs;
	}

	@Override
	public String getMessage() {
//        MessageSource messageSource = SpringBeanUtil.getBeanById("messageSource");
//        return messageSource.getMessage(errorCode.name(), null == args ? null : args, null, Locale.getDefault());
        return "";
	}

}
