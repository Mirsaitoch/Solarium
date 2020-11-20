package com.example.fin_reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import com.example.fin_reg.Student_java.StudentMainActivity;
import com.example.fin_reg.Teacher_java.TeacherMainActivity;


import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {
    EditText fullName, email, password, phone;
    Button registerBtn, goToLogin;
    boolean valid = true;

    CheckBox isTeacherBox, isStudentBox;
    String url = "http://192.168.43.250:8000";
    String userCreateUrl = "/api/user";
    String url_ = url + userCreateUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        fullName = findViewById(R.id.registerName);
        email = findViewById(R.id.registerEmail);
        password = findViewById(R.id.registerPassword);
//        phone = findViewById(R.id.registerPhone);
        registerBtn = findViewById(R.id.registerBtn);
        goToLogin = findViewById(R.id.gotoLogin);
        isStudentBox = findViewById(R.id.isStudent);
        isTeacherBox = findViewById(R.id.isTeacher);

        isStudentBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    isTeacherBox.setChecked(false);
                }
            }
        });


        isTeacherBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (compoundButton.isChecked()) {
                    isStudentBox.setChecked(false);
                }
            }
        });


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkField(fullName);
                checkField(email);
                checkField(password);
//                checkField(phone);


                if (!(isTeacherBox.isChecked() || isStudentBox.isChecked())) {
                    return;

                }

                if (valid) {

                    RequestQueue requestQueue = Volley.newRequestQueue(Register.this);

                    StringRequest postRequest = new StringRequest(Request.Method.POST, url_,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // response
                                    Log.d("Response", response);
                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                                }
                            }
                    ) {
                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("username", fullName.getText().toString());
                            params.put("email", email.getText().toString());
                            params.put("password", password.getText().toString());


                            if(isTeacherBox.isChecked()){
                                params.put("role", "2");

                            }
                            if(isStudentBox.isChecked()){
                                params.put("role", "1");

                            }

                            if (isTeacherBox.isChecked()) {
                                //исправить
                                startActivity(new Intent(getApplicationContext(), TeacherMainActivity.class));
                                finish();

                            }

                            if (isStudentBox.isChecked()) {
                                startActivity(new Intent(getApplicationContext(), StudentMainActivity.class));
                                finish();
                            }
                            return params;
                        }
                    };
                    requestQueue.add(postRequest);
                    //startActivity(new Intent(getApplicationContext(), TeacherMainActivity.class));
                    finish();

                }


            }
        });

        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Login.class));
            }
        });
    }

    public boolean checkField(EditText textField) {
        if (textField.getText().toString().isEmpty()) {
            textField.setError("Error");
            valid = false;
        } else {
            valid = true;
        }

        return valid;
    }
}

//if(isTeacherBox.isChecked()){
//        startActivity(new Intent(getApplicationContext(), Admin.class));
//        finish();
//
//        }
//
//if(isStudentBox.isChecked()) {
//
//        finish();
//        }