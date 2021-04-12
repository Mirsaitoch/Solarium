package com.example.fin_reg.ModelResponse.MiniInfoStudent;
import com.google.gson.annotations.SerializedName;


public class MiniDataResponse{

    @SerializedName("user")
    private MiniUserResponse user;

    public MiniUserResponse getUser() {
        return user;
    }

    public void setUser(MiniUserResponse user) {
        this.user = user;
    }

}