package com.mdzy.xqbadmin.modules.banner.entity;
import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import com.mdzy.xqbadmin.modules.sys.utils.DictUtils;

/**
 * BannerEntity
 * @author chyou
 * @version
 */
public class Banner extends DataEntity {

    private static final long serialVersionUID = 1L;
    private String imgUrl;
    private Integer flag;
    private String param;
    private String flagL;

    public Banner() {
        super();
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    public String getImgUrl(){
        return this.imgUrl;
    }
    public void setFlag(Integer flag){
        this.flag = flag;
        if(flag != null){
            this.setFlagL(DictUtils.getDictLabel(String.valueOf(flag),"banner_flag",""));
        }
    }
    public Integer getFlag(){
        return this.flag;
    }
    public void setParam(String param){
        this.param = param;
    }
    public String getParam(){
        return this.param;
    }
    public String getFlagL() {
        return flagL;
    }

    public void setFlagL(String flagL) {
        this.flagL = flagL;
    }
}