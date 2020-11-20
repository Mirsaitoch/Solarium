package com.example.fin_reg.Student_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

import com.example.fin_reg.R;
import com.example.fin_reg.Teacher_java.TeacherMainActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class StudentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        NavController navController = Navigation.findNavController(StudentMainActivity.this, R.id.nav_host_fragment2);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }
}
