package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

public class SchoolClass {

    @SerializedName("id")
    public Integer id;
    @SerializedName("group")
    public Integer group;
    @SerializedName("subgroup")
    public Integer subgroup;
    @SerializedName("class_teacher_id")
    public Integer classTeacherId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public Integer getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }

    public Integer getClassTeacherId() {
        return classTeacherId;
    }

    public void setClassTeacherId(Integer classTeacherId) {
        this.classTeacherId = classTeacherId;
    }
}
