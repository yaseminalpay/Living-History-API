package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token;

import org.joda.time.DateTime;

import java.io.Serializable;

public interface AuthenticationToken extends Serializable {

    Long getUserId();

    String getFullName();

    DateTime getIssuedAt();

    DateTime getExpiresAt();
}
