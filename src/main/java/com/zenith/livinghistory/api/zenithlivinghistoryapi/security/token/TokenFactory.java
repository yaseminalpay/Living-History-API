package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token;

public interface TokenFactory {
    AuthenticationToken generateToken(Long userId, String fullname);
}
