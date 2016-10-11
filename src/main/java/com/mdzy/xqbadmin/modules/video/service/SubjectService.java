package com.mdzy.xqbadmin.modules.video.service;

import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.video.dao.SubjectDao;
import com.mdzy.xqbadmin.modules.video.entity.OrderBean;
import com.mdzy.xqbadmin.modules.video.entity.SubjectBean;
import com.mdzy.xqbadmin.modules.video.entity.VideoBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
@Service
public class SubjectService extends CrudService<SubjectDao, SubjectBean> {
    @Autowired
    private VideoService videoService;

    /**
     * 获得专题详情，包含专题下的课程
     * @param subjectId
     * @return
     */
    public SubjectBean infoWithCourse(String subjectId){
        //专题
        SubjectBean subjectBean = this.dao.get(subjectId);
        //专题课程
        VideoBean videoBean = new VideoBean();
        videoBean.setSubjectId(subjectId);
        List<VideoBean> videoList = this.videoService.findList(videoBean);
        subjectBean.setCourseList(videoList);
        return subjectBean;
    }

    /**
     * 查询用户浏览记录
     * @param subjectIds 专题ids，","分割
     * @return
     */
    public List<SubjectBean> history(String subjectIds){
        String[] subjectIdArr = subjectIds.split(",");
        List<SubjectBean> list = this.dao.history(subjectIdArr);
        return list;
    }
}
