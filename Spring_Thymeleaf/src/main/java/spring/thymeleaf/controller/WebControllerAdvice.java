package main.java.spring.thymeleaf.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.exceptions.TemplateInputException;

@ControllerAdvice
public class WebControllerAdvice {
	
	private static final Logger logger = LoggerFactory.getLogger(WebControllerAdvice.class);
	
	@ExceptionHandler(value=Exception.class)
	public String handleGeneralException(HttpServletRequest request, Exception ex) {
		return "Error/GeneralError";
	}
	
	@ExceptionHandler(TemplateInputException.class)
	public void templateException(){
		logger.error("IOException handler executed");
		System.out.println("Not found exception");
		//returning 404 error code
	}

}
