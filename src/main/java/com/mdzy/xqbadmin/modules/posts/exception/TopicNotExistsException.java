package com.mdzy.xqbadmin.modules.posts.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class TopicNotExistsException extends ServiceException {

    public TopicNotExistsException(){
        super("圈子主题不存在");
    }
}
