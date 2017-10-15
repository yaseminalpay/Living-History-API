package com.zenith.livinghistory.api.zenithlivinghistoryapi.security.codec;

import com.zenith.livinghistory.api.zenithlivinghistoryapi.security.token.AuthenticationToken;

import java.util.Optional;

public interface TokenCodec<T extends AuthenticationToken> {
    Optional<T> decode(String tokenString);

    String encode(T token);
}
