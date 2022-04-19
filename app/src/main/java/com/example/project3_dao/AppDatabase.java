package com.example.project3_dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Sheet.class}, version = 1) // idk what this error means :(
abstract class AppDataBase extends RoomDatabase {
    public static final String DB_NAME = "APP_DATABASE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String SHEET_TABLE = "SHEET_TABLE";

    private static AppDataBase instance;

    public static synchronized AppDataBase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
            }
        return instance;
    }

    public abstract UserDAO userDAO();
    public abstract SheetDAO sheetDAO();
}