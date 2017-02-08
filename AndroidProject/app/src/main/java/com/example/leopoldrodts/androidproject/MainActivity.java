package com.example.leopoldrodts.androidproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import net.sf.andpdf.pdfviewer.PdfViewerActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

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
        Button buttonEDT = (Button) findViewById(R.id.buttonEDT);
        Button buttonPDF = (Button) findViewById(R.id.buttonPDF);
        Button buttondrawer = (Button) findViewById(R.id.buttondrawer);

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

        buttonEDT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, SectionEDT.class);
                startActivity(intent);
            }
        });

        buttondrawer.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, Drawer_Activity.class);
                startActivity(intent);
            }
        });


        buttonPDF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ouvrirPDF("edtInfo2A20170206");
            }
        });



    }
    private String cheminPDF(String nomfichier){
        File f = new File(getCacheDir()+"/"+nomfichier+".pdf");
        if (!f.exists()) try {

            InputStream is = getAssets().open(nomfichier+".pdf");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();


            FileOutputStream fos = new FileOutputStream(f);
            fos.write(buffer);
            fos.close();
        } catch (Exception e) { throw new RuntimeException(e); }
        return f.getPath();
    }
    private void ouvrirPDF(String nom){
        Intent intent = new Intent(this, PdfActivity.class);
        intent.putExtra(PdfViewerActivity.EXTRA_PDFFILENAME, cheminPDF(nom));
        startActivity(intent);
    }


}
