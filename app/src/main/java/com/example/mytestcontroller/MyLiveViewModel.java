package com.example.mytestcontroller;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyLiveViewModel extends ViewModel {

    private MutableLiveData<Integer> num;

    public MutableLiveData<Integer> getNum() {
        if(num == null){
            num = new MutableLiveData<>();
            num.setValue(0);
        }
        return num;
    }

    public void add(int p){
         num.setValue(num.getValue() + p);
    }
}
