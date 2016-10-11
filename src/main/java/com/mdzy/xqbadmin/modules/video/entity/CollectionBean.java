/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.video.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import org.hibernate.validator.constraints.NotBlank;


/**
 * 专题收藏Bean
 * @author chengyou
 * @version 2016-07-19
 */
public class CollectionBean extends DataEntity {
	
	private static final long serialVersionUID = 1L;
	private String userId;
	private String subjectId;

	private SubjectBean subjectBean;

	public SubjectBean getSubjectBean() {
		return subjectBean;
	}

	public void setSubjectBean(SubjectBean subjectBean) {
		this.subjectBean = subjectBean;
	}
	public CollectionBean() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}
	
}