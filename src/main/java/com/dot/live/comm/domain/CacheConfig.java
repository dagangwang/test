package com.dot.live.comm.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="cache_config")
public class CacheConfig implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7594283776436548430L;

	//缓存编码key
	@Id
	private String id;
	
	//缓存名称
	@Field("name")
	private String name;
	
	//缓存前缀value
	@Field("prefix")
	private String prefix;
	
	//缓存说明
	@Field("desc")
	private String desc;
	
	//缓存时长
	@Field("duration") 
	private String duration;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
	

}
