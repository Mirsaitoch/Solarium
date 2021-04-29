package com.example.fin_reg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.fin_reg.ModelResponse.LoginResponses.LoginDataResponse;
import com.example.fin_reg.ModelResponse.LoginResponses.LoginRequest;
import com.example.fin_reg.apputil.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText login, password;
    TextView text_wrong;
    Button loginBtn, gotoRegister;
    //    private boolean isUserLogin = true;
    private AppConfig appConfig;
    private ConstraintLayout constr;
    private ProgressBar pr;
    private RelativeLayout finr_relat;
    private RelativeLayout relate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        finr_relat = findViewById(R.id.relart_fin);
//        pr = findViewById(R.id.pr);
//        relate = findViewById(R.id.relate);
        login = findViewById(R.id.loginLogin);
        constr = findViewById(R.id.constr_s);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        text_wrong = findViewById(R.id.wrong_pass);
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
            }
        }
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mLogin = login.getText().toString().trim();
                String mPass = password.getText().toString().trim();
                try {
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    // TODO: handle exception
                }
                if (!mLogin.isEmpty() || !mPass.isEmpty()) {
                    Login(mLogin, mPass);
                } else {
                    Toast.makeText(getApplicationContext(), "Заполните все данные!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    public void Login(final String mEmail, final String mPass) {

        finr_relat.setVisibility(View.VISIBLE);
        constr.setVisibility(View.GONE);


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
                            if (loginResponse.getData().getUserProfile().getGroupsUserResponse().getName().equals("teacher")) {
                                Log.e("Role", "teacher");
                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken().toString());
                                appConfig.savePost("Teacher");
                                text_wrong.setVisibility(View.GONE);

                                startActivity(new Intent(Login.this, TeacherMainActivity.class));
                                finish();

                            }

//                           STUDENT
                            if (loginResponse.getData().getUserProfile().getGroupsUserResponse().getName().equals("student")) {
                                Log.e("Role", "student");
                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken());
                                appConfig.savePost("Student");
                                text_wrong.setVisibility(View.GONE);
                                startActivity(new Intent(Login.this, StudentMainActivity.class));
                                finish();
                            }


//                            ADMIN
                            if (loginResponse.getData().getUserProfile().getGroupsUserResponse().getName().equals("admin")) {
                                Log.e("Role", "admin");

                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken());
                                appConfig.savePost("Admin");
                                text_wrong.setVisibility(View.GONE);

                                finish();
                            }


//                            MED
                            if (loginResponse.getData().getUserProfile().getGroupsUserResponse().getName().equals("med_stuff")) {
                                Log.e("Role", "med_stuff");

                                appConfig.updateUserLoginStatus(true);
                                appConfig.saveName(response.body().getData().getUserProfile().getUsername());
                                appConfig.saveToken(response.body().getData().getToken());
                                appConfig.savePost("Med");
                                text_wrong.setVisibility(View.GONE);
                                finish();
                            }

                        }
                    }, 1000);

                } else {
                    Toast.makeText(Login.this, "Неправильный логин или пароль!", Toast.LENGTH_SHORT).show();
                    text_wrong.setVisibility(View.VISIBLE);
                    finr_relat.setVisibility(View.GONE);
                    constr.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<LoginDataResponse> call, Throwable t) {
                text_wrong.setText("Ошибка подключения к серверу! Напишите разработчикам");
                text_wrong.setVisibility(View.VISIBLE);
                Toast.makeText(Login.this, "Ошибка подключения к серверу! Напишите разработчикам", Toast.LENGTH_SHORT).show();
                finr_relat.setVisibility(View.GONE);
                constr.setVisibility(View.VISIBLE);
                Log.e("Error", t.getLocalizedMessage());
            }
        });

    }
}



