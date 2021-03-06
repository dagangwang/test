package com.dot.live.auth.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;


public class MyAccessDecisionManager implements AccessDecisionManager {
	
	Logger logger = LoggerFactory.getLogger(MyAccessDecisionManager.class); 

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {  
            return;  
        }  
        Iterator<ConfigAttribute> ite = configAttributes.iterator();  
        while (ite.hasNext()) {  
            ConfigAttribute ca = ite.next();  
            String needRole = ((SecurityConfig)ca).getAttribute();  
            for (GrantedAuthority ga : authentication.getAuthorities()) { 
            	if (needRole.trim().equals(ga.getAuthority().trim())) {  
                    return;  
                }  
            }  
        }  
        throw new AccessDeniedException("无权限！");  
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}


}
