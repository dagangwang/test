/**
 * 
 */
package com.dot.live.cms.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author hesq1
 * @date 2015年11月1日
 * @desc 文章类
 */
@Document(collection="cms_aticle")
public class Article {
	
	//id
	@Id
	private Long id;
	
	//所属栏目
	private String columnId;
	
	//文章标题
	private String title;
	
	//文章简介
	private String brief;
	
	//文章首图
	private String atcPic;
	
	//文章内容
	private String content;
	
	//文章作者
	private String author;
	
	//创建时间
	private String createTime;
	
	//发布时间
	private String publishTime;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getAtcPic() {
		return atcPic;
	}

	public void setAtcPic(String atcPic) {
		this.atcPic = atcPic;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getColumnId() {
		return columnId;
	}

	public void setColumnId(String columnId) {
		this.columnId = columnId;
	}
	
}
