package com.example.fin_reg.ui.profile_student;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Profile_studentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Profile_studentViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is profile  student fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}