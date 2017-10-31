package com.example.jonmid.contactosbasededatos.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jonmid.contactosbasededatos.Utilities.Constants;

/**
 * Created by jonmid on 26/10/17.
 */

public class SqliteHelper extends SQLiteOpenHelper {

    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.CREATE_TABLE_USERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+Constants.TABLA_NAME_USERS);
        onCreate(db);
    }
}
