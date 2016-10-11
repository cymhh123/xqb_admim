package com.mdzy.xqbadmin.modules.video.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.SubjectBean;
import com.mdzy.xqbadmin.modules.video.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/8.
 */
@Controller
@RequestMapping("${adminPath}/subject")
public class SubejctAction extends BaseController {
    @Autowired
    private SubjectService subjectService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/video/subject_add";
        }else if(type.equals("edit")){
            return "/video/subject_edit";
        }else if(type.equals("list")){
            return "/video/subject_list";
        }
        return null;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(SubjectBean entity){
        entity.setPubStatus("0");//未上架
        this.subjectService.save(entity);
        return new ExecuteBean<>();
    }

    /**
     * 列表
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(SubjectBean entity, Integer page){
        List<SubjectBean> list = this.subjectService.findByPage(entity,page);
        PageInfo<SubjectBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<SubjectBean>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.subjectService.delete(id);
        return new ExecuteBean<>();
    }

    /**
     * 上下架
     * @param entity
     * @return
     */
    @RequestMapping("/pub")
    @ResponseBody
    public Object pub(SubjectBean entity){
        entity.setPubTime(new Date());
        this.subjectService.update(entity);
        return new ExecuteBean<>();
    }
}
