package com.amit.bookapi.filter;

import com.amit.bookapi.services.BasicAuthService;
import com.amit.bookapi.util.NotAuthorizedUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;


@Component
public class BasicAuthFilter implements Filter {

    public static final String AUTHENTICATION_HEADER = "Authorization";

    /**
     * @param request from the filtered url
     * @param response after filtered url
     * @param chain
     * @throws IOException
     * @throws ServletException
     */

    @Autowired
    NotAuthorizedUtil notAuthorizedUtil;

    @Autowired
    private BasicAuthService authService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            final HttpServletRequest httpServletRequest = (HttpServletRequest) request;
            final String authCredentials = httpServletRequest.getHeader(AUTHENTICATION_HEADER);
            final boolean authenticationStatus = authService.doBasicAuthentication(authCredentials);

            if (authenticationStatus) {
                chain.doFilter(request, response);
            } else {
                notAuthorizedUtil.afterWrongAuth(response);
            }
        }
    }
}

