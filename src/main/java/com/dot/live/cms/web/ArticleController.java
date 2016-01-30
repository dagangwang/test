/**
 * 
 */
package com.dot.live.cms.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dot.live.cms.domain.Article;
import com.dot.live.cms.service.ArticleService;
import com.dot.live.cms.vo.ArticleVo;
import com.dot.live.comm.domain.CacheConfig;
import com.dot.live.comm.domain.SysConfig;
import com.dot.live.utils.Pagination;
import com.dot.live.utils.valid.ValidateUtil;

/**
 * @author hesq1
 * @date 2015年11月1日
 * @desc 
 */
@RestController 
@RequestMapping("/admin/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;

	@RequestMapping(value = "/page/{currentPage}", method = RequestMethod.GET) 
	public Object page(@PathVariable(value="currentPage") Integer currentPage){
		ValidateUtil.notNull(currentPage);
		Pagination<Article> page = articleService.getPage(currentPage);
		return page;
    }  
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)  
	public void save(Article article){
		articleService.save(article);
    } 
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)  
	public Article get(@PathVariable(value="id") Long id){
		return articleService.getById(id);
	} 
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)  
	public void update(Article article){
		articleService.update(article);
	} 
	
	/**
	 * spring 不支持 RequestMethod.DELETE
	 * @param id
	 */
	@RequestMapping(value = "/del",method = RequestMethod.POST)  
	public void del(Long[] id){
		ValidateUtil.notNull(id);
		articleService.removeAll(id);
	} 
	  
}
