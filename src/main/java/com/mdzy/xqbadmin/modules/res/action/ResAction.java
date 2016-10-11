package com.mdzy.xqbadmin.modules.res.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.res.entity.ResInfoBean;
import com.mdzy.xqbadmin.modules.res.service.ResInfoBeanService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by chyou on 2016/9/1.
 */
@Controller
@RequestMapping("${adminPath}/res")
public class ResAction extends BaseController {

    @Autowired
    private ResInfoBeanService resInfoBeanService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/res/add";
        }else if(type.equals("edit")){
            return "/res/edit";
        }else if(type.equals("list")){
            return "/res/list";
        }
        return null;
    }
    /**
     * 添加
     * @param resInfoBean
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(ResInfoBean resInfoBean){
        this.resInfoBeanService.save(resInfoBean);
        return new ExecuteBean<>();
    }

    /**
     * 列表
     * @param resInfoBean
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(ResInfoBean resInfoBean,Integer page){
        List<ResInfoBean> list = this.resInfoBeanService.findByPage(resInfoBean,page);
        PageInfo<ResInfoBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<ResInfoBean>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.resInfoBeanService.delete(id);
        return new ExecuteBean<>();
    }
}
