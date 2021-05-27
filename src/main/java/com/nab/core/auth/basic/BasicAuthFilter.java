package com.nab.core.auth.basic;


import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Order(2)
public class BasicAuthFilter implements Filter {

    private final BasicAuthService basicAuthService;

    public BasicAuthFilter(
            BasicAuthService basicAuthService
    ) {
        this.basicAuthService = basicAuthService;
    }
    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        this.basicAuthService.setAuthenticatedUser(req);
        chain.doFilter(request, response);
    }
}
