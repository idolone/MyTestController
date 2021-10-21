package com.example.mytestcontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivityLiveData extends AppCompatActivity {

    private MyLiveViewModel myLiveViewModel;
    private TextView textView;
    private ImageButton ibtn1,ibtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_live_data);
        myLiveViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyLiveViewModel.class);
        textView = findViewById(R.id.textView2);
        ibtn1 = findViewById(R.id.imageButton);
        ibtn2 = findViewById(R.id.imageButton2 );

        myLiveViewModel.getNum().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
             textView.setText(String.valueOf(integer));
            }
        });

        ibtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myLiveViewModel.add(1);
            }
        });

        ibtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               myLiveViewModel.add(-1);
            }
        });


    }
}