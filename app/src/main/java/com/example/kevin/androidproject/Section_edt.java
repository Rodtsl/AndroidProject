package com.example.kevin.androidproject;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by kevin on 09/02/2017.
 */

public class Section_edt extends Fragment{
    View myView;

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        myView = inflater.inflate(R.layout.activity_section_edt,container,false);
        return myView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        expListView = (ExpandableListView) getActivity().findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();
        Log.v("ListAdaptater", "no create");

        listAdapter = new com.example.kevin.androidproject.ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);
        Log.v("ListAdaptater", "create");

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Janvier");
        listDataHeader.add("Fevrier");
        listDataHeader.add("Mars");
        listDataHeader.add("Avril");
        listDataHeader.add("Mai");
        listDataHeader.add("Juin");
        listDataHeader.add("Juillet");
        listDataHeader.add("Aout");
        listDataHeader.add("Septembre");
        listDataHeader.add("Octobre");
        listDataHeader.add("Novembre");
        listDataHeader.add("Decembre");


        // Adding child data
        List<String> Janvier = new ArrayList<String>();
        Janvier.add("EDT Semaine 1");
        Janvier.add("EDT Semaine 2");
        Janvier.add("EDT Semaine 3");
        Janvier.add("EDT Semaine 4");

        List<String> Fevrier = new ArrayList<String>();
        Fevrier.add("EDT Semaine 5");
        Fevrier.add("EDT Semaine 6");
        Fevrier.add("EDT Semaine 7");
        Fevrier.add("EDT Semaine 8");

        List<String> Mars = new ArrayList<String>();
        Mars.add("EDT Semaine 9");
        Mars.add("EDT Semaine 10");
        Mars.add("EDT Semaine 11");
        Mars.add("EDT Semaine 12");

        List<String> Avril = new ArrayList<String>();
        Avril.add("EDT Semaine 13");
        List<String> Mai = new ArrayList<String>();
        Mai.add("EDT Semaine 14");
        List<String> Juin = new ArrayList<String>();
        Juin.add("EDT Semaine 15");
        List<String> Juillet = new ArrayList<String>();
        Juillet.add("EDT Semaine 16");
        List<String> Aout = new ArrayList<String>();
        Aout.add("EDT Vacances");
        List<String> Septembre = new ArrayList<String>();
        Septembre.add("EDT Vacances");
        List<String> Octobre = new ArrayList<String>();
        Octobre.add("EDT Vacances");
        List<String> Novembre = new ArrayList<String>();
        Novembre.add("EDT Vacances");
        List<String> Decembre = new ArrayList<String>();
        Decembre.add("EDT Noel");

        listDataChild.put(listDataHeader.get(0), Janvier); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Fevrier);
        listDataChild.put(listDataHeader.get(2), Mars);
        listDataChild.put(listDataHeader.get(3), Avril);
        listDataChild.put(listDataHeader.get(4), Mai);
        listDataChild.put(listDataHeader.get(5), Juin);
        listDataChild.put(listDataHeader.get(6), Juillet);
        listDataChild.put(listDataHeader.get(7), Aout);
        listDataChild.put(listDataHeader.get(8), Septembre);
        listDataChild.put(listDataHeader.get(9), Octobre);
        listDataChild.put(listDataHeader.get(10), Novembre);
        listDataChild.put(listDataHeader.get(11),Decembre);

    }


}
