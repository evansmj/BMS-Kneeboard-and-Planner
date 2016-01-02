package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsExpandableListAdapter;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsMapProvider;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsTuple;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

import java.util.ArrayList;
import java.util.HashMap;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 * <p/>
 * Shows a list of Japanese charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class JapanKoreaChartFragment extends Fragment
{
    private Context CONTEXT;

    private ArrayList<String> groups;
    private Dialog dialog;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> children;
    private ExpandableListView listView;
    private NavigationChartsExpandableListAdapter adapter;
    private View view;
    private ZoomImageView imageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.japan_korea_chart_fragment_layout, container, false);

        groups = new ArrayList<>();
        children = new HashMap<>();

        setupLists();

        adapter = new NavigationChartsExpandableListAdapter(this.getContext(), groups, children,
                "japan_korea");
        listView = (ExpandableListView) view.findViewById(
                R.id.japan_korea_fragment_expandable_list_view);

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
                switch (groupPosition)
                {
                    case 0:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_airport_diagram);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                        groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 1:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                                groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_adiz_crossing);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                                groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_ils_rwy_01);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                                groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_ils_rwy_19);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                                groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_tacan_rwy_15);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                                groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 6:
                                imageView.setImageResource(
                                        R.drawable.fukuoka_kadena_tacan_rwy_33);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(
                                                groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;
                        }
                        break;
                }
                return false;
            }
        });

        listView.setAdapter(adapter);

        return view;
    }

    /*****************************************************************
     * Sets up array lists and hash maps needed for Japan.
     *****************************************************************/
    private void setupLists()
    {
        NavigationChartsMapProvider provider = new NavigationChartsMapProvider();

        provider.setJapanKorea();
        groups = provider.getJapanKoreaAirbaseList();
        children = provider.getJapanKoreaHashMap();

        /* ArrayList<String> fukuoka = new ArrayList<>();

        groups.add("Fukuoka (Kadena) Airbase");
        fukuoka.add("Fukuoka (Kadena) Airport Diagram");
        fukuoka.add("Fukuoka (Kadena) Departure");
        fukuoka.add("Fukuoka (Kadena) ADIZ Crossing");
        fukuoka.add("Fukuoka (Kadena) ILS RWY 01");
        fukuoka.add("Fukuoka (Kadena) ILS RWY 19");
        fukuoka.add("Fukuoka (Kadena) TACAN RWY 15");
        fukuoka.add("Fukuoka (Kadena) TACAN RWY 33");

        children.put(groups.get(0), fukuoka);*/
    }
}
