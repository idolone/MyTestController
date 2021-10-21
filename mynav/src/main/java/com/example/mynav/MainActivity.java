package com.example.mynav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
     private NavController mycontrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        mycontrl = navHostFragment.getNavController();
        //mycontrl = Navigation.findNavController(this,R.id.fragmentContainerView);

        NavigationUI.setupActionBarWithNavController(this,mycontrl);
    }

    @Override
    public boolean onSupportNavigateUp() {
       // return super.onSupportNavigateUp();
        return mycontrl.navigateUp();
    }
}