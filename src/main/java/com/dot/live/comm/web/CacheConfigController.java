package com.dot.live.comm.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dot.live.comm.domain.CacheConfig;
import com.dot.live.comm.service.ICacheConfigService;
import com.dot.live.utils.Pagination;
import com.dot.live.utils.valid.ValidateUtil;


@RestController 
@RequestMapping(value="/admin/cache")
public class CacheConfigController {
	
	Logger logger = LoggerFactory.getLogger(CacheConfigController.class); 
	
	@Autowired
	ICacheConfigService cacheConfigService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)  
	public CacheConfig get(@PathVariable(value="id") String id){
		return cacheConfigService.getById(id);
	} 
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)  
	public void save(CacheConfig cacheConfig){
		cacheConfigService.save(cacheConfig);
    } 
	
	@RequestMapping(value = "/page/{currentPage}", method = RequestMethod.GET) 
	public Pagination<CacheConfig> page(@PathVariable(value="currentPage") Integer currentPage){
		ValidateUtil.notNull(currentPage);
		return cacheConfigService.getPage(currentPage);
    }  
	
	@RequestMapping(value = "/del", method = RequestMethod.POST)  
	public void del(HttpServletRequest request, HttpServletResponse response,String[] id){
		cacheConfigService.removeAll(id);
	} 
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)  
	public void update(HttpServletRequest request, HttpServletResponse response,CacheConfig cacheConfig){
		cacheConfigService.update(cacheConfig);
	} 

}
