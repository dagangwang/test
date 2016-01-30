package com.dot.live.base.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.dot.live.base.dao.BaseDao;
import com.dot.live.base.service.IBaseService;
import com.dot.live.utils.Pagination;

@Service("baseService")
public class BaseServiceImpl<T, ID extends Serializable> implements IBaseService<T, ID>{
	
	private BaseDao<T,ID> baseDao;
	
	public BaseServiceImpl(BaseDao<T,ID> dao){
		this.baseDao = dao;
	}
	
	public BaseServiceImpl(){
		
	}
	
	@Override
	public void save(T t)  {
		baseDao.save(t);
	}

	@Override
	public T getById(ID id){
		return baseDao.getById(id);
	}

	@Override
	public void remove(ID id){
		baseDao.remove(id);
		
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}

	@Override
	public void insert(List<T> ts) {
		baseDao.insert(ts);
	}

	@Override
	public void removeAll(ID[] ids) {
		baseDao.removeAll(ids);
	}

	@Override
	public void update(T t) {
		baseDao.save(t);
	}

	@Override
	public Pagination<T> getPage(int currentPage) {
		Query query = new Query().with(new Sort(new Sort.Order(Sort.Direction.ASC, "id")));
		Pagination<T> page = baseDao.getPage(currentPage, query);
		return page;
	}
}
