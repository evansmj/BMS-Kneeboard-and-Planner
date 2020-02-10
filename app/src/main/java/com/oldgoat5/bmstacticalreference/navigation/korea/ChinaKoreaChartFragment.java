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
 * Shows a list of Chinese charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class ChinaKoreaChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayList<String> groups;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> children;
    private NavigationChartsExpandableListAdapter adapter;
    private Dialog dialog;
    private ZoomImageView imageView;
    private ExpandableListView listView;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.china_korea_chart_fragment_layout, container, false);

        groups = new ArrayList<>();
        children = new HashMap<>();

        setupLists();

        //airbases = new String[] {"Liuhe Airport Diagram", "Shenyang Airport Diagram"};

        adapter = new NavigationChartsExpandableListAdapter(this.getContext(), groups, children,
                "china_korea");
        listView = (ExpandableListView) view.findViewById(
                R.id.china_korea_fragment_expandable_list_view);

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
            public boolean onChildClick(ExpandableListView parent, View view,
                                     int groupPosition, int childPosition, long id)
            {
                switch (groupPosition)
                {
                    case 0:
                        switch (childPosition)
                        {
                            case 0:
                                imageView.setImageResource(R.drawable.liuhe_airport_diagram);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
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
                                imageView.setImageResource(R.drawable.shenyang_airport_diagram);
                                dialog.setContentView(imageView);
                                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                        WindowManager.LayoutParams.MATCH_PARENT);
                                dialog.setCanceledOnTouchOutside(false);
                                dialog.setTitle((String) ((NavigationChartsTuple)
                                        adapter.getChild(groupPosition, childPosition)).getTitle());
                                dialog.show();
                                break;
                        }
                        break;
                }
                // Return true to consume the click event. In this case the
                // onListItemClick listener is not called anymore.
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

        provider.setChinaKorea();
        groups = provider.getChinaKoreaAirbaseList();
        children = provider.getChinaKoreaHashMap();
    }
}
