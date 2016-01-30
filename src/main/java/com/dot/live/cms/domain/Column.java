/**
 * 
 */
package com.dot.live.cms.domain;

import java.util.List;

/**
 * @author hesq1
 * @date 2015年11月13日
 * @desc 栏目
 */
public class Column {
	
	//key
	private String id;
	
	
	private String fid;
	
	//栏目名称
	private String name;
	
	//文章
	private List<Article> articles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}
	
	
	
}
