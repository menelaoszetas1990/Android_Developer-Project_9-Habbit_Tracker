package com.example.android.android_developer_project_9_habbit_tracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class HabitsDBHelper extends SQLiteOpenHelper {

    // Name of the database file
    private static final String DATABASE_NAME = "habits.db";

    // Database version
    private static final int DATABASE_VERSION = 1;

    /**
     * Default Constructor
     * @param context
     */
    public HabitsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // This method is called when the database is created for the first time
     @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Create a String that contains the SQL statement to create the table
        String SQL_CREATE_TABLE =  "CREATE TABLE " + HabitsContract.HabitsEntry.TABLE_NAME + " ("
                + HabitsContract.HabitsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitsContract.HabitsEntry.COLUMN_HABIT_NAME + " TEXT NOT NULL, "
                + HabitsContract.HabitsEntry.COLUMN_HABIT_DURATION + " INTEGER NOT NULL, "
                + HabitsContract.HabitsEntry.COLUMN_HABIT_DURATION_UNIT + " TEXT NOT NULL);";

        // Execute the SQL statement
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);
    }

    /**
     * This method inserts records in the Habits table
     * @param name - Name of the habit (e.g. Went for a run)
     * @param duration - Duration of the habit (e.g. 50)
     * @param durationUnit - Duration unit (e.g. min)
     */
    public void insertRecord(String name, int duration, String durationUnit) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues habitValues = new ContentValues();
        habitValues.put(HabitsContract.HabitsEntry.COLUMN_HABIT_NAME, name);
        habitValues.put(HabitsContract.HabitsEntry.COLUMN_HABIT_DURATION, duration);
        habitValues.put(HabitsContract.HabitsEntry.COLUMN_HABIT_DURATION_UNIT, durationUnit);

        sqLiteDatabase.insert(HabitsContract.HabitsEntry.TABLE_NAME, null, habitValues);
    }


    public Cursor queryAllRecords() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String[] projection = {
                HabitsContract.HabitsEntry._ID,
                HabitsContract.HabitsEntry.COLUMN_HABIT_NAME,
                HabitsContract.HabitsEntry.COLUMN_HABIT_DURATION,
                HabitsContract.HabitsEntry.COLUMN_HABIT_DURATION_UNIT
        };

        return sqLiteDatabase.query(
                HabitsContract.HabitsEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
    }

    /**
     * This method is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 1, so no action needed here
    }
}