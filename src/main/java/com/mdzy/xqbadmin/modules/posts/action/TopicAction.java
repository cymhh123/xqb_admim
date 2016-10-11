package com.mdzy.xqbadmin.modules.posts.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.posts.entity.TopicBean;
import com.mdzy.xqbadmin.modules.posts.service.TopicBeanService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * 圈子主题管理
 * Created by chyou on 2016/9/10.
 */
@Controller
@RequestMapping("${adminPath}/topic")
public class TopicAction extends BaseController {
    @Autowired
    private TopicBeanService topicBeanService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/topic/add";
        }else if(type.equals("edit")){
            return "/topic/edit";
        }else if(type.equals("list")){
            return "/topic/list";
        }
        return null;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(TopicBean entity){
        this.topicBeanService.save(entity);
        return new ExecuteBean<>();
    }

    /**
     * 列表
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(TopicBean entity,Integer page){
        List<TopicBean> list = this.topicBeanService.findByPage(entity,page);
        PageInfo<TopicBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<TopicBean>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.topicBeanService.delete(id);
        return new ExecuteBean<>();
    }
}
