package com.oldgoat5.bmstacticalreference.missionplanner.level;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
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
    private static final String FIRST_INSTANCE_TAG = "first_instance_tag";

    private Bundle fromConditionsBundle;
    private FragmentManager fragmentManager;
    private LevelBombMissionPlannerConditionsFragment conditionsFragment;
    private LevelBombMissionPlannerParametersFragment parametersFragment;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level_bomb_mission_planner_activity_layout);

        Log.d("levelActivity", "onCreate called");

        conditionsFragment = (LevelBombMissionPlannerConditionsFragment)
                getSupportFragmentManager().findFragmentByTag(FIRST_INSTANCE_TAG);

        Log.d("levelActivity", "conditionsFragment = " + conditionsFragment);

        if (conditionsFragment == null)
        {
            Log.d("levelActivity", "if (conditionsFragment == null) called"); //this is calling
                                                                    // after orientation change, it shouldn't
            conditionsFragment = new LevelBombMissionPlannerConditionsFragment();

            fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(
                    R.id.level_bomb_conditions_fragment_frame_layout,
                    conditionsFragment, FIRST_INSTANCE_TAG).commit();

            Log.d("levelActivity", "after .add.commit();");

            conditionsFragment.setConditionsResult(
                    new LevelBombMissionPlannerConditionsFragment.OnConditionsResult()
                    {
                        @Override
                        public void setBundle(Bundle bundle)
                        {
                            fromConditionsBundle = bundle; //after orientation change this not called
                            Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                            parametersFragment = new LevelBombMissionPlannerParametersFragment();
                            parametersFragment.setArguments(fromConditionsBundle);

                            //remove conditionsFragment load parametersFragment.

                            fragmentManager.beginTransaction().replace(
                                    R.id.level_bomb_conditions_fragment_frame_layout,
                                    parametersFragment).addToBackStack(null).commit();//this works
                        }
                    });
        }
        else
        {
            Log.d("levelActivity", "conditionsFragment != null (else called)");

            conditionsFragment.setConditionsResult(
                    new LevelBombMissionPlannerConditionsFragment.OnConditionsResult()
                    {
                        @Override
                        public void setBundle(Bundle bundle)
                        {
                            fromConditionsBundle = bundle; //after orientation change this not called
                            Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                            parametersFragment = new LevelBombMissionPlannerParametersFragment();
                            parametersFragment.setArguments(fromConditionsBundle);

                            //remove conditionsFragment load parametersFragment.
                            fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().remove(conditionsFragment).commit();

                            fragmentManager.beginTransaction().replace(
                                    R.id.level_bomb_conditions_fragment_frame_layout,
                                    parametersFragment).commit();//this works, but without backstack.
                        }
                    });
        }
    }
}
