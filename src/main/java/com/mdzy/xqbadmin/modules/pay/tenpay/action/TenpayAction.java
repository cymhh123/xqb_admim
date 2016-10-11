package com.mdzy.xqbadmin.modules.pay.tenpay.action;

import com.mdzy.xqbadmin.common.exception.ServiceException;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.pay.tenpay.service.TenpayNotifyService;
import com.mdzy.xqbadmin.modules.pay.tenpay.service.TenpayService;
import com.mdzy.xqbadmin.modules.pay.tenpay.utils.PayCommonUtil;
import com.mdzy.xqbadmin.modules.pay.tenpay.utils.XMLUtil;
import com.mdzy.xqbadmin.modules.sys.action.BaseController;
import com.mdzy.xqbadmin.modules.sys.entity.ExecuteBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/27.
 */
@Controller
@RequestMapping("/tenpay")
public class TenpayAction extends BaseController {
    @Autowired
    private TenpayService tenpayService;

    @Autowired
    private TenpayNotifyService notifyService;

    /**
     * 获得微信预支付id
     * @param subjectId
     * @param userId
     * @param price
     * @return
     */
    @RequestMapping("/prepay")
    @ResponseBody
    public Object getPrepayId(String subjectId,String userId,BigDecimal price,HttpServletRequest request){
        if(StringUtils.isBlank(subjectId) || StringUtils.isBlank(userId) || null == price){
            return new ExecuteBean<String>("201","参数有误");
        }
        String ipAddr = request.getRemoteAddr();
//        return this.tenpayService.getPrepayId(subjectId,userId,price,ipAddr);
        return this.tenpayService.getPrepayInfo(subjectId,userId,price,ipAddr);
    }

    /**
     * 微信回调
     * @param request
     * @param response
     */
    @RequestMapping("/notify")
    public void getNotify(HttpServletRequest request, HttpServletResponse response){
        try {
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            //获取微信调用我们notify_url的返回信息
            String result  = new String(outSteam.toByteArray(),"utf-8");
            Map<String,String> map = XMLUtil.doXMLParse(result);
            boolean flag = this.notifyService.tenpayNotify(map);
            if(flag){
                //告诉微信服务器，我收到信息了，不要在调用回调action了
                response.getWriter().write(PayCommonUtil.setXML("SUCCESS", ""));
            }
        }catch (Exception e){
            throw new ServiceException(e);
        }
    }
}
