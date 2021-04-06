package com.example.fin_reg.ui.StudentTeacherInfo;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.Student;
import com.example.fin_reg.R;
import com.example.fin_reg.UserAdapter;
import com.example.fin_reg.apputil.AppConfig;

import java.util.List;


public class StudentTeacherInfoFragment extends Fragment {
    private  StudentTeacherInfoViewModel studentTeacherInfoViewModel;
    UserAdapter userAdapter;
    private AppConfig appConfig;
    Context this_context;
    List<Student> students;
    private String token_str;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studentTeacherInfoViewModel =
                ViewModelProviders.of(this).get(StudentTeacherInfoViewModel.class);
        View root =  inflater.inflate(R.layout.fragment_student_mini_info, container, false);
        this_context = container.getContext();
        appConfig = new AppConfig(this_context);
        token_str = appConfig.getToken();
        Bundle bundle = this.getArguments();
        int id = bundle.getInt("key_id");
        String str_id =  Integer. toString(id);
        Log.e("id = ", str_id);
        Toast.makeText(this_context, str_id, Toast.LENGTH_SHORT).show();

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



//        textView = view.findViewById(R.id.text_note);


    }

}