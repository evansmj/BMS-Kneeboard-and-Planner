package com.oldgoat5.bmstacticalreference.navigation.aegean;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.slidingtabs.PagerItem;
import com.oldgoat5.bmstacticalreference.slidingtabs.SlidingTabLayout;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 8/29/2015
 *********************************************************************/
public class AegeanNavigationActivity extends FragmentActivity
{
    private ArrayList<PagerItem> tabsList;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aegean_navigation_activity_layout);

        Log.d("aegeannav", "inside onCreate()");

        tabsList = new ArrayList<PagerItem>();

        tabsList.add(new PagerItem("Cyprus", Color.CYAN, Color.GRAY));
        tabsList.add(new PagerItem("Greece", Color.GREEN, Color.GRAY));
        tabsList.add(new PagerItem("Turkiye", Color.YELLOW, Color.GRAY));

        viewPager = (ViewPager) findViewById(R.id.aegean_navigation_pager);
        viewPager.setAdapter(new AegeanNavigationFragmentPageAdapter(getSupportFragmentManager(),
                AegeanNavigationActivity.this));

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.aegean_sliding_tabs);
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
}
