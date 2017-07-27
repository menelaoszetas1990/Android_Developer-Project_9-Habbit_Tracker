package com.example.android.android_developer_project_9_habbit_tracker;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.android_developer_project_9_habbit_tracker.data.HabitsContract;
import com.example.android.android_developer_project_9_habbit_tracker.data.HabitsDBHelper;

public class MainActivity extends AppCompatActivity {

    public static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // test values
        HabitsDBHelper mDbHelper = new HabitsDBHelper(this);

        mDbHelper.insertRecord(
                "Work",
                8,
                HabitsContract.HabitsEntry.DURATION_HOUR);

        mDbHelper.insertRecord(
                "Coffee",
                50,
                HabitsContract.HabitsEntry.DURATION_MINUTE);

        mDbHelper.insertRecord(
                "Gym",
                120,
                HabitsContract.HabitsEntry.DURATION_MINUTE);

        // Read the table records and write to log for test
        Cursor readCursor = mDbHelper.queryAllRecords();

        try {
            while (readCursor.moveToNext()) {
                Log.i(LOG_TAG,
                        readCursor.getInt(0) + " for "
                        + readCursor.getString(1) + " "
                        + readCursor.getString(2));
            }
        } finally {
            readCursor.close();
        }
    }
}