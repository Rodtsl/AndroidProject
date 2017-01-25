package com.example.leopoldrodts.androidproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("Home");


        Button button1A = (Button) findViewById(R.id.button1A);
        System.out.println("Debug boutton 1A");
        Button button2A = (Button) findViewById(R.id.button2A);
        System.out.println("Debug boutton 2A");

        button1A.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Section1A.class);
                startActivity(intent);
            }


        });
        button2A.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Section2A.class);
                startActivity(intent);
            }


        });

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
                Toast.makeText(MainActivity.this, "Ajouter!", Toast.LENGTH_SHORT).show();
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
}
