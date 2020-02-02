package com.wllnb.wllblog.auth;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * OAuth2Token
 *
 * @author wllnb
 * @description Shiro 认证类
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token){
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
