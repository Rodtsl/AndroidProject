package com.example.kevin.testmenu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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



}
