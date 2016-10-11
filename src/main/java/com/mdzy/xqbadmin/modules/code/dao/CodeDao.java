package com.mdzy.xqbadmin.modules.code.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.code.entity.Code;

/**
 * CodeDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface CodeDao extends CrudDao<Code> {

}