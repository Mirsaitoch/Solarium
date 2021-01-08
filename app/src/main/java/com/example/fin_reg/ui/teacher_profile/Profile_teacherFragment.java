package com.example.fin_reg.ui.teacher_profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.fin_reg.R;

public class Profile_teacherFragment extends Fragment {
    private ProfileTeacherViewModel profileTeacherViewModel;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileTeacherViewModel =
                ViewModelProviders.of(this).get(ProfileTeacherViewModel.class);
        View root = inflater.inflate(R.layout.profile_teacher_fragment, container, false);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}


