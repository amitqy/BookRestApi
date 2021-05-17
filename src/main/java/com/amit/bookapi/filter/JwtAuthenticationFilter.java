package com.amit.bookapi.filter;

import com.amit.bookapi.services.JwtAuthService;
import com.amit.bookapi.util.NotAuthorizedUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;


@Component
public class JwtAuthenticationFilter implements Filter {

    /**
     *
     * @param request from the filtered url
     * @param response after filtered url
     * @param chain
     * @throws IOException
     * @throws ServletException
     */

    @Autowired
    NotAuthorizedUtil notAuthorizedUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException,
            ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest)  request;
        final String authCredentials = httpServletRequest.getHeader("Authorization");
      //  System.out.println(authCredentials);
        if(JwtAuthService.bearerToken.equals(authCredentials)){
            chain.doFilter(request,response);
        }
        else{
            notAuthorizedUtil.afterWrongAuth(response);
        }
    }
}


