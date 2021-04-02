package com.example.fin_reg.ModelResponse.ListTeacherGroupResponse;

import com.google.gson.annotations.SerializedName;

public class ClassTeacher {

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
    public Object schoolClassId;
    @SerializedName("created_at")
    public String createdAt;
    @SerializedName("updated_at")
    public String updatedAt;
    @SerializedName("info")
    public Info info;
    @SerializedName("organization")
    public Organization organization;
    @SerializedName("school_class")
    public Object schoolClass;
    @SerializedName("groups")
    public Groups groups;

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

    public Object getSchoolClassId() {
        return schoolClassId;
    }

    public void setSchoolClassId(Object schoolClassId) {
        this.schoolClassId = schoolClassId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Object getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(Object schoolClass) {
        this.schoolClass = schoolClass;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }
}
