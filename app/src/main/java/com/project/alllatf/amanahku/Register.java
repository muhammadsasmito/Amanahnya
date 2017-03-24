package com.project.alllatf.amanahku;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Register");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }
}