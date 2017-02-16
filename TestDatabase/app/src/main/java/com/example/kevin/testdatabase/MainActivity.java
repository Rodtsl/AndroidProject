package com.example.kevin.testdatabase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Base db = new Base(this);
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put("id","1");
        value.put("login","hoang");
        value.put("passeword","123456");
        value.put("nom","cornu");
        value.put("prenom","hoang");

        database.insert("Users",null,value);
        Cursor sql = database.rawQuery("SELECT * FROM Users WHERE nom = ?", new String[]{"cornu"});
        //Cursor sql = database.rawQuery("SELECT * FROM Users where nom = ?", new String[]{"cornu"});
        String [] res = cursorToString(sql);

        Toast.makeText(MainActivity.this, res[1], Toast.LENGTH_SHORT).show();

    }
    /*
    public String cursorToString(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        String sql = new String();
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        sql = c.getString(1);
        c.close();

        //On retourne le joueur
        return sql;
    }
    */

    public String[] cursorToString(Cursor c){
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;

        //Sinon on se place sur le premier élément
        c.moveToFirst();
        //On créé un livre
        String [] sql = new String[5];
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        for(int i=0;i<c.getColumnCount();i++){
            sql[i]=c.getString(i);
        }
        c.close();

        //On retourne le joueur
        return sql;
    }

}
