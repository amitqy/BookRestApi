package com.amit.bookapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amit.bookapi.filter.JwtAuthenticationFilter;



@Configuration
public class JwtAuthFilterConfig {

	@Autowired
	private JwtAuthenticationFilter customerUrlFilter;

	/**
	 *
	 * @return the FilterRegistrationBean instance for JwtAuthenticationFilter
	 */
	@Bean
	public FilterRegistrationBean<JwtAuthenticationFilter> filterRegistrationBean(){
		   FilterRegistrationBean < JwtAuthenticationFilter > registrationBean = new FilterRegistrationBean();
		   registrationBean.setFilter(customerUrlFilter);
		   registrationBean.addUrlPatterns("/api/v1/book/*");
		   return registrationBean;
	}

	// was not able to put more than one FilterRegistrationBean in one class
}
