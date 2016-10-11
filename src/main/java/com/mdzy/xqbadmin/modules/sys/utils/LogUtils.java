package com.mdzy.xqbadmin.modules.sys.utils;


import com.mdzy.xqbadmin.common.utils.Exceptions;
import com.mdzy.xqbadmin.common.utils.IdGen;
import com.mdzy.xqbadmin.common.utils.SpringContextHolder;
import com.mdzy.xqbadmin.common.utils.StringUtils;
import com.mdzy.xqbadmin.modules.log.dao.LogDao;
import com.mdzy.xqbadmin.modules.log.entity.LogBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * 字典工具类
 * @author chengyou
 * @version 2014-11-7
 */
public class LogUtils {
	
	private static LogDao logDao = SpringContextHolder.getBean(LogDao.class);
	
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, String title){
		saveLog(request, null, null, title);
	}
	
	/**
	 * 保存日志
	 */
	public static void saveLog(HttpServletRequest request, Object handler, Exception ex, String title){
		LogBean log = new LogBean();
		log.setTitle(title);
		log.setType(ex == null ? LogBean.TYPE_ACCESS : LogBean.TYPE_EXCEPTION);
		log.setRemoteAddr(StringUtils.getRemoteAddr(request));
		log.setUserAgent(request.getHeader("user-agent"));
		log.setRequestUri(request.getRequestURI());
		log.setParams(request.getParameterMap());
		log.setMethod(request.getMethod());
		// 异步保存日志
		new SaveLogThread(log, handler, ex).start();
	}

	/**
	 * 保存日志线程
	 */
	public static class SaveLogThread extends Thread{
		
		private LogBean log;
		private Object handler;
		private Exception ex;
		
		public SaveLogThread(LogBean log, Object handler, Exception ex){
			super(SaveLogThread.class.getSimpleName());
			this.log = log;
			this.handler = handler;
			this.ex = ex;
		}
		
		@Override
		public void run() {
			// 获取日志标题
			log.setTitle("");
			// 如果有异常，设置异常信息
			log.setException(Exceptions.getStackTraceAsString(ex));
			// 如果无标题并无异常日志，则不保存信息
			if (StringUtils.isBlank(log.getTitle()) && StringUtils.isBlank(log.getException())){
				return;
			}
			// 保存日志信息
			log.setId(IdGen.uuid());
			log.setCreateDate(new Date());
			logDao.insert(log);

		}
	}

	
}
