package com.dot.live.auth.dao;

import java.util.List;

import com.dot.live.auth.domain.Resource;
import com.dot.live.base.dao.BaseDao;

public interface ResourceDao extends BaseDao<Resource,Long>{
	
	public List<Resource> findSourceByUri(String requestUri);
	
}
