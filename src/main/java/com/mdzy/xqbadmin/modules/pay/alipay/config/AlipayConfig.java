package com.mdzy.xqbadmin.modules.pay.alipay.config;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
	
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {
	
	//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
	// 合作身份者ID，以2088开头由16位纯数字组成的字符串
	public static String partner = "2088421544922605";//2088021786721095
	// 卖家支付宝账号
	public static String SELLER = "734493010@qq.com";
	public static String notifyUrl = "alipay/notify";
	// 商户的私钥
//	"MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAN9HYo163KtY8CLx" +
//	"0+pvQJcmGdpU933gKfYzpvPzSjje2kJMdqHb1JTVqZw0gfZF0auuBkb3ag738G7r" +
//			"aOSSWtO/vWp1MNqzuYVfYvDohjSdleBinsc+fLfu6Qbv7mb5kVC0gRHjjEot/VCm" +
//			"7GD/tXZOG+nBiBZjJWxp2xmOBxiRAgMBAAECgYEAsGO2qcqMFhmW7CRbo/Lr9fy1" +
//			"o9RICPtUaxn3JPXohvEXQBUkC06drE73RV395c7Wi2hZsSq4cMbS/O2g2iH8+Z1j" +
//			"+04L4TDOO0ZNIp82GYx6rlu7ArSM9/udM5PD24+O+MSgzy/bn5NGq4PTIeCX71bK" +
//			"WDevziGfmcfDEs7HEJkCQQD7MIODd/3kAmJFiTxzvTS+K3aty6/5Gb21k3du3opD" +
//			"pFstQjOolhvHfCiuHYvAwW8oxG5SqqHef+MDiDesv2XrAkEA444JMzZFOjRVSSNi" +
//			"X+pfHzqndkJXbIyZIStRdHdLwjSOB9YIx6uM/tNcUAlq7d+HL9DdxTyUYj5gUEHC" +
//			"7YDwcwJBAPGsNXwx4FaVbJNWfJEmgy5MhvyjsoVKHNosLYbAGesGoKqkvSsAcW22" +
//			"qTUMPD+SXC6u/y4N+XsnM/VcA6Ty6U0CQHESIeYtoGaUnJBUIczRU+Tbq1yrCG/q" +
//			"yShfMwFxSda9cJnaM9CroMr60ZL/qv96I92RprEcMgtDPW6Dzs1fVZsCQQDYfv+0" +
//			"9tGnBCGA8mN9TSFy9pmmD2JF6EqgOvN9Xjr9URlAbq2O9Ky8k3sbC/1+2zHsVRyA" +
//			"kPH+3f/MJi3D1Vh2";
	public static String private_key =
			"MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAMNTqNytXK1gG1Yn" +
			"mq29dZGEYzNAi/u671Rudl4mLDHghu15MHorrBuRgEyW1PARFg+YouFUykD9QPj+" +
			"QZfe6zdkBxMwyqD4dK2njjSeX6IP9kj4u1duNVg8wWijivI5XVEv/u1HCN6OUUP4" +
			"JqbpCfPBVw9afIHF2wsrVv1/9jYPAgMBAAECgYEAuB+apDs/i6d23WYD5xcbRor3" +
			"QA7uZeM3S+284s81BedTCXQeAGw+ltY3jPr5yzswAo+tqp9U8KJKpux2RIU8T5k0" +
			"ypPJ3tTXEFRK28aszIkLiMyh/DYGhz5TtLhHtI1K7C1W3bj5UcoPCXMIqCPJfcco" +
			"q+vkcPRGGHACNIh70GECQQD1TPYMk2XrXbH4NU7CLhqlBmnyGx03OQnQ4ZaXcSyc" +
			"VKctNSGueaq9OnO7hmrUVdxT4ffVVtadIMZx5adVv1MJAkEAy9iwLh4kH9IMlhkO" +
			"oSQUzIZcUbnkGul0asjgLYxYszjow7sWpF+WD+xfuv83MpLzXWszO2J/QYdJoVsb" +
			"S1KOVwJAYasI9Kzjkbk2mSswdqRAu6A4Isuk8E3nmKGZgibvqjcScS+Mf5m1364c" +
			"UngMpQqitUttkCYJQXrBSKw12jBZcQJBALHDOghNkpUJOJ6gJUjSzSx6MwG2CLyL" +
			"P1Fr8UrnK+bGxv0BJsKa9KLYL7dDnqAE1CNwO5Ia1/yN/OCwMYIi8SsCQQCjYzOS" +
			"RYf+112YJL71UVxJDb/Gt6Bl+zI4/vWLXZL2G2Xxo0Hj9Ja7VKBRcBd1fsEIHNsl" +
			"2UYP6ZkWlHYNeNMW";

	// 支付宝的公钥，无需修改该值
	//"MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
	public static String ali_public_key  = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDDU6jcrVytYBtWJ5qtvXWRhGMzQIv7uu9UbnZeJiwx4IbteTB6K6wbkYBMltTwERYPmKLhVMpA/UD4/kGX3us3ZAcTMMqg+HStp440nl+iD/ZI+LtXbjVYPMFoo4ryOV1RL/7tRwjejlFD+Cam6QnzwVcPWnyBxdsLK1b9f/Y2DwIDAQAB";
	//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

	// 字符编码格式 目前支持 gbk 或 utf-8
	public static String input_charset = "utf-8";
	
	// 签名方式 不需修改
	public static String sign_type = "RSA";
}
