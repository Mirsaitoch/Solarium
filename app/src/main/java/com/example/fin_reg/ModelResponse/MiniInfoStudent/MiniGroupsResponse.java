package com.example.fin_reg.ModelResponse.MiniInfoStudent;

import com.google.gson.annotations.SerializedName;

public class MiniGroupsResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("organization_id")
    private Integer organizationId;
    @SerializedName("human_name")
    private String humanName;
    @SerializedName("permissions")
    private Integer permissions;
    @SerializedName("description")
    private String description;
}
