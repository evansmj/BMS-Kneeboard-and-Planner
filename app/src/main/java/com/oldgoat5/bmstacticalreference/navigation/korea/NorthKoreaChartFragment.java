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
    private HashMap<String, ArrayList<String>> childrenMap;
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
                this.getContext(), groupsList, childrenMap);

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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                        dialog.setTitle(adapter.getGroup(groupPosition).toString());
                        dialog.show();
                        break;

                    case 2:
                        imageView.setImageResource(R.drawable.hwangju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getGroup(groupPosition).toString());
                        dialog.show();
                        break;

                    case 3:
                        imageView.setImageResource(R.drawable.hwangsuwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getGroup(groupPosition).toString());
                        dialog.show();
                        break;

                    case 4:
                        imageView.setImageResource(R.drawable.hyonni_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getGroup(groupPosition).toString());
                        dialog.show();
                        break;

                    case 5:
                        imageView.setImageResource(R.drawable.iwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 6:
                        imageView.setImageResource(R.drawable.kaechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 7:
                        imageView.setImageResource(R.drawable.koksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 8:
                        imageView.setImageResource(R.drawable.kuumni_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 9:
                        imageView.setImageResource(R.drawable.kwail_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 10:
                        imageView.setImageResource(R.drawable.manpo_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 11:
                        imageView.setImageResource(R.drawable.mirim_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 12:
                        imageView.setImageResource(R.drawable.onchon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 13:
                        imageView.setImageResource(R.drawable.ongjin_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 14:
                        imageView.setImageResource(R.drawable.orang_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 15:
                        imageView.setImageResource(R.drawable.panghyon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 16:
                        imageView.setImageResource(R.drawable.pukchangup_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 17:
                        imageView.setImageResource(R.drawable.samjiyonup_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 18:
                        imageView.setImageResource(R.drawable.sondok_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                                dialog.setTitle(
                                        adapter.getChild(groupPosition, childPosition).toString());
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
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 21:
                        imageView.setImageResource(R.drawable.taechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 22:
                        imageView.setImageResource(R.drawable.taetan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 23:
                        imageView.setImageResource(R.drawable.toksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 24:
                        imageView.setImageResource(R.drawable.uiju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
                        dialog.show();
                        break;

                    case 25:
                        imageView.setImageResource(R.drawable.wonsan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(adapter.getChild(groupPosition, childPosition).toString());
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
        /*airbases = new String[]{"East-West Airstrips", "North-South Airstrips",
                "Haeju Airport Diagram", "Hwangju Airport Diagram",
                "Hwangsuwon Airport Diagram", "Hyon-Ni Airport Diagram",
                "Iwon Airport Diagram", "Kaech`on Airport Diagram",
                "Koksan Airport Diagram", "Kuum-ni Airport Diagram",
                "Kwail Airport Diagram", "Manp`o Airport Diagram", "Mirim Airport Diagram",
                "Onch`on Airport Diagram", "Ongjin Airport Diagram", "Orang Airport Diagram",
                "Panghyon Airport Diagram", "Pukch`ang-up Airport Diagram",
                "Samjiyon-up Airport Diagram", "Sondok Airport Diagram",
                "Sunan (Pyongyang) Airport Diagram", "Sunch`on Airport Diagram",
                "T`aech`on Airport Diagram", "Taetan Airport Diagram", "Toksan Airport Diagram",
                "Uiju Airport Diagram", "Wonsan Airport Diagram"};*/
        ArrayList<String> airstrips = new ArrayList<>();
        ArrayList<String> haeju = new ArrayList<>();
        ArrayList<String> hwangju = new ArrayList<>();
        ArrayList<String> hwangsuwon = new ArrayList<>();
        ArrayList<String> hyonni = new ArrayList<>();
        ArrayList<String> iwon = new ArrayList<>();
        ArrayList<String> kaechon = new ArrayList<>();
        ArrayList<String> koksan = new ArrayList<>();
        ArrayList<String> kuumni = new ArrayList<>();
        ArrayList<String> kwail = new ArrayList<>();
        ArrayList<String> manpo = new ArrayList<>();
        ArrayList<String> mirim = new ArrayList<>();
        ArrayList<String> onchon = new ArrayList<>();
        ArrayList<String> ongjin = new ArrayList<>();
        ArrayList<String> orang = new ArrayList<>();
        ArrayList<String> panghyon = new ArrayList<>();
        ArrayList<String> pukchangup = new ArrayList<>();
        ArrayList<String> samjiyonup = new ArrayList<>();
        ArrayList<String> sondok = new ArrayList<>();
        ArrayList<String> sunan = new ArrayList<>();
        ArrayList<String> sunchon = new ArrayList<>();
        ArrayList<String> taechon = new ArrayList<>();
        ArrayList<String> taetan = new ArrayList<>();
        ArrayList<String> toksan = new ArrayList<>();
        ArrayList<String> uiju = new ArrayList<>();
        ArrayList<String> wonsan = new ArrayList<>();

        groupsList.add("Airstrips");
        airstrips.add("East-West Airstrips");
        airstrips.add("North-South Airstrips");
        childrenMap.put(groupsList.get(0), airstrips);

        groupsList.add("Haeju Airbase");
        haeju.add("Haeju Airport Diagram");
        childrenMap.put(groupsList.get(1), haeju);

        groupsList.add("Hwangju Airbase");
        hwangju.add("Hwangju Airport Diagram");
        childrenMap.put(groupsList.get(2), hwangju);

        groupsList.add("Hwangsuwon Airbase");
        hwangsuwon.add("Hwangsuwon Airport Diagram");
        childrenMap.put(groupsList.get(3), hwangsuwon);

        groupsList.add("Hyon-Ni Airbase");
        hyonni.add("Hyon-Ni Airport Diagram");
        childrenMap.put(groupsList.get(4), hyonni);

        groupsList.add("Iwon Airbase");
        iwon.add("Iwon Airport Diagram");
        childrenMap.put(groupsList.get(5), iwon);

        groupsList.add("Kaech`on Airbase");
        kaechon.add("Kaech`on Airport Diagram");
        childrenMap.put(groupsList.get(6), kaechon);

        groupsList.add("Koksan Airbase");
        koksan.add("Koksan Airport Diagram");
        childrenMap.put(groupsList.get(7), koksan);

        groupsList.add("Kuum-ni Airbase");
        kuumni.add("Kuum-ni Airport Diagram");
        childrenMap.put(groupsList.get(8), kuumni);

        groupsList.add("Kwail Airbase");
        kwail.add("Kwail Airport Diagram");
        childrenMap.put(groupsList.get(9), kwail);

        groupsList.add("Manp`o Airbase");
        manpo.add("Manp`o Airport Diagram");
        childrenMap.put(groupsList.get(10), manpo);

        groupsList.add("Mirim Airbase");
        mirim.add("Mirim Airport Diagram");
        childrenMap.put(groupsList.get(11), mirim);

        groupsList.add("Onch`on Airbase");
        onchon.add("Onch`on Airport Diagram");
        childrenMap.put(groupsList.get(12), onchon);

        groupsList.add("Ongjin Airbase");
        ongjin.add("Ongjin Airport Diagram");
        childrenMap.put(groupsList.get(13), ongjin);

        groupsList.add("Orang Airbase");
        orang.add("Orang Airport Diagram");
        childrenMap.put(groupsList.get(14), orang);

        groupsList.add("Panghyon Airbase");
        panghyon.add("Panghyon Airport Diagram");
        childrenMap.put(groupsList.get(15), panghyon);

        groupsList.add("Pukch`ang-up Airbase");
        pukchangup.add("Pukch`ang-up Airport Diagram");
        childrenMap.put(groupsList.get(16), pukchangup);

        groupsList.add("Samjiyon-up Airbase");
        samjiyonup.add("Samjiyon-up Airport Diagram");
        childrenMap.put(groupsList.get(17), samjiyonup);

        groupsList.add("Sondok Airbase");
        sondok.add("Sondok Airport Diagram");
        childrenMap.put(groupsList.get(18), sondok);

        groupsList.add("Sunan (Pyongyang) Airbase");
        sunan.add("Sunan (Pyongyang) Airport Diagram");
        sunan.add("Sunan (Pyongyang) ILS RWY 18");
        childrenMap.put(groupsList.get(19), sunan);

        groupsList.add("Sunch`on Airbase");
        sunchon.add("Sunch`on Airport Diagram");
        childrenMap.put(groupsList.get(20), sunchon);

        groupsList.add("T`aech`on Airbase");
        taechon.add("T`aech`on Airport Diagram");
        childrenMap.put(groupsList.get(21), taechon);

        groupsList.add("Taetan Airbase");
        taetan.add("Taetan Airport Diagram");
        childrenMap.put(groupsList.get(22), taetan);

        groupsList.add("Toksan Airbase");
        toksan.add("Toksan Airport Diagram");
        childrenMap.put(groupsList.get(23), toksan);

        groupsList.add("Uiju Airbase");
        uiju.add("Uiju Airport Diagram");
        childrenMap.put(groupsList.get(24), uiju);

        groupsList.add("Wonsan Airbase");
        wonsan.add("Wonsan Airport Diagram");
        childrenMap.put(groupsList.get(25), wonsan);
    }
}