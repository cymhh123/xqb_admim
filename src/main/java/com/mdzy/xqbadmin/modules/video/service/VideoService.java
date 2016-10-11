package com.mdzy.xqbadmin.modules.video.service;

import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.video.dao.VideoDao;
import com.mdzy.xqbadmin.modules.video.entity.LiveBean;
import com.mdzy.xqbadmin.modules.video.entity.VideoBean;
import org.springframework.stereotype.Service;


/**
 * Created by Administrator on 2016/7/22.
 */
@Service
public class VideoService extends CrudService<VideoDao,VideoBean>{

    /**
     * 视频保存
     * @param videoBean
     */
    public void saveVideo(VideoBean videoBean){
        super.save(videoBean);
        //直播，保存直播信息
        if(videoBean.getType().equals("0")){
            LiveBean liveBean = new LiveBean();
            liveBean.setCourseId(videoBean.getId());
            liveBean.setPlayStatus("0");//即将开始
            liveBean.setPushUrl(videoBean.getPushUrl());
            liveBean.setStartTime(videoBean.getStartTime());
            liveBean.preInsert();
            super.dao.insertLive(liveBean);
        }
    }
}
