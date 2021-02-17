package com.example.fin_reg.ModelResponse.LoginResponses;


import com.google.gson.annotations.SerializedName;

public class UserDataLoginResponse {
    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String username;

    @SerializedName("organization_id")
    private String organization_id;

    @SerializedName("role")
    private String role_id;

    @SerializedName("group_id")
    private String group_id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

}

