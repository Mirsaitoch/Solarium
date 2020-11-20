package com.example.fin_reg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.fin_reg.Student_java.StudentMainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {
    EditText email, password;
    Button loginBtn, gotoRegister;


    CheckBox isTeacherBox, isStudentBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        email = findViewById(R.id.loginEmail);
        password = findViewById(R.id.loginPassword);
        loginBtn = findViewById(R.id.loginBtn);
        gotoRegister = findViewById(R.id.gotoRegister);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mEmail = email.getText().toString().trim();
                String mPass = password.getText().toString().trim();

                if (!mEmail.isEmpty() || !mPass.isEmpty()) {
//
                    Login(mEmail, mPass);

                } else {
                    Toast.makeText(getApplicationContext(), "Заполните данные", Toast.LENGTH_LONG).show();
                }
            }
        });

        gotoRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Register.class));
            }
        });
    }

    private void Login(final String email, final String password) {
        String url = "http://192.168.43.250:8000/api/user/login";
        StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
//                Toast.makeText(Login.this, response, Toast.LENGTH_SHORT).show();


                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONObject jsonData = jsonObject.getJSONObject("data");
                    JSONObject jsonUser = jsonData.getJSONObject("user");
                    String role = jsonUser.getString("role");
                    String token = jsonData.getString("token");
                    Toast.makeText(Login.this, role, Toast.LENGTH_SHORT).show();


                    if (role.equals("Teacher")) {
                        Intent intent = new Intent(Login.this, StudentMainActivity.class);
                        intent.putExtra("token", token);
                        startActivity(intent);
                    }
                    if (role.equals("Student")) {
                        Intent intent = new Intent(Login.this, StudentMainActivity.class);
                        intent.putExtra("token", token);
                        startActivity(intent);
                    }

                } catch (JSONException e) {

                    Toast.makeText(getApplicationContext(), "Ошибка с подключением", Toast.LENGTH_LONG).show();

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                NetworkResponse networkResponse = error.networkResponse;
                if (networkResponse != null && networkResponse.data != null) {
                    String jsonError = new String(networkResponse.data);
                    Toast.makeText(Login.this, jsonError, Toast.LENGTH_SHORT).show();}
                    Toast.makeText(Login.this, "Ошибка: " + error, Toast.LENGTH_SHORT).show();

//
//                Toast.makeText(getApplicationContext(), "Неверное имя пользователя или пароль" + error, Toast.LENGTH_LONG).show();

            }
        }) {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> map = new HashMap<>();
                map.put("email", email);
                map.put("password", password);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);
    }
}






