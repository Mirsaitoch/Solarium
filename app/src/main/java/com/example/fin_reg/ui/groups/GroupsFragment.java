package com.example.fin_reg.ui.groups;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fin_reg.ApiClient;
import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.EachUser;
import com.example.fin_reg.ModelResponse.ListTeacherGroupResponse.ListUseResponse;
import com.example.fin_reg.R;
import com.example.fin_reg.UserAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GroupsFragment extends Fragment {
    private GroupsViewModel groupsViewModel;

    UserAdapter userAdapter;

    TextView textView;
    RecyclerView recyclerView;
    Context this_context;
    List<EachUser> eachUserList ;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        groupsViewModel =
                ViewModelProviders.of(this).get(GroupsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_groups, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true );
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Call<ListUseResponse> call = ApiClient.getUserService().list_of_users();

        call.enqueue(new Callback<ListUseResponse>() {
            @Override
            public void onResponse(Call<ListUseResponse> call, Response<ListUseResponse> response) {
                if(response.isSuccessful()){
                    eachUserList = response.body().getEachUserList();
                    recyclerView.setAdapter(new UserAdapter(getActivity(), eachUserList));


                }
                else{
                    Toast.makeText(getActivity(), "error", Toast.LENGTH_SHORT).show();
                }
                
            }

            @Override
            public void onFailure(Call<ListUseResponse> call, Throwable t) {
                Toast.makeText(getActivity(), t.getMessage() , Toast.LENGTH_SHORT).show();

            }
        });


    }

}
