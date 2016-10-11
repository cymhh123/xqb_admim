package com.mdzy.xqbadmin.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mdzy.xqbadmin.common.utils.IdGen;

import java.util.Date;

/**
 * 实体基础类
 */
@JsonIgnoreProperties(value = {"delStatus"})
public class DataEntity {
    private String id;
    private Date createDate;		// create_time
    private Date updDate;		// upd_time
    private Integer delStatus;

    /**
     * 插入之前调用
     */
    public void preInsert(){
        this.id = IdGen.uuidFor32();
        this.delStatus = 0;
        this.createDate = new Date();
        this.updDate = this.createDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void preUpd(){
        this.updDate = new Date();
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdDate() {
        return this.updDate;
    }

    public void setUpdDate(Date updDate) {
        this.updDate = updDate;
    }

    public Integer getDelStatus() {
        return this.delStatus;
    }

    public void setDelStatus(Integer delStatus) {
        this.delStatus = delStatus;
    }

}
