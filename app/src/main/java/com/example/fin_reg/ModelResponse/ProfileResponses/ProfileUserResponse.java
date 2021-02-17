package com.example.fin_reg.ModelResponse.ProfileResponses;

import com.google.gson.annotations.SerializedName;

public class ProfileUserResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String username;



    @SerializedName("role")
    private String role_id;

    @SerializedName("group_id")
    private String group_id;



    @SerializedName("info")
    private ProfileInfoResponse user_info;

    @SerializedName("organization")
    private ProfileOrganizationResponse user_organization;

    @SerializedName("school_class")
    private ProfileClassInfo classInfo;


    public ProfileClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ProfileClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }


    public ProfileOrganizationResponse getUser_organization() {
        return user_organization;
    }

    public void setUser_organization(ProfileOrganizationResponse user_organization) {
        this.user_organization = user_organization;
    }


    public ProfileInfoResponse getUser_info() {
        return user_info;
    }

    public void setUser_info(ProfileInfoResponse user_info) {
        this.user_info = user_info;
    }

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


    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }
}
