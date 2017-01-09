package com.oldgoat5.bmstacticalreference;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.tools.slidingtabs.PagerItem;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.SlidingTabLayout;

import java.util.ArrayList;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 ********************************************************************/
public class MainActivity extends FragmentActivity
{
    int grossWeight;
    int totalDrag;

    private ArrayList<PagerItem> tabsList;
    private DrawerLayout drawerLayout;
    private ImageView drawerToggle;
    private ImageView settingsImageView;
    private ImageView aboutImageView;
    private ListView drawerListView;
    private MainFragmentPageAdapter fragmentPageAdapter;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabsList = new ArrayList<>();

        tabsList.add(new PagerItem("Load Card",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Tactical Reference",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Reference",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Fuel Calculator",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Navigation",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Mission Planner",
                getResources().getColor(R.color.silver), Color.GRAY));

        viewPager = (ViewPager) findViewById(R.id.main_pager);
        viewPager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(),
                MainActivity.this));

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.main_sliding_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setTabTitleTextColor("#D5DADD");
        slidingTabLayout.setViewPager(viewPager);

        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {
            @Override
            public int getIndicatorColor(int position)
            {
                return tabsList.get(position).getIndicatorColor();
            }

            public int getDividerColor(int position)
            {
                return tabsList.get(position).getDividerColor();
            }
        });

        setListeners();
    }

    private void setListeners()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.left_drawer);

        drawerToggle = (ImageView) findViewById(R.id.drawer_toggle);
        aboutImageView = (ImageView) findViewById(R.id.about_icon);
        settingsImageView = (ImageView) findViewById(R.id.settings_icon);

        drawerLayout.setScrimColor(
                ContextCompat.getColor(getApplicationContext(), R.color.steamed_glass));

        drawerListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toggleDrawer();
            }
        });

        aboutImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startAboutActivity();
            }
        });

        settingsImageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startSettingsActivity();
            }
        });
    }

    private void selectItem(int position) {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
        }
    }

    private void startAboutActivity()
    {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    private void startSettingsActivity()
    {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }

    private void toggleDrawer()
    {
        if (drawerLayout == null)
        {
            return;
        }

        if (drawerLayout.isDrawerVisible(drawerListView))
        {
            drawerLayout.closeDrawer(drawerListView);
        }
        else
        {
            drawerLayout.openDrawer(drawerListView);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            selectItem(position);
        }
    }
}
