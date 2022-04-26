package com.example.project3_mobile;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Sheet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String DB_NAME = "APP_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String SHEET_TABLE = "SHEET_TABLE";

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
            }
        return instance;
    }

    public abstract UserDAO getDAO();
    public abstract SheetDAO sheetDAO();

}