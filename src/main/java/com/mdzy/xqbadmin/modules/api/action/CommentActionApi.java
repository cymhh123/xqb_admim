package com.mdzy.xqbadmin.modules.api.action;

import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.CommentBean;
import com.mdzy.xqbadmin.modules.video.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 评论模块
 * Created by Administrator on 2016-07-20.
 */
@Controller
@RequestMapping("/api/comment")
public class CommentActionApi extends BaseController {
    @Autowired
    private CommentService commentService;

    /**
     * 保存评论
     * @param commentBean
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object saveComment(@Validated CommentBean commentBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ExecuteBean<>("201","参数有误");
        }
        this.commentService.save(commentBean);
        return new ExecuteBean<>();
    }

    /**
     * 查询评论列表
     * @param subjectCourserId
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String subjectCourserId){
        if(StringUtils.isBlank(subjectCourserId)){
            return new ExecuteBean<>("201","参数有误");
        }
        CommentBean commentBean = new CommentBean();
        commentBean.setSubjectCourseId(subjectCourserId);
        List<CommentBean> list = this.commentService.findList(commentBean);
        return new ExecuteBean<List<CommentBean>>(list);
    }
}
