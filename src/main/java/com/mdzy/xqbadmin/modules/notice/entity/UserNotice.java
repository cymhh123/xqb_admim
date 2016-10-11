package com.mdzy.xqbadmin.modules.notice.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

/**
 * Created by Administrator on 2016/9/28.
 */
public class UserNotice extends DataEntity{
    private static final long serialVersionUID = 1L;
    private String userAccount;
    private String noticeId;
    private Integer readStatus;
    private Notice notice;

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
    }

    public String getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(String noticeId) {
        this.noticeId = noticeId;
    }

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }
    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

}
