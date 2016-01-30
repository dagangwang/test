/**
 * 
 */
package com.dot.live.cms.vo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author hesq1
 * @date 2015年11月1日
 * @desc 
 */
public class ArticleVo {
		//id
		private Long id;
		
		//文章标题
		private String title;
		
		//文章简介
		private String brief;
		
		//文章首图
		private String atcPic;
		
		//上传图片
		private MultipartFile  poster;
		
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

		public MultipartFile getPoster() {
			return poster;
		}

		public void setPoster(MultipartFile poster) {
			this.poster = poster;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}
		
		
		
}
