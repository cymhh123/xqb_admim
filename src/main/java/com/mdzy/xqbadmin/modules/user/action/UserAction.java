package com.mdzy.xqbadmin.modules.user.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import com.mdzy.xqbadmin.modules.user.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
@RequestMapping("${adminPath}/user")
@Controller
public class UserAction extends BaseController{
    @Autowired
    private UserBeanService userBeanService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/user/add";
        }else if(type.equals("edit")){
            return "/user/edit";
        }else if(type.equals("list")){
            return "/user/list";
        }
        return null;
    }

    /**
     * 列表
     * @param userBean
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(UserBean userBean, Integer page){
        List<UserBean> list = this.userBeanService.findList(userBean);
        PageInfo<UserBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<UserBean>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.userBeanService.delete(id);
        return new ExecuteBean<>();
    }
}
