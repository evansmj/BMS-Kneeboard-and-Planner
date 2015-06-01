package com.oldgoat5.bmstacticalreference.Navigation;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/*********************************************************************
 * Fragment pager adapter for falcon-online.org Balkans theater.
 *
 * @author Michael Evans
 * @since 5/28/2015
 *********************************************************************/
public class BattleForBalkansNavigationFragmentPageAdapter extends FragmentPagerAdapter
{
    private final int COUNT = 11;
    private Context context;

    public BattleForBalkansNavigationFragmentPageAdapter(FragmentManager fm, Context context)
    {
        super(fm);
        this.context = context;
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
        switch (position) //italy Sicily Slovenia Albania Bosnia Greece Macedonia Montenegro Serbia Croatia Hungary
        {
            case 0:
                return "Italy"; //blue

            case 1:
                return "Sicily"; //blue

            case 2:
                return "Slovenia"; //blue

            case 3:
                return "Albania"; //red

            case 4:
                return "Bosnia Herzegovnia"; //red

            case 5:
                return "Greece"; //blue

            case 6:
                return "Macedonia"; //red

            case 7:
                return "Montenegro"; //red

            case 8:
                return "Serbia"; //red

            case 9:
                return "Croatia"; //gray

            case 10:
                return "Hungary"; //gray

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
