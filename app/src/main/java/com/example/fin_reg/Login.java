package com.example.fin_reg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fin_reg.ModelResponse.LoginResponses.LoginDataResponse;
import com.example.fin_reg.ModelResponse.LoginResponses.LoginRequest;
import com.example.fin_reg.apputil.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText login, password;
    Button loginBtn, gotoRegister;
    //    private boolean isUserLogin = true;
    private AppConfig appConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.loginLogin);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        appConfig = new AppConfig(this);
        if (appConfig.isUserLogin()) {
            String name = appConfig.getName();
            String token = appConfig.getToken();
            String post = appConfig.getPost();
            if (post.equals("Student")) {
                startActivity(new Intent(Login.this, StudentMainActivity.class));
                finish();

            }
            if (post.equals("Teacher")) {
                startActivity(new Intent(Login.this, TeacherMainActivity.class));
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "ахахаххааххах", Toast.LENGTH_LONG).show();

            }
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mLogin = login.getText().toString().trim();
                String mPass = password.getText().toString().trim();
                if (!mLogin.isEmpty() || !mPass.isEmpty()) {
                    Login(mLogin, mPass);
                } else {
                    Toast.makeText(getApplicationContext(), "Заполните все данные!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void Login(final String mEmail, final String mPass) {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setLogin(mEmail);
        loginRequest.setPassword(mPass);

        Call<LoginDataResponse> loginDataCall = ApiClient.getUserService().userLogin(loginRequest);


        loginDataCall.enqueue(new Callback<LoginDataResponse>() {
            @Override
            public void onResponse(Call<LoginDataResponse> call, Response<LoginDataResponse> response) {
                if (response.isSuccessful()) {
                    LoginDataResponse loginResponse = response.body();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {


//                            TEACHER
                           if (loginResponse.getData().getUserProfile().getGroup_id().equals("1")) {

                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken().toString());
                                appConfig.savePost("Teacher");
                                startActivity(new Intent(Login.this, TeacherMainActivity.class));
                                finish();

                            }

//                           STUDENT
                            if (loginResponse.getData().getUserProfile().getGroup_id().equals("2")) {
                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken());
                                appConfig.savePost("Student");
                                startActivity(new Intent(Login.this, StudentMainActivity.class));
                                finish();
                            }


//                            ADMIN
                            if (loginResponse.getData().getUserProfile().getGroup_id().equals("3")) {
                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken());
                                appConfig.savePost("Admin");
                                finish();
                            }


//                            MED
                            if (loginResponse.getData().getUserProfile().getGroup_id().equals("4")) {
                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken());
                                appConfig.savePost("Med");
                                finish();
                            }





                            else {
                                Toast.makeText(Login.this, "??????????" + loginResponse.getData().getUserProfile().getGroup_id(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 700);

                } else {
                    Toast.makeText(Login.this, "Неправильный логин или пароль!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginDataResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Throwable " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Error", t.getLocalizedMessage());
            }
        });

    }
}



