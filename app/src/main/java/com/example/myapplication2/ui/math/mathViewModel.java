package com.example.myapplication2.ui.math;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

    public class
    mathViewModel extends ViewModel {

        private final MutableLiveData<String> mText;

        public mathViewModel() {
            mText = new MutableLiveData<>();
            mText.setValue("This is math fragment");
        }

        public LiveData<String> getText() {
            return mText;
        }
    }

