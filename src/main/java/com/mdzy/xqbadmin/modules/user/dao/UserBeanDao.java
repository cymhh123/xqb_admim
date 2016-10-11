/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.user.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理DAO接口
 * @author chengyou
 * @version 2016-09-06
 */
@MyBatisDao
public interface UserBeanDao extends CrudDao<UserBean> {
    /**
     * 账号和密码查询用户
     * @param account
     * @param password
     * @return
     */
	UserBean findByAccountAndPwd(@Param("account") String account, @Param("password") String password);

    /**
     * 账号查询用户
     * @param account
     * @return
     */
    UserBean findByAccount(@Param("account") String account);
}