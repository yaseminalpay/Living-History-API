package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.jwt;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.configuration.AuthenticationConfiguration;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.AuthenticationToken;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.TokenFactory;
import org.joda.time.DateTime;

public class JwtTokenFactory implements TokenFactory {
    private AuthenticationConfiguration configuration;

    public JwtTokenFactory(AuthenticationConfiguration configuration) {
        this.configuration = configuration;
    }

    @Override
    public AuthenticationToken generateToken(Long userId, String fullname) {
        DateTime currentTime = DateTime.now();
        JwtAuthenticationToken token = new JwtAuthenticationToken();
        token.setUserId(userId);
        token.setFullName(fullname);
        token.setIssuedAt(currentTime);
        token.setExpiresAt(currentTime.plusSeconds(configuration.getAccessTokenLifetime()));
        return token;
    }
}
