package com.dream.shc.base.controlle;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;




@Controller
public class BaseController {
	private Logger logger;

	public Logger getLogger() {
		return logger;
	}
	@Resource(name = "logger")
	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	@ExceptionHandler(Exception.class)
	public String handleCommonException(Exception ex){
		ex.printStackTrace();
		logger.info(ex.getMessage());
		return "common/error/common_exception_error";
	}
//	protected User getCurrentUser(){
//		return (User)RequestContextHolder.currentRequestAttributes().getAttribute(SystemConstants.SESSION_KEY_USER, RequestAttributes.SCOPE_SESSION);
//	}
}
