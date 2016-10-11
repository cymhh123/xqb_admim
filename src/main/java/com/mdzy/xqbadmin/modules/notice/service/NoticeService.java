package com.mdzy.xqbadmin.modules.notice.service;

import com.mdzy.xqbadmin.common.jpush.config.JpushConfig;
import com.mdzy.xqbadmin.common.jpush.utils.JpushUtils;
import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.notice.entity.Notice;
import com.mdzy.xqbadmin.modules.notice.dao.NoticeDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NoticeService
 * @author chyou
 * @version
 */
@Service
public class NoticeService extends CrudService<NoticeDao, Notice> {
}