package com.mdzy.xqbadmin.modules.posts.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class PostsFollowException extends ServiceException {

    public PostsFollowException(){
        super("已关注该用户");
    }
}
