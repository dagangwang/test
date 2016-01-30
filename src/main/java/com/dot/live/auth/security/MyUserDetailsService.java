package com.dot.live.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.dot.live.auth.dao.UserDao;

public class MyUserDetailsService implements UserDetailsService{

	@Autowired  
    private UserDao authUserDao; 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails rs = authUserDao.getUserByName(username);
		return rs;
	}

}
