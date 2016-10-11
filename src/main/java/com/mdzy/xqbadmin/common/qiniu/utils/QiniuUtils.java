package com.mdzy.xqbadmin.common.qiniu.utils;

import com.mdzy.xqbadmin.common.qiniu.config.QiniuConfig;
import com.qiniu.util.Auth;

/**
 * Created by Administrator on 2016/7/29.
 */
public class QiniuUtils {

    /**
     * 获得上传token
     * @return
     */
    public static String getUpToken(){
        Auth auth = Auth.create(QiniuConfig.ACCESS_KEY, QiniuConfig.SECRET_KEY);
        String uptoken = auth.uploadToken(QiniuConfig.BUCKET_NAME);
        return uptoken;
    }

    public static String getBucketDomain(){
        return QiniuConfig.BUCKET_DOMAIN;
    }
}
