package com.mdzy.xqbadmin.modules.code.service;

import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.code.entity.Code;
import com.mdzy.xqbadmin.modules.code.dao.CodeDao;

/**
 * CodeService
 * @author chyou
 * @version
 */
@Service
public class CodeService extends CrudService<CodeDao, Code> {

}