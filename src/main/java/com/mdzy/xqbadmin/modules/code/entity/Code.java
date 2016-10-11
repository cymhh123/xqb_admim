package com.mdzy.xqbadmin.modules.code.entity;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;

/**
 * CodeEntity
 * @author chyou
 * @version
 */
public class Code extends DataEntity {
    private static final long serialVersionUID = 1L;
    private String phone;
    private String code;
    private Integer scope;

    public Code() {
        super();
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public String getPhone(){
        return this.phone;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getCode(){
        return this.code;
    }
    public Integer getScope() {
        return scope;
    }

    public void setScope(Integer scope) {
        this.scope = scope;
    }
}