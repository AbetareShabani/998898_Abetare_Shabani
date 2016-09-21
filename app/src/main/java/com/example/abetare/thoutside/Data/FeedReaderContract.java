package com.example.abetare.thoutside.Data;

import android.provider.BaseColumns;

import com.example.abetare.thoutside.DbHelper;

/**
 * Created by Abetare on 9/20/2016.
 */
public class FeedReaderContract {
    private FeedReaderContract(){}
    public static class FeedEntry implements BaseColumns{
        public static final String TABLE_NAME="data";
        public static final String COLUMN_NAME_TEMP="Temperature";
        public static final String COLUMN_NAME_HUMIDITY="Humidity";
        public static final String COLUMN_NAME_PRESSURE="Pressure";
        public static final String COLUMN_NAME_LOCATION="Location";
        public static final String COLUMN_NAME_City="City";
        public static final String COLUMN_NAME_State="State";
    }
}
