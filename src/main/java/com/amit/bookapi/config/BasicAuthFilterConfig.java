package com.amit.bookapi.config;

import com.amit.bookapi.filter.BasicAuthFilter;
import com.amit.bookapi.util.NotAuthorizedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicAuthFilterConfig {

    @Autowired
    private BasicAuthFilter customURLFilter;
    /**
     *
     * @return the FilterRegistrationBean instance for BasicAuthFilter
     */
    @Bean
    public FilterRegistrationBean<BasicAuthFilter> filterRegistrationBasicAuthBean(){
        FilterRegistrationBean < BasicAuthFilter > registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(customURLFilter);
        registrationBean.addUrlPatterns("/register");
        return registrationBean;
    }

}
