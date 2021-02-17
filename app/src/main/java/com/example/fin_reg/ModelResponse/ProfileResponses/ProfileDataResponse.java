package com.example.fin_reg.ModelResponse.ProfileResponses;

import com.google.gson.annotations.SerializedName;

public class ProfileDataResponse {
    @SerializedName("data")
    private ProfileDataUserResponse userData;

    public ProfileDataUserResponse getUserData() {
        return userData;
    }

    public void setUserData(ProfileDataUserResponse userData) {
        this.userData = userData;
    }
}
