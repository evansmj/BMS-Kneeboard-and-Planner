package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

/*********************************************************************
 * Airport information for falcon-online Battle For Balkans Theater.
 *
 * @author Michael Evans
 * @since 5/26/2015
 *********************************************************************/
public class BattleForBalkansNavigationActivity extends FragmentActivity
{
    private BattleForBalkansNavigationFragmentPageAdapter fragmentPageAdapter;
    private ArrayList<PagerItem> tabsList;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_for_balkans_navigation_activity);

    }
}
