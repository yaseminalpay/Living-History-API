package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.codec.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.codec.TokenCodec;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.configuration.AuthenticationConfiguration;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.jwt.JwtAuthenticationToken;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Optional;

@Component
public class JwtTokenCodec implements TokenCodec<JwtAuthenticationToken> {


    //region Private Members

    private AuthenticationConfiguration configuration;
    private static final ObjectMapper defaultMapper;
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final String EXCEPTION_MESSAGE_INVALID_TOKEN_SCHEME = "Invalid token scheme";
    private static final String EXCEPTION_MESSAGE_INVALID_TOKEN_FORMAT = "Invalid token format";
    private static final SignatureAlgorithm DEFAULT_ALGORITHM = SignatureAlgorithm.HS256;

    //endregion


    static {
        defaultMapper = new ObjectMapper();
    }


    //region Constructor

    /**
     * Constructor.
     * @param configuration - Configuration.
     */
    @Autowired
    public JwtTokenCodec(AuthenticationConfiguration configuration) {

        this.configuration = configuration;
    }

    //endregion


    //region Private Methods

    /**
     * Parses token body.
     * @param authenticationTokenString - Token.
     * @return
     */
    private JwtAuthenticationToken parseTokenBody(String authenticationTokenString) {

        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey(configuration.getSecret().getBytes(UTF8))
                    .parseClaimsJws(authenticationTokenString);

            return convertClaimsToToken(claims.getBody());

        } catch (Exception ex) {

            throw ex;
        }
    }

    /**
     * Converts claims to token.
     * @param claims - Claims.
     * @return
     */
    private JwtAuthenticationToken convertClaimsToToken(Claims claims) {

        if (claims == null) {
            throw new RuntimeException(EXCEPTION_MESSAGE_INVALID_TOKEN_FORMAT);
        }

        return defaultMapper.convertValue(claims, JwtAuthenticationToken.class);
    }

    /**
     * Converts token to claims.
     * @param token - Token.
     * @return
     */
    private Claims convertTokenToClaims(JwtAuthenticationToken token) {

        @SuppressWarnings("unchecked")
        Map<String, Object> map = defaultMapper.convertValue(token, Map.class);
        Claims claims = Jwts.claims();
        claims.putAll(map);

        return claims;
    }
    //endregion



    //region Public Methods

    /**
     * Decodes token.
     * @param tokenString - Token.
     * @return
     */
    @Override
    public Optional<JwtAuthenticationToken> decode(String tokenString) {

        if (tokenString == null ||  tokenString.isEmpty()) {
            return Optional.empty();
        }

        String expectedPrefix = configuration.getScheme();

        if (!tokenString.startsWith(expectedPrefix)) {
            throw new RuntimeException(EXCEPTION_MESSAGE_INVALID_TOKEN_SCHEME);
        }

        if (tokenString.equals(expectedPrefix)) {
            throw new RuntimeException(EXCEPTION_MESSAGE_INVALID_TOKEN_FORMAT);
        }

        final String authenticationTokenString = tokenString.substring(expectedPrefix.length() + 1);

        return Optional.ofNullable(parseTokenBody(authenticationTokenString));
    }

    /**
     * Encodes token.
     * @param token - Token.
     * @return
     */
    @Override
    public String encode(JwtAuthenticationToken token) {

        if (token == null) {
            throw new NullPointerException("Token is null.");
        }

        Claims claims = convertTokenToClaims(token);

        return Jwts.builder().setClaims(claims)
                .signWith(DEFAULT_ALGORITHM, configuration.getSecret().getBytes(UTF8))
                .compact();
    }
    //endregion
}
