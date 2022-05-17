package com.example.project3_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class SheetCreatorActivity extends AppCompatActivity {

    private Button saveSheetButton;
    private Button cancelSheetButton;

    private UserDAO userDAO;
    private SheetDAO sheetDAO;

    private int sheetID;
    private int userID;
    private List<User> users;

    private String username;


    private EditText charName, bodyStat, mindStat, charDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        users = userDAO.getAllUsers();

        username = getIntent().getStringExtra("USERNAME");

        for (User u : users) {
            if(u.getUsername().equals(username)){
                Toast.makeText(SheetCreatorActivity.this, "You are logged in as " + u.getUsername(), Toast.LENGTH_SHORT).show();

                userID = u.getUserId();
            }

        }

        charName = findViewById(R.id.sheet_CharacterName);
        bodyStat = findViewById(R.id.sheet_BodyStat);
        mindStat = findViewById(R.id.sheet_MindStat);
        charDesc = findViewById(R.id.sheet_EditDesc);

        saveSheetButton = findViewById(R.id.sheetSaveButton);
        cancelSheetButton = findViewById(R.id.sheetCancelButton);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();

        sheetDAO = (SheetDAO) Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();

        saveSheetButton.setOnClickListener(view -> saveSheet());

        cancelSheetButton.setOnClickListener(view -> cancelCreateSheet());
    }

    public void saveSheet(){
        Sheet sheet = new Sheet(charName.getText().toString(), userID);

        sheet.setBodyStat(Integer.parseInt(bodyStat.getText().toString()));
        sheet.setMindStat(Integer.parseInt(mindStat.getText().toString()));
        sheet.setDescription(charDesc.getText().toString());

        sheetDAO.insert(sheet);
        Toast.makeText(SheetCreatorActivity.this, "Sheet Saved!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);
    }

    public void cancelCreateSheet(){
        Toast.makeText(SheetCreatorActivity.this, "Sheet NOT Saved.", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("USERNAME", username);
        startActivity(intent);

    }
}
