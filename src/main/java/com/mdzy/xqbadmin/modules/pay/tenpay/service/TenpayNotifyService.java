package com.mdzy.xqbadmin.modules.pay.tenpay.service;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 微信回调
 * Created by Administrator on 2016/7/27.
 */
@Service
public class TenpayNotifyService {

    /**
     * 微信回调业务
     * @param resultMap
     * @return
     */
    public boolean tenpayNotify(Map<String,String> resultMap){
        String orderId = resultMap.get("out_trade_no");
        //回调记录
        //TODO
        //成功，修改订单状态
        if (resultMap.get("result_code").toString().equalsIgnoreCase("SUCCESS")) {
            //修改订单状态为成功
            return true;
        }
        return false;
    }
}
