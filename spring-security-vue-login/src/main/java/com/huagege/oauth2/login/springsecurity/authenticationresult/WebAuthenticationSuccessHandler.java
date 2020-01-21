package com.huagege.oauth2.login.springsecurity.authenticationresult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.huagege.oauth2.login.utils.UserResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName WebAuthenticationSuccessHandler
 * @Author zzrdark
 * @Date 2020-01-17 18:53
 * @Description TODO
 **/
@Component
public class WebAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private ObjectMapper objectMapper;




    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        logger.info("登录成功");

        if ("json".equals("json")) {
            response.setContentType("application/json;charset=UTF-8");
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "*");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers",
                    "Origin, X-Requested-With, Content-Type, Accept, Connection, User-Agent, Cookie");
            response.setHeader("Access-Control-Allow-Credentials", "true");
            response.setHeader("Content-type", "application/json");
            response.setHeader("Cache-Control", "no-cache, must-revalidate");
            UserResult userResult = new UserResult();
            userResult.setAuthentication(authentication);
            userResult.setCode(0);
            userResult.setData("");

            response.getWriter().write(objectMapper.writeValueAsString(userResult));
            response.flushBuffer();
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
}
