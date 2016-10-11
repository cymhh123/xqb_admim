package com.mdzy.xqbadmin.modules.video.service;

import com.mdzy.xqbadmin.modules.sys.service.CrudService;
import com.mdzy.xqbadmin.modules.video.dao.OrderDao;
import com.mdzy.xqbadmin.modules.video.entity.OrderBean;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
@Service
public class OrderService extends CrudService<OrderDao,OrderBean>{

    /**
     * 用户已支付订单
     * @param userId
     * @return
     */
    public List<OrderBean> payOrderList(String userId){
        OrderBean orderBean = new OrderBean();
        orderBean.setUserId(userId);
        orderBean.setPayStatus("1");
        return this.findList(orderBean);
    }
}
