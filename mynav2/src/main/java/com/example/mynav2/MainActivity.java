package com.example.mynav2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private NavController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        controller = navHostFragment.getNavController();

        NavigationUI.setupActionBarWithNavController(this,controller);
    }

    @Override
    public boolean onSupportNavigateUp() {
        //return super.onSupportNavigateUp();
        return controller.navigateUp();
    }
}