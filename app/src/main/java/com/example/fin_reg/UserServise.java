package com.example.fin_reg;

import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.ListUseResponse;
import com.example.fin_reg.ModelResponse.LoginResponses.LoginDataResponse;
import com.example.fin_reg.ModelResponse.LoginResponses.LoginRequest;
import com.example.fin_reg.ModelResponse.ProfileResponses.ProfileDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserServise {

    @POST("api/login")
    Call<LoginDataResponse> userLogin(@Body LoginRequest loginRequest);


    @GET("URL/9696")
    Call<ListUseResponse> list_of_users();

    @GET("api/user/get")
    Call<ProfileDataResponse> profileData(@Header("Authorization") String token);



}
