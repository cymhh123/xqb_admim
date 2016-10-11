package com.mdzy.xqbadmin.modules.notice.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.notice.entity.UserNotice;
import com.mdzy.xqbadmin.modules.notice.service.UserNoticeService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * UserNoticeAction
 * auther:chyou
 */
@Controller
@RequestMapping("${adminPath}/user/notice")
public class UserNoticeAction extends BaseController {

    @Autowired
    private UserNoticeService userNoticeService;

    /**
     * 列表
     * @param page 当前页
     * @param userNotice 参数实体
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer page, @Valid UserNotice userNotice, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
             return  new ExecuteBean<>("201","参数有误");
        }
        List<UserNotice> list = this.userNoticeService.findByPage(userNotice,page);
        PageInfo<UserNotice> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<UserNotice>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 单个
     * @param id
     * @return
     */
    @RequestMapping("/one")
    @ResponseBody
    public Object get(String id,Model model){
       UserNotice userNotice = this.userNoticeService.get(id);
       return new ExecuteBean<UserNotice>(userNotice);
    }

    /**
     * 添加
     * @param userNotice
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(UserNotice userNotice){
        this.userNoticeService.save(userNotice);
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
         this.userNoticeService.delete(id);
         return new ExecuteBean<>();
     }

    /**
     * 发送消息
     * @return
     */
    @RequestMapping("/send")
    @ResponseBody
    public Object sendNotice(String userAccounts,String noticeIds){
        if(StringUtils.isBlank(userAccounts) || StringUtils.isBlank(noticeIds)){
            return new ExecuteBean<>("202","未选择用户和消息");
        }
        String[] userIdArr = userAccounts.split(",");
        String[] noticeIdArr = noticeIds.split(",");
        this.userNoticeService.batchJpush(Arrays.asList(userIdArr),Arrays.asList(noticeIdArr));
        return new ExecuteBean<>();
    }
}
