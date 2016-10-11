package com.mdzy.xqbadmin.common.config;


import com.mdzy.xqbadmin.common.utils.MD5;
import com.mdzy.xqbadmin.common.utils.PropertiesLoader;
import com.mdzy.xqbadmin.common.utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局配置类
 * 缓存并获取resources配置文件的信息
 * @author chengyou
 * @version 2014-06-25
 */
public class Global {

	/**
	 * 当前对象实例
	 */
	private static Global global = new Global();
	
	/**
	 * 保存全局属性值
	 */
	private static Map<String, String> map = new HashMap<String,String>();
	
	/**
	 * 属性文件加载对象
	 */
	private static PropertiesLoader loader = new PropertiesLoader("resources.properties");

	/**
	 * 获取当前对象实例
	 */
	public static Global getInstance() {
		return global;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('product_path')}
	 */
	public static String getConfig(String key) {
		String value = map.get(key);
		if (value == null){
			value = loader.getProperty(key);
			map.put(key, value != null ? value : StringUtils.EMPTY);
		}
		return value;
	}
	
	/**
	 * 获取配置
	 * @see ${fns:getConfig('product_path')}
	 */
	public static String getProductPath() {
		return getConfig("product_path");
	}

	/**
	 * 加密校验
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean insecurity(String str1,String str2){
		String salt = getConfig("ecode");
		StringBuffer sb = new StringBuffer(salt);
		String code= MD5.md5(sb.append(str1).toString());
		return !code.equals(str2);
	}

	public static String getAdminPath(){
		return getConfig("adminPath");
	}
	
}
