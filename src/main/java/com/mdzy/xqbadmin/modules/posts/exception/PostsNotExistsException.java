package com.mdzy.xqbadmin.modules.posts.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class PostsNotExistsException extends ServiceException {

    public PostsNotExistsException(){
        super("帖子不存在");
    }
}
