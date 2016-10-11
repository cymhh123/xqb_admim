package com.mdzy.xqbadmin.common.utils;

import com.mdzy.xqbadmin.common.config.Global;
import com.qiniu.util.Auth;
import com.qiniu.util.StringMap;

public class QiNiuUplodTokenUtil {
	
	private static Auth auth = Auth.create(Global.getConfig("qiniu_accesskey"),Global.getConfig("qiniu_secretkey"));

	public static String getUpToken() {
		return auth.uploadToken(
				Global.getConfig("namespace_front"),
				null,
				3600000* 24,
				new StringMap(), true);
		   //.putNotEmpty("persistentOps", "").putNotEmpty("persistentNotifyUrl", "").putNotEmpty("persistentPipeline", "")
	}


	public static String getDownToken(String downurl){
		String urlSigned = auth.privateDownloadUrl(downurl, 3600 * 24);
		System.out.println(urlSigned);
		return urlSigned;
	}
}
