package com.oldgoat5.bmstacticalreference.Navigation.Balkans;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.oldgoat5.bmstacticalreference.Navigation.Korea.KoreaNavigationFragmentPageAdapter;
import com.oldgoat5.bmstacticalreference.SlidingTabs.PagerItem;
import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.SlidingTabs.SlidingTabLayout;

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

        tabsList = new ArrayList<PagerItem>();

        tabsList.add(new PagerItem("Italy", Color.BLUE, Color.GRAY));
        tabsList.add(new PagerItem("Sicily", Color.BLUE, Color.GRAY));
        tabsList.add(new PagerItem("Slovenia", Color.BLUE, Color.GRAY));
        tabsList.add(new PagerItem("Albania", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Bosnia Herzegovnia", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Greece", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Macedonia", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Montenegro", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Serbia", Color.RED, Color.GRAY));
        tabsList.add(new PagerItem("Croatia", Color.GRAY, Color.GRAY));
        tabsList.add(new PagerItem("Hungary", Color.GRAY, Color.GRAY));

        viewPager = (ViewPager) findViewById(R.id.battle_for_balkans_navigation_pager);
        viewPager.setAdapter(new BattleForBalkansNavigationFragmentPageAdapter(getSupportFragmentManager(),
                BattleForBalkansNavigationActivity.this));

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.battle_for_balkans_sliding_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setTabTitleTextColor("#000000");
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
    }
}