package main.java.spring.thymeleaf.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class User {

	String username;
	String password;
	Boolean gender;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public User(String username, String password, Boolean gender) {
		super();
		this.username = username;
		this.password = password;
		this.gender = gender;
	}

	public User() {
		super();
	}
	
	

}
