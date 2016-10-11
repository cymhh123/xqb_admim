package com.mdzy.xqbadmin.modules.video.dao;


import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.video.entity.SubjectBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
@MyBatisDao
public interface SubjectDao extends CrudDao<SubjectBean> {
    /**
     * 浏览记录
     * @param userId
     * @param subjectIdArr
     * @return
     */
    List<SubjectBean> history(@Param("subjectIdArr")String[] subjectIdArr);
}
