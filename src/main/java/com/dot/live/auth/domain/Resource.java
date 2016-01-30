package com.dot.live.auth.domain;

import java.io.Serializable;
import java.util.List;

public class Resource implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3838794618962244180L;
	private Long id;
	private String resourseName;  
    private String resoursePattern;
    private String description;  
    private List<Role> roles;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getResourseName() {
		return resourseName;
	}
	public void setResourseName(String resourseName) {
		this.resourseName = resourseName;
	}
	public String getResoursePattern() {
		return resoursePattern;
	}
	public void setResoursePattern(String resoursePattern) {
		this.resoursePattern = resoursePattern;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

}
