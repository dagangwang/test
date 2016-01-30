package com.dot.live.auth.dao;

import java.util.List;

import com.dot.live.auth.domain.User;
import com.dot.live.base.dao.BaseDao;

public interface UserDao extends BaseDao<User,Long>{
  
    public List findByProperty(String propertyName, Object value);  
  
    public User getUserByName(String username);  
  
    public List<String> loadUserAuthoritiesByName(String username);   
	
}
