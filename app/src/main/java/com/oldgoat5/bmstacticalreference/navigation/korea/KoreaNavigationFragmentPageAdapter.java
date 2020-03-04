package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Pager adapter for Korean Theater of Operations.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class KoreaNavigationFragmentPageAdapter extends FragmentPagerAdapter
{
    private final int COUNT = 5;
    private Context CONTEXT;

    public KoreaNavigationFragmentPageAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.CONTEXT = context;
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
    public CharSequence getPageTitle(int position)
    {
        switch (position) //south korea, north korea, japan, china, russia
        {
            case 0:
                return "South Korea";

            case 1:
                return "North Korea";

            case 2:
                return "Japan";

            case 3:
                return "China";

            case 4:
                return "Russia";

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
