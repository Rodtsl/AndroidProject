package com.example.leopoldrodts.androidproject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;

public class SectionEDT extends Activity {

    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section_edt);

        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        prepareListData();

        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expListView.setAdapter(listAdapter);
    }

    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Janvier");
        listDataHeader.add("Fevrier");
        listDataHeader.add("Mars");

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


        listDataChild.put(listDataHeader.get(0), Janvier); // Header, Child data
        listDataChild.put(listDataHeader.get(1), Fevrier);
        listDataChild.put(listDataHeader.get(2), Mars);
    }
}