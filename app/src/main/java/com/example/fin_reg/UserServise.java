package com.example.fin_reg;

import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.DataListResponse;
import com.example.fin_reg.ModelResponse.LoginResponses.LoginDataResponse;
import com.example.fin_reg.ModelResponse.LoginResponses.LoginRequest;
import com.example.fin_reg.ModelResponse.MiniInfoStudent.MiniProfileStudentDataResponse;
import com.example.fin_reg.ModelResponse.ProfileResponses.ProfileDataResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface UserServise {

    @POST("api/login")
    Call<LoginDataResponse> userLogin(@Body LoginRequest loginRequest);

    @GET("api/school_class/get")
    Call<DataListResponse> list_of_users(@Header("Authorization") String token);

    @GET("api/user/get")
    Call<ProfileDataResponse> profileData(@Header("Authorization") String token);

    @GET("api/user/get")
    Call<MiniProfileStudentDataResponse> miniInfoStudent(@Header("Authorization") String token, @Query("user_id") int str_id);


}
