package com.mdzy.xqbadmin.modules.res.entity;

import com.mdzy.xqbadmin.modules.sys.entity.DataEntity;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
public class UserRes extends DataEntity {
    private static final long serialVersionUID = 1L;
    @NotBlank
    private String userId;
    @NotBlank
    private String resId;

    private String[] sorts;

    private ResInfoBean resInfo;

    public ResInfoBean getResInfo() {
        return resInfo;
    }

    public void setResInfo(ResInfoBean resInfo) {
        this.resInfo = resInfo;
    }

    public String[] getSorts() {
        return sorts;
    }

    public void setSorts(String[] sorts) {
        this.sorts = sorts;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

}
