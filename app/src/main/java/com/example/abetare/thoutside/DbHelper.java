package com.example.abetare.thoutside;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.abetare.thoutside.Data.FeedReaderContract;
import com.example.abetare.thoutside.Data.ForecastData;

import java.util.ArrayList;

/**
 * Created by Abetare on 9/20/2016.
 */
public class DbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "theOutsideDB.db";
    public static final int DATABASE_VERSION = 1;


    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + FeedReaderContract.FeedEntry.TABLE_NAME + " ( " +
            FeedReaderContract.FeedEntry._ID + " INTEGER PRIMARY KEY, " + FeedReaderContract.FeedEntry.COLUMN_NAME_TEMP +
            COMMA_SEP + FeedReaderContract.FeedEntry.COLUMN_NAME_HUMIDITY + COMMA_SEP + FeedReaderContract.FeedEntry.COLUMN_NAME_PRESSURE +
            COMMA_SEP + FeedReaderContract.FeedEntry.COLUMN_NAME_City + COMMA_SEP + FeedReaderContract.FeedEntry.COLUMN_NAME_State + " ) ";
    private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + FeedReaderContract.FeedEntry.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);

    }

    public void insert(ContentValues values) {
        SQLiteDatabase db = this.getWritableDatabase();
        long newRowId = db.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values);
    }

    public void update() {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(SQL_DELETE_ENTRIES);
        onCreate(sqLiteDatabase);
    }

    public void onDowngrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        onUpgrade(sqLiteDatabase, oldVersion, newVersion);
    }

    public void read() {
        SQLiteDatabase db = this.getReadableDatabase();
        String[] projection = {
                FeedReaderContract.FeedEntry._ID,
                FeedReaderContract.FeedEntry.COLUMN_NAME_LOCATION,
                FeedReaderContract.FeedEntry.COLUMN_NAME_City,
                FeedReaderContract.FeedEntry.COLUMN_NAME_State,
                FeedReaderContract.FeedEntry.COLUMN_NAME_TEMP,
                FeedReaderContract.FeedEntry.COLUMN_NAME_HUMIDITY,
                FeedReaderContract.FeedEntry.COLUMN_NAME_PRESSURE
        };

        Cursor c = db.query(
                FeedReaderContract.FeedEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        c.moveToFirst();
        int cityindex=c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_City);
        int locationindex=c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_LOCATION);
        int stateindex=c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_State);
        int tempindex=c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_TEMP);
        int humidityindex=c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_HUMIDITY);
        int pressureindex=c.getColumnIndex(FeedReaderContract.FeedEntry.COLUMN_NAME_PRESSURE);
        String selection = FeedReaderContract.FeedEntry.COLUMN_NAME_City+ " = ?";
        String[] selectionArgs = { "M" };

       /* ArrayList<ForecastData> forecastDataList= new ArrayList<>();
        while(c.moveToNext()){
            c.getString(cityindex);
            c.getString(locationindex);
            c.getString(stateindex);
            c.getString(tempindex);
            c.getString(humidityindex);
            c.getString(pressureindex);
            ForecastData forecast=new ForecastData(c.getFloat(humidityindex), c.getString(locationindex), c.getString(cityindex),
                    c.getString(stateindex), c.getFloat(tempindex), c.getFloat(pressureindex));
            forecastDataList.add(forecast);
        }
        return forecastDataList;*/
    }

}