package com.mdzy.xqbadmin.common.qiniu.utils;

import com.mdzy.xqbadmin.common.qiniu.config.QiniuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.model.FileInfo;
import com.qiniu.storage.model.FileListing;
import com.qiniu.util.Auth;

/**
 * Created by Administrator on 2016/7/28.
 */
public class QiniuFace {

    /**
     * 文件列表
     */
    public static void list(String marker,Integer limit){
        Auth auth = Auth.create(QiniuConfig.ACCESS_KEY,QiniuConfig.SECRET_KEY);
        //实例化一个BucketManager对象
        BucketManager bucketManager = new BucketManager(auth);
        //要列举文件的空间名
        String bucket = QiniuConfig.BUCKET_NAME;
        try {
            //调用listFiles方法列举指定空间的指定文件
            //参数一：bucket    空间名
            //参数二：prefix    文件名前缀
            //参数三：marker    上一次获取文件列表时返回的marker
            //参数四：limit     每次迭代的长度限制，最大1000，推荐值100
            //参数五：delimiter 指定目录分隔符，列出所有公共前缀（模拟列出目录效果）。缺省值为空字符串
            FileListing fileListing = bucketManager.listFiles(bucket,null,marker,limit,null);
            FileInfo[] items = fileListing.items;
            for(FileInfo fileInfo:items){
                System.out.println(fileInfo.key);
            }
        } catch (QiniuException e) {
            //捕获异常信息
            Response r = e.response;
            System.out.println(r.toString());
        }
    }

    public static void main(String[] args){
//        list();
    }
}
