package com.example.kevin.androidproject;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by kevin on 06/03/2017.
 */

public class DataBaseMySql extends AsyncTask<Void, Void, String[][]> {
    @Override
    protected String[][] doInBackground(Void... params) {
        String result = "";
        InputStream is = null;
// Envoi de la requête avec HTTPPost
        try{
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("https://hoangphuoccornu.000webhostapp.com/Android/users.php");
            //httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("log_tag", "Connexion établie");
        }catch(Exception e){
            Log.e("log_tag", "Error in http connection "+e.toString());
        }
//Conversion de la réponse en chaine
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();

            result=sb.toString();
            Log.e("log_tag", result);
        }catch(Exception e){
            Log.e("log_tag", "Error converting result "+e.toString());
        }
// Parsing des données JSON
        try{
            String [][] tableau;
            JSONArray jArray = new JSONArray(result);
            tableau = new String[jArray.length()][5];
            for(int i=0;i<jArray.length();i++){
                JSONObject json_data = jArray.getJSONObject(i);
                tableau[i][0] = json_data.getString("id");
                tableau[i][1] = json_data.getString("login");
                tableau[i][2] = json_data.getString("passeword");
                tableau[i][3] = json_data.getString("nom");
                tableau[i][3] = json_data.getString("prenom");
            }
            return tableau;
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        return new String[0][0];
    }
}
/*
    //lancer une requète//
    BDD bdd = new BDD();
    bdd.execute();
    try {
        String [][] basedonnees = bdd.get();
        Toast.makeText(MainActivity.this, basedonnees[0][1], Toast.LENGTH_SHORT).show();
    } catch (InterruptedException e) {
        e.printStackTrace();
    } catch (ExecutionException e) {
        e.printStackTrace();
    }
*/