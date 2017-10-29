package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.jwt;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.configuration.AuthenticationConfiguration;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.AuthenticationToken;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.TokenFactory;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

/**
 * Factory generates JWT.
 */
@Component
public class JwtTokenFactory implements TokenFactory {


    //region Private Members

    private AuthenticationConfiguration configuration;

    //endregion

    //region Constructor

    /**
     * Constructor.
     * @param configuration - Configuration.
     */
    public JwtTokenFactory(AuthenticationConfiguration configuration) {
        this.configuration = configuration;
    }

    //endregion

    //region Public Methods

    /**
     * Generates JWT token.
     * @param userId - User Identifier.
     * @param fullname - User Name.
     * @return token - JWT.
     */
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
    //endregion

}
