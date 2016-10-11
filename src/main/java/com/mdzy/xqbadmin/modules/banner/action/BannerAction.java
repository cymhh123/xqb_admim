package com.mdzy.xqbadmin.modules.banner.action;

import com.mdzy.xqbadmin.modules.banner.entity.Banner;
import com.mdzy.xqbadmin.modules.banner.service.BannerService;
import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * BannerAction
 * auther:chyou
 */
@Controller
@RequestMapping("${adminPath}/banner")
public class BannerAction extends BaseController {

    @Autowired
    private BannerService bannerService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/banner/add";
        }else if(type.equals("edit")){
            return "/banner/edit";
        }else if(type.equals("list")){
            return "/banner/list";
        }
        return null;
    }

    /**
     * 列表
     * @param page 当前页
     * @param banner 参数实体
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer page,Banner banner){
        List<Banner> list = this.bannerService.findByPage(banner,page);
        PageInfo<Banner> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<Banner>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 单个
     * @param id
     * @return
     */
    @RequestMapping("/one")
    @ResponseBody
    public Object get(String id){
        Banner banner = this.bannerService.get(id);
        return new ExecuteBean<Banner>(banner);
    }

    /**
     * 添加
     * @param banner
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(Banner banner){
        this.bannerService.save(banner);
        return new ExecuteBean<>();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.bannerService.delete(id);
        return new ExecuteBean<>();
    }
}
