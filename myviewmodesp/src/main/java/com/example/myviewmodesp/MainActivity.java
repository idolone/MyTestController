package com.example.myviewmodesp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.myviewmodesp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MyViewModel myViewModel;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);
        myViewModel = new ViewModelProvider(this,
                new SavedStateViewModelFactory(getApplication(),this))
                .get(MyViewModel.class);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);


    }
}