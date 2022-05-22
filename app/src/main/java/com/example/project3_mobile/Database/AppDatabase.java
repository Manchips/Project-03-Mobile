package com.example.project3_mobile.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.project3_mobile.Models.Sheet;
import com.example.project3_mobile.DAO.SheetDAO;
import com.example.project3_mobile.Models.User;
import com.example.project3_mobile.DAO.UserDAO;

@Database(entities = {User.class, Sheet.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public static final String USER_TABLE = "USER_TABLE";
    public static final String SHEET_TABLE = "SHEET_TABLE";

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "")
                    .fallbackToDestructiveMigration()
                    .build();
            }
        return instance;
    }

    public abstract UserDAO getUserDAO();
    public abstract SheetDAO getSheetDAO();

}