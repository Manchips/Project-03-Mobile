package com.example.project3_mobile;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface SheetDAO {
    @Insert
    void insert(Sheet... sheets);

    @Update
    void update(Sheet... sheets);

    @Delete
    void delete(Sheet sheet);

    @Query("SELECT * FROM " + AppDataBase.SHEET_TABLE + " ORDER BY mCharName ASC")
    List<Sheet> getAllSheets();

    @Query("SELECT * FROM " + AppDataBase.SHEET_TABLE + " WHERE mCharName = :charname")
    Sheet getSheetbyCharName(String charname);

    @Query("SELECT * FROM " + AppDataBase.SHEET_TABLE + " WHERE mCreatorId = :userid")
    Sheet getSheetbyCreator(int userid);
}
