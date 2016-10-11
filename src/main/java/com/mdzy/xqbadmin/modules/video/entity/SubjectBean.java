package com.mdzy.xqbadmin.modules.video.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;
import org.hibernate.validator.constraints.NotBlank;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/7/21.
 */
public class SubjectBean extends DataEntity {
    private static final long serialVersionUID = 1L;
    private String title;		// title
    private String profiles;		// profiles
    private String imgUrl;		// img_url
    private BigDecimal price;		// price
    private String freeFlag;		// free_flag
    private String freeFlagL;
    private String pubStatus;		// pub_status
    private String pubStatusL;
    private Date pubTime;		// pub_time
    private String type;		// type
    private String typeL;
    private String label;		// label
    private Date startTime;		// start_time
    private String editFlag;
    private List<VideoBean> courseList;

    public List<VideoBean> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<VideoBean> courseList) {
        this.courseList = courseList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProfiles() {
        return profiles;
    }

    public void setProfiles(String profiles) {
        this.profiles = profiles;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFreeFlag() {
        return freeFlag;
    }

    public void setFreeFlag(String freeFlag) {
        this.freeFlag = freeFlag;
        if(StringUtils.isNotBlank(freeFlag)){
            this.setFreeFlagL(DictUtils.getDictLabel(freeFlag,"free_flag",""));
        }
    }

    public String getPubStatus() {
        return pubStatus;
    }

    public void setPubStatus(String pubStatus) {
        this.pubStatus = pubStatus;
        if(StringUtils.isNotBlank(pubStatus)){
            this.setPubStatusL(DictUtils.getDictLabel(pubStatus,"pub_status",""));
        }
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if(StringUtils.isNotBlank(type)){
            this.setTypeL(DictUtils.getDictLabel(type,"subject_type",""));
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getFreeFlagL() {
        return freeFlagL;
    }

    public void setFreeFlagL(String freeFlagL) {
        this.freeFlagL = freeFlagL;
    }

    public String getPubStatusL() {
        return pubStatusL;
    }

    public void setPubStatusL(String pubStatusL) {
        this.pubStatusL = pubStatusL;
    }

    public String getTypeL() {
        return typeL;
    }

    public void setTypeL(String typeL) {
        this.typeL = typeL;
    }
    public String getEditFlag() {
        return editFlag;
    }

    public void setEditFlag(String editFlag) {
        this.editFlag = editFlag;
    }

}
