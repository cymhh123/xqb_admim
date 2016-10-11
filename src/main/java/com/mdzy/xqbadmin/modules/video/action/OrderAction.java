package com.mdzy.xqbadmin.modules.video.action;

import com.github.pagehelper.PageInfo;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.OrderBean;
import com.mdzy.xqbadmin.modules.video.entity.SubjectBean;
import com.mdzy.xqbadmin.modules.video.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/10/11.
 */
@Controller
@RequestMapping("${adminPath}/order")
public class OrderAction extends BaseController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/page")
    public String page(String type){
        if(type.equals("list")){
            return "/video/order_list";
        }
        return null;
    }

    /**
     * 列表
     * @param page
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Object list(OrderBean entity, Integer page){
        List<OrderBean> list = this.orderService.findByPage(entity,page);
        PageInfo<OrderBean> pageInfo = new PageInfo<>(list);
        return new ExecuteBean<List<OrderBean>>(list,pageInfo.getPages(), (int) pageInfo.getTotal());
    }


}
