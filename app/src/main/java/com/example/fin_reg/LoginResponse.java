package com.example.fin_reg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("username")
    private String username;


    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("role_id")
    @Expose
    private String role_id;






    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }





    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }





    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }




    public String getRole() {
        return role_id;
    }

    public void setRole(String role_id) {
        this.role_id = role_id;
    }



}
