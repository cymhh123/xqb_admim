package com.mdzy.xqbadmin.modules.index.action;

import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.modules.admin.entity.SysAdmin;
import com.mdzy.xqbadmin.modules.index.service.IndexService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by Administrator on 2016/8/10.
 */
@Controller
@RequestMapping("${adminPath}")
public class IndexAction extends BaseController {
    @Autowired
    private IndexService indexService;

    @RequestMapping("/main")
    public String index(){
        return "index";
    }

    @RequestMapping("/index")
    public String login_html(){
        return "login";
    }

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public Object login(String account, String password, HttpSession session){
        try{
            SysAdmin sysAdmin = this.indexService.login(account,password);
            session.setAttribute("sysAdmin",sysAdmin);
        }catch (ServiceException e){
            return new ExecuteBean<>(e);
        }
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 退出
     * @param session
     * @return
     */
    @RequestMapping("/out")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "redirect:"+adminPath+"/index";
    }
}
