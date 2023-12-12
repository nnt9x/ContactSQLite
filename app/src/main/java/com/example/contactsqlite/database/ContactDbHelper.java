package com.example.contactsqlite.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Contact.db";

    // Phuong thuc khoi tao
    public ContactDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE contacts(\n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                "name TEXT NOT NULL,\n" +
                "phone TEXT NOT NULL\n" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Co the bo qua
    }
}
