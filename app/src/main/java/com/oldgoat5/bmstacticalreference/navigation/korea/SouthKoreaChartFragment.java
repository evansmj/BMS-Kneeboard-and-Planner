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
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsTuple;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsExpandableListAdapter;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsMapProvider;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

import java.util.ArrayList;
import java.util.HashMap;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Shows a list of South Korean charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class SouthKoreaChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayList<String> groups;
    private Dialog dialog;
    private ExpandableListView listView;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> children;
    private NavigationChartsExpandableListAdapter adapter;
    private View view;
    private ZoomImageView imageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.south_korea_chart_fragment_layout, container, false);

        groups = new ArrayList<>();
        children = new HashMap<>();

        setupLists();

        adapter = new NavigationChartsExpandableListAdapter(this.getContext(), groups, children,
                "south_korea");

        listView = (ExpandableListView) view.findViewById(
                R.id.south_korea_fragment_expandable_list_view);

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
                                        R.drawable.south_korea_airstrips_east_west);
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
                                        R.drawable.south_korea_airstrips_north_south);
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
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.kotar_range_diagram);
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
                                        R.drawable.kotar_area_chart);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.kotar_target_list);
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

                    case 2:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.chongju_airport_diagram);
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
                                        R.drawable.chongju_five_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.chongju_ils_rwy_23r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.chongju_tacan_rwy_05l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.chongju_tacan_rwy_05r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.chongju_tacan_rwy_23l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 6:
                                imageView.setImageResource(
                                        R.drawable.chongju_visual_approach);
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

                    case 3:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.choongwon_airport_diagram);
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
                                        R.drawable.choongwon_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.choongwon_ils_rwy_34r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.choongwon_tacan_rwy_34l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.choongwon_tacan_rwy_16l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.choongwon_tacan_rwy_16r);
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

                    case 4:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.hoengsong_airport_diagram);
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
                                        R.drawable.hoengsong_wonju_four_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.hoengsong_ils_rwy_02);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.hoengsong_tacan_rwy_20);
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

                    case 5:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.kangnung_airport_diagram);
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
                                        R.drawable.kangnung_gangwon_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.kangnung_ils_rwy_26);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.kangnung_circle_to_land_rwy_08);
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

                    case 6:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.kimhae_airport_diagram);
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
                                        R.drawable.kimhae_nakdong_3a_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.kimhae_nakdong_4a_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.kimhae_ils_rwy_34);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.kimhae_tacan_rwy_16);
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

                    case 7:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.kimpo_airport_diagram);
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
                                        R.drawable.kimpo_1w_1e_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.kimpo_ils_rwy_14l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.kimpo_ils_rwy_14r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.kimpo_ils_rwy_32l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.kimpo_ils_rwy_32r);
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

                    case 8:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.kunsan_airport_diagram);
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
                                        R.drawable.kunsan_spawn_points);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.kunsan_aladi_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.kunsan_coyote_3_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.kunsan_patro_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.kunsan_alternate_runway);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 6:
                                imageView.setImageResource(
                                        R.drawable.kunsan_ils_rwy_18);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 7:
                                imageView.setImageResource(
                                        R.drawable.kunsan_ils_rwy_36);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 8:
                                imageView.setImageResource(
                                        R.drawable.kunsan_visual_18_36);
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

                    case 9:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.kwangju_airport_diagram);
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
                                        R.drawable.kwangju_3a_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.kwangju_4a_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.kwangju_ils_rwy_02);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.kwangju_ils_rwy_20);
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

                    case 10:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.mandumi_airstrip_diagram);
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

                    case 11:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.osan_airport_diagram);
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
                                        R.drawable.osan_draggin_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.osan_jet_yoke_4_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.osan_ils_rwy_09);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.osan_ils_rwy_27);
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

                    case 12:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.pohang_airport_diagram);
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
                                        R.drawable.pohang_posco_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.pohang_ils_rwy_26);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.pohang_tacan_rwy_08);
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

                    case 13:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.pusan_airport_diagram);
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
                                        R.drawable.pusan_korav_north_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.pusan_ils_rwy_32);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.pusan_tacan_rwy_14);
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

                    case 14:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.pyongtaek_airport_diagram);
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
                                        R.drawable.pyongtaek_osan_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.pyongtaek_ils_rwy_34);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.pyongtaek_tacan_rwy_16);
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

                    case 15:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.sachon_airport_diagram);
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
                                        R.drawable.sachon_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.sachon_ils_rwy_05l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.sachon_ils_rwy_23r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.sachon_tacan_rwy_05r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.sachon_tacan_rwy_23l);
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

                    case 16:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.seosan_haemi_airport_diagram);
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
                                        R.drawable.seosan_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.seosan_haemi_ils_rwy_02r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.seosan_haemi_hi_tacan_rwy_02l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.seosan_haemi_hi_tacan_rwy_20l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.seosan_haemi_hi_tacan_rwy_20r);
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

                    case 17:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.seoul_airport_diagram);
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
                                        R.drawable.seoul_hatch_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.seoul_noru_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.seoul_ils_rwy_19);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.seoul_tacan_rwy_01);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 5:
                                imageView.setImageResource(
                                        R.drawable.seoul_tacan_rwy_18);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 6:
                                imageView.setImageResource(
                                        R.drawable.seoul_tacan_rwy_36);
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

                    case 18:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.sokcho_airport_diagram);
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
                                        R.drawable.sokcho_1_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.sokcho_ils_rwy_26);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.sokcho_circle_to_land_rwy_08);
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

                    case 19:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.suwon_airport_diagram);
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
                                        R.drawable.suwon_suwon_6_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.suwon_ils_rwy_32l);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.suwon_tacan_rwy_14l_14r);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 4:
                                imageView.setImageResource(
                                        R.drawable.suwon_tacan_rwy_32r);
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
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.taegu_airport_diagram);
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
                                        R.drawable.taegu_taegu_6_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.taegu_ils_rwy_32);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.taegu_circle_to_land_rwy_14);
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

                    case 21:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(
                                        R.drawable.yechon_airport_diagram);
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
                                        R.drawable.yechon_parot_5a_departure);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 2:
                                imageView.setImageResource(
                                        R.drawable.yechon_ils_rwy_26);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(
                                        WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;

                            case 3:
                                imageView.setImageResource(
                                        R.drawable.yechon_tacan_rwy_08);
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

        provider.setSouthKorea();

        groups = provider.getSouthKoreaAirbaseList();
        children = provider.getSouthKoreaHashMap();
    }
}
