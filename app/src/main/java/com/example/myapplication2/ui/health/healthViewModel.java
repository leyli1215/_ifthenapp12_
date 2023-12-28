package com.example.myapplication2.ui.health;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class healthViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public healthViewModel() {
        mText = new MutableLiveData<>();

        mText.setValue("This is health fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}