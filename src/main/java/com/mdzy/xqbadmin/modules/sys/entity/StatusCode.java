package com.mdzy.xqbadmin.modules.sys.entity;

import com.mdzy.xqbadmin.common.persistence.annotation.CodeAnnot;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by chengyou on 2015/6/24.
 */
public enum StatusCode {

    @CodeAnnot("加密失败")MD5_ERROR("001"),
    @CodeAnnot("成功")SUCCESS("200"),
    @CodeAnnot("参数错误")PARENT_ERROR("201"),
    @CodeAnnot("系统错误")SYS_ERROR("202"),
    ;

    private static final Map<String, String> hMap = new HashMap<String, String>();

    static {
        Field[] fields = StatusCode.class.getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(CodeAnnot.class)) {
                hMap.put(field.getName(), field.getAnnotation(CodeAnnot.class).value());
            }
        }
    }

    private final String value;

    // 构造器默认也只能是private, 从而保证构造函数只能在内部使用
    StatusCode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getDescription() {
        return hMap.get(this.toString());
    }
}
