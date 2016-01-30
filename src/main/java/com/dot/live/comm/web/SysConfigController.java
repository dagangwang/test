package com.dot.live.comm.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dot.live.comm.domain.SysConfig;
import com.dot.live.comm.service.ISysConfigService;
import com.dot.live.utils.Pagination;
import com.dot.live.utils.valid.ValidateUtil;

@RestController 
@RequestMapping("/admin/config")
public class SysConfigController {
	
	Logger logger = LoggerFactory.getLogger(SysConfigController.class); 
	
	@Autowired
	ISysConfigService sysConfigService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)  
	public SysConfig get(@PathVariable(value="id") String id){
		return sysConfigService.getById(id);
	} 
	
	@RequestMapping(value = "/save",method = RequestMethod.POST)  
	public void save(@Valid SysConfig sysConfig,BindingResult result){
		sysConfigService.save(sysConfig);
    }
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)  
	public void update(SysConfig sysConfig){
		sysConfigService.update(sysConfig);
	} 
	
	/**
	 * spring 不支持 RequestMethod.DELETE
	 * @param id
	 */
	@RequestMapping(value = "/del",method = RequestMethod.POST)  
	public void del(String[] id){
		ValidateUtil.notNull(id);
		sysConfigService.removeAll(id);
	} 
	
	@RequestMapping(value = "/page/{currentPage}", method = RequestMethod.GET) 
	public Object page(@PathVariable(value="currentPage") Integer currentPage){
		ValidateUtil.notNull(currentPage);
		Pagination<SysConfig> page = sysConfigService.getPage(currentPage);
		return page;
    }  
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)  
	public List<SysConfig> getAll(HttpServletRequest request, HttpServletResponse response,SysConfig sysConfig){
		return sysConfigService.getAll();
	} 
	
	@RequestMapping(value = "/pid/{pid}", method = RequestMethod.GET)  
	@ResponseBody
	public List<SysConfig> getByPId(@PathVariable(value="pid") String pId){
		return sysConfigService.getByPId(pId);
	} 
	
	@RequestMapping(value = "/dbInit",method = RequestMethod.GET)  
	@ResponseBody
	public void dbInit(HttpServletRequest request, HttpServletResponse response){
		sysConfigService.dbInit();
    }  
	
}
