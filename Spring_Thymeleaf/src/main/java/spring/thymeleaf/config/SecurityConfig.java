package main.java.spring.thymeleaf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("jji").password("admin").roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");		
		auth.inMemoryAuthentication().withUser("dba").password("admin").roles("DBA");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// http.antMatcher("/Web/*").authorizeRequests().anyRequest().authenticated().and().formLogin();
		http.authorizeRequests().antMatchers("/*").hasRole("ADMIN")
//				Disable https
				.and().formLogin().and().csrf();
				
	}
}
