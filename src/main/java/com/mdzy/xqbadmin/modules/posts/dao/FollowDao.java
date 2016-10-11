package com.mdzy.xqbadmin.modules.posts.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.posts.entity.Follow;

/**
 * FollowDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface FollowDao extends CrudDao<Follow> {

}