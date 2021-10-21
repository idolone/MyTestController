package com.example.mytestcontroller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    private static final String TAG = "Carlos";
    private MyViewModel myViewModel;
    private TextView textView;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.e(TAG, "onCreate: " );

        initData();
        initEvent();
    }

    private void initEvent() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.num++;
                textView.setText(String.valueOf(myViewModel.num));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myViewModel.num += 2;
                textView.setText(String.valueOf(myViewModel.num));
            }
        });
    }

    private void initData() {
        myViewModel = new ViewModelProvider(this,new ViewModelProvider.AndroidViewModelFactory(getApplication())).get(MyViewModel.class);
        textView = findViewById(R.id.textView);
        textView.setText(String.valueOf(myViewModel.num));
        btn1 = findViewById(R.id.button1);
        btn2 = findViewById(R.id.button2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: " );
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: " );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }




}