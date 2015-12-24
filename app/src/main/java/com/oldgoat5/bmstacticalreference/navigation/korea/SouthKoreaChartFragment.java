package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ExpandableListView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsExpandableListAdapter;
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
    private HashMap<String, ArrayList<String>> children;
    private NavigationChartsExpandableListAdapter adapter;
    private View view;
    private ZoomImageView imageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.south_korea_chart_fragment_layout, container, false);

//        airbases = new String[]{"East-West Airstrips", "North-South Airstrips",
//                "Chongju Airport Diagram", "Chongju Five Departure",
//                "Chongju ILS RWY 23R", "Chongju TACAN RWY 05L",
//                "Chongju TACAN RWY 05R", "Chongju TACAN RWY 23L",
//                "Chongju Visual Approach", "Choongwon Airport Diagram",
//                "Choongwon One Departure", "Choongwon ILS RWY 34R",
//                "Choongwon TACAN 34L", "Choongwon TACAN RWY 16L",
//                "Choongwon TACAN RWY 16R", "Hoengsong Airport Diagram",
//                "Hoengsong NOTAM", "Hoengsong ILS RWY 36",
//                "Hoengsong Visual RWY 18", "Hoengsong Visual RWY 36",
//                "Kangnung Airport Diagram", "Kangnung Kangwon One Departure",
//                "Kangnung ILS RWY 26", "Kangnung Circle To Land RWY 08",
//                "Kimhae Airport Diagram", "Kimhae Nakdong 3A Departure",
//                "Kimhae Nakdong 4A Departure", "Kimhae ILS RWY 34",
//                "Kimhae TACAN RWY 16", "Kimpo Airport Diagram",
//                "Kimpo 1W & 1E Departure", "Kimpo ILS RWY 14L",
//                "Kimpo ILS RWY 14R", "Kimpo ILS RWY 32L",
//                "Kimpo ILS RWY 32R", "Kunsan Airport Diagram",
//                "Kunsan Aladi One Departure", "Kunsan Coyote Three Departure",
//                "Kunsan Patro Departure", "Kunsan ILS RWY 18",
//                "Kunsan ILS RWY 36", "Kunsan Visual Approach",
//                "Kwangju Airport Diagram", "Kwangju 3A Departure RWY 02",
//                "Kwangju 4A Departure RWY 20", "Kwangju ILS RWY 02",
//                "Kwangju ILS RWY 20", "Mandumi Airport Diagram",
//                "Osan Airport Diagram", "Osan Draggin One Departure",
//                "Osan Jet Yoke Four Departure", "Osan ILS RWY 09",
//                "Osan ILS RWY 27", "Pohang Airport Diagram",
//                "Pohang Posco One Departure", "Pohang ILS RWY 26",
//                "Pohang TACAN RWY 08", "Pusan Airport Diagram",
//                "Pusan Korav North Departure", "Pusan ILS RWY 32",
//                "Pusan TACAN RWY 14", "P`yong`taek Airport Diagram",
//                "P`yong`taek Osan One Departure", "P`yong`taek ILS RWY 34",
//                "P`yong`taek TACAN RWY 16", "Sachon Airport Diagram",
//                "Sachon One Departure", "Sachon ILS RWY 05L",
//                "Sachon ILS RWY 23R", "Sachon TACAN RWY 05R",
//                "Sachon TACAN RWY 23L", "Seosan/Haemi Airport Diagram",
//                "Seosan/Haemi One Departure", "Seosan/Haemi ILS RWY 02R",
//                "Seosan/Haemi TACAN RWY 02L", "Seosan/Haemi TACAN RWY 20L",
//                "Seosan/Haemi TACAN RWY 20R", "Seoul Airport Diagram",
//                "Seoul Noru One Departure", "Seoul ILS RWY 19",
//                "Seoul TACAN RWY 01", "Seoul TACAN RWY 18",
//                "Seoul TACAN RWY 36", "Sokcho Airport Diagram",
//                "Sokcho NOTAM", "Sokcho One Departure",
//                "Sokcho ILS RWY 18", "Sokcho Visual RWY 18",
//                "Sokcho Visual RWY 36", "Suwon Airport Diagram",
//                "Suwon Six Departure", "Suwon ILS RWY 32L",
//                "Suwon TACAN 14L &14R", "Suwon TACAN RWY 32R",
//                "Taegu Airport Diagram", "Taegu Six Departure",
//                "Taegu ILS RWY 32", "Taegu Circle To Land RWY 14",
//                "Yechon Airport Diagram", "Yechon Solty 5A Departure",
//                "Yechon ILS RWY 26", "Yechon TACAN RWY 8"};

        groups = new ArrayList<>();
        children = new HashMap<>();

        setupLists();

        adapter = new NavigationChartsExpandableListAdapter(this.getContext(), groups, children);

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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
        ArrayList<String> airstrips = new ArrayList<>();
        ArrayList<String> kotar = new ArrayList<>();
        ArrayList<String> chongju = new ArrayList<>();
        ArrayList<String> choongwon = new ArrayList<>();
        ArrayList<String> hoengsong = new ArrayList<>();
        ArrayList<String> kangnung = new ArrayList<>();
        ArrayList<String> kimhae = new ArrayList<>();
        ArrayList<String> kimpo = new ArrayList<>();
        ArrayList<String> kunsan = new ArrayList<>();
        ArrayList<String> kwangju = new ArrayList<>();
        ArrayList<String> mandumi = new ArrayList<>();
        ArrayList<String> osan = new ArrayList<>();
        ArrayList<String> pohang = new ArrayList<>();
        ArrayList<String> pusan = new ArrayList<>();
        ArrayList<String> pyongtaek = new ArrayList<>();
        ArrayList<String> sachon = new ArrayList<>();
        ArrayList<String> seosan = new ArrayList<>();
        ArrayList<String> seoul = new ArrayList<>();
        ArrayList<String> sokcho = new ArrayList<>();
        ArrayList<String> suwon = new ArrayList<>();
        ArrayList<String> taegu = new ArrayList<>();
        ArrayList<String> yechon = new ArrayList<>();

        groups.add("Airstrips");
        airstrips.add("East-West Airstrips");
        airstrips.add("North-South Airstrips");
        children.put(groups.get(0), airstrips);

        groups.add("Kotar");
        kotar.add("Kotar Range Diagram");
        kotar.add("Kotar Area Chart");
        kotar.add("Kotar Target List");
        children.put(groups.get(1), kotar);

        groups.add("Chongju Airbase");
        chongju.add("Chongju Airport Diagram");
        chongju.add("Chongju 5 Departure");
        chongju.add("Chongju ILS RWY 23R");
        chongju.add("Chongju TACAN RWY 05L");
        chongju.add("Chongju TACAN RWY 05R");
        chongju.add("Chongju TACAN RWY 23L");
        chongju.add("Chongju Visual Approach");
        children.put(groups.get(2), chongju);

        groups.add("Choongwon Airbase");
        choongwon.add("Choongwon Airport Diagram");
        choongwon.add("Choongwon One Departure");
        choongwon.add("Choongwon ILS RWY 34R");
        choongwon.add("Choongwon TACAN 34L");
        choongwon.add("Choongwon TACAN RWY 16L");
        choongwon.add("Choongwon TACAN RWY 16R");
        children.put(groups.get(3), choongwon);

        groups.add("Hoengsong Airbase");
        hoengsong.add("Hoengsong Airport Diagram");
        hoengsong.add("Hoengsong Wonju 3 Departure");
        hoengsong.add("Hoengsong ILS RWY 02");
        hoengsong.add("Hoengsong TACAN RWY 20");
        children.put(groups.get(4), hoengsong);

        groups.add("Kangnung Airbase");
        kangnung.add("Kangnung Airport Diagram");
        kangnung.add("Kangnung Gangwon 1 Departure");
        kangnung.add("Kangnung ILS RWY 26");
        kangnung.add("Kangnung Circle to Land RWY 08");
        children.put(groups.get(5), kangnung);

        groups.add("Kimhae Airbase");
        kimhae.add("Kimhae Airport Diagram");
        kimhae.add("Kimhae Nakdong 3A Departure");
        kimhae.add("Kimhae Nakdong 4A Departure");
        kimhae.add("Kimhae ILS RWY 34");
        kimhae.add("Kimhae TACAN RWY 16");
        children.put(groups.get(6), kimhae);

        groups.add("Kimpo Airbase");
        kimpo.add("Kimpo Airport Diagram");
        kimpo.add("Kimpo 1W&1E Departure");
        kimpo.add("Kimpo ILS RWY 14L");
        kimpo.add("Kimpo ILS RWY 14R");
        kimpo.add("Kimpo ILS RWY 32L");
        kimpo.add("Kimpo ILS RWY 32R");
        children.put(groups.get(7), kimpo);

        groups.add("Kunsan Airbase");
        kunsan.add("Kunsan Airport Diagram");
        kunsan.add("Kunsan Parking");
        kunsan.add("Kunsan Aladi One Departure");
        kunsan.add("Kunsan Coyote Three Departure");
        kunsan.add("Kunsan Patro Departure");
        kunsan.add("Kunsan Alternate Runway");
        kunsan.add("Kunsan ILS RWY 18");
        kunsan.add("Kunsan ILS RWY 36");
        kunsan.add("Kunsan Visual Approach");
        children.put(groups.get(8), kunsan);

        groups.add("Kwangju Airbase");
        kwangju.add("Kwangju Airport Diagram");
        kwangju.add("Kwangju 3A Departure");
        kwangju.add("Kwangju 4A Departure");
        kwangju.add("Kwangju ILS RWY 02");
        kwangju.add("Kwangju ILS RWY 20");
        children.put(groups.get(9), kwangju);

        groups.add("Mandumi Airstrip");
        mandumi.add("Mandumi Airport Diagram");
        children.put(groups.get(10), mandumi);

        groups.add("Osan Airbase");
        osan.add("Osan Airport Diagram");
        osan.add("Osan Draggin 1 Departure");
        osan.add("Osan Jet Yoke 4 Departure");
        osan.add("Osan ILS RWY 09");
        osan.add("Osan ILS RWY 27");
        children.put(groups.get(11), osan);

        groups.add("Pohang Airbase");
        pohang.add("Pohang Airport Diagram");
        pohang.add("Pohang Posco 1 Departure");
        pohang.add("Pohang ILS RWY 26");
        pohang.add("Pohang TACAN RWY 08");
        children.put(groups.get(12), pohang);

        groups.add("Pusan Airbase");
        pusan.add("Pusan Airport Diagram");
        pusan.add("Pusan Korav North Departure");
        pusan.add("Pusan ILS RWY 32");
        pusan.add("Pusan TACAN RWY 14");
        children.put(groups.get(13), pusan);

        groups.add("P`yong`taek Airbase");
        pyongtaek.add("P`yong`taek Osan 1 Departure");
        pyongtaek.add("P`yong`taek ILS RWY 34");
        pyongtaek.add("P`yong`taek TACAN RWY 16");
        children.put(groups.get(14), pyongtaek);

        groups.add("Sachon Airbase");
        sachon.add("Sachon 1 Departure");
        sachon.add("Sachon ILS RWY 05L");
        sachon.add("Sachon ILS RWY 23R");
        sachon.add("Sachon TACAN RWY 05R");
        sachon.add("Sachon TACAN RWY 23L");
        children.put(groups.get(15), sachon);

        groups.add("Seosan (Haemi) Airbase");
        seosan.add("Seosan (Haemi) Airport Diagram");
        seosan.add("Seosan (Haemi) 1 Departure");
        seosan.add("Seosan (Haemi) ILS RWY 02R");
        seosan.add("Seosan (Haemi) TACAN RWY 02L");
        seosan.add("Seosan (Haemi) TACAN RWY 20L");
        seosan.add("Seosan (Haemi) TACAN RWY 20R");
        children.put(groups.get(16), seosan);

        groups.add("Seoul Airbase");
        seoul.add("Seoul Airport Diagram");
        seoul.add("Seoul Hatch 1 Departure");
        seoul.add("Seoul Noru 1 Departure");
        seoul.add("Seoul ILS RWY 19");
        seoul.add("Seoul TACAN RWY 01");
        seoul.add("Seoul TACAN RWY 18");
        seoul.add("Seoul TACAN RWY 36");
        children.put(groups.get(17), seoul);

        groups.add("Sokcho Airbase");
        sokcho.add("Sokcho Airport Diagram");
        sokcho.add("Sokcho 1 Departure");
        sokcho.add("Sokcho ILS RWY 18");
        sokcho.add("Sokcho Visual RWY 18");
        sokcho.add("Sokcho Visual RWY 36");
        children.put(groups.get(18), sokcho);

        groups.add("Suwon Airbase");
        suwon.add("Suwon Airport Diagram");
        suwon.add("Suwon 6 Departure");
        suwon.add("Suwon ILS RWY 32L");
        suwon.add("Suwon TACAN 14L&14R");
        suwon.add("Suwon TACAN RWY 32R");
        children.put(groups.get(19), suwon);

        groups.add("Taegu Airbase");
        taegu.add("Taegu Airport Diagram");
        taegu.add("Taegu 6 Departure");
        taegu.add("Taegu ILS RWY 32");
        taegu.add("Taegu Circle to Land RWY 14");
        children.put(groups.get(20), taegu);

        groups.add("Yechon Airbase");
        yechon.add("Yechon Airport Diagram");
        yechon.add("Yechon Parot 5A Departure");
        yechon.add("Yechon ILS RWY 26");
        yechon.add("Yechon TACAN RWY 08");
        children.put(groups.get(21), yechon);
    }
}
