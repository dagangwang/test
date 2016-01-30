/**
 * 
 */
package com.dot.live.cms.dao.impl;

import org.springframework.stereotype.Repository;

import com.dot.live.base.dao.impl.BaseDaoImpl;
import com.dot.live.cms.dao.ArticleDao;
import com.dot.live.cms.domain.Article;

/**
 * @author hesq1
 * @date 2015年11月1日
 * @desc 
 */
@Repository("articleDao")
public class ArticleDaoImpl extends BaseDaoImpl<Article,Long> implements ArticleDao{
	
	public ArticleDaoImpl(){
		 super(Article.class);  
	}
	
	@Override
	public void save(Article t){
		if(null == t.getId()){
			t.setId(this.generateId());
		}
		super.save(t);
	}
	
}
