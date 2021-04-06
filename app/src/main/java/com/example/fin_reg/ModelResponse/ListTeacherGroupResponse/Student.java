package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

public class Student {
    public Student(Integer id, String username, Integer organizationId, Object role, Integer groupId, Integer schoolClassId, Info_ info, Organization_ organization, SchoolClass schoolClass, Groups_ groups) {
        this.id = id;
        this.username = username;
        this.organizationId = organizationId;
        this.role = role;
        this.groupId = groupId;
        this.schoolClassId = schoolClassId;
        this.info = info;
        this.organization = organization;
        this.schoolClass = schoolClass;
        this.groups = groups;
    }


    @SerializedName("id")
    public Integer id;

    @SerializedName("username")
    public String username;



    @SerializedName("organization_id")
    public Integer organizationId;

    @SerializedName("role")
    public Object role;

    @SerializedName("group_id")
    public Integer groupId;

    @SerializedName("school_class_id")
    public Integer schoolClassId;

    @SerializedName("info")
    public Info_ info;

    @SerializedName("organization")
    public Organization_ organization;

    @SerializedName("school_class")
    public SchoolClass schoolClass;

    @SerializedName("groups")
    public Groups_ groups;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Object getRole() {
        return role;
    }

    public void setRole(Object role) {
        this.role = role;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Integer schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public Info_ getInfo() {
        return info;
    }

    public void setInfo(Info_ info) {
        this.info = info;
    }

    public Organization_ getOrganization() {
        return organization;
    }

    public void setOrganization(Organization_ organization) {
        this.organization = organization;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Groups_ getGroups() {
        return groups;
    }

    public void setGroups(Groups_ groups) {
        this.groups = groups;
    }
}