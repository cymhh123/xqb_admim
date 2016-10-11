/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.posts.service;


import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.modules.posts.dao.PostsBeanDao;
import com.mdzy.xqbadmin.modules.posts.entity.PostsBean;
import com.mdzy.xqbadmin.modules.posts.entity.ReplyBean;
import com.mdzy.xqbadmin.modules.posts.entity.TopicBean;
import com.mdzy.xqbadmin.modules.posts.entity.UserCircle;
import com.mdzy.xqbadmin.modules.posts.exception.PostsCollectionExistsException;
import com.mdzy.xqbadmin.modules.posts.exception.PostsNotExistsException;
import com.mdzy.xqbadmin.modules.posts.exception.PostsPrasieExistsException;
import com.mdzy.xqbadmin.modules.posts.exception.TopicNotExistsException;
import com.mdzy.xqbadmin.modules.sys.constants.Constants;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import com.mdzy.xqbadmin.modules.user.exception.UserNotExistsException;
import com.mdzy.xqbadmin.modules.user.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子管理Service
 * @author chengyou
 * @version 2016-09-10
 */
@Service
public class PostsBeanService extends CrudService<PostsBeanDao, PostsBean> {
    @Autowired
    private ReplyBeanService replyBeanService;
    @Autowired
    private UserBeanService userBeanService;
    @Autowired
    private TopicBeanService topicBeanService;
    @Autowired
    private UserCircleService userCircleService;

    /**
     * 帖子详情和回复
     * @param postsId 帖子id
     * @return
     */
    public PostsBean postsAndReply(String postsId){
        //查询帖子
        PostsBean postsBean = this.get(postsId);
        if(postsBean == null){
            throw new PostsNotExistsException();
        }
        //查询帖子回复
        ReplyBean replyBean = new ReplyBean();
        replyBean.setCircleId(postsId);
        List<ReplyBean> replyBeanList = this.replyBeanService.findList(replyBean);
        postsBean.setReplyList(replyBeanList);
        return postsBean;
    }

    /**
     * 发帖
     * @param circleId 圈子id
     * @param userId 发帖人id
     * @param content 内容
     * @param imgUrls 图片
     */
    public void sendPosts(String circleId,String userId,String content,String imgUrls){
        //校验人是否存在
        UserBean userBean = this.userBeanService.get(userId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        //主题圈子是否存在
        TopicBean topicBean = this.topicBeanService.get(circleId);
        if(topicBean == null){
            throw new TopicNotExistsException();
        }
        //保存帖子
        PostsBean postsBean = new PostsBean();
        postsBean.setCircleId(circleId);
        postsBean.setUserId(userId);
        postsBean.setImgUrl(imgUrls);
        postsBean.setClickNum(0);
        postsBean.setLikeNum(0);
        postsBean.setPraiseNum(0);
        postsBean.setContent(content);
        this.save(postsBean);
    }

    /**
     * 收藏帖子
     * @param userId 用户id
     * @param postsId 帖子id
     */
    public void collecionPosts(String userId,String postsId){
        //校验人是否存在
        UserBean userBean = this.userBeanService.get(userId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        //帖子是否存在
        PostsBean postsBean = this.get(postsId);
        if(postsBean == null){
            throw new PostsNotExistsException();
        }
        //帖子是否收藏
        UserCircle userCircle = new UserCircle();
        userCircle.setCircleId(postsId);
        userCircle.setUserId(userId);
        userCircle.setOperType(Constants.POSTS.POSTS_LIKE);
        List<UserCircle> list = this.userCircleService.findList(userCircle);
        if(list != null && list.size() > 0){
            throw new PostsCollectionExistsException();
        }
        //收藏帖子
        this.userCircleService.save(userCircle);
        //收藏帖子数+1
        postsBean.setLikeNum(postsBean.getLikeNum()+1);
        this.update(postsBean);
    }

    /**
     * 点赞帖子
     * @param userId 用户id
     * @param postsId 帖子id
     */
    public void praisePosts(String userId,String postsId){
        //校验人是否存在
        UserBean userBean = this.userBeanService.get(userId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        //帖子是否存在
        PostsBean postsBean = this.get(postsId);
        if(postsBean == null){
            throw new PostsNotExistsException();
        }
        //帖子是否已经点过赞
        UserCircle userCircle = new UserCircle();
        userCircle.setCircleId(postsId);
        userCircle.setUserId(userId);
        userCircle.setOperType(Constants.POSTS.POSTS_PRAISE);
        List<UserCircle> list = this.userCircleService.findList(userCircle);
        if(list != null && list.size() > 0){
            throw new PostsPrasieExistsException();
        }
        //帖子点赞
        this.userCircleService.save(userCircle);
        //帖子点赞数+1
        postsBean.setPraiseNum(postsBean.getPraiseNum()+1);
        this.update(postsBean);
    }

    /**
     * 帖子点击
     * @param postsId 帖子id
     */
    public void clickPosts(String postsId){
        //帖子是否存在
        PostsBean postsBean = this.get(postsId);
        if(postsBean == null){
            throw new PostsNotExistsException();
        }
        postsBean.setClickNum(postsBean.getClickNum()+1);
        this.update(postsBean);

    }

    /**
     * 查询用户的帖子
     * @param userId 用户id
     * @return
     */
    public List<PostsBean> postsByUserId(String userId,Integer page){
        //校验人是否存在
        UserBean userBean = this.userBeanService.get(userId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        PostsBean postsBean = new PostsBean();
        postsBean.setUserId(userId);
        List<PostsBean> list = this.findByPage(postsBean,page);
        return list;
    }
}