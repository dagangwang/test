package com.dot.live.comm.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 系统数据表（权限很高）
 * @author heshuangquan
 *
 */
@Document(collection="sys_config")
public class SysConfig implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1733901862093394876L;
	
	//编码
	@Id 
	@NotNull
	@Size(min = 1, max = 20)
	private String id;
	
	//父id 父编码
	@Field("p_id")
	private String pId;
	
	//值
	@Field("value")
	@NotNull
	@Size(min = 1)
	private String value;
	
	//名称
	@Field("name")
	@NotNull
	@Size(min = 1)
	private String name;
	
	//作用及描述
	@Field("desc")
	private String describe;
	

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	
	public String getpId() {
		return pId;
	}


	public void setpId(String pId) {
		this.pId = pId;
	}


	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}
	
	

}
