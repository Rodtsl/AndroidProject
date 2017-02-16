package com.example.kevin.androidproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevin on 15/02/2017.
 */

public class Database extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "base.sqlite";
    private static final int VERSION = 1;
    public static final String METIER_KEY = "id";
    public static final String METIER_LOGIN = "login";
    public static final String METIER_PSWD = "passeword";
    public static final String METIER_NOM = "nom";
    public static final String METIER_PRENOM = "prenom";

    public static final String METIER_TABLE_NAME = "Users";
    public static final String METIER_TABLE_CREATE =
            "CREATE TABLE " + METIER_TABLE_NAME + " (" +
                    METIER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_LOGIN + " TEXT, " +
                    METIER_PSWD + " TEXT, " +
                    METIER_NOM + " TEXT, " +
                    METIER_PRENOM + " TEXT);";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {
        db.execSQL(METIER_TABLE_CREATE);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
