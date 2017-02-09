package com.example.kevin.androidproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by kevin on 09/02/2017.
 */

public class Section_2A extends Fragment{
    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.activity_section_2a,container,false);

        return myView;
    }
    private ListView Edt2A;
    public String[] NomEdt= new String[]{
            "EdtS1","EdtS2"
    };
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        Edt2A=(ListView)getActivity().findViewById(R.id.ListEDT2A);
        ArrayAdapter<String> adaptater=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,NomEdt);
        Edt2A.setAdapter(adaptater);
    }
}
