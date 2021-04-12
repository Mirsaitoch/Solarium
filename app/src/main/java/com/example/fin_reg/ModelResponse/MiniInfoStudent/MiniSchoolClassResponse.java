package com.example.fin_reg.ModelResponse.MiniInfoStudent;

import com.google.gson.annotations.SerializedName;

public class MiniSchoolClassResponse {

    @SerializedName("id")
    private Integer id;
    @SerializedName("group")
    private Integer group;
    @SerializedName("subgroup")
    private Integer subgroup;
    @SerializedName("class_teacher_id")
    private Integer classTeacherId;

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
