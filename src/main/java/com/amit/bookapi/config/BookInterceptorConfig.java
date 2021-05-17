package com.amit.bookapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.amit.bookapi.interceptor.BookInterceptor;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class BookInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private BookInterceptor bookInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(bookInterceptor);
	}
}
