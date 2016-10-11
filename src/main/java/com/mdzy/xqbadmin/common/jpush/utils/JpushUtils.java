package com.mdzy.xqbadmin.common.jpush.utils;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.resp.APIConnectionException;
import cn.jpush.api.common.resp.APIRequestException;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.IosNotification;
import cn.jpush.api.push.model.notification.Notification;
import com.alibaba.fastjson.JSON;
import com.mdzy.xqbadmin.common.jpush.config.JpushConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;


/**
 * 极光推送
 * Created by Administrator on 2016/7/29.
 */
public class JpushUtils {

    protected static final Logger LOG = LoggerFactory.getLogger(JpushUtils.class);

    /**
     * 多个别名，相同内容。
     * @param aliases 别名列表
     * @param title 消息内容
     * @param content message和消息的附加信息
     * @param secret 秘钥
     * @param appkey 应用key
     */
    public static void pushAliases(List<String> aliases, String title, Map<String, String> content, String secret,String appkey){
        //jpushClient
        JPushClient jpushClient = new JPushClient(secret,appkey,5);

        PushPayload payload = buildPushObject_all_alias_messageandnotification(aliases, title, content);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error, should retry later", e);
        } catch (APIRequestException e) {
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    /**
     * 一个别名，相同内容。
     * @param alias 别名
     * @param title 消息内容
     * @param content message和消息的附加信息
     * @param secret 秘钥
     * @param appkey 应用key
     */
    public static void pushAlias(String alias,String title,Map<String, String> content,String secret,String appkey){

        JPushClient jpushClient = new JPushClient(secret,appkey,5);
        PushPayload payload = buildPushObject_all_alias_messageandnotification(alias, title, content);

        try {
            PushResult result = jpushClient.sendPush(payload);
            LOG.info("Got result - " + result);

        } catch (APIConnectionException e) {
            LOG.error("Connection error, should retry later", e);

        } catch (APIRequestException e) {
            LOG.error("Should review the error, and fix the request", e);
            LOG.info("HTTP Status: " + e.getStatus());
            LOG.info("Error Code: " + e.getErrorCode());
            LOG.info("Error Message: " + e.getErrorMessage());
        }
    }

    public static  PushPayload buildPushObject_all_alias_messageandnotification(List<String> aliases,String title,Map<String, String> content){
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(aliases))
                .setMessage(Message.newBuilder()
                        .setTitle(title)
                        .setMsgContent(JSON.toJSONString(content))
                        .build())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(title)
                                .setSound("happy.caf")
                                .addExtras(content)
                                .build())
                        .build())
                .build();

    }

    public static  PushPayload buildPushObject_all_alias_messageandnotification(String alias,String title,Map<String, String> content){
        return PushPayload.newBuilder()
                .setPlatform(Platform.all())
                .setAudience(Audience.alias(alias))
                .setMessage(Message.newBuilder()
                        .setTitle(title)
                        .setMsgContent(JSON.toJSONString(content))
                        .build())
                .setNotification(Notification.newBuilder()
                        .addPlatformNotification(IosNotification.newBuilder()
                                .setAlert(title)
                                .setSound("happy.caf")
                                .addExtras(content)
                                .build())
                        .build())
                .build();

    }

    public static void main(String[] args) {
        List<String>l=new ArrayList<String>();
//        l.add("18035147802");
        l.add("18000000001");
        Map<String,String>m=new HashMap<String,String>();
        m.put("type", "10");
        m.put("msg", "直播测试消息");
        m.put("time", new Date() + "");
//        pushAliases(l, "我的数据", m, JpushConfig.USER_masterSecret,JpushConfig.USER_appKey);
        pushAliases(l, "我的数据", m, JpushConfig.TEACHER_masterSecret,JpushConfig.TEACHER_appKey);
    }
}
