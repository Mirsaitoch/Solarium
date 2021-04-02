package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

public class Info_ {

    @SerializedName("id")
    public Integer id;
    @SerializedName("firstname")
    public String firstname;
    @SerializedName("middlename")
    public String middlename;
    @SerializedName("lastname")
    public String lastname;
    @SerializedName("birthdate")
    public Object birthdate;
    @SerializedName("avatar")
    public Object avatar;
    @SerializedName("medical_policy")
    public String medicalPolicy;

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
}
