/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.user.entity;

import com.mdzy.xqbadmin.modules.posts.entity.PostsBean;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.util.Date;
import java.util.List;

/**
 * 用户管理Entity
 * @author chengyou
 * @version 2016-09-06
 */
public class UserBean extends DataEntity {
	
	private static final long serialVersionUID = 1L;
	@NotBlank
	private String nick;		// 昵称
	@NotBlank
	private String sex;		// 性别（0：女1：男2:保密）
	private String phone;		// 绑定手机号
	@NotBlank
	private String imgUrl;		// 头像url
	@NotBlank
	private String account;		// 账号
	@NotBlank
	private String type;		// 账号类型：0:手机号,1:qq,2:微信
	private String password;		// 密码
	private String sexL;
	private String userTypeL;
	//帖子列表
	List<PostsBean> postList;
	private String qiNiuToken;

	public String getQiNiuToken() {
		return qiNiuToken;
	}

	public void setQiNiuToken(String qiNiuToken) {
		this.qiNiuToken = qiNiuToken;
	}

	public UserBean() {
		super();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
		if(sex != null){
			this.setSexL(DictUtils.getDictLabel(sex,"sex",""));
		}
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
		if(type != null){
			this.setUserTypeL(DictUtils.getDictLabel(type,"user_type",""));
		}
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSexL() {
		return sexL;
	}

	public void setSexL(String sexL) {
		this.sexL = sexL;
	}

	public String getUserTypeL() {
		return userTypeL;
	}

	public void setUserTypeL(String userTypeL) {
		this.userTypeL = userTypeL;
	}


	public List<PostsBean> getPostList() {
		return postList;
	}

	public void setPostList(List<PostsBean> postList) {
		this.postList = postList;
	}
}