package com.example.fin_reg.ui.profile_teacher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fin_reg.ApiClient;
import com.example.fin_reg.Login;
import com.example.fin_reg.ModelResponse.ProfileResponses.ProfileDataResponse;
import com.example.fin_reg.R;
import com.example.fin_reg.apputil.AppConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile_teacherFragment extends Fragment {
    private ProfileTeacherViewModel profileTeacherViewModel;
    private AppConfig appConfig;
    Context this_context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileTeacherViewModel =
                ViewModelProviders.of(this).get(ProfileTeacherViewModel.class);
        View root = inflater.inflate(R.layout.fragment_teacher_profile, container, false);
        this_context = container.getContext();


        Button button_logout = (Button) root.findViewById(R.id.Button_logout);
        TextView name_middle_text_view = (TextView) root.findViewById(R.id.u_name_middle);
        TextView surname_text_view = (TextView) root.findViewById(R.id.u_surname);
//        TextView middle_text_view = (TextView) root.findViewById(R.id.u_middle);
//        TextView post_user = (TextView) root.findViewById(R.id.u_post);

        appConfig = new AppConfig(this_context);
        String token_str = appConfig.getToken();
        String token = "Bearer " + token_str;

        Call<ProfileDataResponse> profileData = ApiClient.getUserService().profileData(token);

        profileData.enqueue(new Callback<ProfileDataResponse>() {
            @Override
            public void onResponse(Call<ProfileDataResponse> call, Response<ProfileDataResponse> response) {
                if(response.isSuccessful()){

//                    Toast.makeText(this_context, response.body().toString(), Toast.LENGTH_SHORT).show();
                    String name = response.body().getUserData().getUserResponse().getUser_info().getFirstname();
                    String surname = response.body().getUserData().getUserResponse().getUser_info().getLastname();
                    String middle_name = response.body().getUserData().getUserResponse().getUser_info().getMiddlename();
                    String school_name = response.body().getUserData().getUserResponse().getUser_organization().getName();

                    String name_middle = name + middle_name;


                    surname_text_view.setText(surname);
                    name_middle_text_view.setText(name);
//                    middle_text_view.setText(middle_name);

                }
                else{

                }
            }

            @Override
            public void onFailure(Call<ProfileDataResponse> call, Throwable t) {

            }
        });






        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appConfig.logout();
                startActivity(new Intent(this_context, Login.class));
                getActivity().finish();

            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}


