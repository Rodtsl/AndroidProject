package com.example.kevin.androidproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private AutoCompleteTextView login;
    private EditText passeword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = (AutoCompleteTextView) findViewById(R.id.id);
        passeword = (EditText) findViewById(R.id.password);
        login.setError(null);
        passeword.setError(null);
        Button mSignupButton = (Button) findViewById(R.id.sign_in_button);
        mSignupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isUserValid(login.getText().toString(),passeword.getText().toString())){
                    redirection();
                }
            }
        });
    }

    private void redirection(){
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    private boolean isUserValid(String log,String pass) {
        if(passeword.length() >= 4) {
            DatabaseSqlite db = new DatabaseSqlite(this);
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor sql = database.rawQuery("SELECT login,passeword FROM Users WHERE login = ?", new String[]{log});
            String[][] user = cursorToString(sql);
            if(user != null && user.length != 0){
                if(user[0][1].equals(pass)){
                    return true;
                }else{
                    passeword.setError("Mot de passe incorect");
                    return false;
                }
            }else{
                login.setError("Login inexistant");
                return false;
            }
        }else{
            passeword.setError("Mot de passe trop court");
            return false;
        }
    }
    public String[][] cursorToString(Cursor c){
        if(c != null) {
            String[][] sql = new String[c.getCount()][c.getColumnCount()];
            int i = 0;
            if (c.getCount() == 0)
                return sql;
            c.moveToFirst();
            while (true) {
                sql[i][0] = c.getString(0);
                sql[i][1] = c.getString(1);
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

