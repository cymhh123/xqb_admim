package com.mdzy.xqbadmin.modules.notice.service;

import com.mdzy.xqbadmin.common.jpush.config.JpushConfig;
import com.mdzy.xqbadmin.common.jpush.utils.JpushUtils;
import com.mdzy.xqbadmin.modules.notice.dao.UserNoticeDao;
import com.mdzy.xqbadmin.modules.notice.entity.Notice;
import com.mdzy.xqbadmin.modules.notice.entity.UserNotice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserNoticeService
 * @author chyou
 * @version
 */
@Service
public class UserNoticeService extends CrudService<UserNoticeDao, UserNotice> {
    @Autowired
    private NoticeService noticeService;

    /**
     * 消息推送
     * @param aliases
     * @param noticeId
     */
    public void jpush(final List<String> aliases, final String noticeId){
        final Notice notice = this.noticeService.get(noticeId);
        if(notice != null){
            final Map<String,String> content = new HashMap<>();
            content.put("msg",notice.getProfile());
            content.put("type",notice.getCategory().toString());
            new Thread(new Runnable() {
                @Override
                public void run() {
                for(String alias : aliases){
                    //保存消息
                    UserNotice userNotice = new UserNotice();
                    userNotice.setUserAccount(alias);
                    userNotice.setNoticeId(noticeId);
                    userNotice.setReadStatus(0);
                    save(userNotice);
                    //推送
                    JpushUtils.pushAlias(alias,notice.getTitle(),content, JpushConfig.TEACHER_masterSecret,JpushConfig.TEACHER_appKey);
                }
                }
            }).start();

        }
    }

    /**
     * 发送多条消息
     * @param aliases
     * @param noticeIds
     */
    public void batchJpush(List<String> aliases,List<String> noticeIds){
        for(String noticeId : noticeIds){
            this.jpush(aliases,noticeId);
        }
    }
}