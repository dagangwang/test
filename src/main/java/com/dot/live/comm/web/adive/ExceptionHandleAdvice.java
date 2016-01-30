package com.dot.live.comm.web.adive;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.dot.live.comm.exp.CommException;
import com.dot.live.comm.exp.ErrorCode;
import com.dot.live.comm.exp.ErrorResult;



@ControllerAdvice(basePackages = "com.lenovo.raise.web")
public class ExceptionHandleAdvice {
	
	@Autowired
	private MessageSource messageSource;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandleAdvice.class);

	/**
	 * 参数无效异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST)	
	@ResponseBody 
	ErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {	
		LOGGER.info("handleMethodArgumentNotValidException", ex);
		FieldError fieldError = ex.getBindingResult().getFieldError();				
		String error = resolveLocalizedErrorMessage(fieldError);				
		StringBuffer message = new StringBuffer();				
		message.append(fieldError.getField()).append(" / ").append(error);
		return new ErrorResult(ErrorCode.INVALID_PARAMETERS.getCode(), message.toString());
	}
	
	/**
	 * 自定义异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(CommException.class) 
	@ResponseStatus(HttpStatus.BAD_REQUEST)	
	@ResponseBody 
	ResponseEntity<ErrorResult> handleServerException(CommException ex) {	
		LOGGER.info("serverException", ex);
		ErrorCode errorCode= ex.getErrorCode();
		HttpStatus httpStatus = errorCode.getStatusCode();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ErrorResult errorMessage = getErrorMessage(errorCode, ex.getExtraArgs());								
		return new ResponseEntity<ErrorResult>(errorMessage, headers, httpStatus);
	}
	

	/**
	 * 参数校验异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = {BindException.class}) 
	@ResponseStatus(HttpStatus.BAD_REQUEST)	
	@ResponseBody 
	ResponseEntity<ErrorResult> handleBindException(BindException ex) {	
		LOGGER.info("BindException", ex);
		Map<String, String> errorMessages = new HashMap<>();
		if(ex.hasGlobalErrors()) {
            for(ObjectError error : ex.getGlobalErrors()) {
            	 errorMessages.put("globalErrors", error.getDefaultMessage());
            }
        }

        if(ex.hasFieldErrors()) {
            for(FieldError error : ex.getFieldErrors()) {
                errorMessages.put(error.getField(), error.getDefaultMessage());
            }
        }
        ErrorResult result = new ErrorResult();
        result.setCode(ErrorCode.INVALID_PARAMETERS.getCode());
        result.setMsg(errorMessages);
    	HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<ErrorResult>(result, headers, ErrorCode.INVALID_PARAMETERS.getStatusCode());
	}
	
	/**
	 * 所有异常
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = {Exception.class, RuntimeException.class})
	ResponseEntity<ErrorResult> defaultErrorHandler(Exception ex) {
		LOGGER.info("defaultErrorHandler class:{}, message:{}", ex.getClass(), ex.getMessage());
		ErrorCode errorCode= ErrorCode.INTERNAL_SERVER_ERROR;
		
		String errFld = "";
		if (ex instanceof ServletRequestBindingException) {
			String pattern = "Missing request header '([^']*)'"; // only affected "null" not empty
			// Create a Pattern object
			Pattern r = Pattern.compile(pattern);
			// Now create matcher object.
			Matcher m = r.matcher(ex.getMessage());
		    if (m.find()) {
		    	errFld = m.group(1);
		    	errorCode= ErrorCode.INVALID_PARAMETERS;
		    } 
		}else if (ex instanceof HttpMessageNotReadableException){
			errorCode = ErrorCode.INVALID_REQUEST;
		}
		
		HttpStatus httpStatus = errorCode.getStatusCode();
		ErrorResult errorMessage = getErrorMessage(errorCode, new Object[] {errFld});	
		return new ResponseEntity<ErrorResult>(errorMessage, httpStatus);
	}
	
	private String resolveLocalizedErrorMessage(FieldError fieldError) {
		Locale currentLocale = LocaleContextHolder.getLocale();
		return messageSource.getMessage(fieldError, currentLocale);
	}	
	
	private ErrorResult getErrorMessage(ErrorCode errorCode, Object[] args) {
    	String localizeErrorMessage = getLocalizeErrorMessage(errorCode.name(), args);
    	return new ErrorResult(errorCode.getCode(), localizeErrorMessage);
    }
    
    private String getLocalizeErrorMessage(String errorCode, Object[] args) {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(errorCode, args, locale);
    }
}
