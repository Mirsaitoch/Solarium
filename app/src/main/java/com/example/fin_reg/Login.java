package com.example.fin_reg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
    EditText login, password;
    Button loginBtn, gotoRegister;


    CheckBox isTeacherBox, isStudentBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login = findViewById(R.id.loginLogin);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);


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

//        gotoRegister.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(), Register.class));
//            }
//        });
    }



    private void Login(final String mEmail, final String mPass) {
        LoginRequest loginRequest =  new LoginRequest();
        loginRequest.setLogin(mEmail);
        loginRequest.setPassword(mPass);

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);

        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(response.isSuccessful()){


                    LoginResponse loginResponse = response.body();

                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                            String role = loginResponse.getRole();


                            if(1 ==2 ) {

                                startActivity(new Intent(Login.this, StudentMainActivity.class).putExtra("data", loginResponse.getLogin()));
                            }
                            else{
                                Toast.makeText(Login.this, "error not stud", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, 700 );

                }
                else{
                    Toast.makeText(Login.this, "Неправильный логин или пароль!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(Login.this, "Throwable "+t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }




}



