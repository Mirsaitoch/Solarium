package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

public class DataListResponse {
    @SerializedName("data")
    private TeacherList teacherinfo;

    public TeacherList getTeacherinfo() {
        return teacherinfo;
    }

    public void setTeacherinfo(TeacherList teacherinfo) {
        this.teacherinfo = teacherinfo;
    }
}
