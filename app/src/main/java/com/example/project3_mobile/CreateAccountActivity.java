package com.example.project3_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class CreateAccountActivity extends AppCompatActivity {

    private EditText mUserText, mPasswordText;

    private UserDAO userDAO;
    private List<User> users;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        mUserText = findViewById(R.id.editTextUsername);
        mPasswordText = findViewById(R.id.editTextPassword);
        Button mRegisterButton = findViewById(R.id.registerButton);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();

        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { register(); }
        });
    }

    public void register(){
        User user = new User(mUserText.getText().toString(), mPasswordText.getText().toString());

        if (mUserText.getText().toString().isEmpty() || mPasswordText.getText().toString().isEmpty()) {
            Toast.makeText(CreateAccountActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else if (mUserText.getText().toString().equals("admin")) {
            Toast.makeText(CreateAccountActivity.this, "Invalid Username", Toast.LENGTH_SHORT).show();
        } else if (mUserText.getText().toString().equals(userDAO.getUserbyUsername(mUserText.getText().toString()))){
            Toast.makeText(CreateAccountActivity.this, "Username already in use", Toast.LENGTH_SHORT).show();
        }else {
            userDAO.insert(user);
            Toast.makeText(CreateAccountActivity.this, "Account successfully created", Toast.LENGTH_SHORT).show();
        }
    }
}
