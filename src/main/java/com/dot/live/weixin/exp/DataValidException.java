package com.dot.live.weixin.exp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

public class DataValidException extends RuntimeException implements ErrorResultInterface{

	private static final long serialVersionUID = -8747117152911180206L;

 	private List<String> globalErrors;

    private List<Map<String, String>> fieldErrors;
    
    public DataValidException(Errors errors){
    	this(errors,null);
    }

    public DataValidException(Errors errors, Locale locale){
        if(errors.hasGlobalErrors()) {
            this.globalErrors = new ArrayList<String>();
            for(ObjectError error : errors.getGlobalErrors()) {
            	this.globalErrors.add(getMessage(error));
            }
        }

        if(errors.hasFieldErrors()) {
        	this.fieldErrors = new ArrayList<Map<String, String>>();
            for(FieldError error : errors.getFieldErrors()) {
                Map<String, String> errorData = new HashMap<String, String>();
                errorData.put(error.getField(), getMessage(error));
                this.fieldErrors.add(errorData);
            }
        }
    }

    private static String getMessage(ObjectError error) {
//        MessageSource messageSource = SpringBeanUtil.getBeanById("messageSource");
//        return messageSource.getMessage(error.getCode(), error.getArguments(), error.getDefaultMessage(), Locale.getDefault());
    	return "";
    }

	public ErrorResult getErrorResult() {
		ErrorResult rs = new ErrorResult();
		rs.setCode(ErrorCode.INVALID_PARAMETERS.getCode());
		rs.setMessage(fieldErrors);
		return rs;
	}

	
}
