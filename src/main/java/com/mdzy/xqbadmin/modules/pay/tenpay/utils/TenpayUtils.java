package com.mdzy.xqbadmin.modules.pay.tenpay.utils;

import com.mdzy.xqbadmin.modules.pay.tenpay.config.TenpayConfig;
import org.jdom.JDOMException;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * 微信支付
 * Created by Administrator on 2016/7/27.
 */
public class TenpayUtils {

    /**
     * 获得预支付订单信息
     * @param orderId 订单id
     * @param body 商品描述
     * @param attach 附加数据
     * @param price 金额（元）
     * @param ipAddr ip地址
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static Map<String,String> getPrepayInfo(String orderId, String body,String attach, BigDecimal price,String ipAddr) throws JDOMException, IOException {
        //封装请求参数
        SortedMap<Object,Object> parameters = new TreeMap<Object,Object>();
        parameters.put("appid", TenpayConfig.APP_ID);
        parameters.put("mch_id", TenpayConfig.MCH_ID);
        parameters.put("nonce_str", PayCommonUtil.CreateNoncestr());
        parameters.put("body", body);
        parameters.put("attach",attach);
        parameters.put("out_trade_no", orderId);
        parameters.put("total_fee", price.multiply(new BigDecimal(100)).intValue() + "");
        parameters.put("spbill_create_ip",ipAddr);
        parameters.put("notify_url", TenpayConfig.NOTIFY_URL);
        parameters.put("trade_type", "APP");
        //生成sign
        String sign = PayCommonUtil.createSign("UTF-8", parameters);
        parameters.put("sign", sign);
        //封装成xml格式
        String requestXML = PayCommonUtil.getRequestXml(parameters);
        //请求微信获得预支付信息
        String result =CommonUtil.httpsRequest(TenpayConfig.UNIFIED_ORDER_URL, "POST", requestXML);
        Map<String,String> resultMap = XMLUtil.doXMLParse(result);
        return resultMap;
    }

    /**
     * 获得预支付订单id
     * @param orderId 订单id
     * @param body 商品描述
     * @param attach 附加数据
     * @param price 金额（元）
     * @param ipAddr ip地址
     * @return
     * @throws JDOMException
     * @throws IOException
     */
    public static String getPrepayId(String orderId, String body,String attach, BigDecimal price,String ipAddr) throws JDOMException, IOException {
        Map<String,String> resultMap = getPrepayInfo(orderId,body,attach,price,ipAddr);
        return resultMap.get("prepay_id");
    }

}
