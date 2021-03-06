package com.example.project3_mobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.project3_mobile.R;

import java.util.List;

public class LandingActivity extends AppCompatActivity {

    Button mLoginButton, mCreateAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mLoginButton = findViewById(R.id.landingLoginButton);
        mCreateAccountButton = findViewById(R.id.landingCreateAccountButton);

        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });

        mCreateAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreateAccountActivity.class);
                startActivity(intent);
            }
        });
    }
}