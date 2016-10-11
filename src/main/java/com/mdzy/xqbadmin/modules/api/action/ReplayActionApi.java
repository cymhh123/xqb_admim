package com.mdzy.xqbadmin.modules.api.action;

import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.ReplayBean;
import com.mdzy.xqbadmin.modules.video.service.ReplayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016-07-20.
 */
@Controller
@RequestMapping("/api/replay")
public class ReplayActionApi extends BaseController {

    @Autowired
    private ReplayService replayService;

    /**
     * 保存回复
     * @param replayBean
     * @return
     */
    @RequestMapping("/save")
    @ResponseBody
    public Object save(@Validated ReplayBean replayBean, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return new ExecuteBean<>("201","参数有误");
        }
        this.replayService.save(replayBean);
        return new ExecuteBean<>();
    }

}
