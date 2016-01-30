package com.dot.live.comm.service;

import java.util.List;

import com.dot.live.base.service.IBaseService;
import com.dot.live.comm.domain.SysConfig;

public interface ISysConfigService extends IBaseService<SysConfig,String>{
	
	  
	public List<SysConfig> getByPId(String pId);
	
	public void dbInit();
	
}
