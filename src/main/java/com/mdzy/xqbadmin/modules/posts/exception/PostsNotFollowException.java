package com.mdzy.xqbadmin.modules.posts.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class PostsNotFollowException extends ServiceException {

    public PostsNotFollowException(){
        super("未关注过此人");
    }
}
