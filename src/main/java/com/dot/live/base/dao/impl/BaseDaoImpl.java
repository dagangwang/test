package com.dot.live.base.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.dot.live.base.dao.BaseDao;
import com.dot.live.base.domain.IdGenInfo;
import com.dot.live.utils.Pagination;

/**
 * 
 * @author heshuangquan
 *
 * @param <T>
 * @param <ID>
 */
@Repository("mongoBaseDao")
public class BaseDaoImpl<T, ID extends Serializable> implements BaseDao<T,ID> {
	
	private Class<T> type; 
	
	protected static final int PAGE_SIZE = 10; 
	
	@Autowired 
    protected RedisTemplate<String,Object> redisTemplate; 
	
	@Autowired
	protected MongoTemplate mongoTemplate;
	
	public BaseDaoImpl(Class<T> type) {  
        this.type = type;  
    }  
	
	public BaseDaoImpl(){
		
	}
	
	@Override
	public boolean init(){
		if(!mongoTemplate.collectionExists(IdGenInfo.class)){
			mongoTemplate.createCollection(IdGenInfo.class);
		}
		for(MongoColls coll : MongoColls.values()){
			 boolean hasCollec = mongoTemplate.exists(new Query(Criteria.where("coll_name").is(coll.getCollName())), IdGenInfo.class);
			 if(!hasCollec){
				 IdGenInfo idGenInfo = new IdGenInfo();
				 idGenInfo.setCollName(coll.getCollName());
				 idGenInfo.setCollDesc(coll.getCollDesc());
				 idGenInfo.setIdIndex(0l);
				 mongoTemplate.insert(idGenInfo);
			 }
		 }
		 return true;
	}
	
	@Override
	public long generateId(){
		IdGenInfo info = this.mongoTemplate.findAndModify(new Query(Criteria.where("coll_name").is(getColName())),  new Update().inc("id_index", 1), IdGenInfo.class);
		return info.getIdIndex();
	}
	
	@Override
	public void save(T t){
		mongoTemplate.save(t);
	}
	
	@Override
	public void insert(T t){
		mongoTemplate.insert(t);
	}
	
	@Override
	public String getColName(){
		return this.mongoTemplate.getCollectionName(type);
	}

	@Override
	public T getById(ID id){
		return mongoTemplate.findById(id, type);
	}

	@Override
	public void remove(ID id) {
		mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), type);
	}
	
	@Override
	public void removeAll(ID[] ids){
		mongoTemplate.remove(new Query(Criteria.where("_id").in(ids)), type);
	}
	
	@Override
	public Pagination<T> getPage(int currentPage, Query query) {
		
		long totalCount = this.mongoTemplate.count(query, type);  
        //总页数  
        Pagination<T> page = new Pagination<T>(currentPage, totalCount,PAGE_SIZE);  
        query.skip((page.getCurrentPage() - 1) * page.getPageSize());
        query.limit(PAGE_SIZE);// 从skip开始,取多少条记录  
        List<T> datas = this.mongoTemplate.find(query, type);  
        page.setItems(datas);//获取数据      
        return page;  
	}

	@Override
	public void update(Query query, Update update){
		mongoTemplate.findAndModify(query, update, type);
	}

	@Override
	public List<T> getAll(){
		return mongoTemplate.findAll(type);
	}

	
	
	@Override
	public RedisTemplate<String, Object> getRedisTemplate() {
		return redisTemplate;
	}

	@Override
	public void insert(List<T> ts){
		mongoTemplate.insert(ts, type);

	}
	@Override
	public MongoTemplate getMongoTemplate(){
		return mongoTemplate;
	}

	
}
