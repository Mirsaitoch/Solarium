package com.example.fin_reg;

public class LoginResponse {

    private String username;

    private String token;

    private String login;

    private String role_id;

    private String body;


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

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
            return "LoginResponse{" +
                    "username='" + username + '\'' +
                    ", token='" + token + '\'' +
                    ", login='" + login + '\'' +
                    ", role_id='" + role_id + '\'' +
                    ", body='" + body + '\'' +
                    '}';
    }
}
