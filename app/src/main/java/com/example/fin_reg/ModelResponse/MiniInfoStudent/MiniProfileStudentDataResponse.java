package com.example.fin_reg.ModelResponse.MiniInfoStudent;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MiniProfileStudentDataResponse {

    @SerializedName("data")
    @Expose
    private MiniDataResponse data;

    public MiniDataResponse getData() {
        return data;
    }

    public void setData(MiniDataResponse data) {
        this.data = data;
    }

}