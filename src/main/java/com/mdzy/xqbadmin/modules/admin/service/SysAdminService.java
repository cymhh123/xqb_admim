package com.mdzy.xqbadmin.modules.admin.service;

import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.admin.entity.SysAdmin;
import com.mdzy.xqbadmin.modules.admin.dao.SysAdminDao;

/**
 * SysAdminService
 * @author chyou
 * @version
 */
@Service
public class SysAdminService extends CrudService<SysAdminDao, SysAdmin> {

}