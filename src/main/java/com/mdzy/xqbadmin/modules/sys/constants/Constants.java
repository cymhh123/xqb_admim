package com.mdzy.xqbadmin.modules.sys.constants;


/**
 * 项目中使用的常量定义
 * Created by chengyou on 2015/10/24.
 */
public class Constants {
    public static final Integer PAGE_SIZE = 10;


    public static class Message{
        //消息通知
        public static final Integer NOTICE_XIAOXI = 2;

    }

    /**
     * JPush
     */
    public static class JPust{
        //教师端
        public static final Integer TYPE_TEACHER = 1;
        //家长端
        public static final Integer TYPE_USER = 0;
        //终端端
        public static final Integer TYPE_TERMINAL = 3;
    }

    /**
     *
     */
    public static class Notice{
        //全部(家长，教师)
        public static final String SEND_TYPE_ALL = "0";
        //家长
        public static final String SEND_TYPE_USER = "1";
        //教师
        public static final String SEND_TYPE_TEACHER = "2";
        //终端
        public static final String SEND_TYPE_TERMINAL = "3";

        public static final String SEND_TYPE_RECTOR = "4";
    }

    /**
     * 视频常量
     */
    public static class Video{

        //类型：直播
        public static final String TYPE_ZHIBO = "0";

        //类型：点播
        public static final String TYPE_DIANBO = "1";

        //推荐
        public static final String LABEL_HOT = "1";

        //上架
        public static final String STATUS_PUB = "1";
    }

    /**
     * 帖子常量
     */
    public static class POSTS{
        //收藏
        public static final Integer POSTS_LIKE = 1;
        //点赞
        public static final Integer POSTS_PRAISE = 0;
    }

    /**
     * 资源常量
     */
    public static class Res{
        //教育指南
        public static final Integer SORTS_STUDY = 4;
    }
}
