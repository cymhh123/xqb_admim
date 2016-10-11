package com.mdzy.xqbadmin.common.utils;

public class ConstantUtils {
    public static final String TERMINAL = "terminal";
    public static final String TERMINAL_ANDROID = "1";
    public static final String TERMINAL_IOS = "2";
    public static final String TERMINAL_WAP = "3";
    public static final String TERMINAL_WEB = "4";
    public static final String TOKEN = "token";
    public static final String MEMBER_ID = "memberId";
    public static final int minute = 60;
    public static final int hours = minute * 60;
    public static final int day = hours * 24;

    /**
     * 帖子常量定义
     *
     * @author p
     * @version 1.0
     * @since 2014年9月2日
     */
    public static interface Post {

        //置顶
        public static final String TOP = "2";

        //推荐
        public static final String RECOMMEND = "1";

        //普通
        public static final String NORMAL = "0";

        //摘要字数
        public static final Integer SUMMARY_NUM = 60;

        //帖子点赞操作
        public static final String OPER_FAV = "0";

    }

    /**
     * 消息常量
     *
     * @author chengyou
     */
    public static interface Msg {
        public static final String MSG_TYPE_SYSTEM = "0";
        public static final String MSG_TITLE_DO_POST = "发帖积分奖励";
        public static final String MSG_CONTENT_DO_POST = "恭喜您，发帖获得奖励${score}积分";
        public static final String MSG_TITLE_DO_SHARE = "分享信息积分奖励";
        public static final String MSG_CONTENT_DO_SHARE = "恭喜您，分享内容获得奖励${score}积分";
        public static final String MSG_TITLE_SCORE_DH = "积分兑换通知";
    }

    /**
     * 积分常量
     *
     * @author p
     */
    public static interface Score {
        //分享
        public static final String FROM_FX = "fx";
        //发帖
        public static final String FROM_FT = "ft";
        //礼品积分兑换
        public static final String FROM_DH = "dh";
        //完善个人资料
        public static final String FROM_PERFECT = "wszl";
        //赚取
        public static final String EARN = "0";
        //消费
        public static final String CONSUME = "1";
    }

    /**
     * 短信常量
     *
     * @author chengyou
     * @since 2015.6.30
     */
    public static interface Sms {
        public static final String SMS_APP_ID = "sms_app_id";
        //注册验证码模板
        public static final String SMS_TEMP_REGIST = "sms_template_regist";
        //注册成功模板
        public static final String SMS_TEMP_REGIST_SUCCESS = "sms_regist_success";
        //注册成功发短信送积分
        public static final String SMS_TEMP_REGIST_SCORE = "sms_regist_score";

        public static final String SMS_LABEL = "sms";

        //登录注册
        public static final String REGISTER = "-1";
        //重置密码
        public static final String RESETPASSWORD = "-2";
    }

    /**
     * 广告
     *
     * @author p
     */
    public static interface Advert {
        //广告位：首页广告
        public static final String POSITION_INDEX = "0";
    }

    /**
     * 字典
     *
     * @author p
     */
    public static interface Dict {
        //广告-设备类型
        public static final String TYPE_ADVERT_APP = "terminalType";
        //广告-app
        public static final String LABEL_ADVERT_APP = "app";
        //用户默认头像
        public static final String TYPE_HEADER_IMG = "header";
        public static final String LABEL_HEADER_IMG = "headerImg";
        //手机应用启动引导图
        public static final String TYPE_START_IMG = "app";
        public static final String LABEL_START_IMG = "startImg";
    }

    /**
     * 专题
     *
     * @author p
     */
    public static interface Subject {
        //专题首页显示
        public static final String BANNER_YES = "1";
    }

    /**
     * 动态
     *
     * @author p
     */
    public static interface Notice {
        //应用首页显示
        public static final String INDEX_YES = "1";
    }

    /**
     * 个人中心
     *
     * @author p
     */
    public interface Personal {
        //wap登录
        int LOGIN_WAP = 3;
        //手机登录
        int LOGIN_PHONE = 2;
        //网站登录
        int LOGIN_WEB = 1;
        //token
        String TOKEN_WEB = "-web-token";
        String TOKEN_WAP = "-wap-token";
        String TOKEN_APP = "-token";
        //loginCookie
        String COOKIE_LOGIN = "loginCookie";

        String COOKIE_CART = "shoppingcart";

        String COOKIE_PRDUCT = "product";
    }

    /**
     * 支付
     *
     * @author p
     */
    public interface PayConstants {
        //支付宝
        String PAY_TYPE_ALIPY = "0";
        //银联支付
        String PAY_TYPE_UNION = "1";
        //微信
        String PAY_TYPE_WEIXIN = "2";
    }
}
