package com.mdzy.xqbadmin.modules.posts.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class PostsCollectionExistsException extends ServiceException {

    public PostsCollectionExistsException(){
        super("帖子已收藏");
    }
}
