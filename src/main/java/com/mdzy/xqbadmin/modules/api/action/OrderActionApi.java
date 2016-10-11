package com.mdzy.xqbadmin.modules.api.action;

import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import com.mdzy.xqbadmin.modules.video.entity.OrderBean;
import com.mdzy.xqbadmin.modules.video.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/9/27.
 */
@Controller
@RequestMapping("/api/order")
public class OrderActionApi extends BaseController {
    @Autowired
    private OrderService orderService;

    /**
     * 用户已支付订单
     * @param userId
     * @return
     */
    @RequestMapping("/pay")
    @ResponseBody
    public Object userBuy(String userId){
        if(StringUtils.isBlank(userId)){
            return new ExecuteBean<>("201","参数有误");
        }
        List<OrderBean> orderList = this.orderService.payOrderList(userId);
        return new ExecuteBean<>(orderList);
    }
}
