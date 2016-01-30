package com.dot.live.auth.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8388073127435274375L;
	
	private Long id;
	private String roleName;  
	private String roleValue;
    private String des;  
    
    private List<User> users;  
    
    private List<Resource> perms;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleValue() {
		return roleValue;
	}
	public void setRoleValue(String roleValue) {
		this.roleValue = roleValue;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Resource> getPerms() {
		return perms;
	}
	public void setPerms(List<Resource> perms) {
		this.perms = perms;
	}
	@Override
	public String getAuthority() {
		return this.roleValue;
	}
	
}
