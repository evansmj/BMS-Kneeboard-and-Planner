package com.oldgoat5.bmstacticalreference;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.oldgoat5.bmstacticalreference.missionplanner.MissionPlannerFragment;
import com.oldgoat5.bmstacticalreference.tacticalreference.TacticalReferenceFragment;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsFragment;
import com.oldgoat5.bmstacticalreference.reference.ReferenceFragment;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Handles the main page fragments.
 *
 * @author Michael Evans
 *
 *********************************************************************/
public class MainFragmentPageAdapter extends FragmentPagerAdapter
{
    private final int COUNT = 5;
    private Context CONTEXT;
    
    public MainFragmentPageAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.CONTEXT = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0:
                return new LoadCardFragment();
            case 1:
                return new TacticalReferenceFragment();
            case 2:
                return new ReferenceFragment();
            case 3:
                return new NavigationChartsFragment();
            case 4:
                return new MissionPlannerFragment();
            default:
                break;
        }
        return null;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        switch (position)
        {
            case 0:
                return "Data Card";
            case 1:
                return "Tactical Reference";
            case 2:
                return "Reference";
            case 3:
                return "Navigation";
            case 4:
                return "Mission Planner";
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return COUNT;
    }
}
