/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.posts.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;


/**
 * 圈子主题Entity
 * @author chengyou
 * @version 2016-09-10
 */
public class TopicBean extends DataEntity {
	
	private static final long serialVersionUID = 1L;
	private String title;		// title
	private String imgUrl;		// img_url
	private String des;		// des
	private Integer postsNum; //主题下帖子的数量
	
	public TopicBean() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public Integer getPostsNum() {
		return postsNum;
	}

	public void setPostsNum(Integer postsNum) {
		this.postsNum = postsNum;
	}
	
}