/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.posts.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;


/**
 * 帖子回复Entity
 * @author chengyou
 * @version 2016-09-10
 */
public class ReplyBean extends DataEntity {
	
	private static final long serialVersionUID = 1L;
	private String userId;		// user_id
	private String circleId;		// circle_id
	private String toUserId;		// to_user
	private String replyId;		// reply_id
	private String content;		// content
	private String nick;
	private String toNick;
	private String avatar;
	private String toAvatar;
	
	public ReplyBean() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getCircleId() {
		return circleId;
	}

	public void setCircleId(String circleId) {
		this.circleId = circleId;
	}
	
	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	
	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}


	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getToNick() {
		return toNick;
	}

	public void setToNick(String toNick) {
		this.toNick = toNick;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getToAvatar() {
		return toAvatar;
	}

	public void setToAvatar(String toAvatar) {
		this.toAvatar = toAvatar;
	}
}