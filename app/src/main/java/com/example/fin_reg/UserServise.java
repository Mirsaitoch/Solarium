package com.example.fin_reg;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserServise {

    @POST("login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest );
}
