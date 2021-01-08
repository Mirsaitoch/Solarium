package com.example.fin_reg;

        import okhttp3.OkHttpClient;
        import okhttp3.logging.HttpLoggingInterceptor;
        import retrofit2.Retrofit;
        import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient  {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();



        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://192.168.34.49:8000/api/user/")
                .client(okHttpClient )
                .build();

        return retrofit;

    }
    public static UserServise getUserService(){
        UserServise userServise = getRetrofit().create(UserServise.class);

        return userServise;


    }
}