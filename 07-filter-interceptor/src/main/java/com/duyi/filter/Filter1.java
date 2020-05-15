package com.duyi.filter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 使用FilterRegistrationBean注册Filter
 */
public class Filter1 extends HttpFilter {
   /* @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        long long1 = System.currentTimeMillis();
        System.out.println("filter1----------------------" + long1);
        chain.doFilter(request, response);
    }*/
}
