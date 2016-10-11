package com.mdzy.xqbadmin.modules.video.service;

import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.video.dao.CommentDao;
import com.mdzy.xqbadmin.modules.video.entity.CommentBean;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016-07-20.
 */
@Service
public class CommentService extends CrudService<CommentDao,CommentBean> {
}
