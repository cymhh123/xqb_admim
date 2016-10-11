package com.mdzy.xqbadmin.modules.sys.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mdzy.xqbadmin.common.utils.CacheUtils;
import com.mdzy.xqbadmin.common.utils.SpringContextHolder;
import com.mdzy.xqbadmin.modules.dict.dao.DictDao;
import com.mdzy.xqbadmin.modules.dict.entity.DictBean;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 字典工具类
 *
 * @author chengyou
 * @version 2013-5-29
 */
public class DictUtils {

    private static DictDao dictDao = SpringContextHolder.getBean(DictDao.class);
    public static final String CACHE_DICT_MAP = "dictMap";

    /**
     * 类型，值查询标题
     *
     * @param value        值
     * @param type         类型
     * @param defaultValue 默认值
     * @return
     */
    public static String getDictLabel(String value, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(value)) {
            for (DictBean dict : getDictList(type)) {
                if (type.equals(dict.getType()) && value.equals(dict.getValue())) {
                    return dict.getLabel();
                }
            }
        }
        return defaultValue;
    }

    /**
     * 类型，值查询标题
     *
     * @param values
     * @param type
     * @param defaultValue
     * @return
     */
    public static String getDictLabels(String values, String type, String defaultValue) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(values)) {
            List<String> valueList = Lists.newArrayList();
            for (String value : StringUtils.split(values, ",")) {
                valueList.add(getDictLabel(value, type, defaultValue));
            }
            return StringUtils.join(valueList, ",");
        }
        return defaultValue;
    }

    /**
     * 标题，类型查询值
     *
     * @param label        标题
     * @param type         类型
     * @param defaultLabel
     * @return
     */
    public static String getDictValue(String label, String type, String defaultLabel) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(label)) {
            for (DictBean dict : getDictList(type)) {
                if (type.equals(dict.getType()) && label.equals(dict.getLabel())) {
                    return dict.getValue();
                }
            }
        }
        return defaultLabel;
    }

    /**
     * 类型查询字典列表
     *
     * @param type 类型
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<DictBean> getDictList(String type) {
        Map<String, List<DictBean>> dictMap = (Map<String, List<DictBean>>) CacheUtils.get(CACHE_DICT_MAP);
        if (dictMap == null) {
            dictMap = Maps.newHashMap();
            DictBean d = new DictBean();
            for (DictBean dict : dictDao.findList(d)) {
                List<DictBean> dictList = dictMap.get(dict.getType());
                if (dictList != null) {
                    dictList.add(dict);
                } else {
                    dictMap.put(dict.getType(), Lists.newArrayList(dict));
                }
            }
            CacheUtils.put(CACHE_DICT_MAP, dictMap);
        }
        List<DictBean> dictList = dictMap.get(type);
        if (dictList == null) {
            dictList = Lists.newArrayList();
        }
        return dictList;
    }

    /**
     * 获取lables
     * @param type
     * @return
     */
    public static List<String> getDicLabelList(String type) {
        List<DictBean> dictList = DictUtils.getDictList(type);
        List<String> dictStrList = new ArrayList<String>();
        for (DictBean dict : dictList) {
            dictStrList.add(dict.getLabel());
        }
        return dictStrList;
    }

}
