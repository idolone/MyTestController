package com.example.mytestcontroller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "KIN";
    private SeekBar seekBar;
    private TextView textView;
    private int progress = 0;
    private Handler  mhandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.what == 0){
                progress = (int)msg.obj;
                Log.i(TAG, "handleMessage: " +progress);
                seekBar.setProgress(progress);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initEvent();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true)
                {
             progress += 1;
             if(progress >100)  break;
             Message msg = Message.obtain();
             msg.what = 0;
             msg.obj = progress;
             mhandler.sendMessage(msg);

                }

            }
        }).start();
    }

    private void initEvent() {
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.i(TAG, "onProgressChanged: "+progress);
                textView.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i(TAG, "onStartTrackingTouch: ");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.i(TAG, "onStopTrackingTouch: ");
            }
        });
    }

    private void initData() {
    }

    private void initView() {
        seekBar = findViewById(R.id.seekBar);
        textView = findViewById(R.id.text);
    }
}