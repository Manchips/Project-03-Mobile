package com.example.project3_mobile;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class SheetEditorActivity extends AppCompatActivity {

    private Button saveSheetButton;
    private Button deleteSheetButton;

    private UserDAO userDAO;
    private SheetDAO sheetDAO;

    private int sheetID;

    private EditText charName, bodyStat, mindStat, charDesc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        charName = findViewById(R.id.sheet_CharacterName);
        bodyStat = findViewById(R.id.sheet_BodyStat);
        mindStat = findViewById(R.id.sheet_MindStat);
        charDesc = findViewById(R.id.sheet_EditDesc);

        saveSheetButton = findViewById(R.id.sheetSaveButton);
        deleteSheetButton = findViewById(R.id.sheetDeleteButton);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();

        sheetDAO = (SheetDAO) Room.databaseBuilder(this, AppDatabase.class, AppDatabase.DB_NAME)
                .allowMainThreadQueries()
                .build()
                .getDAO();

        saveSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveSheet();
            }
        });

        deleteSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteSheet();
            }
        });
    }

    public void saveSheet(){

    }

    public void deleteSheet(){

    }
}
