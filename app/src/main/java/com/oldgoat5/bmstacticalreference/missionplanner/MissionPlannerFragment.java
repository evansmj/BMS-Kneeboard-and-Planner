package com.oldgoat5.bmstacticalreference.missionplanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.missionplanner.level.LevelBombMissionPlannerActivity;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 7/17/2015
 *********************************************************************/
public class MissionPlannerFragment extends Fragment
{
    private Button levelBombSelectButton;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.mission_planner_fragment_layout, container, false);

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

    private void showLevelBombMissionPlanner()
    {
        Intent intent = new Intent(getActivity(), LevelBombMissionPlannerActivity.class);
        startActivity(intent);
    }
}
