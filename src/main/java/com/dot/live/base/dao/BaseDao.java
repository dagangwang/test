package com.dot.live.base.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;

import com.dot.live.utils.Pagination;


/**
 * 
 * @author heshuangquan
 *
 * @param <T>
 * @param <ID>
 */
public interface BaseDao <T, ID extends Serializable>{
	
	public boolean init();
	
	public void save(T t);
	
	public void insert(T t);
	
	public void insert(List<T> ts);
	
	public T getById(ID id);
	
	public void remove(ID id);
	
	public void removeAll(ID[] ids);
	
	public Pagination<T> getPage(int currentPage, Query query);
	
	public void update(Query query, Update update);
	
	public List<T> getAll();
	
	public String getColName();
	
	public long generateId();
	
	public RedisTemplate<String, Object> getRedisTemplate();
	
	public MongoTemplate getMongoTemplate();
	
}
