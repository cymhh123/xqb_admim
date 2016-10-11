package com.mdzy.xqbadmin.modules.res.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class ResNotExistsException extends ServiceException {

    public ResNotExistsException(){
        super("资源不存在");
    }
}
