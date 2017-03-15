package com.example.kevin.androidproject;

import android.app.Fragment;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

/**
 * Created by kevin on 09/02/2017.
 */

public class Section_1A extends Fragment{
    View myView;
    private ListView Edt1A;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.activity_section_1a,container,false);
        return myView;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Edt1A=(ListView)getActivity().findViewById(R.id.ListEDT1A);
        ArrayAdapter<String> adaptater=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,NomEdt());
        Edt1A.setAdapter(adaptater);
        Button mSignupButton = (Button) getActivity().findViewById(R.id.Ajout);
        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AjoutList();
            }
        });
    }

    public void AjoutList(){
        DatabaseSqlite db = new DatabaseSqlite(getActivity());
        SQLiteDatabase database = db.getWritableDatabase();
        ContentValues liste1 = new ContentValues();
        liste1.put("nom","Valeur Ajoutée");
        database.insert("Liste",null,liste1);
        ArrayAdapter<String> adaptater=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,NomEdt());
        Edt1A.setAdapter(adaptater);
    }

    public String [] NomEdt(){
        DatabaseSqlite db = new DatabaseSqlite(getActivity());
        SQLiteDatabase database = db.getReadableDatabase();
        Cursor sql = database.rawQuery("SELECT * FROM Liste",null);
        String [] res = cursorToString(sql);
        return res;
    }
    public String[] cursorToString(Cursor c){
        if(c != null) {
            String[] sql = new String[c.getCount()];
            int i = 0;
            if (c.getCount() == 0)
                return sql;
            c.moveToFirst();
            while (true) {
                sql[i] = c.getString(1);
                i++;
                if (!c.moveToNext())
                    break;

            }
            c.close();
            return sql;
        }else{
            return null;
        }
    }
}
