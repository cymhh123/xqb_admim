package com.mdzy.xqbadmin.modules.video.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/19.
 */
public class LiveBean extends DataEntity {
    private String pushUrl;		// push_url
    private String playStatus;		// play_status
    private Date startTime;		// start_time
    private String courseId;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }

    public String getPlayStatus() {
        return playStatus;
    }

    public void setPlayStatus(String playStatus) {
        this.playStatus = playStatus;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
}
