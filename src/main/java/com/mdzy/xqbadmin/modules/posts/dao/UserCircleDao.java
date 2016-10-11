package com.mdzy.xqbadmin.modules.posts.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.posts.entity.UserCircle;

/**
 * 用户收藏/点赞帖子DAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface UserCircleDao extends CrudDao<UserCircle> {

}