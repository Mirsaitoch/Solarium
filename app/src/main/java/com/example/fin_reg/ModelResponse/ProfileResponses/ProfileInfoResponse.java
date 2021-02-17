package com.example.fin_reg.ModelResponse.ProfileResponses;

import com.google.gson.annotations.SerializedName;

public class ProfileInfoResponse {

    @SerializedName("id")
    private String id;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("middlename")
    private String middlename;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("birthdate")
    private String birthdate;

    @SerializedName("medical_policy")
    private String medical_policy;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getMedical_policy() {
        return medical_policy;
    }

    public void setMedical_policy(String medical_policy) {
        this.medical_policy = medical_policy;
    }
}
