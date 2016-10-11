package com.mdzy.xqbadmin.modules.notice.action;

import com.mdzy.xqbadmin.common.config.Global;
import com.mdzy.xqbadmin.modules.notice.entity.Notice;
import com.mdzy.xqbadmin.modules.notice.service.NoticeService;
import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * NoticeAction
 * auther:chyou
 */
@Controller
@RequestMapping("${adminPath}/notice")
public class NoticeAction extends BaseController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/notice/add";
        }else if(type.equals("edit")){
            return "/notice/edit";
        }else if(type.equals("list")){
            return "/notice/list";
        }else if(type.equals("send")){
            return "/notice/send_notice";
        }
        return null;
    }

    /**
     * 列表
     * @param page 当前页
     * @param notice 参数实体
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer page,@Valid Notice notice,BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return  new ExecuteBean<>("201","参数有误");
        }
        List<Notice> list = this.noticeService.findByPage(notice,page);
        PageInfo<Notice> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<Notice>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 查询所有消息
     * @return
     */
    @RequestMapping("/all")
    @ResponseBody
    public Object listAll(){
        List<Notice> list = this.noticeService.findList(new Notice());
        return new ExecuteBean<List<Notice>>(list);
    }

    /**
     * 单个
     * @param id
     * @return
     */
    @RequestMapping("/one")
    @ResponseBody
    public Object get(String id,Model model){
        Notice notice = this.noticeService.get(id);
        return new ExecuteBean<Notice>(notice);
    }

    /**
     * 添加
     * @param notice
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(Notice notice){
        Integer category = notice.getCategory();
        this.noticeService.save(notice);
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
        this.noticeService.delete(id);
        return new ExecuteBean<>();
    }

    /**
     * 消息详情页
     * @param id  消息id
     * @param model
     * @return
     */
    @RequestMapping("/info")
    public String info(String id, Model model){
        Notice notice = this.noticeService.get(id);
        model.addAttribute("notice",notice);
        return "notice/info";
    }

}
