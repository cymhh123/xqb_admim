package com.mdzy.xqbadmin.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class JsonTools {

	/**
	 * json 字符串 转 Map
	 * 
	 * @param json
	 * @return
	 */
	public static Map<String, Object> jsonStrToMap(String json) {
		Map<String, Object> map = new HashMap<String, Object>();
		if (ChkTools.isNull(json)) {
			return map;
		}

		JSONObject jsonObject = JSON.parseObject(json);
		Set<String> keys = jsonObject.keySet();
		for (String key : keys) {
			map.put(key, jsonObject.get(key));
		}

		return map;
	}
	
	public static Map<String, String> jsonStrToMapStr(String json) {
		Map<String, String> map = new HashMap<String, String>();
		if (ChkTools.isNull(json)) {
			return map;
		}

		JSONObject jsonObject = JSON.parseObject(json);
		Set<String> keys = jsonObject.keySet();
		for (String key : keys) {
			map.put(key, jsonObject.get(key).toString());
		}

		return map;
	}

	/**
	 * json 字符串 转 JSONObject
	 * 
	 * @param json
	 * @return
	 */
	public static Object jsonStrToJsonObject(String json, Class<?> clazz) {
		if (clazz == String.class) {
			if (json.length() > 2) {
				// 去掉首尾的引号
				json = json.substring(1, json.length() - 1);
			}
			return json;
		} else {
			JSONObject parse = JSON.parseObject(json);
			return JSON.toJavaObject(parse, clazz);
		}
	}

	/**
	 * 对象-->json
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return JSON.toJSONString(obj);
	}

	public static Map<String, Object> objToMap(Object obj) {
		String json = toJson(obj);
		Map<String, Object> map = jsonStrToMap(json);
		return map;
	}


	public static void main(String[] args) {
		String json = "{ \"firstName\": \"Brett\", \"lastName\":\"McLaughlin\", \"email\": \"aaaa\" }";
		Map<String, Object> map = jsonStrToMap(json);
		String js = "{\"+\"}";
		System.err.println(map);
	}

}
