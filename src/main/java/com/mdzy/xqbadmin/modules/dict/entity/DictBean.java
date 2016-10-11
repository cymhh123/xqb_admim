package com.mdzy.xqbadmin.modules.dict.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * 数据字典实体
* Created by chengyou on 2015-8-11.
*/
public class DictBean{
	private String id;
	//创建时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	//更新时间
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateDate;
	//删除标识(0:未删除1：删除)
	private String delFlag="0";
    //数据值
    private String value;
    //标签名
    private String label;
    //类型
    private String type;
    //描述
    private String description;
    //排序（升序)
    private int sort;
    //父级编号
    private String parentId;

	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
	public void setLabel(String label){
		this.label=label;
	}
	public String getLabel(){
		return this.label;
	}
	public void setType(String type){
		this.type=type;
	}
	public String getType(){
		return this.type;
	}
	public void setDescription(String description){
		this.description=description;
	}
	public String getDescription(){
		return this.description;
	}
	public void setSort(int sort){
		this.sort=sort;
	}
	public int getSort(){
		return this.sort;
	}
	public void setParentId(String parentId){
		this.parentId=parentId;
	}
	public String getParentId(){
		return this.parentId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

}
