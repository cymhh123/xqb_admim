package com.mdzy.xqbadmin.modules.banner.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.banner.entity.Banner;

/**
 * BannerDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface BannerDao extends CrudDao<Banner> {

}