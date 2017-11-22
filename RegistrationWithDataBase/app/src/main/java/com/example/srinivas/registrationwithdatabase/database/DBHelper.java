package com.example.srinivas.registrationwithdatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Srinivas on 6/16/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "registrationapp.db";
    private static final int DATABASE_VERSION = 1;

    private static String TABLE_CREATE_REGISTRATION =
            "CREATE TABLE " + RegContract.RegDetails.TABLE_NAME + "("
                    +RegContract.RegDetails._ID +" INTEGER PRIMARY KEY,"
                    +RegContract.RegDetails.NAME+" TEXT,"
                    +RegContract.RegDetails.USER_NAME+" TEXT,"
                    +RegContract.RegDetails.PASSWORD+" TEXT,"
                    +RegContract.RegDetails.EMAIL+" TEXT"
                    +")";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);


    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_REGISTRATION);
        Log.i(DATABASE_NAME," cREATED");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS"+RegContract.RegDetails.TABLE_NAME);
    }
}
