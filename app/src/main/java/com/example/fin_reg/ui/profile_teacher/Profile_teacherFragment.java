package com.example.fin_reg.ui.profile_teacher;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fin_reg.R;
import com.example.fin_reg.apputil.AppConfig;

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
        appConfig = new AppConfig(this_context);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}


