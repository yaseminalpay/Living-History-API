package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("livinghistory.auth")
public class AuthenticationConfiguration {

    private String secret;
    private String scheme;
    private int accessTokenLifetime = 1800;  // in seconds

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public int getAccessTokenLifetime() {
        return accessTokenLifetime;
    }

    public void setAccessTokenLifetime(int accessTokenLifetime) {
        this.accessTokenLifetime = accessTokenLifetime;
    }
}
