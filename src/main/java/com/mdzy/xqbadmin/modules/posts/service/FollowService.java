package com.mdzy.xqbadmin.modules.posts.service;

import com.mdzy.xqbadmin.modules.posts.exception.PostsFollowException;
import com.mdzy.xqbadmin.modules.posts.exception.PostsNotFollowException;
import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.posts.entity.Follow;
import com.mdzy.xqbadmin.modules.posts.dao.FollowDao;

import java.util.List;

/**
 * FollowService
 * @author chyou
 * @version
 */
@Service
public class FollowService extends CrudService<FollowDao, Follow> {

    /**
     * 关注
     * @param userId  用户id
     * @param followUserId 被关注用户id
     */
    public void follow(String userId,String followUserId){
        //是否已关注
        Follow follow = new Follow();
        follow.setUserId(userId);
        follow.setFollowUserId(followUserId);
        List<Follow> list = this.findList(follow);
        if(list != null && list.size() > 0){
            throw new PostsFollowException();
        }
        this.save(follow);
    }

    /**
     * 取消关注
     * @param userId 用户id
     * @param followUserId 被关注用户id
     */
    public void unFollow(String userId,String followUserId){
        //是否已关注
        Follow follow = new Follow();
        follow.setUserId(userId);
        follow.setFollowUserId(followUserId);
        List<Follow> list = this.findList(follow);
        if(list == null || list.size() == 0){
            throw new PostsNotFollowException();
        }
        String id = list.get(0).getId();
        this.delete(id);
    }
}