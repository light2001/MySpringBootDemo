package com.myspring.cli.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * AuthenticationEntryPoint 用来解决匿名用户访问无权限资源时的异常
 * AccessDeineHandler 用来解决认证过的用户访问无权限资源时的异常
 * */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    //当出错的时候 发送 Unauthorized
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException authException) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
//        Result genFailResult = ResultGenerator.genFailResult(401, "无效的token,或者无权访问"+request.getHeader("Authorization"));
//        response.getWriter().write(new ObjectMapper().writeValueAsString(genFailResult));

         response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "无效的token,或者无权访问");
    }
}
