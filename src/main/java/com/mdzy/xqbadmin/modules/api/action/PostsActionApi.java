package com.mdzy.xqbadmin.modules.api.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.posts.entity.Follow;
import com.mdzy.xqbadmin.modules.posts.entity.PostsBean;
import com.mdzy.xqbadmin.modules.posts.entity.TopicBean;
import com.mdzy.xqbadmin.modules.posts.service.FollowService;
import com.mdzy.xqbadmin.modules.posts.service.PostsBeanService;
import com.mdzy.xqbadmin.modules.posts.service.ReplyBeanService;
import com.mdzy.xqbadmin.modules.posts.service.TopicBeanService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 圈子帖子控制器
 * Created by chyou on 2016/9/29.
 */
@Controller
@RequestMapping("/api/posts")
public class PostsActionApi extends BaseController {
    @Autowired
    private PostsBeanService postsBeanService;
    @Autowired
    private ReplyBeanService replyBeanService;
    @Autowired
    private TopicBeanService topicBeanService;
    @Autowired
    private FollowService followService;

    /**
     * 圈子主题列表
     * @return
     */
    @RequestMapping("/topic")
    @ResponseBody
    public Object topicList(){
        List<TopicBean> list = this.topicBeanService.findList(new TopicBean());
        return new ExecuteBean<>(list);
    }

    /**
     * 帖子列表
     * @param circleId 圈子主题id
     * @param page 当前页
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(String circleId,Integer page){
        if(StringUtils.isBlank(circleId) || page == null){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        PostsBean postsBean = new PostsBean();
        postsBean.setCircleId(circleId);
        List<PostsBean> list = this.postsBeanService.findByPage(postsBean,page);
        PageInfo<PostsBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 返回帖子详情
     * @param postsId 帖子id
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public Object info(String postsId){
        if(StringUtils.isBlank(postsId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            PostsBean postsBean = this.postsBeanService.postsAndReply(postsId);
            return new ExecuteBean<>(postsBean);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
    }

    /**
     * 发帖
     * @param circleId 圈子主题id
     * @param userId 发帖人id
     * @param content 内容
     * @param imgUrls 图片url，“,”分割
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(String circleId,String userId,String content,String imgUrls){
        if(StringUtils.isBlank(circleId) || StringUtils.isBlank(userId) || StringUtils.isBlank(content)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.postsBeanService.sendPosts(circleId,userId,content,imgUrls);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 收藏帖子
     * @param userId 用户id
     * @param postsId 帖子id
     */
    @RequestMapping("/collection")
    @ResponseBody
    public Object collecionPosts(String userId,String postsId){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(postsId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.postsBeanService.collecionPosts(userId,postsId);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 点赞帖子
     * @param userId 用户id
     * @param postsId 帖子id
     */
    @RequestMapping("/praise")
    @ResponseBody
    public Object praisePosts(String userId,String postsId){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(postsId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.postsBeanService.praisePosts(userId,postsId);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 帖子浏览
     * @param postsId 帖子id
     */
    @RequestMapping("/view")
    @ResponseBody
    public Object clickPosts(String postsId){
        if(StringUtils.isBlank(postsId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.postsBeanService.clickPosts(postsId);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 保存帖子回复
     * @param userId 回复人id
     * @param postsId 帖子id
     * @param toUserId 被回复用户id
     * @param content 内容
     * @return
     */
    @RequestMapping("/reply")
    @ResponseBody
    public Object savePostsReply(String userId,String postsId,String toUserId,String content){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(postsId) || StringUtils.isBlank(toUserId) ||
                StringUtils.isBlank(content)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.replyBeanService.savePostsReply(userId,postsId,toUserId,content);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 查询用户发的帖子
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/list/user")
    @ResponseBody
    public Object userPosts(String userId,Integer page){
        if(StringUtils.isBlank(userId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            List<PostsBean> list = this.postsBeanService.postsByUserId(userId,page);
            PageInfo<PostsBean> pageInfo = new PageInfo<>(list);
            return new ExecuteBean<>(pageInfo);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
    }

    /**
     * 关注的人列表
     * @param userId 用户id
     * @return
     */
    @RequestMapping("/follow/list")
    @ResponseBody
    public Object followUserList(String userId){
        if(StringUtils.isBlank(userId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            Follow follow = new Follow();
            follow.setUserId(userId);
            List<Follow> list = this.followService.findList(follow);
            return new ExecuteBean<>(list);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
    }

    /**
     * 关注
     * @param userId 用户id
     * @param followUserId 被关注用户id
     * @return
     */
    @RequestMapping("/follow")
    @ResponseBody
    public Object follow(String userId,String followUserId){
        if(StringUtils.isBlank(userId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.followService.follow(userId,followUserId);
            return new ExecuteBean<>(StatusCode.SUCCESS);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
    }

    /**
     * 取消关注
     * @param userId 用户id
     * @param followUserId 被关注用户id
     * @return
     */
    @RequestMapping("/unFollow")
    @ResponseBody
    public Object unFollow(String userId,String followUserId){
        if(StringUtils.isBlank(userId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.followService.unFollow(userId,followUserId);
            return new ExecuteBean<>(StatusCode.SUCCESS);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
    }
}
