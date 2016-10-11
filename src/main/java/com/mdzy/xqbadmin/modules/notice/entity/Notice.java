package com.mdzy.xqbadmin.modules.notice.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;

/**
 * NoticeEntity
 * @author chyou
 * @version
 */
@JsonIgnoreProperties(value = {"content"})
public class Notice extends DataEntity {

    private static final long serialVersionUID = 1L;
    private String title;
    private String profile;
    private String detailUrl;
    private Integer category;
    private String categoryL;
    private String content;
    private Integer readStatus;

    public Integer getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Integer readStatus) {
        this.readStatus = readStatus;
    }

    public String getCategoryL() {
        return categoryL;
    }

    public void setCategoryL(String categoryL) {
        this.categoryL = categoryL;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Notice() {
        super();
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return this.title;
    }
    public void setProfile(String profile){
        this.profile = profile;
    }
    public String getProfile(){
        return this.profile;
    }
    public void setDetailUrl(String detailUrl){
        this.detailUrl = detailUrl;
    }
    public String getDetailUrl(){
        return this.detailUrl;
    }
    public void setCategory(Integer category){
        this.category = category;
        if(category != null){
            String label = DictUtils.getDictLabel(category.toString(),"notice_category","");
            this.setCategoryL(label);
        }
    }
    public Integer getCategory(){
        return this.category;
    }
}