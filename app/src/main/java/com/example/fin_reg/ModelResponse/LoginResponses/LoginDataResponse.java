package com.example.fin_reg.ModelResponse.LoginResponses;

import com.google.gson.annotations.SerializedName;

public class LoginDataResponse {
    @SerializedName("data")
    private LoginResponse data;

    public LoginResponse getData() {

        return data;
    }
    public void setData(LoginResponse data) {
        this.data = data;
    }

}
