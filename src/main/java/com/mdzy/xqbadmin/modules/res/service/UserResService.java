package com.mdzy.xqbadmin.modules.res.service;

import com.mdzy.xqbadmin.modules.res.dao.UserResDao;
import com.mdzy.xqbadmin.modules.res.entity.ResInfoBean;
import com.mdzy.xqbadmin.modules.res.entity.UserRes;
import com.mdzy.xqbadmin.modules.res.exception.ResCollectionException;
import com.mdzy.xqbadmin.modules.res.exception.ResNotExistsException;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import com.mdzy.xqbadmin.modules.user.exception.UserNotExistsException;
import com.mdzy.xqbadmin.modules.user.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;

import java.util.List;

/**
 * UserResService
 * @author chyou
 * @version
 */
@Service
public class UserResService extends CrudService<UserResDao, UserRes> {
    @Autowired
    private UserBeanService userBeanService;
    @Autowired
    private ResInfoBeanService resInfoBeanService;

    /**
     * 用户收藏资源
     * @param userId 用户id
     * @param resId 资源id
     */
    public void saveResCollection(String userId,String resId){
        //校验用户
        UserBean userBean = this.userBeanService.get(userId);
        if(userBean == null){
            throw new UserNotExistsException();
        }
        //校验资源
        ResInfoBean resInfoBean = this.resInfoBeanService.get(resId);
        if(resInfoBean == null){
            throw new ResNotExistsException();
        }
        //用户是否已收藏
        UserRes userRes = new UserRes();
        userRes.setUserId(userId);
        userRes.setResId(resId);
        List<UserRes> list = this.findList(userRes);
        if(list != null && list.size() > 0){
            throw new ResCollectionException();
        }
        //保存收藏
        this.save(userRes);
    }
}