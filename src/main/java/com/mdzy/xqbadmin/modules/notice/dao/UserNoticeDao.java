package com.mdzy.xqbadmin.modules.notice.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.notice.entity.UserNotice;

/**
 * UserNoticeDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface UserNoticeDao extends CrudDao<UserNotice> {

}