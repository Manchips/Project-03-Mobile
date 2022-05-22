package com.example.project3_mobile.Activities;



import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.project3_mobile.DAO.UserDAO;
import com.example.project3_mobile.Database.AppDatabase;
import com.example.project3_mobile.Models.User;
import com.example.project3_mobile.R;

import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private Button mLoginButton;
    private EditText mUserText, mPasswordText;

    private UserDAO userDAO;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mUserText = findViewById(R.id.login_Username);
        mPasswordText = findViewById(R.id.login_Password);

        mLoginButton = findViewById(R.id.buttonLogin);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.USER_TABLE)
                .allowMainThreadQueries()
                .build()
                .getUserDAO();

        users = userDAO.getAllUsers();

        mLoginButton.setOnClickListener(view -> login());
    }

    private void login() {
        for (User u : users) {
            Toast.makeText(LoginActivity.this, u.getUsername(), Toast.LENGTH_SHORT).show();
            if (mUserText.getText().toString().equals(u.getUsername()) && mPasswordText.getText().toString().equals(u.getPassword())) {
                Toast.makeText(LoginActivity.this, "Welcome back " + u.getUsername(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);

                intent.putExtra("USERNAME", mUserText.getText().toString());

                startActivity(intent);
                return;
            }
        }
        Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
    }
}

