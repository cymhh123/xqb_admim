package com.mdzy.xqbadmin.modules.api.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.SubjectBean;
import com.mdzy.xqbadmin.modules.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
@RequestMapping("/api/subject")
public class SubjectActionApi extends BaseController {
    @Autowired
    private SubjectService subjectService;

    /**
     * 专题列表
     * @param page
     * @param type 0：直播 1：点播
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer page,String type){
        if(StringUtils.isBlank(type) || page == null){
            return new ExecuteBean<>("201","参数有误");
        }
        SubjectBean subjectBean = new SubjectBean();
        subjectBean.setPubStatus("1");//上架
        subjectBean.setType(type);
        List<SubjectBean> list = this.subjectService.findByPage(subjectBean,page);
        PageInfo<SubjectBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 查询专题详情
     * @param subjectId
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public Object info(String subjectId){
        if(StringUtils.isBlank(subjectId)){
            return new ExecuteBean<>("201","参数有误");
        }
        SubjectBean subjectBean = this.subjectService.infoWithCourse(subjectId);
        return new ExecuteBean<>(subjectBean);
    }

    /**
     * 查询用户浏览记录
     * @param subjectIds
     * @return
     */
    @RequestMapping("/history")
    @ResponseBody
    public Object findListByHistory(String subjectIds){
        if(StringUtils.isBlank(subjectIds)){
            return new ExecuteBean<>("201","参数有误");
        }
        List<SubjectBean> list = this.subjectService.history(subjectIds);
        return new ExecuteBean<List<SubjectBean>>(list);
    }
}
