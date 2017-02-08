package com.example.kevin.testmenu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;



public class Section2A extends AppCompatActivity {
    private ListView Edt2A;
    public String[] NomEdt= new String[]{
            "EdtS1","EdtS2"
    };
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section2);
        Edt2A=(ListView)findViewById(R.id.ListEDT2A);
        ArrayAdapter<String> adaptater=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NomEdt);
        Edt2A.setAdapter(adaptater);
    }

}
