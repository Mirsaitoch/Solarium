package com.example.fin_reg.ModelResponse.ProfileResponses;

import com.google.gson.annotations.SerializedName;

public class ProfileOrganizationResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("namespace")
    private String namespace;

    @SerializedName("name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
