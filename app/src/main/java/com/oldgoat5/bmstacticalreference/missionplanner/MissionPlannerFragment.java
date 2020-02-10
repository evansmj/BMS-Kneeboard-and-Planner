package com.oldgoat5.bmstacticalreference.missionplanner;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.oldgoat5.bmstacticalreference.ColorFragment;
import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.missionplanner.level.LevelBombMissionPlannerActivity;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 7/17/2015
 *********************************************************************/
public class MissionPlannerFragment extends ColorFragment
{
    private AppBarLayout appBarLayout;
    private Button levelBombSelectButton;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.mission_planner_fragment_layout, container, false);

        appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar_layout);

        levelBombSelectButton = (Button) view.findViewById(R.id.level_bomb_select_button);

        levelBombSelectButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                showLevelBombMissionPlanner();
            }
        });

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean visible)
    {
        if (visible && appBarLayout != null)
        {
            appBarLayout.setExpanded(true, true);
        }
    }

    @Override
    public int getBackgroundColor()
    {
        return R.color.toolbar_green;
    }

    @Override
    public int getStatusBarColor()
    {
        return R.color.statusbar_green;
    }

    private void showLevelBombMissionPlanner()
    {
        Intent intent = new Intent(getActivity(), LevelBombMissionPlannerActivity.class);
        startActivity(intent);
    }
}
