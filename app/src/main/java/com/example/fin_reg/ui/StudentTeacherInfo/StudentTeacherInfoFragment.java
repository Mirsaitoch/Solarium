package com.example.fin_reg.ui.StudentTeacherInfo;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fin_reg.ApiClient;
import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.Student;
import com.example.fin_reg.ModelResponse.MiniInfoStudent.MiniProfileStudentDataResponse;
import com.example.fin_reg.R;
import com.example.fin_reg.UserAdapter;
import com.example.fin_reg.apputil.AppConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudentTeacherInfoFragment extends Fragment {
    private StudentTeacherInfoViewModel studentTeacherInfoViewModel;
    UserAdapter userAdapter;
    private AppConfig appConfig;
    Context this_context;
    List<Student> students;
    private String token_str;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        studentTeacherInfoViewModel =
                ViewModelProviders.of(this).get(StudentTeacherInfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_student_mini_info, container, false);
        this_context = container.getContext();
        appConfig = new AppConfig(this_context);
        token_str = appConfig.getToken();
        String token = "Bearer " + token_str;
        Bundle bundle = this.getArguments();
        int id = bundle.getInt("key_id");
        String str_id = Integer.toString(id);
        appConfig = new AppConfig(this_context);
        String token_str = appConfig.getToken();

        TextView name_middle_text_view = (TextView) root.findViewById(R.id.u_name_middle);
        TextView surname_text_view = (TextView) root.findViewById(R.id.u_surname);

        Call<MiniProfileStudentDataResponse> miniProfileStudentDataResponseCall = ApiClient.getUserService().miniInfoStudent(token, id);
        miniProfileStudentDataResponseCall.enqueue(new Callback<MiniProfileStudentDataResponse>() {
            @Override
            public void onResponse(Call<MiniProfileStudentDataResponse> call, Response<MiniProfileStudentDataResponse> response) {
                String username = response.body().getData().getUser().getInfo().getFirstname();
                String surname = response.body().getData().getUser().getInfo().getLastname();
                String middle_name = response.body().getData().getUser().getInfo().getMiddlename();
                String nameAndMiddle = username + " " + middle_name;

                surname_text_view.setText(surname);
                name_middle_text_view.setText(nameAndMiddle);
            }

            @Override
            public void onFailure(Call<MiniProfileStudentDataResponse> call, Throwable t) {
                Toast.makeText(this_context, "Connection error", Toast.LENGTH_SHORT).show();

            }
        });

        return root;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        textView = view.findViewById(R.id.text_note);


    }

}