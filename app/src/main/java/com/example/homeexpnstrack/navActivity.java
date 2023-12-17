package com.example.homeexpnstrack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.navigation.NavigationView;

public class navActivity extends AppCompatActivity {
    NavigationView NavView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        NavView = (NavigationView) findViewById(R.id.nav_view);
    }
}