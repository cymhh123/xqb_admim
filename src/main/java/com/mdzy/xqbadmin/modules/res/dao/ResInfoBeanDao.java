/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.res.dao;


import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.res.entity.ResInfoBean;
import com.mdzy.xqbadmin.modules.res.entity.UserRes;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * res_infoDAO接口
 * @author chengyou
 * @version 2016-09-05
 */
@MyBatisDao
public interface ResInfoBeanDao extends CrudDao<ResInfoBean> {
    /**
     * 查询用户收藏的资源
     * @return
     */
    List<ResInfoBean> findResCollectionList(@Param("userId") String userId, @Param("sorts") List<Integer> sorts);

    /**
     * 用户收藏资源
     * @param userRes
     */
    void saveResCollection(UserRes userRes);
}