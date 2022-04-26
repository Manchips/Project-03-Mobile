package com.example.project3_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.project3_mobile.R;

public class LandingActivity extends AppCompatActivity {

    public void startLoginActivity(View view) {
        Intent intent = new Intent (this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }
}