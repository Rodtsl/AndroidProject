package com.example.leopoldrodts.androidproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.Toast;

import static java.security.AccessController.getContext;


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






  /*  mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //Toast.makeText(OSXActivity.this, "Time for an upgrade!", Toast.LENGTH_SHORT).show();
            Intent intent;
            switch((int) id){
                case 0 :
                    intent = new Intent(AndroidActivity.this, MainActivity.class);
                    startActivity(intent);
                    break;
                case 1 :
                    intent = new Intent(AndroidActivity.this, IOSActivity.class);
                    startActivity(intent);
                    break;
                case 2 :
                    intent = new Intent(AndroidActivity.this, WindowsActivity.class);
                    startActivity(intent);
                    break;
                case 3 :
                    intent = new Intent(AndroidActivity.this, OSXActivity.class);
                    startActivity(intent);
                    break;
                case 4 :
                    intent = new Intent(AndroidActivity.this, LinuxActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    });*/
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
