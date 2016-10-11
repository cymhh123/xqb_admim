package com.mdzy.xqbadmin.modules.video.dao;


import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.video.entity.LiveBean;
import com.mdzy.xqbadmin.modules.video.entity.VideoBean;

/**
 * Created by Administrator on 2016/7/22.
 */
@MyBatisDao
public interface VideoDao extends CrudDao<VideoBean> {
    Integer insertLive(LiveBean liveBean);
}
