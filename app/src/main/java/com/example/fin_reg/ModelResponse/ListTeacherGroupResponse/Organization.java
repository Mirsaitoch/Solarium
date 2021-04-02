package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

public class Organization {
    @SerializedName("id")
    public Integer id;
    @SerializedName("namespace")
    public String namespace;
    @SerializedName("name")
    public String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
