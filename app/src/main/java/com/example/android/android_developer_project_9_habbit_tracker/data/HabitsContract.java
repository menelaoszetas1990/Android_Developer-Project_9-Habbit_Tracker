package com.example.android.android_developer_project_9_habbit_tracker.data;

import android.provider.BaseColumns;

public class HabitsContract {

    // Empty constructor
    private HabitsContract() {
    }

    // Inner class that defines constant values for the habits database table.
    //Each entry in the table represents a single habit tracked on a particular day.
    public static class HabitsEntry implements BaseColumns {

        // Name of database table
        public static final String TABLE_NAME = "habits";

        // Unique ID INTEGER
        public final static String _ID = BaseColumns._ID;

        // Habit Name TEXT
        public final static String COLUMN_HABIT_NAME = "habit_name";

        // Duration of the habit INTEGER
        public final static String COLUMN_HABIT_DURATION = "habit_duration";

        // Duration unit TEXT
        public final static String COLUMN_HABIT_DURATION_UNIT = "habit_duration_unit";

        // Duration unit values
        public static final String DURATION_MINUTE = "minute(s)";
        public static final String DURATION_HOUR = "hour(s)";

        // Returns whether or not the given duration unit is valid
        public static boolean isValidDurationUnit(String unit) {
            if (unit.equals(DURATION_MINUTE) || unit.equals(DURATION_HOUR)) {
                return true;
            }
            return false;
        }
    }
}
