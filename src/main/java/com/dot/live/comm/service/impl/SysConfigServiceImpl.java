package com.dot.live.comm.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import com.dot.live.base.service.impl.BaseServiceImpl;
import com.dot.live.comm.dao.SysConfigDao;
import com.dot.live.comm.domain.SysConfig;
import com.dot.live.comm.service.ISysConfigService;

@Service("sysConfigService")
public class SysConfigServiceImpl extends BaseServiceImpl<SysConfig,String> implements ISysConfigService {
	
	static Logger logger = LoggerFactory.getLogger(SysConfigServiceImpl.class); 
	
	private SysConfigDao sysConfigDao;
	
	@Autowired
	public SysConfigServiceImpl(SysConfigDao sysConfigDao) {
		super(sysConfigDao);  
		this.sysConfigDao = sysConfigDao;
	}
	
	@Override
	@CacheEvict(value = "user", key = "com:dot:live:comm:service:+#sysConfig.id") 
	public void save(SysConfig sysConfig)  {
		sysConfigDao.save(sysConfig);
	}

	@Override
	public List<SysConfig> getByPId(String pId){
		return sysConfigDao.getByPId(pId);
	}
	
	/**
	 * 初始化mongdb，生成各个collection对应的id值
	 */
	@Override
	public void dbInit(){
		sysConfigDao.init();
	}
	

}
