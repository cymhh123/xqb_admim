package com.mdzy.xqbadmin.modules.video.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/2.
 */
public class OrderBean extends DataEntity {
    private static final long serialVersionUID = 1L;
    private String userId;		// user_id
    private String userName;
    private String subjectId;		// subject_id
    private String price;		// price
    private String payStatus;		// pay_status
    private String payStatusL;
    private Date payTime;		// pay_time
    private String title;
    private String info;
    private String payType;
    private SubjectBean subjectBean;

    public SubjectBean getSubjectBean() {
        return subjectBean;
    }

    public void setSubjectBean(SubjectBean subjectBean) {
        this.subjectBean = subjectBean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
        if(StringUtils.isNotBlank(payStatus)){
            this.setPayStatusL(DictUtils.getDictLabel(payStatus,"pay_status",""));
        }
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPayStatusL() {
        return payStatusL;
    }

    public void setPayStatusL(String payStatusL) {
        this.payStatusL = payStatusL;
    }
}
