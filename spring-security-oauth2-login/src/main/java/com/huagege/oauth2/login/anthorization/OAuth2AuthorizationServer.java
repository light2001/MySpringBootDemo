package com.huagege.oauth2.login.anthorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    // 用户认证
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() // <1>
                // <2> begin ...
                .withClient("clientapp").secret("112233") // Client 账号、密码。
                //只有在authorization_code模式下需要
//                .redirectUris("http://localhost:9001/callback") // 配置回调地址，选填。
                .authorizedGrantTypes("authorization_code","password") // 授权码模式
                .scopes("read_userinfo", "read_contacts") // 可授权的 Scope
                // <2> end ...
//                .and().withClient() // 可以继续配置新的 Client // <3>
                ;
    }

}