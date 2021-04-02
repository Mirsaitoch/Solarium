package com.example.fin_reg.ModelResponse.LoginResponses;

import com.google.gson.annotations.SerializedName;

public class GroupsUserResponse {
    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("organization_id")
    private String organization_id;

    @SerializedName("human_name")
    private String human_name;

    @SerializedName("permissions")
    private String permissions;

    @SerializedName("description")
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrganization_id() {
        return organization_id;
    }

    public void setOrganization_id(String organization_id) {
        this.organization_id = organization_id;
    }

    public String getHuman_name() {
        return human_name;
    }

    public void setHuman_name(String human_name) {
        this.human_name = human_name;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
