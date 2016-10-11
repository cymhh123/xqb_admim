package com.mdzy.xqbadmin.modules.pay.alipay.service;

import com.mdzy.xqbadmin.modules.pay.alipay.config.AlipayConfig;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by Administrator on 2016/7/26.
 */
@Service
public class NotifyService {

    /**
     * 异步服务
     * @param requestParams
     * @return
     */
    public boolean validationOrder(Map<String,String> requestParams) {
        //交易状态
        String trade_status = requestParams.get("trade_status");
        //支付宝交易流水号
        String trade_no = requestParams.get("trade_no");
        //订单id
        String orderId = requestParams.get("out_trade_no");
        //支付宝回调记录
        //TODO
        //判断订单真实性
        //获取订单，对比金额
        //TODO
        //卖家支付宝账号对应的支付宝唯一用户号。以2088开头的纯16位数字。相当于配置文件中的合作身份者ID
        String seller_id = requestParams.get("seller_id");
        //判断支付商户是否与当前商户一致
        if (seller_id.equals(AlipayConfig.partner) == false) {
            return false;
        }
        if (trade_status.equals("TRADE_FINISHED")) {//交易成功(退款日期超过可退款期限后状态为这个)
            return true;
        } else if (trade_status.equals("TRADE_SUCCESS")) {//支付成功(付款成功后)
            //修改订单状态为成功
            return true;
        }
        return false;
    }
}
