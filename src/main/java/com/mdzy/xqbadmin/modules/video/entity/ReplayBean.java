package com.mdzy.xqbadmin.modules.video.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import org.hibernate.validator.constraints.NotBlank;

/**
 * Created by Administrator on 2016-07-20.
 */
public class ReplayBean extends DataEntity {
    @NotBlank
    private String commentId;
    @NotBlank
    private String content;
    @NotBlank
    private String userId;
    private String userName;
    private String userAvatar;
    private String replayId;
    private String replayName;
    private String replayAvatar;

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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

    public String getReplayId() {
        return replayId;
    }

    public void setReplayId(String replayId) {
        this.replayId = replayId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getReplayName() {
        return replayName;
    }

    public void setReplayName(String replayName) {
        this.replayName = replayName;
    }

    public String getReplayAvatar() {
        return replayAvatar;
    }

    public void setReplayAvatar(String replayAvatar) {
        this.replayAvatar = replayAvatar;
    }

}
