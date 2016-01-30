package com.dot.live.utils;

import java.io.Serializable;
import java.util.List;

public class Pagination<T> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6500271088964993918L;

	/** 每页显示条数 */  
    private Integer pageSize = 8;  
  
    /** 当前页 */  
    private Integer currentPage = 1;  
  
    /** 总页数 */  
    private Integer totalPage = 1;  
  
    /** 查询到的总数据量 */  
    private Long totalNumber = 0l;  
  
    /** 数据集 */  
    private List<T> items;  
    
    
    
    public Integer getPageSize() {
		return pageSize;
	}



	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	
	
	public Integer getCurrentPage() {
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}



	public Integer getTotalPage() {
		return totalPage;
	}



	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}



	public Long getTotalNumber() {
		return totalNumber;
	}



	public void setTotalNumber(Long totalNumber) {
		this.totalNumber = totalNumber;
	}



	public List<T> getItems() {
		return items;
	}


	public void setItems(List<T> items) {
		this.items = items;
	}


	public Pagination(int currentPage, Long totalCount,int pageSize){
		this.totalPage = (int) (totalCount/pageSize);
		this.totalNumber = totalCount;
		this.pageSize = pageSize;
		long count =  this.getTotalNumber();  
        int divisor = (int) (count / this.getPageSize());  
        int remainder = (int) (count % this.getPageSize());  
        this.setTotalPage(remainder == 0 ? divisor == 0 ? 1 : divisor : divisor + 1);
        //control out of bound
        if(currentPage < 1)currentPage = 1;
		if(currentPage > this.getTotalPage())currentPage = this.getTotalPage();
		this.currentPage = currentPage;
	}

}
