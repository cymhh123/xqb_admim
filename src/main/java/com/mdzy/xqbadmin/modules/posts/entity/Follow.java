package com.mdzy.xqbadmin.modules.posts.entity;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;

/**
 * FollowEntity
 * @author chyou
 * @version
 */
public class Follow extends DataEntity {

    private static final long serialVersionUID = 1L;
    private String userId;
    private String followUserId;
    private UserBean followUser;

    public Follow() {
        super();
    }
    public void setUserId(String userId){
        this.userId = userId;
    }
    public String getUserId(){
        return this.userId;
    }
    public void setFollowUserId(String followUserId){
        this.followUserId = followUserId;
    }
    public String getFollowUserId(){
        return this.followUserId;
    }
    public UserBean getFollowUser() {
        return followUser;
    }

    public void setFollowUser(UserBean followUser) {
        this.followUser = followUser;
    }
}