package main.java.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import main.java.spring.thymeleaf.model.User;

@Controller
public class WebController implements ApplicationContextAware {
	
	ApplicationContext context;

	@Value(value="${web.msg:Ok not too bad}")
	String msg;
	
	@Value(value="${spring.thymeleaf.templateResolverOrder:123}")
	String propertyMsg;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String helloWorld(ModelMap map) {
		return "HelloWorld";
	}
	
	@RequestMapping(value="JJ", method=RequestMethod.GET)
	public String jjPage(ModelMap map) {
		return "JJPage";
	}
	
	@ModelAttribute
	@Order(value=1)
	public void addModelAttribute(ModelMap map) {
		map.addAttribute("message", msg);
		map.addAttribute("propertyMsg", propertyMsg);
		
		List<String> testList = new ArrayList<String>();
		for(int i=0; i<100; i++) {
			testList.add(String.valueOf(i));
		}
		map.addAttribute("listData", testList);
		User user = context.getBean(User.class);
		user.setGender(true);
		user.setUsername("JJ");
		user.setPassword("P@ssw0rd");
		map.addAttribute("user", user);
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		// TODO Auto-generated method stub
		this.context = arg0;
	}
}
