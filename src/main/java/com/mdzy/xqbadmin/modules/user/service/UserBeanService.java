/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.mdzy.xqbadmin.modules.user.service;


import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.DateUtils;
import com.mdzy.xqbadmin.common.utils.GenerateTools;
import com.mdzy.xqbadmin.common.utils.SmsTools;
import com.mdzy.xqbadmin.modules.code.entity.Code;
import com.mdzy.xqbadmin.modules.code.service.CodeService;
import com.mdzy.xqbadmin.modules.posts.entity.PostsBean;
import com.mdzy.xqbadmin.modules.posts.service.PostsBeanService;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.user.dao.UserBeanDao;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import com.mdzy.xqbadmin.modules.user.exception.UserNotExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 用户管理Service
 * @author chengyou
 * @version 2016-09-06
 */
@Service
public class UserBeanService extends CrudService<UserBeanDao, UserBean>{
    @Autowired
    private CodeService codeService;
    @Autowired
    private PostsBeanService postsBeanService;

    /**
     * 发送验证码
     * @param phone
     * @return
     */
    public String sendSMS(String phone,Integer scope,Integer length){
        try{
            String code = GenerateTools.getRomNum(length);
            SmsTools.templateSMS(phone, code);
            //记录数据
            Code codeBean = new Code();
            codeBean.setPhone(phone);
            codeBean.setScope(scope);
            List<Code> list = this.codeService.findList(codeBean);
            if(list == null || list.size() == 0){ //保存
                codeBean.setCode(code);
                this.codeService.save(codeBean);
            }else{//更新
                codeBean = list.get(0);
                Code codeBean2 = new Code();
                codeBean2.setId(codeBean.getId());
                codeBean2.setCode(code);
                this.codeService.update(codeBean2);
            }
            return code;
        }catch (Exception e){
            throw new ServiceException("发送验证码失败");
        }
    }

    /**
     * 注册
     * @param phone
     * @param password
     * @param code
     */
    public void register(String phone,String password,String code){
        //获取验证码
        String relCode = "";
        Date updDate = null;
        Code codeBean = new Code();
        codeBean.setPhone(phone);
        codeBean.setScope(0);
        List<Code> list = this.codeService.findList(codeBean);
        if(list == null || list.size() == 0){
            throw new ServiceException("未获取到验证码");
        }else{
            relCode = list.get(0).getCode();
            updDate = list.get(0).getUpdDate();
        }
        //验证码是否失效
        long time = DateUtils.pastMinutes(updDate);
        if(time > 1){
            throw new ServiceException("验证码已失效");
        }
        //验证码是否正确
        if(!code.equals(relCode)){
            throw new ServiceException("验证码错误");
        }
        //用户是否存在
        UserBean userBean = this.dao.findByAccountAndPwd(phone,password);
        if(userBean != null){//存在
            throw new ServiceException("用户已存在");
        }
        //保存
        userBean = new UserBean();
        userBean.setPhone(phone);
        userBean.setAccount(phone);
        userBean.setPassword(password);
        userBean.setNick(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2"));
        userBean.setSex("2");
        userBean.setImgUrl("0");
        userBean.setType("0");
        this.save(userBean);
    }

    /**
     * 登录
     * @param phone
     * @param password
     * @return
     */
    public UserBean login(String phone,String password){
        //用户是否存在
        UserBean userBean = this.dao.findByAccountAndPwd(phone,password);
        if(userBean == null){
            throw new ServiceException("用户不存在");
        }
        return userBean;
    }

    /**
     * 绑定手机号
     * @param phone
     * @param code
     */
    public void bindingPhone(String userId,String phone,String code){
        //判断验证码是否超时
        //获取验证码
        String relCode = "";
        Date updDate = null;
        Code codeBean = new Code();
        codeBean.setPhone(phone);
        codeBean.setScope(1);
        List<Code> list = this.codeService.findList(codeBean);
        if(list == null || list.size() == 0){
            throw new ServiceException("未获取到验证码");
        }else{
            relCode = list.get(0).getCode();
            updDate = list.get(0).getUpdDate();
        }
        //验证码是否失效
        long time = DateUtils.pastMinutes(updDate);
        if(time > 1){
            throw new ServiceException("验证码已失效");
        }
        //验证码是否正确
        if(!code.equals(relCode)){
            throw new ServiceException("验证码错误");
        }
        //更新用户
        UserBean userBean = new UserBean();
        userBean.setId(userId);
        userBean.setPhone(phone);
        this.update(userBean);
    }

    /**
     * 修改密码
     * @param userId
     * @param oldPassword
     * @param newPassword
     */
    public void modifyPassword(String userId,String oldPassword,String newPassword){
        //校验旧密码是否正确
        UserBean userBean = this.get(userId);
        if(userBean == null){
            throw new ServiceException("用户不存在");
        }
        String relOldPass = userBean.getPassword();
        if(!relOldPass.equals(oldPassword)){
            throw new ServiceException("密码输入有误");
        }
        //修改密码
        UserBean userBeanForModify = new UserBean();
        userBeanForModify.setPassword(newPassword);
        userBeanForModify.setId(userId);
        this.update(userBeanForModify);
    }

    /**
     * 忘记密码
     * @param phone
     * @param newPassword
     * @param code
     */
    public void forgetPassword(String phone,String newPassword,String code){
        //判断验证码是否超时
        //获取验证码
        String relCode = "";
        Date updDate = null;
        Code codeBean = new Code();
        codeBean.setPhone(phone);
        codeBean.setScope(2);
        List<Code> list = this.codeService.findList(codeBean);
        if(list == null || list.size() == 0){
            throw new ServiceException("未获取到验证码");
        }else{
            relCode = list.get(0).getCode();
            updDate = list.get(0).getUpdDate();
        }
        //验证码是否失效
        long time = DateUtils.pastMinutes(updDate);
        if(time > 1){
            throw new ServiceException("验证码已失效");
        }
        //验证码是否正确
        if(!code.equals(relCode)){
            throw new ServiceException("验证码错误");
        }
        //判断用户是否存在
        UserBean userBean = this.dao.findByAccount(phone);
        if(userBean == null){
            throw new ServiceException("用户不存在");
        }
        UserBean userBeanForForget = new UserBean();
        userBeanForForget.setId(userBean.getId());
        userBeanForForget.setPassword(newPassword);
        this.update(userBeanForForget);
    }

    /**
     * 账号和密码查询用户
     * @param account
     * @param password
     * @return
     */
    public UserBean findByAccountAndPwd(String account,String password){
        return this.dao.findByAccountAndPwd(account,password);
    }

    /**
     * 账号查询用户
     * @param account
     * @return
     */
    public UserBean findByAccount(String account){
        return this.dao.findByAccount(account);
    }

}