package com.example.fin_reg.ui.StudentTeacherInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentTeacherInfoViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public StudentTeacherInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is teacher profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
