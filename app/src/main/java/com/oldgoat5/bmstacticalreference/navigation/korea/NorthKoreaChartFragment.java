package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
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

import androidx.fragment.app.Fragment;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Shows a list of North Korean charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class NorthKoreaChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayList<String> groupsList;
    private Dialog dialog;
    private ExpandableListView listView;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> childrenMap;
    private NavigationChartsExpandableListAdapter adapter;
    private ZoomImageView imageView;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.north_korea_chart_fragment_layout, container, false);

        groupsList = new ArrayList<>();
        childrenMap = new HashMap<>();

        setupLists();

        adapter = new NavigationChartsExpandableListAdapter(
                this.getContext(), groupsList, childrenMap, "north_korea");

        listView = (ExpandableListView) view.findViewById(
                R.id.north_korea_fragment_expandable_list_view);

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
                                        R.drawable.north_korea_airstrips_east_west);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 1:
                                imageView.setImageResource(
                                        R.drawable.north_korea_airstrips_north_south);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                        }
                        break;

                    case 1:
                        imageView.setImageResource(R.drawable.haeju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 2:
                        imageView.setImageResource(R.drawable.hwangju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 3:
                        imageView.setImageResource(R.drawable.hwangsuwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 4:
                        imageView.setImageResource(R.drawable.hyonni_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 5:
                        imageView.setImageResource(R.drawable.iwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 6:
                        imageView.setImageResource(R.drawable.kaechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 7:
                        imageView.setImageResource(R.drawable.koksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 8:
                        imageView.setImageResource(R.drawable.kuumni_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 9:
                        imageView.setImageResource(R.drawable.kwail_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 10:
                        imageView.setImageResource(R.drawable.manpo_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 11:
                        imageView.setImageResource(R.drawable.mirim_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 12:
                        imageView.setImageResource(R.drawable.onchon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 13:
                        imageView.setImageResource(R.drawable.ongjin_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 14:
                        imageView.setImageResource(R.drawable.orang_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 15:
                        imageView.setImageResource(R.drawable.panghyon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 16:
                        imageView.setImageResource(R.drawable.pukchangup_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 17:
                        imageView.setImageResource(R.drawable.samjiyonup_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 18:
                        imageView.setImageResource(R.drawable.sondok_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 19:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.sunan_pyongyang_airport_diagram);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 1:
                                imageView.setImageResource(
                                        R.drawable.sunan_pyongyang_ils_rwy_18);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;
                        }
                        break;

                    case 20:
                        imageView.setImageResource(R.drawable.sunchon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 21:
                        imageView.setImageResource(R.drawable.taechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 22:
                        imageView.setImageResource(R.drawable.taetan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 23:
                        imageView.setImageResource(R.drawable.toksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 24:
                        imageView.setImageResource(R.drawable.uiju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                    case 25:
                        imageView.setImageResource(R.drawable.wonsan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle((String) ((NavigationChartsTuple)
                                adapter.getChild(groupPosition, childPosition)).getTitle());
                        dialog.show();
                        break;

                }

                return false;
            }
        });

        listView.setAdapter(adapter);

        return view;
    }

    /*****************************************************************
     * Sets up array lists and hash maps needed for north korea.
     *****************************************************************/
    private void setupLists()
    {
        NavigationChartsMapProvider provider = new NavigationChartsMapProvider();

        provider.setNorthKorea();

        groupsList = provider.getNorthKoreaAirbaseList();
        childrenMap = provider.getNorthKoreaHashMap();
    }
}