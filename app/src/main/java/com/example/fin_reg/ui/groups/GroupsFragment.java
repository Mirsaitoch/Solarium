package com.example.fin_reg.ui.groups;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.ApiClient;
import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.DataListResponse;
import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.Student;
import com.example.fin_reg.R;
import com.example.fin_reg.UserAdapter;
import com.example.fin_reg.apputil.AppConfig;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupsFragment extends Fragment {
    private GroupsViewModel groupsViewModel;

    UserAdapter userAdapter;
    private AppConfig appConfig;
    TextView textView;
    RecyclerView recyclerView;
    Context this_context;

    List<Student> studentList;
    private String token_str;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groupsViewModel =
                ViewModelProviders.of(this).get(GroupsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_groups, container, false);

        this_context = container.getContext();

        appConfig = new AppConfig(this_context);
        token_str = appConfig.getToken();
        Log.e("token", token_str);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        String token = "Bearer " + token_str;


        Call<DataListResponse> call = ApiClient.getUserService().list_of_users(token);

        call.enqueue(new Callback<DataListResponse>() {
            @Override
            public void onResponse(Call<DataListResponse> call, Response<DataListResponse> response) {
                if (response.isSuccessful()) {

                    studentList = response.body().getTeacherinfo().students;
                    recyclerView.setAdapter(new UserAdapter(getActivity(), studentList));

                } else {

//                    Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<DataListResponse> call, Throwable t) {
//                Toast.makeText(getActivity(), "ERRRRRRR" + t.getMessage() , Toast.LENGTH_SHORT).show();

            }
        });


    }

}
