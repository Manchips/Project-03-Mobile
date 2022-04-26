package com.example.project3_mobile;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity(tableName = AppDatabase.SHEET_TABLE)
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

    public int getSheetId() {
        return mSheetId;
    }

    public void setSheetId(int mSheetId) {
        this.mSheetId = mSheetId;
    }

    public int getCreatorId() {
        return mCreatorId;
    }

    public void setCreatorId(int mCreatorId) {
        this.mCreatorId = mCreatorId;
    }

    public String getCharName() {
        return mCharName;
    }

    public void setCharName(String mCharName) {
        this.mCharName = mCharName;
    }

    public int getBodyStat() {
        return mBodyStat;
    }

    public void setBodyStat(int mBodyStat) {
        this.mBodyStat = mBodyStat;
    }

    public int getMindStat() {
        return mMindStat;
    }

    public void setMindStat(int mMindStat) {
        this.mMindStat = mMindStat;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String mDescription) {
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
