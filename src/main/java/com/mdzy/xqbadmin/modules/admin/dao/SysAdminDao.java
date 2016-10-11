package com.mdzy.xqbadmin.modules.admin.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.admin.entity.SysAdmin;

/**
 * SysAdminDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface SysAdminDao extends CrudDao<SysAdmin> {

}