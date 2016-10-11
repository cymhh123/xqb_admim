package com.mdzy.xqbadmin.modules.posts.action;

import com.mdzy.xqbadmin.modules.posts.entity.ReplyBean;
import com.mdzy.xqbadmin.modules.posts.service.ReplyBeanService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 帖子回复管理
 * Created by chyou on 2016/9/10.
 */
@Controller
@RequestMapping("${adminPath}/reply")
public class ReplyAction extends BaseController{
    @Autowired
    private ReplyBeanService replyBeanService;

    /**
     * 列表
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(ReplyBean entity){
        List<ReplyBean> list = this.replyBeanService.findList(entity);
        return new ExecuteBean<List<ReplyBean>>(list);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.replyBeanService.delete(id);
        return new ExecuteBean<>();
    }
}
