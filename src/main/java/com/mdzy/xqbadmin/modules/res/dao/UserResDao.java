package com.mdzy.xqbadmin.modules.res.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.res.entity.UserRes;

/**
 * UserResDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface UserResDao extends CrudDao<UserRes> {

}