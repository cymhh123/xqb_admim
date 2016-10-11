package com.mdzy.xqbadmin.modules.index.service;


import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.modules.admin.entity.SysAdmin;
import com.mdzy.xqbadmin.modules.admin.service.SysAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/10/8.
 */
@Service
public class IndexService{
    @Autowired
    private SysAdminService sysAdminService;

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     */
    public SysAdmin login(String account,String password){
        SysAdmin sysAdmin = new SysAdmin();
        sysAdmin.setAccount(account);
        sysAdmin.setPassword(password);
        List<SysAdmin> list = this.sysAdminService.findList(sysAdmin);
        if(list == null || list.size()==0){
            throw new ServiceException("用户名或密码错误");
        }
        return list.get(0);
    }
}
