package com.mdzy.xqbadmin.modules.sys.action;

import com.mdzy.xqbadmin.common.mapper.JsonMapper;
import com.mdzy.xqbadmin.common.utils.DateUtils;
import com.mdzy.xqbadmin.common.utils.MD5;
import com.mdzy.xqbadmin.modules.sys.entity.StatusCode;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 控制器支持类
 *
 * @author chengyou
 * @version 2013-3-23
 */
public abstract class BaseController {
    @Autowired
    protected HttpServletRequest request;

    @Value("#{APP_PROP['ecode']}")
    private String salt;
    @Value("#{APP_PROP['product_path']}")
    protected String path;

    @Value("${adminPath}")
    protected String adminPath;

    /**
     * return Map 返回数据专用map
     */
    protected Map<String, Object> map = new HashMap<String, Object>();
    /**
     * 日志对象
     */
    protected Logger logger = Logger.getLogger(getClass());

    /**
     * 验证Bean实例对象
     */
    @Autowired
    protected Validator validator;

    /**
     * 客户端返回JSON字符串
     *
     * @param response
     * @param object
     * @return
     */
    protected String renderString(HttpServletResponse response, Object object) {
        return renderString(response, JsonMapper.toJsonString(object), "application/json");
    }

    /**
     * 客户端返回字符串
     *
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 转化为json串
     *
     * @param object
     * @return
     */
    protected String toJsonStr(Object object) {
        return JsonMapper.nonDefaultMapper().toJson(object);
    }

    /**
     * 加密校验
     * @param str1
     * @param str2
     * @return
     */
    protected boolean insecurity(String str1,String str2){
        StringBuffer sb = new StringBuffer(this.salt);
        String code= MD5.md5(sb.append(str1).toString());
        return code.equals(str2);
    }

    /**
     * 加密失败返回信息
     * @return
     */
    protected Map<String,Object> insecurityFailMap(){
        map.put("state", StatusCode.MD5_ERROR.getValue());
        map.put("msg", StatusCode.MD5_ERROR.getDescription());
        return map;
    }

    public Map<String,Object> mapInfo(String state,String msg){
        map.put("state", state);
        map.put("msg", msg);
        return map;
    }

    /**
     * 参数绑定异常
     */
    @ExceptionHandler({BindException.class, ConstraintViolationException.class, ValidationException.class})
    public String bindException() {
        return "error/404";
    }


    /**
     * 初始化数据绑定
     * 1. 将所有传递进来的String进行HTML编码，防止XSS攻击
     * 2. 将字段中Date类型转换为String类型
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        // Date 类型转换
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDate(text));
            }
//			@Override
//			public String getAsText() {
//				Object value = getValue();
//				return value != null ? DateUtils.formatDateTime((Date)value) : "";
//			}
        });
    }

    /**
     * 获取请求参数中所有的信息
     *
     * @param request
     * @return
     */
    public static Map<String, String> getAllRequestParam(final HttpServletRequest request) {
        Map<String, String> res = new HashMap<String, String>();
        Enumeration<?> temp = request.getParameterNames();
        if (null != temp) {
            while (temp.hasMoreElements()) {
                String en = (String) temp.nextElement();
                String value = request.getParameter(en);
                res.put(en, value);
                if (null == res.get(en) || "".equals(res.get(en))) {
                    res.remove(en);
                }
            }
        }
        return res;
    }

    /**
     * 用于处理异常的
     * @return
     */
//    @ExceptionHandler({ServiceException.class})
//    public String exception(ServiceException e) {
//        request.setAttribute("error",e);
//        return "/error/error";
//    }

}
