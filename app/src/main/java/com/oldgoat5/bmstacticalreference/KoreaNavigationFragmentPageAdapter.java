package com.oldgoat5.bmstacticalreference;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/*********************************************************************
 * Page adapter for Korean Theater of Operations.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class KoreaNavigationFragmentPageAdapter extends FragmentPagerAdapter
{
    public KoreaNavigationFragmentPageAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        switch (position) //south korea, north korea, japan, china, russia
        {
            case 0:
                return new SouthKoreaChartFragment();

            case 1:
                return new NorthKoreaChartFragment();

            case 2:
                return new JapanKoreaChartFragment();

            case 3:
                return new ChinaKoreaChartFragment();

            case 4:
                return new RussiaKoreaChartFragment();

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
