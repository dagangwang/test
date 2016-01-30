package com.dot.live.auth.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import com.dot.live.auth.dao.ResourceDao;
import com.dot.live.auth.domain.Resource;
import com.dot.live.base.dao.impl.BaseDaoImpl;

@Repository("authSourceDao")
public class ResourceDaoImpl extends BaseDaoImpl<Resource,Long> implements ResourceDao{

	@Override  
    public List<Resource> findSourceByUri(String requestUri) {  
		List<Resource> resourceList = this.getAll();
        List<Resource> resources = new ArrayList<Resource>();  
        for (Resource resource : resourceList) {  
            if (urlMatcher(resource.getResoursePattern(), requestUri))  
            	resources.add(resource);  
        }  
        return resources;  
    }  
	
	private boolean urlMatcher(String sourcePatten, String requestUri) {  
        boolean isMatcher = false;  
        PathMatcher matcher = new AntPathMatcher();  
        isMatcher = matcher.match(sourcePatten, requestUri);  
        return isMatcher;  
    }  

}
