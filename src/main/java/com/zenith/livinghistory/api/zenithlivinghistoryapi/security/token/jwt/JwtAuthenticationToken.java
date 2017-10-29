package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.AuthenticationToken;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationToken implements AuthenticationToken {

    @JsonProperty("id")
    private Long userId;

    @JsonProperty("name")
    private String fullName;

    @JsonProperty("iat")
    private Long issuedAt;

    @JsonProperty("exp")
    private Long expiresAt;

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public DateTime getIssuedAt() {
        return new DateTime(issuedAt, DateTimeZone.UTC);
    }

    @Override
    public DateTime getExpiresAt() {
        return new DateTime(expiresAt, DateTimeZone.UTC);
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIssuedAt(DateTime issuedAt) {
        this.issuedAt = issuedAt.getMillis() / 1000;
    }

    public void setExpiresAt(DateTime expiresAt) {
        this.expiresAt = expiresAt.getMillis() / 1000;
    }
}
