package com.example.fin_reg.ui.profile_teacher;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProfileTeacherViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public ProfileTeacherViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is teacher profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
