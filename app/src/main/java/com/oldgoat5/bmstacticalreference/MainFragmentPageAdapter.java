package com.oldgoat5.bmstacticalreference;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.oldgoat5.bmstacticalreference.loadout.LoadOutFragment;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsFragment;
import com.oldgoat5.bmstacticalreference.reference.ReferenceFragment;

/*********************************************************************
 * Handles the main page fragments.
 *
 * @author Michael Evans
 *
 *********************************************************************/
public class MainFragmentPageAdapter extends FragmentPagerAdapter
{
    
    public MainFragmentPageAdapter(FragmentManager fm)
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
                return new LoadOutFragment();
            case 2:
                return new ReferenceFragment();
            case 3:
                return new FuelCalculatorFragment();
            case 4:
                return new NavigationChartsFragment();
            default:
                break;
        }
        return null;
    }

    @Override
    public int getCount()
    {
        return 5;
    }
    
}
