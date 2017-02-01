package com.example.leopoldrodts.androidproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;



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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Edt2A=(ListView)findViewById(R.id.ListEDT2A);
        ArrayAdapter<String> adaptater=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,NomEdt);
        Edt2A.setAdapter(adaptater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        // Activate the navigation drawer toggle
      /*  if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }*/
        switch (item.getItemId()) {
            case R.id.MenuSync:
                //-------------------A completer------------------
                Toast.makeText(Section2A.this, "Synchronisation ...", Toast.LENGTH_SHORT).show();
                return true;
           /* case R.id.action_settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_propos:
                intent = new Intent(MainActivity.this, AndroidActivity.class);
                startActivity(intent);
                return true;*/
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }





}
