package com.example.mytestcontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mytestcontroller.databinding.ActivityMainDataBindingBinding;

public class MainActivityDataBinding extends AppCompatActivity {
     private ActivityMainDataBindingBinding  dataBinding;
     private MyLiveViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main_data_binding);
        myViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyLiveViewModel.class);
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_data_binding);
        dataBinding.setData(myViewModel);
        dataBinding.setLifecycleOwner(this);

    }
}