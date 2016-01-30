package com.dot.live.weixin.domain;
	  
	/** 
	 * 链接消息 
	 *  
	 * @author  wanggang  
	 * @date    2016-01-15 
	 */  
	public class RecLinkMsg  extends RecBaseMsg {  
	    // 消息标题  
	    private String Title;  
	    // 消息描述  
	    private String Description;  
	    // 消息链接  
	    private String Url;  
	  
	    public String getTitle() {  
	        return Title;  
	    }  
	  
	    public void setTitle(String title) {  
	        Title = title;  
	    }  
	  
	    public String getDescription() {  
	        return Description;  
	    }  
	  
	    public void setDescription(String description) {  
	        Description = description;  
	    }  
	  
	    public String getUrl() {  
	        return Url;  
	    }  
	  
	    public void setUrl(String url) {  
	        Url = url;  
	    }  
	}  

