package com.dot.live.weixin.domain;

import java.io.Serializable;
/**
 * 
 * @author hesq1
 * @date 2015年10月9日
 * @desc 微信访问AccessToken对象
 */
public class AccessToken implements Serializable{

	
	private static final long serialVersionUID = -8281692070532095883L;
	
	//token值
	private String access_token;
	
	//失效时间
	private Long expires_in;

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	public Long getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(Long expires_in) {
		this.expires_in = expires_in;
	}

	
	
}
