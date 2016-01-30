package com.dot.live.comm.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.live.base.service.impl.BaseServiceImpl;
import com.dot.live.comm.dao.CacheConfigDao;
import com.dot.live.comm.domain.CacheConfig;
import com.dot.live.comm.service.ICacheConfigService;

@Service("cacheConfigService")
public class CacheConfigServiceImpl  extends BaseServiceImpl<CacheConfig,String> implements ICacheConfigService {

	static Logger logger = LoggerFactory.getLogger(CacheConfigServiceImpl.class); 
	
	private CacheConfigDao cacheConfigDao;
	
	@Autowired
	public CacheConfigServiceImpl(CacheConfigDao cacheConfigDao){
		super(cacheConfigDao);  
		this.cacheConfigDao = cacheConfigDao;
	}
	
	

}
