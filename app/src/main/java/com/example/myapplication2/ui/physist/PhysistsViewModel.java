package com.example.myapplication2.ui.physist;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PhysistsViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public PhysistsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is physist fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}