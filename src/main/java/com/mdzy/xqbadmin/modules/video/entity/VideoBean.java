package com.mdzy.xqbadmin.modules.video.entity;


import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/22.
 */
public class VideoBean extends DataEntity {
    private String title;		// title
    private String imgUrl;		// img_url
    private String teacherName;		// teacher_name
    private String playUrl;		// play_url
    private String type;		// type
    private String profiles;		// profiles
    private String subjectId;
    private String pushUrl;
    private Date startTime;
    private LiveBean liveBean;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public LiveBean getLiveBean() {
        return liveBean;
    }

    public void setLiveBean(LiveBean liveBean) {
        this.liveBean = liveBean;
    }

    public String getPushUrl() {
        return pushUrl;
    }

    public void setPushUrl(String pushUrl) {
        this.pushUrl = pushUrl;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

}
