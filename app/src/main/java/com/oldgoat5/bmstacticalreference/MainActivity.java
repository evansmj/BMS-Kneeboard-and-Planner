package com.oldgoat5.bmstacticalreference;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

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
    private ImageView settingsImageView;
    private ImageView aboutImageView;
    private MainFragmentPageAdapter fragmentPageAdapter;
    private SlidingTabLayout slidingTabLayout;
    private Toolbar toolbar;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.main_activity_toolbar);

        tabsList = new ArrayList<PagerItem>();

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
        aboutImageView = (ImageView) findViewById(R.id.about_icon);
        settingsImageView = (ImageView) findViewById(R.id.settings_icon);

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
}
