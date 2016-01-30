package com.dot.live.base.dao.impl;

public enum  MongoColls {
	
	CacheConfig("cache_config","缓存配置"),
	WeiXinInfo("WeiXin_info","微信基本信息"),
	WeiXinMenu("WeiXin_menu","微信菜单"),
	Article("cms_aticle","文章"),
	WeiXinToken("WeiXin_token","微信token")
	;
	
	
	MongoColls(String collName, String collDesc){
		this.collName = collName;
		this.collDesc = collDesc;
	}
	
	private String collName;
	
	private String collDesc;
	
	public String getCollName() {
		return collName;
	}
	public String getCollDesc() {
		return collDesc;
	}
	
	

}
