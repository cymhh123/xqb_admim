package com.mdzy.xqbadmin.modules.api.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.notice.entity.UserNotice;
import com.mdzy.xqbadmin.modules.notice.service.UserNoticeService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/28.
 */
@Controller
@RequestMapping("/api/user/notice")
public class UserNoticeActionApi extends BaseController{
    @Autowired
    private UserNoticeService userNoticeService;

    /**
     * 用户消息
     * @param account
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String account,Integer page){
        if(StringUtils.isBlank(account) || page == null){
            return new ExecuteBean<>("201","参数有误");
        }
        UserNotice userNotice = new UserNotice();
        userNotice.setUserAccount(account);
        List<UserNotice> list = this.userNoticeService.findByPage(userNotice,page);
        PageInfo<UserNotice> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 用户已读消息
     * @param userNoticeId
     * @return
     */
    @RequestMapping("/read")
    @ResponseBody
    public Object readNotice(String userNoticeId){
        if(StringUtils.isBlank(userNoticeId)){
            return new ExecuteBean<>("201","参数有误");
        }
        UserNotice userNotice = new UserNotice();
        userNotice.setId(userNoticeId);
        userNotice.setReadStatus(1);
        this.userNoticeService.update(userNotice);
        return new ExecuteBean<>();
    }

    /**
     * 删除用户消息
     * @param userNoticeId
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String userNoticeId){
        if(StringUtils.isBlank(userNoticeId)){
            return new ExecuteBean<>("201","参数有误");
        }
        this.userNoticeService.delete(userNoticeId);
        return new ExecuteBean<>();
    }
}
