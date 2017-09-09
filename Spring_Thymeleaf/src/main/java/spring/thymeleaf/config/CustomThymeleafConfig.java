package main.java.spring.thymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

//@Configuration
public class CustomThymeleafConfig {
	
	@Bean
	public ClassLoaderTemplateResolver yourTemplateResolver() {
	        ClassLoaderTemplateResolver yourTemplateResolver = new ClassLoaderTemplateResolver();
	        yourTemplateResolver.setPrefix("/jj/templates/");
	        yourTemplateResolver.setSuffix(".html");
	        yourTemplateResolver.setTemplateMode("HTML5");
	        yourTemplateResolver.setCharacterEncoding("UTF-8");
	        yourTemplateResolver.setOrder(0);
	        return yourTemplateResolver;
	    }

}
