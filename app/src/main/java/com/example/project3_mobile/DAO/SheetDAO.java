package com.example.project3_mobile.DAO;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.project3_mobile.Database.AppDatabase;
import com.example.project3_mobile.Models.Sheet;

@Dao
public interface SheetDAO {
    @Insert
    void insert(Sheet... sheets);

    @Update
    void update(Sheet... sheets);

    @Delete
    void delete(Sheet sheet);

    @Query("SELECT * FROM " + AppDatabase.SHEET_TABLE + " ORDER BY mCharName ASC")
    List<Sheet> getAllSheets();

    @Query("SELECT * FROM " + AppDatabase.SHEET_TABLE + " WHERE mCharName = :charname")
    Sheet getSheetbyCharName(String charname);

    @Query("SELECT * FROM " + AppDatabase.SHEET_TABLE + " WHERE mCreatorId = :userid")
    Sheet getSheetbyCreator(int userid);
}
