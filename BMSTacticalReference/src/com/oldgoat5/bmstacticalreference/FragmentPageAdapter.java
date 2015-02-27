package com.oldgoat5.bmstacticalreference;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentPageAdapter extends FragmentPagerAdapter
{
    
    public FragmentPageAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0: 
                return new LoadCardFragment();
            case 1:
                return new WeightAndBalanceFragment();
            case 2:
                return new TacticalReferenceFragment();
            case 3:
                return new AircraftManualsFragment();
            default:
                break;
        }
        return null;
        /*switch(position)
        {
            case 0:
                return LoadCardFragment.newInstance(
                        "LoadCardFragment, Instance 1");
            case 1:
                return WeightAndBalanceFragment.newInstance(
                        "WeightAndBalanceFragment, Instance 1");
            case 2:
                return TacticalReferenceFragment(
                        "TacticalReferenceFragment, Instance 1");
            case 3: 
                return FragmentFour(
                        "FragmentFour, Instance 1");
        }*/
    }

    @Override
    public int getCount()
    {
        return 4;
    }
    
}
