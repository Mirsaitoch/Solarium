package com.example.fin_reg.ModelResponse.MiniInfoStudent;

import com.google.gson.annotations.SerializedName;

public class MiniInfoResponse {

    @SerializedName("id")
    private Integer id;
    @SerializedName("firstname")
    private String firstname;
    @SerializedName("middlename")
    private String middlename;
    @SerializedName("lastname")
    private String lastname;
    @SerializedName("birthdate")
    private Object birthdate;
    @SerializedName("avatar")
    private Object avatar;
    @SerializedName("medical_policy")
    private String medicalPolicy;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Object getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Object birthdate) {
        this.birthdate = birthdate;
    }

    public Object getAvatar() {
        return avatar;
    }

    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    public String getMedicalPolicy() {
        return medicalPolicy;
    }

    public void setMedicalPolicy(String medicalPolicy) {
        this.medicalPolicy = medicalPolicy;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
