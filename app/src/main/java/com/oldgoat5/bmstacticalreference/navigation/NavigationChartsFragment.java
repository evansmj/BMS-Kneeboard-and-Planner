package com.oldgoat5.bmstacticalreference.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.navigation.aegean.AegeanNavigationActivity;
import com.oldgoat5.bmstacticalreference.navigation.balkans.BattleForBalkansNavigationActivity;
import com.oldgoat5.bmstacticalreference.navigation.korea.KoreaNavigationActivity;
import com.oldgoat5.bmstacticalreference.navigation.korea.interactivemap.KoreaInteractiveMapActivity;

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
    private Button aegeanSelectButton;
    private Button battleForBalkansSelectButton;
    private Button koreaInteractiveMapButton;
    private Button koreaSelectButton;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater,
        ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.navigation_chart_fragment_layout, container, false);

        aegeanSelectButton = (Button) view.findViewById(R.id.aegean_navigation_select_button);
        battleForBalkansSelectButton = (Button) view.findViewById(
                R.id.battle_for_balkans_navigation_select_button);
        koreaSelectButton = (Button) view.findViewById(R.id.korea_navigation_select_button);
        koreaInteractiveMapButton = (Button) view.findViewById(
                R.id.korea_interactive_map_select_button);

        aegeanSelectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showAegeanNavigation();
            }
        });

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

        koreaInteractiveMapButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                showKoreaInteractiveMap();
            }
        });

        return view;
    }

    private void showAegeanNavigation()
    {
        Intent intent = new Intent(getActivity(), AegeanNavigationActivity.class);
        startActivity(intent);
    }

    /*****************************************************************
     * Starts the battle for balkans activity.
     *****************************************************************/
    private void showBattleForBalkansNavigation()
    {
        Intent intent = new Intent(getActivity(), BattleForBalkansNavigationActivity.class);
        startActivity(intent);
    }

    /*****************************************************************
     * Starts the korea navigation activity.
     *****************************************************************/
    private void showKoreaNavigation()
    {
        Intent intent = new Intent(getActivity(), KoreaNavigationActivity.class);
        startActivity(intent);
    }

    /*****************************************************************
     * Starts the korea interactive map activity.
     *****************************************************************/
    private void showKoreaInteractiveMap()
    {
        Intent intent = new Intent(getActivity(), KoreaInteractiveMapActivity.class);
        startActivity(intent);
    }
}
