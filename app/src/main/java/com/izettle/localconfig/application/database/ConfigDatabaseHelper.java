package com.izettle.localconfig.application.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.izettle.localconfig.application.database.tables.ApplicationTable;
import com.izettle.localconfig.application.database.tables.ConfigurationTable;

public class ConfigDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "localConfig.db";
    private static final int DATABASE_VERSION = 1;

    public ConfigDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(ApplicationTable.CREATE);
        sqLiteDatabase.execSQL(ConfigurationTable.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}