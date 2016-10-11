/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.res.service;

import com.mdzy.xqbadmin.modules.res.dao.ResInfoBeanDao;
import com.mdzy.xqbadmin.modules.res.entity.ResInfoBean;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 资源Service
 * @author chengyou
 * @version 2016-09-05
 */
@Service
public class ResInfoBeanService extends CrudService<ResInfoBeanDao, ResInfoBean> {
}