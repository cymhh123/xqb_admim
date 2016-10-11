package com.mdzy.xqbadmin.modules.api.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.CollectionBean;
import com.mdzy.xqbadmin.modules.video.service.CollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
@RequestMapping("/api/collection")
public class CollectionActionApi extends BaseController {
    @Autowired
    private CollectionService collectionService;

    /**
     * 用户收藏的专题
     * @param userId
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String userId,Integer page){
        if(StringUtils.isBlank(userId) || page == null){
            return new ExecuteBean<>("201","参数错误");
        }
        CollectionBean collectionBean = new CollectionBean();
        collectionBean.setUserId(userId);
        List<CollectionBean> list =  this.collectionService.findByPage(collectionBean,page);
        PageInfo<CollectionBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 收藏专题
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object saveCollection(String userId,String subjectId){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(subjectId)){
            return new ExecuteBean<>("201","参数有误");
        }
        try{
            this.collectionService.saveCollection(userId,subjectId);
        }catch (ServiceException e){
            return new ExecuteBean<>("202",e.getMessage());
        }
        return new ExecuteBean<>();
    }

}
