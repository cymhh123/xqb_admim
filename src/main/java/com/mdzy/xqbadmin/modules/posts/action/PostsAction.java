package com.mdzy.xqbadmin.modules.posts.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.posts.entity.PostsBean;
import com.mdzy.xqbadmin.modules.posts.service.PostsBeanService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 帖子管理
 * Created by chyou on 2016/9/10.
 */
@Controller
@RequestMapping("${adminPath}/posts")
public class PostsAction extends BaseController{
    @Autowired
    private PostsBeanService postsBeanService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/posts/add";
        }else if(type.equals("edit")){
            return "/posts/edit";
        }else if(type.equals("list")){
            return "/posts/list";
        }else if(type.equals("info")){
            return "/posts/info";
        }
        return null;
    }

    /**
     * 列表
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(PostsBean entity, Integer page){
        List<PostsBean> list = this.postsBeanService.findByPage(entity,page);
        PageInfo<PostsBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<PostsBean>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.postsBeanService.delete(id);
        return new ExecuteBean<>();
    }
}
