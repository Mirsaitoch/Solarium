package com.example.fin_reg.ModelResponse.ProfileResponses;

import com.google.gson.annotations.SerializedName;

public class ProfileDataUserResponse {
    @SerializedName("user")
    private ProfileUserResponse userResponse;

    public ProfileUserResponse getUserResponse() {
        return userResponse;
    }

    public void setUserResponse(ProfileUserResponse userResponse) {
        this.userResponse = userResponse;
    }
}
