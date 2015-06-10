package com.oldgoat5.bmstacticalreference.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.oldgoat5.bmstacticalreference.navigation.korea.KoreaNavigationActivity;
import com.oldgoat5.bmstacticalreference.navigation.balkans.BattleForBalkansNavigationActivity;
import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 5/7/2015
 *
 * Contains charts for Korea.
 *********************************************************************/
public class NavigationChartsFragment extends Fragment
{
    private Button battleForBalkansSelectButton;
    private Button koreaSelectButton;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.navigation_chart_fragment_layout, container, false);

        Log.d("NavChartsFragment", "inside onCreateView()");

        battleForBalkansSelectButton = (Button) view.findViewById(
                R.id.battle_for_balkans_navigation_select_button);
        koreaSelectButton = (Button) view.findViewById(R.id.korea_navigation_select_button);

        battleForBalkansSelectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showBattleForBalkansNavigation();
            }
        });

        koreaSelectButton.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showKoreaNavigation();
            }
        });

        return view;
    }

    /*****************************************************************
     * Starts the battle for balkans activity.
     *****************************************************************/
    public void showBattleForBalkansNavigation()
    {
        Intent intent = new Intent(getActivity(), BattleForBalkansNavigationActivity.class);
        startActivity(intent);
    }

    /*****************************************************************
     * Starts the korea navigation activity.
     *****************************************************************/
    public void showKoreaNavigation()
    {
        Intent intent = new Intent(getActivity(), KoreaNavigationActivity.class);
        startActivity(intent);
    }
}
