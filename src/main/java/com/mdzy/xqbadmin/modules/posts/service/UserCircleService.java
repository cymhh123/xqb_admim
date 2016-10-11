package com.mdzy.xqbadmin.modules.posts.service;

import com.mdzy.xqbadmin.modules.posts.dao.UserCircleDao;
import com.mdzy.xqbadmin.modules.posts.entity.UserCircle;
import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;

/**
 * 用户收藏、点赞帖子Service
 * @author chyou
 * @version
 */
@Service
public class UserCircleService extends CrudService<UserCircleDao, UserCircle> {

}