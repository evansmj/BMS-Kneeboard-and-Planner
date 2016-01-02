package com.oldgoat5.bmstacticalreference.navigation.aegean;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsExpandableListAdapter;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsTuple;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 8/30/2015
 *********************************************************************/
public class CyprusAegeanChartFragment extends Fragment
{
    Context CONTEXT;

    private Dialog dialog;
    private ExpandableListView listView;
    private NavigationChartsExpandableListAdapter listAdapter;
    private ArrayList<String> airbases;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> charts;
    private View view;
    private ZoomImageView imageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.cyprus_aegean_chart_fragment_layout, container, false);

        airbases = new ArrayList<>();
        charts = new HashMap<>();

        /*setupLists();

        listAdapter = new NavigationChartsExpandableListAdapter(getContext(), airbases, charts);
        listView = (ExpandableListView) view.findViewById(
                R.id.cyprus_aegean_fragment_expandable_list_view);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        dialog = new Dialog(CONTEXT);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        imageView = new ZoomImageView(CONTEXT);

        listView.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
        {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id)
            {
                Log.d("ExpandableListAdapter",
                        "onChildClick() g " + groupPosition + "c" + childPosition);
                switch (groupPosition)
                {
                    case 0:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(R.drawable.pafos_airport_diagram);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle(
                                        listAdapter.getChild(groupPosition, childPosition).toString());
                                dialog.show();
                                break;
                            case 1:
                                imageView.setImageResource(R.drawable.pafos_ils_dme_rwy_29);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle(
                                        listAdapter.getChild(groupPosition, childPosition).toString());
                                dialog.show();
                                break;
                        }
                        break;
                }
                return false;
            }
        });*/

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

                switch (position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.pafos_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.pafos_ils_dme_rwy_29);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                }
                // Return true to consume the click event. In this case the
                // onListItemClick listener is not called anymore.
                //return false;
            }
        });*/

        listView.setAdapter(listAdapter);

        return view;
    }

    /*****************************************************************
     * Sets up the lists and hash maps for the expandable list view.
     *****************************************************************/
    private void setupLists()
    {
        airbases.add("Pafos Airbase");
        ArrayList<String> pafos = new ArrayList<>();

        pafos.add("Pafos Airport Diagram");
        pafos.add("Pafos ILS/DME RWY 29");
        //charts.put(airbases.get(0), pafos);
    }
}
