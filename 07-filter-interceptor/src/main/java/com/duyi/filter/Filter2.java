package com.duyi.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class Filter2 extends HttpFilter {

    /**
     * 不需要过滤的URL
     */
    private static final Set<String> ALLOWED_PATHS = Collections
            .unmodifiableSet(new HashSet<>(
                    Arrays.asList("/main/excludefilter", "/login", "/logout", "/register")));


    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        long long1 = System.currentTimeMillis();
        System.out.println("filter2----------------------" + long1);
        String allowedPath = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean allowed = ALLOWED_PATHS.contains(allowedPath);
        if (allowed) {
            System.out.println(request.getRequestURI() + "无需过滤，通过！！！");
        } else {
            System.out.println(request.getRequestURI() + "需要过滤，重新投胎吧！！！");
        }
        chain.doFilter(request, response);
    }
}
