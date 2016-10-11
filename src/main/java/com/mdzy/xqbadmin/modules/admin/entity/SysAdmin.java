package com.mdzy.xqbadmin.modules.admin.entity;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

/**
 * 后台管理员Bean
 * SysAdminEntity
 * @author chyou
 * @version
 */
public class SysAdmin extends DataEntity {

    private static final long serialVersionUID = 1L;
    private String account;
    private String password;

    public SysAdmin() {
        super();
    }
    public void setAccount(String account){
        this.account = account;
    }
    public String getAccount(){
        return this.account;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getPassword(){
        return this.password;
    }
}