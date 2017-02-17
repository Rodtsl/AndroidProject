package com.example.kevin.androidproject;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Button mSignupButton = (Button) findViewById(R.id.sign_up);
        final EditText login = (EditText) findViewById(R.id.login);
        final EditText mdp = (EditText) findViewById(R.id.password);
        final EditText nom = (EditText) findViewById(R.id.nom);
        final EditText prenom = (EditText) findViewById(R.id.prenom);
        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inscription(login.getText()+"",mdp.getText()+"",nom.getText()+"",prenom.getText()+"");
                redirection();
            }
        });

    }
    private void redirection(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
    private void inscription(String login,String mdp,String nom, String prenom){
        Database db = new Database(this);
        ContentValues value = new ContentValues();
        value.put("id","2");
        value.put("login",login);
        value.put("passeword",mdp);
        value.put("nom",nom);
        value.put("prenom",prenom);

        SQLiteDatabase database = db.getWritableDatabase();

        database.insert("Users",null,value);
    }
}
