package com.example.fin_reg.ModelResponse.MiniInfoStudent;

import com.google.gson.annotations.SerializedName;

public class MiniUserResponse {

    @SerializedName("id")

    private Integer id;
    @SerializedName("username")
    private String username;
    @SerializedName("organization_id")
    private Integer organizationId;
    @SerializedName("role")
    private Object role;
    @SerializedName("group_id")
    private Integer groupId;
    @SerializedName("school_class_id")
    private Integer schoolClassId;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("info")
    private MiniInfoResponse info;
    @SerializedName("organization")
    private MiniOrganizationResponse organization;
    @SerializedName("school_class")
    private MiniSchoolClassResponse schoolClass;
    @SerializedName("groups")
    private MiniSchoolClassResponse groups;
    @SerializedName("guarded_class")
    private Object guardedClass;

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

    public MiniInfoResponse getInfo() {
        return info;
    }

    public void setInfo(MiniInfoResponse info) {
        this.info = info;
    }

    public MiniOrganizationResponse getOrganization() {
        return organization;
    }

    public void setOrganization(MiniOrganizationResponse organization) {
        this.organization = organization;
    }

    public MiniSchoolClassResponse getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(MiniSchoolClassResponse schoolClass) {
        this.schoolClass = schoolClass;
    }

    public MiniSchoolClassResponse getGroups() {
        return groups;
    }

    public void setGroups(MiniSchoolClassResponse groups) {
        this.groups = groups;
    }

    public Object getGuardedClass() {
        return guardedClass;
    }

    public void setGuardedClass(Object guardedClass) {
        this.guardedClass = guardedClass;
    }
}
