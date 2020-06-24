package com.devirek.blogapp.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

public class JWTAuthenticationFilter extends OncePerRequestFilter {

    private JWTDataProvider jwtDataProvider;

    public JWTAuthenticationFilter() {
        Optional.ofNullable(jwtDataProvider)
                .orElse(this.jwtDataProvider = new JWTDataProvider());
    }

    @Autowired
    public JWTAuthenticationFilter(JWTDataProvider jwtDataProvider) {
        this.jwtDataProvider = jwtDataProvider;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
    }
}
