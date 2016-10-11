package com.mdzy.xqbadmin.common.qiniu;

import org.json.JSONException;

import java.util.UUID;

/**
 * 七牛token生成及回调的设置
 */
public class Uptoken {
	//七牛上传回调我们的服务器地址
	public final static String RETURN_URL = "http://192.168.3.110:8066/QiNiuCallback.jsp";

	/**
	 * 生成七牛token
	 * @return
	 * @throws AuthException
	 * @throws JSONException
	 */
	public final static String makeUptoken() throws AuthException,
			JSONException {
		Mac mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
		PutPolicy putPolicy = new PutPolicy(Config.BUCKET_NAME);
		// 可以根据自己需要设置过期时间,sdk默认有设置，具体看源码
		// putPolicy.expires = getDeadLine();
		//七牛服务回调我们服务的地址
		putPolicy.returnUrl = RETURN_URL;
		//回调内容
		putPolicy.returnBody = "{\"name\": $(fname),\"size\": \"$(fsize)\",\"w\": \"$(imageInfo.width)\",\"h\": \"$(imageInfo.height)\",\"key\":$(etag)}";
		String uptoken = putPolicy.token(mac);
		return uptoken;
	}

	/**
	 * 生成32位UUID 并去掉"-"
	 */
	public static String getUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}
