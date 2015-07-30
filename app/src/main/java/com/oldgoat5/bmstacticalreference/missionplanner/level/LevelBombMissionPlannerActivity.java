package com.oldgoat5.bmstacticalreference.missionplanner.level;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 7/17/2015
 *********************************************************************/
public class LevelBombMissionPlannerActivity extends FragmentActivity
{
    private Bundle fromConditionsBundle;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private LevelBombMissionPlannerConditionsFragment conditionsFragment;
    private LevelBombMissionPlannerParametersFragment parametersFragment;
    private LevelBombMissionPlannerConditionsFragment.OnConditionsResult onConditionsResult;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_bomb_mission_planner_activity_layout);

        conditionsFragment = new LevelBombMissionPlannerConditionsFragment();

        if (findViewById(R.id.level_bomb_conditions_fragment_frame_layout) != null)
        {
            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null)
            {
                return;
            }

            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.level_bomb_conditions_fragment_frame_layout, conditionsFragment);
            fragmentTransaction.commit();

            conditionsFragment.setConditionsResult(
                    new LevelBombMissionPlannerConditionsFragment.OnConditionsResult()
            {
                @Override
                public void setBundle(Bundle bundle)
                {
                    fromConditionsBundle = bundle;
                    Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                    parametersFragment = new LevelBombMissionPlannerParametersFragment();
                    parametersFragment.setArguments(fromConditionsBundle);

                    //remove conditionsFragment load parametersFragment.
                    fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(
                            R.id.level_bomb_conditions_fragment_frame_layout, parametersFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            });
        }
    }
}
