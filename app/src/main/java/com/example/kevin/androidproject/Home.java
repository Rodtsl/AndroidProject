package com.example.kevin.androidproject;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by kevin on 09/02/2017.
 */

public class Home extends Fragment{
    View myView;
    private TextView mAffichageCompteur = null;
    private int mCompteur = 0;
    public final static String EXTRA_COMPTEUR = "com.example.kevin.androidproject.CompteurService";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.activity_home,container,false);
        return myView;
    }
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        com.github.barteksc.pdfviewer.PDFView pdfView=(com.github.barteksc.pdfviewer.PDFView) getActivity().findViewById(R.id.pdfView);
        pdfView.fromAsset("edt.pdf")
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(false)
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                .enableAnnotationRendering(false)
                .password(null)
                .scrollHandle(null)
                .load();
        mAffichageCompteur = (TextView) getActivity().findViewById(R.id.affiche_compteur);
    }

}