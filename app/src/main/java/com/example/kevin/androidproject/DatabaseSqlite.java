package com.example.kevin.androidproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kevin on 15/02/2017.
 */

public class DatabaseSqlite extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "base.sqlite";
    private static final int VERSION = 1;
    public static final String METIER_KEY = "id";
    public static final String METIER_LOGIN = "login";
    public static final String METIER_PSWD = "passeword";
    public static final String METIER_NOM = "nom";
    public static final String METIER_PRENOM = "prenom";

    public static final String METIER_TABLE_NAME = "Users";
    public static final String LIST_TABLE_NAME = "Liste";
    public static final String LIST_KEY = "id";
    public static final String LIST_NOM = "nom";




    public static final String METIER_TABLE_CREATE =
            "CREATE TABLE " + METIER_TABLE_NAME + " (" +
                    METIER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    METIER_LOGIN + " TEXT, " +
                    METIER_PSWD + " TEXT, " +
                    METIER_NOM + " TEXT, " +
                    METIER_PRENOM + " TEXT);";

    public static final String LIST_TABLE_CREATE =
            "CREATE TABLE " + LIST_TABLE_NAME + " (" +
                    LIST_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    LIST_NOM + " TEXT);";

    public DatabaseSqlite(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override public void onCreate(SQLiteDatabase db) {

        db.execSQL(METIER_TABLE_CREATE);
        db.execSQL(LIST_TABLE_CREATE);
        ContentValues user = new ContentValues();
        user.put("login","hoang");
        user.put("passeword","123456");
        user.put("nom","cornu");
        user.put("prenom","hoang");
        db.insert("Users",null,user);
        ContentValues liste1 = new ContentValues();
        liste1.put("nom","edt1");
        db.insert("Liste",null,liste1);
        ContentValues liste2 = new ContentValues();
        liste2.put("nom","edt2");
        db.insert("Liste",null,liste2);
    }

    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //s'active quand le numéro de version change
        db.execSQL("drop table Users");
        db.execSQL("drop table Liste");
        db.execSQL(METIER_TABLE_CREATE);
        db.execSQL(METIER_TABLE_CREATE);
    }
}
