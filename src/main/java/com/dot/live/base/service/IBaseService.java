package com.dot.live.base.service;

import java.io.Serializable;
import java.util.List;

import com.dot.live.utils.Pagination;

public interface IBaseService<T, ID extends Serializable> {
	
	public void save(T t);
	
	public T getById(ID id);
	
	public void remove(ID id);
	
	public void update(T t);
	
	public void removeAll(ID[] ids);
	
	public List<T> getAll();
	
	public void insert(List<T> ts);
	
	public Pagination<T> getPage(int currentPage);
}
