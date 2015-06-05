package com.oldgoat5.bmstacticalreference;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;

public class MainActivity extends FragmentActivity 
    implements ActionBar.TabListener
{
    int grossWeight;
    int totalDrag;

    private ActionBar actionBar;
    //DBTools dbHelper;
    private MainFragmentPageAdapter fragmentPageAdapter;
    private ViewPager viewPager;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "begin onCreate()");
        viewPager = (ViewPager) findViewById(R.id.pager);
        fragmentPageAdapter = new MainFragmentPageAdapter(
                getSupportFragmentManager());
        //dbHelper = new DBTools(this);
        //Log.d("MainActivity", "after dhHelper = new DBTools(this)");
        
        /*try
        {
            dbHelper.createDataBase();
        }
        catch (IOException ioe)
        {
            throw new Error("Unable to create database");
        }
        
        try
        {
            dbHelper.openDataBase();
        }
        catch (SQLiteException sqle)
        {
            throw sqle;
        }*/
        
        actionBar = getActionBar();
        
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        
        actionBar.addTab(actionBar.newTab().setText(
                "Load Card").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "Loadout").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "Reference").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "Fuel Calculator").setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(
                "Navigation Charts").setTabListener(this));
        
        viewPager.setAdapter(fragmentPageAdapter);
        
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
        });
    }
    
    
    @Override
    public void onTabSelected(Tab tab, FragmentTransaction ft)
    {
        viewPager.setCurrentItem(tab.getPosition());
    }
    
    @Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft)
    {
        // TODO Auto-generated method stub
    }
    
    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft)
    {
        // TODO Auto-generated method stub
    }
}
