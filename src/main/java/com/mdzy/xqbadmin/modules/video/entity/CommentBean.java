package com.mdzy.xqbadmin.modules.video.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by Administrator on 2016-07-20.
 */
public class CommentBean extends DataEntity {
    @NotBlank
    private String subjectCourseId;
    @NotBlank
    private String content;
    @NotBlank
    private String userId;
    @NotBlank
    private String type;
    private String userName;
    private String avatar;
    private List<ReplayBean> replays;


    public String getSubjectCourseId() {
        return subjectCourseId;
    }

    public void setSubjectCourseId(String subjectCourseId) {
        this.subjectCourseId = subjectCourseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ReplayBean> getReplays() {
        return replays;
    }

    public void setReplays(List<ReplayBean> replays) {
        this.replays = replays;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
