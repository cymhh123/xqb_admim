/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.posts.entity;

import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

import java.util.Date;
import java.util.List;

/**
 * 帖子管理Entity
 * @author chengyou
 * @version 2016-09-10
 */
public class PostsBean extends DataEntity {
	
	private static final long serialVersionUID = 1L;
	private String circleId;		// circle_id
	private String userId;		// user_id
	private String content;		// 内容
	private String imgUrl;		// img_url
	private Integer clickNum;		// 查看
	private Integer likeNum;		// 喜欢,收藏
	private Integer praiseNum;		// 点赞
	private String nick; //昵称
	private String title;//圈子标题
	private String[] imgUrls;
	private String avatar;
	private List<ReplyBean> replyList;

	public List<ReplyBean> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyBean> replyList) {
		this.replyList = replyList;
	}

	public PostsBean() {
		super();
	}

	public String getCircleId() {
		return circleId;
	}

	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
		if(StringUtils.isNotBlank(imgUrl)){
			this.imgUrls = imgUrl.split(",");
		}
	}
	
	public Integer getClickNum() {
		return clickNum;
	}

	public void setClickNum(Integer clickNum) {
		this.clickNum = clickNum;
	}
	
	public Integer getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(Integer likeNum) {
		this.likeNum = likeNum;
	}
	
	public Integer getPraiseNum() {
		return praiseNum;
	}

	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String[] getImgUrls() {
		return imgUrls;
	}

	public void setImgUrls(String[] imgUrls) {
		this.imgUrls = imgUrls;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
}