package com.example.fin_reg.ModelResponse.LoginResponses;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("user")
    private UserDataLoginResponse userProfile;
    @SerializedName("token")
    private String token;

    public UserDataLoginResponse getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserDataLoginResponse userProfile) {
        this.userProfile = userProfile;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}


