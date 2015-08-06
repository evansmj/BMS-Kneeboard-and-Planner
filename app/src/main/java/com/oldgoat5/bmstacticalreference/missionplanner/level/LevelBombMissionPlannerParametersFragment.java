package com.oldgoat5.bmstacticalreference.missionplanner.level;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

import java.util.HashMap;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 7/17/2015
 *********************************************************************/
public class LevelBombMissionPlannerParametersFragment extends Fragment
{
    private final String[] RELEASE_KTAS_ITEMS = {"---", "450", "500", "550", "600"};

    private ArrayAdapter<String> releaseKtasArrayAdapter;
    private EditText approachCourseEditText;
    private EditText releaseAltitudeEditText;
    private EditText targetElevationEditText;
    private HashMap<String, Boolean> inputValidity;
    private Spinner releaseKtasSpinner;
    private View view;

    private int selectedCloudBase;
    private int selectedConLayer;
    private int selectedTemperature;
    private int selectedWindDirection;
    private int selectedWindSpeed;
    private String selectedSituation;
    private String selectedReleaseSpeed;
    private String selectedWeapon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.level_bomb_mission_planner_parameters_fragment_layout, container, false);

        Log.d("levelParametersFragment", "onCreateView() called");

        getArgsFromBundle();
        instantiateResources();

        inputValidity = new HashMap<>();

        releaseKtasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        break;
                    case 1:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        break;
                    case 2:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        break;
                    case 3:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        break;
                    case 4:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                releaseKtasSpinner.requestFocus();
            }
        });

        releaseKtasSpinner.setAdapter(releaseKtasArrayAdapter);

        approachCourseEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b /*&& !approachCourseEditText.getText().toString().contains("°")*/)
                {
                    try
                    {
                        String oldText = approachCourseEditText.getText().toString();

                        if (oldText.length() == 3 && !approachCourseEditText.getText().toString().contains("°"))
                        {
                            if (Integer.parseInt(oldText) > 360)
                            {
                                Toast.makeText(
                                        getActivity(), "Invalid Heading, must be < 360", Toast.LENGTH_LONG).show();
                                inputValidity.put("selectedApproachCourse", false);
                            }
                            else
                            {
                                inputValidity.put("selectedApproachCourse", true);
                            }
                            approachCourseEditText.append("°");
                        }
                        else if (oldText.length() == 3 && approachCourseEditText.getText().toString().contains("°"))
                        {
                            if (Integer.parseInt(oldText.substring(0, 3)) > 360)
                            {
                                Toast.makeText(
                                        getActivity(), "Invalid Heading, must be < 360", Toast.LENGTH_LONG).show();
                                inputValidity.put("selectedApproachCourse", false);
                            }
                            else
                            {
                                inputValidity.put("selectedApproachCourse", true);
                            }
                        }
                        else
                        {
                            Toast.makeText(
                                    getActivity(), "Heading must be 3 digits", Toast.LENGTH_LONG).show();
                            inputValidity.put("selectedApproachCourse", false);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(), "Invalid Approach Course Heading", Toast.LENGTH_LONG).show();
                    }
                }
                if (inputValidity.containsKey("selectedApproachCourse"))
                    Log.d("levelParametersfragment", inputValidity.get("selectedApproachCourse").toString());
            }
        });

        return view;
    }

    /*****************************************************************
     * Sets arguments from weather conditions fragment.
     *****************************************************************/
    private void getArgsFromBundle()
    {
        selectedCloudBase = getArguments().getInt("selectedCloudBase");
        selectedConLayer = getArguments().getInt("selectedConLayer");
        selectedTemperature = getArguments().getInt("selectedTemperature");
        selectedWindDirection = getArguments().getInt("selectedWindDirection");
        selectedWindSpeed = getArguments().getInt("selectedWindSpeed");
        selectedSituation = getArguments().getString("selectedSituation");
        selectedWeapon = getArguments().getString("selectedWeapon");
    }

    private void instantiateResources()
    {
        approachCourseEditText = (EditText) view.findViewById(R.id.level_approach_course_edit_text);
        approachCourseEditText.setText("000°");
        releaseAltitudeEditText = (EditText) view.findViewById(R.id.level_release_altitude_edit_text);
        releaseAltitudeEditText.setText("5000ft. MSL");
        targetElevationEditText = (EditText) view.findViewById(R.id.level_target_elevation_edit_text);
        targetElevationEditText.setText("100ft. AGL");
        releaseKtasSpinner = (Spinner) view.findViewById(R.id.level_release_ktas_spinner);
        releaseKtasArrayAdapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_spinner_item, RELEASE_KTAS_ITEMS);
    }
}
