package com.mdzy.xqbadmin.modules.video.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.video.entity.CommentBean;

/**
 * Created by Administrator on 2016-07-20.
 */
@MyBatisDao
public interface CommentDao extends CrudDao<CommentBean> {
}
