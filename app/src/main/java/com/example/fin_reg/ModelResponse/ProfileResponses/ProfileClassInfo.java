package com.example.fin_reg.ModelResponse.ProfileResponses;

import com.google.gson.annotations.SerializedName;

public class ProfileClassInfo {
    @SerializedName("id")
    private String id;

    @SerializedName("group")
    private String group;


    @SerializedName("subgroup")
    private String subgroup;


    @SerializedName("class_teacher_id")
    private String class_teacher_id;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public String getClass_teacher_id() {
        return class_teacher_id;
    }

    public void setClass_teacher_id(String class_teacher_id) {
        this.class_teacher_id = class_teacher_id;
    }
}
