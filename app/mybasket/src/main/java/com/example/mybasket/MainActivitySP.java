package com.example.mybasket;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.mybasket.databinding.ActivityMainBinding;
import com.example.mybasket.databinding.ActivityMainSpBinding;

public class MainActivitySP extends AppCompatActivity {
    private MySPStateViewModel mySPStateViewModel;
    private ActivityMainSpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_sp);

        mySPStateViewModel = new ViewModelProvider(this,
              new SavedStateViewModelFactory(getApplication(),this))
              //  new ViewModelProvider.AndroidViewModelFactory(getApplication()))
                .get(MySPStateViewModel.class);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main_sp);
        binding.setData(mySPStateViewModel);
        binding.setLifecycleOwner(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mySPStateViewModel.save();
    }
}