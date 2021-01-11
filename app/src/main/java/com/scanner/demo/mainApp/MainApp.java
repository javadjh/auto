package com.scanner.demo.mainApp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.MaterialToolbar;
import com.scanner.demo.R;
import com.scanner.demo.databinding.ActivityMainAppBinding;

public class MainApp extends AppCompatActivity {
    NavController navController;
    ActivityMainAppBinding mainAppBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainAppBinding = DataBindingUtil.setContentView(this,R.layout.activity_main_app);
        navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupWithNavController(new CollapsingToolbarLayout(this),new MaterialToolbar(this),navController);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }



    @Override
    public void onBackPressed() {
        if(navController.getCurrentDestination().getId()==R.id.letterSingleFragment ||
        navController.getCurrentDestination().getId()==R.id.upsertLetterFragment||
        navController.getCurrentDestination().getId()==R.id.upsertLetterStepTwoFragment){
            super.onBackPressed();
        }else{
            finish();
            finish();
            finish();
            finish();
        }
    }
}