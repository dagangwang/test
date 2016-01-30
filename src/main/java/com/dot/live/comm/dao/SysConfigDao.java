package com.dot.live.comm.dao;

import java.util.List;

import com.dot.live.base.dao.BaseDao;
import com.dot.live.comm.domain.SysConfig;

public interface SysConfigDao extends BaseDao<SysConfig,String>{
	
	public List<SysConfig> getByPId(String pId);
}
