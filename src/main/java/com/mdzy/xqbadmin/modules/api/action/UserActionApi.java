package com.mdzy.xqbadmin.modules.api.action;

import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.qiniu.utils.QiniuUtils;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import com.mdzy.xqbadmin.modules.user.entity.UserBean;
import com.mdzy.xqbadmin.modules.user.service.UserBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 用户管理
 * Created by Administrator on 2016/9/26.
 */
@Controller
@RequestMapping("/api/user")
public class UserActionApi extends BaseController{
    @Autowired
    public UserBeanService userBeanService;

    /**
     * 发送验证码
     * @param phone 手机号
     * @return
     */
    @RequestMapping("/sendSms")
    @ResponseBody
    public Object sendSMS(String phone,Integer scope){
        if(StringUtils.isBlank(phone) || scope == null){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            //发送验证码
            this.userBeanService.sendSMS(phone,scope,4);
            return new ExecuteBean<>(StatusCode.SUCCESS);
        }catch (Exception e){
            return new ExecuteBean<>(e);
        }
    }

    /**
     * 注册
     * @return
     */
    @RequestMapping("/register")
    @ResponseBody
    public Object register(String phone,String password,String code){
        if(StringUtils.isBlank(phone) || StringUtils.isBlank(password) || StringUtils.isBlank(code)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.userBeanService.register(phone,password,code);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 手机登录
     * @param phone
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String phone,String password){
        if(StringUtils.isBlank(phone) || StringUtils.isBlank(password)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            UserBean userBean = this.userBeanService.login(phone,password);
            userBean.setQiNiuToken(QiniuUtils.getUpToken());
            return new ExecuteBean<>(userBean);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
    }

    /**
     * 第三方登录
     * @param userBean
     * @param bindingResult
     * @return
     */
    @RequestMapping("/thirdLogin")
    @ResponseBody
    public Object thirdLogin(@Valid UserBean userBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        userBean.setPhone("0");//绑定的手机号，默认为0，未绑定
        this.userBeanService.save(userBean);
        userBean.setQiNiuToken(QiniuUtils.getUpToken());
        return new ExecuteBean<>(userBean);
    }

    /**
     * 完善用户信息
     * @param userBean
     * @return
     */
    @RequestMapping("/perfect")
    @ResponseBody
    public Object perfectInfo(UserBean userBean){
        this.userBeanService.update(userBean);
        return new ExecuteBean<>();
    }

    /**
     * 绑定手机号
     * @param phone
     * @param code
     * @return
     */
    @RequestMapping("/binding")
    @ResponseBody
    public Object bindingPhone(String userId,String phone,String code){
        if(StringUtils.isBlank("userId") || StringUtils.isBlank(phone) || StringUtils.isBlank(code)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.userBeanService.bindingPhone(userId,phone,code);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 修改密码
     * @param userId
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping("/password/modify")
    @ResponseBody
    public Object modifyPassword(String userId,String oldPassword,String newPassword){
        if(StringUtils.isBlank(userId) || StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.userBeanService.modifyPassword(userId,oldPassword,newPassword);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 忘记密码
     * @param phone
     * @param newPassword
     * @param code
     * @return
     */
    @RequestMapping("/password/forget")
    @ResponseBody
    public Object forgetPassword(String phone,String newPassword,String code){
        if(StringUtils.isBlank(phone) || StringUtils.isBlank(newPassword) || StringUtils.isBlank(code)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        try{
            this.userBeanService.forgetPassword(phone,newPassword,code);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 用户信息
     * @param userId
     * @return
     */
    @RequestMapping("/info")
    @ResponseBody
    public Object info(String userId){
        if(StringUtils.isBlank(userId)){
            return new ExecuteBean<>(StatusCode.PARENT_ERROR);
        }
        UserBean userBean = this.userBeanService.get(userId);
        return new ExecuteBean<>(userBean);
    }

}
