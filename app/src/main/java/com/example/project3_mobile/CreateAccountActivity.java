package com.example.project3_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;


public class CreateAccountActivity extends AppCompatActivity {

    private EditText mUserText, mPasswordText;
    private Button mRegisterButton;

    private UserDAO userDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        mUserText = findViewById(R.id.editTextUsername);
        mPasswordText = findViewById(R.id.editTextPassword);

        mRegisterButton = findViewById(R.id.registerButton);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();


        mRegisterButton.setOnClickListener(view -> register());

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
        } else if (mUserText.getText().toString().equals(userDAO.getUserbyUsername(mUserText.getText().toString()).getUsername())){
            Toast.makeText(CreateAccountActivity.this, "Username already in use", Toast.LENGTH_SHORT).show();
        }else {
            userDAO.insert(user);
            Toast.makeText(CreateAccountActivity.this, "Account successfully created", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
        }
    }
}
