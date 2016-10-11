package com.mdzy.xqbadmin.modules.res.exception;

import com.mdzy.xqbadmin.common.exception.ServiceException;

/**
 * Created by Administrator on 2016/9/29.
 */
public class ResCollectionException extends ServiceException {

    public ResCollectionException(){
        super("已收藏");
    }
}
