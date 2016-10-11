/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.posts.dao;


import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.posts.entity.TopicBean;

/**
 * 用户管理DAO接口
 * @author chengyou
 * @version 2016-09-10
 */
@MyBatisDao
public interface TopicBeanDao extends CrudDao<TopicBean> {
	
}