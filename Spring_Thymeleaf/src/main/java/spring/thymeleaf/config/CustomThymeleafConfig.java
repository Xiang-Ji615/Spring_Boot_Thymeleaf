package main.java.spring.thymeleaf.config;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.expression.Sets;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

import main.java.spring.thymeleaf.dialect.HelloWorldDialect;

@Configuration
public class CustomThymeleafConfig implements ApplicationContextAware{

	  private ApplicationContext applicationContext;
	
	@Bean
	public ClassLoaderTemplateResolver yourTemplateResolver() {
		ClassLoaderTemplateResolver yourTemplateResolver = new ClassLoaderTemplateResolver();
		yourTemplateResolver.setPrefix("jj/templates/");
		yourTemplateResolver.setSuffix(".html");
		yourTemplateResolver.setTemplateMode("HTML");
		yourTemplateResolver.setOrder(0);
		yourTemplateResolver.setCheckExistence(true);
		return yourTemplateResolver;
	}
	
	@Bean
	public ITemplateResolver templateResolver() {
	    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
	    resolver.setPrefix("classpath:templates/");
	    resolver.setSuffix(".html");
	    resolver.setTemplateMode(TemplateMode.HTML);
	    resolver.setCacheable(false);
	    resolver.setOrder(1);
	    return resolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setEnableSpringELCompiler(true);
		Set<ITemplateResolver> templateResolvers = new HashSet<>(Arrays.asList(templateResolver(), yourTemplateResolver()));
		templateEngine.setTemplateResolvers(templateResolvers);
		templateEngine.addDialect(new HelloWorldDialect());
		return templateEngine;
	}
//	
//	
//	private ITemplateResolver templateResolver() {
//		    SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
//		    resolver.setApplicationContext(applicationContext);
//		    resolver.setPrefix("jj/templates/");
//		    resolver.setTemplateMode(TemplateMode.HTML);
//		    resolver.setOrder(0);
//		    return resolver;
//		  }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
		
	}

}
