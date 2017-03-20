package com.example.kevin.androidproject;

/**
 * Created by kevin on 20/03/2017.
 */
import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class CompteurService extends IntentService {
    private final static String TAG = "CompteurService";

    public CompteurService() {
        super(TAG);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "Le compteur valait : " + intent.getIntExtra(Home.EXTRA_COMPTEUR, -1));
        int i = 0;
        // Cette boucle permet de rajouter artificiellement du temps de traitement
        while(i < 10)
            i++;
    }
}