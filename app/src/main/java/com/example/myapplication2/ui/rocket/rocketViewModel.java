package com.example.myapplication2.ui.rocket;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class
rocketViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public rocketViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is rocket fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}