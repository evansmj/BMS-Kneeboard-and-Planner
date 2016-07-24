package com.oldgoat5.bmstacticalreference;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

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
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
        todo
            case R.id.action_settings:
                startSettingsActivity();
                return true;

            case R.id.action_about:
                startAboutActivity();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }*/

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
