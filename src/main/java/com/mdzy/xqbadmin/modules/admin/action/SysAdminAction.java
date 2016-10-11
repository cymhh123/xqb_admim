package com.mdzy.xqbadmin.modules.admin.action;

import com.mdzy.xqbadmin.modules.admin.entity.SysAdmin;
import com.mdzy.xqbadmin.modules.admin.service.SysAdminService;
import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 后台管理员Action
 * SysAdminAction
 * auther:chyou
 */
@Controller
@RequestMapping("${adminPath}/admin")
public class SysAdminAction extends BaseController {

    @Autowired
    private SysAdminService sysAdminService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("add")){
            return "/admin/add";
        }else if(type.equals("list")){
            return "/admin/list";
        }
        return null;
    }

    /**
     * 列表
     * @param page 当前页
     * @param sysAdmin 参数实体
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(Integer page,SysAdmin sysAdmin){
        List<SysAdmin> list = this.sysAdminService.findByPage(sysAdmin,page);
        PageInfo<SysAdmin> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<>(pageInfo);
    }

    /**
     * 单个
     * @param id
     * @return
     */
    @RequestMapping("/one")
    @ResponseBody
    public Object get(String id){
        SysAdmin sysAdmin = this.sysAdminService.get(id);
        return new ExecuteBean<SysAdmin>(sysAdmin);
    }

    /**
     * 添加
     * @param sysAdmin
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(SysAdmin sysAdmin){
        this.sysAdminService.save(sysAdmin);
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public Object delete(String id){
        this.sysAdminService.delete(id);
        return new ExecuteBean<>(StatusCode.SUCCESS);
    }
}
