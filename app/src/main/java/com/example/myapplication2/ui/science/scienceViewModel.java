package com.example.myapplication2.ui.science;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class scienceViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public scienceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is science fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}