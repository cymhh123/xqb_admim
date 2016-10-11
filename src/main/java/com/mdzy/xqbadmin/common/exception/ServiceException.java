package com.mdzy.xqbadmin.common.exception;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service层公用的Exception, 从由Spring管理事务的函数中抛出时会触发事务回滚.
 * @author chengyou
 */
public class ServiceException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static Logger logger = LoggerFactory.getLogger(ServiceException.class);

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
		logger.info("============"+message+"================");
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
