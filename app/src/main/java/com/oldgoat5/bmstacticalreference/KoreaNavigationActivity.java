package com.oldgoat5.bmstacticalreference;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.Notification;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

/*********************************************************************
 * @author Michael Evans
 * @version 5/8/2015
 *********************************************************************/
public class KoreaNavigationActivity extends FragmentActivity //implements ActionBar.TabListener
{
    private ActionBar actionBar;
    private KoreaNavigationFragmentPageAdapter fragmentPageAdapter;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea_navigation_activity_layout);

        Log.d("KoreaNavigationActivity", "inside onCreate()");

        viewPager = (ViewPager) findViewById(R.id.korea_navigation_pager);
        viewPager.setAdapter(new KoreaNavigationFragmentPageAdapter(getSupportFragmentManager(),
                KoreaNavigationActivity.this));

        //fragmentPageAdapter = new KoreaNavigationFragmentPageAdapter(getSupportFragmentManager());

        //sliding tab layout
        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.korea_sliding_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

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
                // TODO Auto-generated method stub
            }

            @Override
            public void onPageScrollStateChanged(int arg0)
            {
                // TODO Auto-generated method stub
            }
        });*/

        Toast toast = Toast.makeText(this, "Long Press for Chart", Toast.LENGTH_LONG);
        toast.show();
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
