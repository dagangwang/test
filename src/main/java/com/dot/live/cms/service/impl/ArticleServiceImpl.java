/**
 * 
 */
package com.dot.live.cms.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dot.live.base.service.impl.BaseServiceImpl;
import com.dot.live.cms.dao.ArticleDao;
import com.dot.live.cms.domain.Article;
import com.dot.live.cms.service.ArticleService;

/**
 * @author hesq1
 * @date 2015年11月1日
 * @desc 
 */
@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article,Long> implements ArticleService{

	static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class); 
	
	ArticleDao articleDao;
	
	@Autowired
	public ArticleServiceImpl(ArticleDao articleDao){
		super(articleDao);  
		this.articleDao = articleDao;
	}

	
}
