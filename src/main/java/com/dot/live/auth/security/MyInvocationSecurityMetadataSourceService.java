package com.dot.live.auth.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.dot.live.auth.dao.ResourceDao;
import com.dot.live.auth.domain.Resource;
import com.dot.live.auth.domain.Role;
public class MyInvocationSecurityMetadataSourceService implements FilterInvocationSecurityMetadataSource{

	@Autowired  
    private ResourceDao authSourceDao; 
	
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String url = ((FilterInvocation) object).getRequestUrl();  
        int firstQuestionMarkIndex = url.indexOf("?");  
        if (firstQuestionMarkIndex != -1) {  
            url = url.substring(0, firstQuestionMarkIndex);  
        }  
        System.out.println("url:" + url);  
        List<ConfigAttribute> result = new ArrayList<ConfigAttribute>();  
        ConfigAttribute attribute = new SecurityConfig("ROLE_BASE");  
        result.add(attribute);  
        try {  
            List<Resource> resourceList = authSourceDao.findSourceByUri(url);  
            if (resourceList != null && resourceList.size() > 0) {  
                for (Resource resource : resourceList) {  
                    List<Role> roles = resource.getRoles();  
                    if (roles != null && roles.size() > 0) {  
                        for (Role role : roles) {  
                            ConfigAttribute conf = new SecurityConfig(role.getRoleValue());  
                            result.add(conf);  
                        }  
                    }  
                }  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return result;  
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}


	

}
