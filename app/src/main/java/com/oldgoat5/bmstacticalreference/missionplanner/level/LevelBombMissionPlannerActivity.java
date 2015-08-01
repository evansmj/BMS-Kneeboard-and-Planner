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
    private static final String FIRST_INSTANCE_TAG = "first_instance_tag";

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
                            fromConditionsBundle = bundle; //after scroll this not called
                            Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                            parametersFragment = new LevelBombMissionPlannerParametersFragment();
                            parametersFragment.setArguments(fromConditionsBundle);

                            //remove conditionsFragment load parametersFragment.
                            //todo fix not displaying parameter fragment after orientation change.

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
                            fromConditionsBundle = bundle; //after scroll this not called
                            Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                            parametersFragment = new LevelBombMissionPlannerParametersFragment();
                            parametersFragment.setArguments(fromConditionsBundle);

                            //remove conditionsFragment load parametersFragment.
                            //todo fix not displaying parameter fragment after orientation change.

                            fragmentManager = getSupportFragmentManager();
                            fragmentManager.beginTransaction().remove(conditionsFragment).commit();

                            fragmentManager.beginTransaction().replace(
                                    R.id.level_bomb_conditions_fragment_frame_layout,
                                    parametersFragment).commit();//this works, but without backstack.
                        }
                    });
        }
























        if (savedInstanceState != null && true == false)
        {
            Log.d("levelActivity", "if savedInstanceState != null called");



            conditionsFragment.setConditionsResult(
                    new LevelBombMissionPlannerConditionsFragment.OnConditionsResult()
                    {
                        @Override
                        public void setBundle(Bundle bundle)
                        {
                            fromConditionsBundle = bundle; //after scroll this not called
                            Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                            parametersFragment = new LevelBombMissionPlannerParametersFragment();
                            parametersFragment.setArguments(fromConditionsBundle);

                            //remove conditionsFragment load parametersFragment.
                            //todo fix not displaying parameter fragment after orientation change.
                            //todo add the interface to the fragment.

                            fragmentManager.beginTransaction().replace(
                                    R.id.level_bomb_conditions_fragment_frame_layout, parametersFragment,
                                    FIRST_INSTANCE_TAG)
                                    .addToBackStack(null).commit();
                        }
                    });
            return;
        }








        if (findViewById(R.id.level_bomb_conditions_fragment_frame_layout) != null && true == false)
        {
            Log.d("levelbombActivity", "if (findview-conditions != null");//after scroll this was called

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.

            if (savedInstanceState != null)
            {
                Log.d("levelbombActivity", "if (savedInstanceState != null"); //after scroll this was called
                return;
            }

            Log.d("levelbombActivity", "committing conditions fragment"); //after scroll this not called.

            /*fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.level_bomb_conditions_fragment_frame_layout, conditionsFragment);
            fragmentTransaction.commit();*/

            conditionsFragment.setConditionsResult(
                    new LevelBombMissionPlannerConditionsFragment.OnConditionsResult()
                    {
                        @Override
                        public void setBundle(Bundle bundle)
                        {
                            fromConditionsBundle = bundle; //after scroll this not called
                            Log.d("levelBombActivity", "set bundle = " + bundle.getInt("selectedCloudBase"));

                            parametersFragment = new LevelBombMissionPlannerParametersFragment();
                            parametersFragment.setArguments(fromConditionsBundle);

                            //remove conditionsFragment load parametersFragment.
                            //todo fix not displaying parameter fragment after orientation change.
                            //todo add the interface to the fragment.

                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(
                                    R.id.level_bomb_conditions_fragment_frame_layout, parametersFragment)
                                    .addToBackStack(null).commit();
                        }
                    });
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        Log.d("levelActivity", "onSaveInstanceState");//this, then oncreate called, then if savedinstancestate
        //save stuff here

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("levelActivity", "onRestoreInstanceState");
    }
}
