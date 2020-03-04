package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.graphics.Color;
import android.os.Bundle;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.PagerItem;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.SlidingTabLayout;

import java.util.ArrayList;

import androidx.fragment.app.FragmentActivity;
import androidx.viewpager.widget.ViewPager;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 5/8/2015
 *********************************************************************/
public class KoreaNavigationActivity extends FragmentActivity //implements ActionBar.TabListener
{
    private ArrayList<PagerItem> tabsList;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea_navigation_activity_layout);

        tabsList = new ArrayList<PagerItem>();

        tabsList.add(new PagerItem("South Korea", Color.BLUE, Color.GRAY));
        tabsList.add(new PagerItem("North Korea", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Japan", Color.GRAY, Color.GRAY));
        tabsList.add(new PagerItem("China",Color.GRAY, Color.GRAY));
        tabsList.add(new PagerItem("Russia", Color.GRAY, Color.GRAY));

        viewPager = (ViewPager) findViewById(R.id.korea_navigation_pager);
        viewPager.setAdapter(new KoreaNavigationFragmentPageAdapter(getSupportFragmentManager(),
                KoreaNavigationActivity.this));

        //fragmentPageAdapter = new KoreaNavigationFragmentPageAdapter(getSupportFragmentManager());

        //sliding tab layout
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.korea_sliding_tabs);
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

        //actionBar = getActionBar();

        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        /*actionBar.addTab(actionBar.newTab().setText(
                "South Korea").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "North Korea").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "Japan").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "China").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "Russia").setTabListener(this));  */

        /*viewPager.setAdapter(fragmentPageAdapter);


        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageSelected(int arg0)
            {
                actionBar.setSelectedNavigationItem(arg0);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2)
            {
            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
            }
        });*/

        //Toast toast = Toast.makeText(this, "Long Press for Chart", Toast.LENGTH_LONG);
        //toast.show();
    }

    /*@Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {
            viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction)
    {

    }*/
}
