package com.mdzy.xqbadmin.modules.video.action;

import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import com.mdzy.xqbadmin.modules.video.entity.VideoBean;
import com.mdzy.xqbadmin.modules.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/9.
 */
@Controller
@RequestMapping("${adminPath}/course")
public class VideoAction extends BaseController {
    @Autowired
    public VideoService videoService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("course_add")){
            return "/video/course_add";
        }else if(type.equals("list")){
            return "/video/course_list";
        }else if(type.equals("live_add")){
            return "/video/course_live_add";
        }
        return null;
    }

    /**
     * 添加
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(VideoBean entity){
        this.videoService.saveVideo(entity);
        return new ExecuteBean<>();
    }

    /**
     * 列表
     * @param entity
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(VideoBean entity){
        List<VideoBean> list = this.videoService.findList(entity);
        return new ExecuteBean<>(list);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.videoService.delete(id);
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }
}
