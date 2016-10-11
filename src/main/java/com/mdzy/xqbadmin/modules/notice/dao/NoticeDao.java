package com.mdzy.xqbadmin.modules.notice.dao;

import com.mdzy.xqbadmin.common.persistence.CrudDao;
import com.mdzy.xqbadmin.common.persistence.annotation.MyBatisDao;
import com.mdzy.xqbadmin.modules.notice.entity.Notice;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * NoticeDAO接口
 * @author chyou
 * @version
 */
@MyBatisDao
public interface NoticeDao extends CrudDao<Notice> {

    /**
     * 查询用户消息
     * @param userId
     * @return
     */
    List<Notice> listByUserId(@Param("userId") String userId);
}