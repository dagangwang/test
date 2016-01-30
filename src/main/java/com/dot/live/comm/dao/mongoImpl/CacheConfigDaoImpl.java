package com.dot.live.comm.dao.mongoImpl;

import org.springframework.stereotype.Repository;

import com.dot.live.base.dao.impl.BaseDaoImpl;
import com.dot.live.comm.dao.CacheConfigDao;
import com.dot.live.comm.domain.CacheConfig;

@Repository("cacheConfigDao")
public class CacheConfigDaoImpl  extends BaseDaoImpl<CacheConfig,String> implements CacheConfigDao {

	public CacheConfigDaoImpl(){
		 super(CacheConfig.class);  
	}
	

}
