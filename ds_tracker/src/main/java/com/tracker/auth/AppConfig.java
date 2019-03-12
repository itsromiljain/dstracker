package com.tracker.auth;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {

	@Autowired
	RequestInterceptor requestInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor).excludePathPatterns(
				new String[] {"/login", "/logout","/register","/admin/**","/webjars/**", "/swagger-ui.html/**", "/swagger-resources/**", "/csrf", "/actuator/**", "/error", "/v2/api-docs"});
	}

	@Bean
	public StrongPasswordEncryptor strongEncryptor(){
		StrongPasswordEncryptor encryptor = new StrongPasswordEncryptor();
		return encryptor;
	}
}