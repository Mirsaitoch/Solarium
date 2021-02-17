package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListUseResponse {

    @SerializedName("users")
    List<EachUser> eachUserList;
    public ListUseResponse(List<EachUser> eachUserList){this.eachUserList = eachUserList;}

    public List<EachUser> getEachUserList() {
        return eachUserList;
    }

    public void setEachUserList(List<EachUser> eachUserList) {
        this.eachUserList = eachUserList;
    }
}



