package com.mdzy.xqbadmin.modules.user.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class UserNotExistsException extends ServiceException {

    public UserNotExistsException(){
        super("用户不存在");
    }
}
