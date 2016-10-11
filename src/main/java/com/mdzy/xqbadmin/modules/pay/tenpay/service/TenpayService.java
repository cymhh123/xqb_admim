package com.mdzy.xqbadmin.modules.pay.tenpay.service;

import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.modules.pay.tenpay.utils.*;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/27.
 */
@Service
public class TenpayService {

    /**
     * 获得预支付订单id
     * @return
     */
    public ExecuteBean<String> getPrepayId(String subjectId,String userId,BigDecimal price,String ipAddr){
        //获得订单信息
        // TODO
        //获取订单信息字符串
        String prepay_id="";
        try {
            prepay_id = TenpayUtils.getPrepayId("","",userId,price,ipAddr);
        } catch (Exception e1) {
            throw new ServiceException(e1);
        }
        return new ExecuteBean<>(prepay_id);
    }

    /**
     * 获得预支付订单信息
     * @return
     */
    public ExecuteBean<Map<String,String>> getPrepayInfo(String subjectId,String userId,BigDecimal price,String ipAddr){
        //获取订单信息
        //TODO
        String orderId = "";
        String title = "";
        Map<String,String> resultMap = new HashMap<>();
        try {
            resultMap = TenpayUtils.getPrepayInfo(orderId,title,userId,price,ipAddr);
        } catch (Exception e1) {
            throw new ServiceException(e1);
        }
        return new ExecuteBean<>(resultMap);
    }
}
