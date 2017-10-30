package com.zenith.livinghistory.api.zenithlivinghistoryapi.dto.request;

public class SignInRequest {
    private String email;
    private String password1;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }
}
