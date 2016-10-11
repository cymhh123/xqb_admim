package com.mdzy.xqbadmin.modules.pay.alipay.action;

import com.mdzy.xqbadmin.modules.pay.alipay.service.AlipayService;
import com.mdzy.xqbadmin.modules.pay.alipay.service.NotifyService;
import com.mdzy.xqbadmin.modules.pay.alipay.utils.AlipayNotify;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 支付宝action
 * Created by Administrator on 2016/7/26.
 */
@Controller
@RequestMapping("/alipay")
public class AlipayAction extends BaseController {
    @Autowired
    private AlipayService alipayService;
    @Autowired
    private NotifyService notifyService;

    /**
     * 支付获取签名
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/sign", method = RequestMethod.GET)
    public Object getOrderSignStr(String subjectId,String userId,BigDecimal price) {
        return this.alipayService.payInfo(subjectId,userId,price);
    }


    /**
     * 支付成功后回调
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/notify")
    public String aliNotify() {
        Map<String, String> params = getAllRequestParam(request);
        //获取支付宝的通知返回参数，可参考技术文档中页面跳转同步通知参数列表(以上仅供参考)//
        if (AlipayNotify.verify(params)) {//验证成功
            //所有参数查看 http://doc.open.alipay.com/doc2/detail?treeId=59&articleId=103666&docType=1
            if(this.notifyService.validationOrder(params)){
                return "success";
            }else{
                return "fail";
            }
        } else {// 验证失败
            return "fail";
        }
    }
}
