package com.huagege.login.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName CrossFilter
 * @Author zzrdark
 * @Date 2020-01-17 19:22
 * @Description TODO
 **/
public class CrossFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
//        logger.debug("跨域请求进来了。。。");
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        httpServletRequest.getSession();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Headers",
                "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Content-type", "application/json");
        httpResponse.setHeader("Cache-Control", "no-cache, must-revalidate");
        filterChain.doFilter(request, httpResponse);
    }

    @Override
    public void destroy() {

    }
}
