package com.mdzy.xqbadmin.modules.dict.controller;


import com.mdzy.xqbadmin.modules.dict.service.DictService;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
* Created by chengyou on 2015-8-11.
*/
@Controller
@RequestMapping("${adminPath}/dict")
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    /**
     * 查询日志列表（测试架构）
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list() {
        System.out.println("#######################");
    	return  this.dictService.findTypeList();
    }

}
