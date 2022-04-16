package com.example.project3_dao;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = AppDataBase.SHEET_TABLE)
public class Sheet {

    @PrimaryKey(autoGenerate = true)
    private int mSheetId;

    private int mCreatorId;
    private String mCharName;

    private int mBodyStat;
    private int mMindStat;
    private String mDescription;

    public Sheet(String mCharName, int mCreatorId) {
        this.mCharName = mCharName;
        this.mCreatorId = mCreatorId;
    }

    public String getmCharName() {
        return mCharName;
    }

    public void setmCharName(String mCharName) {
        this.mCharName = mCharName;
    }

    public int getmBodyStat() {
        return mBodyStat;
    }

    public void setmBodyStat(int mBodyStat) {
        this.mBodyStat = mBodyStat;
    }

    public int getmMindStat() {
        return mMindStat;
    }

    public void setmMindStat(int mMindStat) {
        this.mMindStat = mMindStat;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sheet)) return false;
        Sheet sheet = (Sheet) o;
        return mSheetId == sheet.mSheetId && mBodyStat == sheet.mBodyStat && mMindStat == sheet.mMindStat && Objects.equals(mCharName, sheet.mCharName) && Objects.equals(mDescription, sheet.mDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mSheetId, mCharName, mBodyStat, mMindStat, mDescription);
    }

    @Override
    public String toString() {
        return "Sheet{" +
                "mCharName='" + mCharName + '\'' +
                ", mBodyStat=" + mBodyStat +
                ", mMindStat=" + mMindStat +
                ", mDescription='" + mDescription + '\'' +
                '}';
    }
}
