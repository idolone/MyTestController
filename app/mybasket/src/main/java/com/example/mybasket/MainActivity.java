package com.example.mybasket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mybasket.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MySaveStateViewMode mySaveStateViewMode;
    private MyViewModel myViewModel;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        myViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication()))
//                .get(MyViewModel.class);
        mySaveStateViewMode = new ViewModelProvider(this,new SavedStateViewModelFactory(getApplication(),this))
                .get(MySaveStateViewMode.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
       // binding.setData(myViewModel);
        binding.setData(mySaveStateViewMode);
        binding.setLifecycleOwner(this);
        //setContentView(R.layout.activity_main);
    }
}