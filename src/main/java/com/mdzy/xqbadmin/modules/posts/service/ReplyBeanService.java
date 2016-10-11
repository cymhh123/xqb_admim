/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.posts.service;

import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.modules.posts.dao.ReplyBeanDao;
import com.mdzy.xqbadmin.modules.posts.entity.PostsBean;
import com.mdzy.xqbadmin.modules.posts.entity.ReplyBean;
import com.mdzy.xqbadmin.modules.posts.exception.PostsNotExistsException;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import com.mdzy.xqbadmin.modules.user.exception.UserNotExistsException;
import com.mdzy.xqbadmin.modules.user.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 帖子回复Service
 * @author chengyou
 * @version 2016-09-10
 */
@Service
public class ReplyBeanService extends CrudService<ReplyBeanDao, ReplyBean> {
    @Autowired
    private UserBeanService userBeanService;

    @Autowired
    private PostsBeanService postsBeanService;

    /**
     * 保存回复
     * @param userId 回复人id
     * @param postsId 帖子id
     * @param toUserId 被回复人id
     * @param content 内容
     */
    public void savePostsReply(String userId,String postsId,String toUserId,String content){
        //校验人是否存在
        UserBean userBean = this.userBeanService.get(userId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        userBean = this.userBeanService.get(toUserId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        //帖子是否存在
        PostsBean postsBean = this.postsBeanService.get(postsId);
        if(postsBean == null){
            throw new PostsNotExistsException();
        }
        ReplyBean replyBean = new ReplyBean();
        replyBean.setUserId(userId);
        replyBean.setCircleId(postsId);
        replyBean.setContent(content);
        replyBean.setToUserId(toUserId);
        this.save(replyBean);
    }
}