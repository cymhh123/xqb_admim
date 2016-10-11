package com.mdzy.xqbadmin.modules.posts.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

/**
 * 用户收藏/点赞帖子Entity
 * @author chyou
 * @version
 */
public class UserCircle extends DataEntity {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String circleId;
    private Integer operType;

    public UserCircle() {
        super();
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setCircleId(String circleId){
        this.circleId = circleId;
    }
    public String getCircleId(){
        return this.circleId;
    }
    public void setOperType(Integer operType){
        this.operType = operType;
    }
    public Integer getOperType(){
        return this.operType;
    }
}