package com.dot.live.comm.dao.mongoImpl;

import java.util.List;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.dot.live.base.dao.impl.BaseDaoImpl;
import com.dot.live.comm.dao.SysConfigDao;
import com.dot.live.comm.domain.SysConfig;

@Repository("sysConfigDao")
public class SysConfigDaoImpl extends BaseDaoImpl<SysConfig,String> implements SysConfigDao {
	
	public SysConfigDaoImpl(){
		 super(SysConfig.class);  
	}
	
	@Override
	public List<SysConfig> getByPId(String pId){
		return this.mongoTemplate.find(new Query(Criteria.where("p_id").is(pId)), SysConfig.class);
	}
	
}
