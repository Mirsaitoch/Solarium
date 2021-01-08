package com.example.fin_reg;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("username")
    private String username;


    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("role")
    @Expose
    private String role;






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







    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }




    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



}
