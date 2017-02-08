package com.example.kevin.testmenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class Section1A extends AppCompatActivity {

    private ArrayAdapter<String> adaptater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setContentView(R.layout.activity_section1);
        adaptater= new ArrayAdapter<String>(this,R.layout.activity_section1);

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
                Toast.makeText(Section1A.this, "Synchronisation ...", Toast.LENGTH_SHORT).show();
                return true;
           /* case R.id.action_settings:
                intent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(intent);
                return true;
            case R.id.action_propos:
                intent = new Intent(MainActivity.this, AndroidActivity.class);
                startActivity(intent);
                return true;*/
            default :
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.actionbar,menu);
        return true;
    };


}
