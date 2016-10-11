package com.mdzy.xqbadmin.modules.api.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.res.entity.ResInfoBean;
import com.mdzy.xqbadmin.modules.res.entity.UserRes;
import com.mdzy.xqbadmin.modules.res.service.ResInfoBeanService;
import com.mdzy.xqbadmin.modules.res.service.UserResService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 资源管理
 * Created by chyou on 2016/9/1.
 */
@Controller
@RequestMapping("/api/res")
public class ResActionApi extends BaseController {

    @Autowired
    private ResInfoBeanService resInfoBeanService;
    @Autowired
    private UserResService userResService;

    /**
     * 资源列表
     * @param sorts 分类0：游戏1：故事2：儿歌3：文学4：教育指南
     * @param page 当前页
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer sorts,Integer page){
        if(sorts==null || page == null){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        ResInfoBean resInfoBean = new ResInfoBean();
        resInfoBean.setSorts(sorts);
        List<ResInfoBean> list = this.resInfoBeanService.findByPage(resInfoBean,page);
        PageInfo<ResInfoBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 资源详情页
     * @param id 资源id
     * @param model
     * @return
     */
    @RequestMapping("/info")
    public String info(String id,Model model){
        ResInfoBean resInfoBean = this.resInfoBeanService.get(id);
        model.addAttribute("res",resInfoBean);
        return "res/res_info";
    }

    /**
     * 查询用户收藏资源列表
     * @param userId 用户id
     * @param sorts 类别,多个“,”分割
     * @param page 当前页
     * @return
     */
    @RequestMapping("/user/list")
    @ResponseBody
    public Object collection(String userId,String sorts,Integer page){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(sorts) || page==null){
            return  new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        String[] sortsArr = sorts.split(",");
        UserRes userRes = new UserRes();
        userRes.setUserId(userId);
        userRes.setSorts(sortsArr);
        List<UserRes> list = this.userResService.findByPage(userRes,page);
        PageInfo<UserRes> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 用户收藏资源
     * @param userId 用户id
     * @param resId 资源id
     * @return
     */
    @RequestMapping("/user/save")
    @ResponseBody
    public Object saveCollection(String userId,String resId){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(resId)){
            return  new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.userResService.saveResCollection(userId,resId);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>();
    }

}
