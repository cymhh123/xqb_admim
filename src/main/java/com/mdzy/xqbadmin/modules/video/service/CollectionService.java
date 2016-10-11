package com.mdzy.xqbadmin.modules.video.service;

import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.video.dao.CollectionDao;
import com.mdzy.xqbadmin.modules.video.entity.CollectionBean;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by Administrator on 2016/7/22.
 */
@Service
public class CollectionService extends CrudService<CollectionDao,CollectionBean>{

    /**
     * 用户收藏
     */
    public void saveCollection(String userId,String subjectId){
        CollectionBean collectionBean = new CollectionBean();
        collectionBean.setUserId(userId);
        collectionBean.setSubjectId(subjectId);
        //查询是否已经收藏
        List<CollectionBean> list = this.dao.findList(collectionBean);
        if(list != null && list.size() > 0){
            throw new ServiceException("用户已收藏");
        }
        this.save(collectionBean);
    }
}
