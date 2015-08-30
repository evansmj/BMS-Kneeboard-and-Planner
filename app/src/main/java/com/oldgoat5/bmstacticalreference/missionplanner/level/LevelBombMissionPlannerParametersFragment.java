package com.oldgoat5.bmstacticalreference.missionplanner.level;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

import java.util.HashMap;
import java.util.StringTokenizer;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 7/17/2015
 *********************************************************************/
public class LevelBombMissionPlannerParametersFragment extends Fragment
{
    private final double[] CLUSTER_SPLASH_PATTERN_BURST_ALT = {300, 500, 700, 900, 1200, 1500, 1800, 2200, 2600, 3000};
    private final double[] CBU_52BB_SPLASH_PATTERN = {696, 898, 1063, 1205, 1391, 1556, 1704, 1884, 2048, 2200};
    private final double[] CBU_58AB_SPLASH_PATTERN = {885, 1143, 1353, 1534, 1771, 1980, 2169, 2398, 2607, 2800};
    private final double[] CBU_87_SPLASH_PATTERN = {632, 816, 966, 1095, 1265, 1414, 1549, 1713, 1862, 2000};
    private final double[] CBU_97SFW_SPLASH_PATTERN = {632, 816, 966, 1095, 1265, 1414, 1549, 1713, 1862, 2000};
    private final double[] MK_20D_SPLASH_PATTERN = {506, 653, 773, 876, 1012, 1131, 1239, 1370, 1490, 1600};
    private final String[] RELEASE_KTAS_ITEMS = {"---", "400", "450", "500", "550"};
    private final String[] RELEASE_MODE_ITEMS = {"---", "Single", "Pair"};
    private final String[] RIPPLE_QUANTITY_ITEMS = {"---", "1", "2", "3", "4", "5", "6"};

    private ArrayAdapter<String> releaseKtasArrayAdapter;
    private ArrayAdapter<String> releaseModeArrayAdapter;
    private ArrayAdapter<String> rippleQuantityArrayAdapter;
    private Button calculateButton;
    private EditText approachCourseEditText;
    private EditText bombSpacingEditText;
    private EditText burstAltitudeEditText;
    private EditText releaseAltitudeEditText;
    private EditText targetElevationEditText;
    private HashMap<String, Boolean> inputValidity;
    private Spinner releaseKtasSpinner;
    private Spinner releaseModeSpinner;
    private Spinner rippleQuantitySpinner;
    private SplineInterpolator interpolator;
    private TextView determinedBombRangeResultTextView;
    private TextView determinedReleaseAltitudeResultTextView;
    private TextView determinedReleaseSpeedResultTextView;
    private TextView determinedSightDepressionResultTextView;
    private TextView determinedMinSafeReleaseAltitudeResultTextView;
    private TextView determinedLengthCbuTextView;
    private TextView determinedLengthCbuLabelTextView;
    private TextView determinedLengthCbuResultTextView;
    private TextView determinedWidthCbuTextView;
    private TextView determinedWidthCbuLabelTextView;
    private TextView determinedWidthCbuResultTextView;
    private TextView determinedStickLengthTextView;
    private TextView determinedStickLengthLabelTextView;
    private TextView determinedStickLengthResultTextView;
    private TextView selectedBombSpacingTextView;
    private TextView selectedBombSpacingLabelTextView;
    private TextView selectedBurstAltitudeTextView;
    private TextView selectedBurstAltitudeLabelTextView;
    private TextView selectedReleaseModeTextView;
    private TextView selectedReleaseModeLabelTextView;
    private TextView selectedRippleQuantityTextView;
    private TextView selectedRippleQuantityLabelTextView;
    private View view;

    private boolean useHpa;
    private double selectedAltimeter;
    private String selectedApproachCourse;
    private int selectedBombSpacing;
    private int selectedBurstAltitude;
    private int selectedCloudBase;
    private int selectedConLayer;
    private int selectedReleaseAltitudeAGL;
    private int selectedTargetElevationMSL;
    private int selectedTemperature;
    private int selectedWindDirection;
    private int selectedWindSpeed;
    private String selectedSituation;
    private String selectedReleaseMode;
    private String selectedReleaseSpeed;
    private String selectedRippleQuantity;
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

        determineSmsParametersToDisplay();

        releaseKtasSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        inputValidity.put("selectedReleaseSpeed", false);
                        break;
                    case 1:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        inputValidity.put("selectedReleaseSpeed", true);
                        break;
                    case 2:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        inputValidity.put("selectedReleaseSpeed", true);
                        break;
                    case 3:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        inputValidity.put("selectedReleaseSpeed", true);
                        break;
                    case 4:
                        selectedReleaseSpeed = RELEASE_KTAS_ITEMS[i];
                        inputValidity.put("selectedReleaseSpeed", true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                selectedReleaseSpeed = RELEASE_KTAS_ITEMS[0];
                inputValidity.put("selectedReleaseSpeed", false);
            }
        });

        releaseKtasSpinner.setAdapter(releaseKtasArrayAdapter);
        releaseModeSpinner.setAdapter(releaseModeArrayAdapter);
        rippleQuantitySpinner.setAdapter(rippleQuantityArrayAdapter);

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
                            selectedApproachCourse = approachCourseEditText.getText().toString();
                            approachCourseEditText.append("°");
                        }
                        else if ((oldText.length() == 3 || oldText.length() == 4)
                                && approachCourseEditText.getText().toString().contains("°"))
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
                            selectedApproachCourse = approachCourseEditText.getText().toString();
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
                        inputValidity.put("selectedApproachCourse", false);
                    }
                }
            }
        });

        releaseAltitudeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b)
                {
                    String oldText = releaseAltitudeEditText.getText().toString();

                    try
                    {
                        if (oldText.contains("ft. AGL"))
                        {
                            oldText = oldText.replace("ft. AGL", "");
                            selectedReleaseAltitudeAGL = Integer.parseInt(oldText);
                            inputValidity.put("selectedReleaseAltitude", true);
                        }
                        else if (oldText.contains("ft."))
                        {
                            oldText = oldText.replace("ft.", "");
                            selectedReleaseAltitudeAGL = Integer.parseInt(oldText);
                            releaseAltitudeEditText.append(" AGL");
                            inputValidity.put("selectedReleaseAltitude", true);
                        }
                        else
                        {
                            selectedReleaseAltitudeAGL = Integer.parseInt(oldText);
                            releaseAltitudeEditText.append("ft. AGL");
                            inputValidity.put("selectedReleaseAltitude", true);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(), "Invalid Release Altitude", Toast.LENGTH_LONG).show();
                        inputValidity.put("selectedReleaseAltitude", false);
                    }
                }
            }
        });

        targetElevationEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b)
                {
                    String oldText = targetElevationEditText.getText().toString();

                    try
                    {
                        if (oldText.contains("ft. MSL"))
                        {
                            oldText = oldText.replace("ft. MSL", "");
                            selectedTargetElevationMSL = Integer.parseInt(oldText);
                            inputValidity.put("selectedTargetElevation", true);
                        }
                        else if (oldText.contains("ft."))
                        {
                            oldText = oldText.replace("ft.", "");
                            selectedTargetElevationMSL = Integer.parseInt(oldText);
                            targetElevationEditText.append(" MSL");
                            inputValidity.put("selectedTargetElevation", true);
                        }
                        else
                        {
                            selectedTargetElevationMSL = Integer.parseInt(oldText);
                            targetElevationEditText.append("ft. MSL");
                            inputValidity.put("selectedTargetElevation", true);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(), "Invalid Target Elevation", Toast.LENGTH_LONG).show();
                        inputValidity.put("selectedTargetElevation", false);
                    }
                }
            }
        });

        burstAltitudeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b)
                {
                    String oldText = burstAltitudeEditText.getText().toString();

                    try
                    {
                        if (oldText.contains("ft. AGL"))
                        {
                            oldText = oldText.replace("ft. AGL", "");
                            selectedBurstAltitude = Integer.parseInt(oldText);
                            inputValidity.put("selectedBurstAltitude", true);
                        }
                        else if (oldText.contains("ft."))
                        {
                            oldText = oldText.replace("ft.", "");
                            selectedBurstAltitude = Integer.parseInt(oldText);
                            burstAltitudeEditText.append(" AGL");
                            inputValidity.put("selectedBurstAltitude", true);
                        }
                        else
                        {
                            selectedBurstAltitude = Integer.parseInt(oldText);
                            burstAltitudeEditText.append("ft. AGL");
                            inputValidity.put("selectedBurstAltitude", true);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(), "Invalid Burst Altitude", Toast.LENGTH_LONG).show();
                        inputValidity.put("selectedBurstAltitude", false);
                    }
                }
            }
        });

        bombSpacingEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b)
                {
                    String oldText = bombSpacingEditText.getText().toString();

                    try
                    {
                        if (oldText.contains("ft."))
                        {
                            oldText = oldText.replace("ft.", "");
                            selectedBombSpacing = Integer.parseInt(oldText);
                            inputValidity.put("selectedBombSpacing", true);
                        }
                        else
                        {
                            selectedBombSpacing = Integer.parseInt(oldText);
                            bombSpacingEditText.append("ft.");
                            inputValidity.put("selectedBombSpacing", true);
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(), "Invalid Bomb Spacing", Toast.LENGTH_LONG).show();
                        inputValidity.put("selectedBombSpacing", false);
                    }
                }
            }
        });

        releaseModeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        selectedReleaseMode = RELEASE_MODE_ITEMS[i];
                        inputValidity.put("selectedReleaseMode", false);
                        break;
                    case 1:
                        selectedReleaseMode = RELEASE_MODE_ITEMS[i];
                        inputValidity.put("selectedReleaseMode", true);
                        break;
                    case 2:
                        selectedReleaseMode = RELEASE_MODE_ITEMS[i];
                        inputValidity.put("selectedReleaseMode", true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                selectedReleaseMode = RELEASE_MODE_ITEMS[0];
                inputValidity.put("selectedReleaseMode", false);
            }
        });

        rippleQuantitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", false);
                        break;
                    case 1:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", true);
                        break;
                    case 2:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", true);
                        break;
                    case 3:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", true);
                        break;
                    case 4:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", true);
                        break;
                    case 5:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", true);
                        break;
                    case 6:
                        selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[i];
                        inputValidity.put("selectedRippleQuantity", true);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                selectedRippleQuantity = RIPPLE_QUANTITY_ITEMS[0];
                inputValidity.put("selectedRippleQuantity", false);
            }
        });


        calculateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View pview)
            {
                view.requestFocus();
                //TOOD add release KCAS later, adjuster in loadcard.

                if (inputIsValid())
                {
                    try
                    {
                        //incase nothing focused
                        selectedTargetElevationMSL = Integer.parseInt(
                                targetElevationEditText.getText().toString().replace("ft. MSL", ""));
                        selectedReleaseAltitudeAGL = Integer.parseInt(
                                releaseAltitudeEditText.getText().toString().replace("ft. AGL", ""));
                        selectedBombSpacing = Integer.parseInt(
                                bombSpacingEditText.getText().toString().replace("ft.", ""));
                        selectedBurstAltitude = Integer.parseInt(
                                burstAltitudeEditText.getText().toString().replace("ft. AGL", ""));

                        determinedReleaseAltitudeResultTextView.setText(
                                (selectedTargetElevationMSL + selectedReleaseAltitudeAGL) + "ft. MSL");
                        determinedReleaseAltitudeResultTextView.setTextColor(Color.BLACK);
                        determinedReleaseAltitudeResultTextView.setTypeface(Typeface.DEFAULT);
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(), "Bad form args", Toast.LENGTH_LONG).show();
                    }

                    //calculate minReleaseAlt
                    if (!selectedWeapon.contains("CBU") || !selectedWeapon.contains("Rockeye"))
                    {

                    }

                    //calculate trajectory
                    //TODO add approximate air resistance, then closer air resistance based on dimensions
                    final double g = 9.80665;                                 //g acceleration on Earth m/s^2
                    final double Vo = Integer.parseInt(
                            selectedReleaseSpeed) * 0.51444444444;         //meters per second
                    final double releaseAngle = 0 * 0.017;               //level release angle radians
                    final double Vx = Vo * Math.cos(releaseAngle);         //x release velocity m/s
                    final double Vy = Vo * Math.sin(releaseAngle);         //y release velocity m/s
                    final double Yo = selectedReleaseAltitudeAGL * 0.3048; //release altitude AGL meters
                    final double maxHeight = Yo + Math.pow(Vy, 2) / (2 * g);  //max height reached
                    final double timeToMaxHeight = Vy / g;
                    final double timeMaxHeightToImpact = Math.sqrt(2 * maxHeight / g);
                    final double bombRange =
                            (Vx * (timeToMaxHeight + timeMaxHeightToImpact)) * 3.28084; //horizontal range in feet
                    final double fallTime = Math.round(
                            (timeToMaxHeight + timeMaxHeightToImpact) * 10.0) / 10.0; //seconds
                    final double speedAtImpact = Math.sqrt(
                            Math.pow((g * timeMaxHeightToImpact), 2) + Math.pow(Vx, 2));

                    Log.d("levelreleaseparamet", fallTime + "seconds fall ");
                    Log.d("levelreleaseparamet", "unrounded seconds fall" + (timeToMaxHeight + timeMaxHeightToImpact));
                    determinedBombRangeResultTextView.setText(Long.toString(Math.round(bombRange)) + "ft.");
                    determinedBombRangeResultTextView.setTextColor(Color.BLACK);
                    determinedBombRangeResultTextView.setTypeface(Typeface.DEFAULT);

                    //calculate release speed
                    final double altimeterPascal;

                    if (!useHpa)
                    {
                        altimeterPascal = selectedAltimeter * 3386.38867;
                    }
                    else
                    {
                        altimeterPascal = selectedAltimeter * 100;
                    }

                    final double R = 287.05; //constant specific gas for dry air
                    final double Po = 1.225; //kg/m^3 (standard pressure 0 msl, 15C)
                    final double P = altimeterPascal / (R * (selectedTemperature + 273.15));//pressure at release altitude
                    final double tas = Double.parseDouble(selectedReleaseSpeed);
                    final long determinedReleaseSpeed = Math.round(tas / Math.sqrt(Po / P));

                    determinedReleaseSpeedResultTextView.setText(Long.toString(determinedReleaseSpeed) + "kn.");
                    determinedReleaseSpeedResultTextView.setTextColor(Color.BLACK);
                    determinedReleaseSpeedResultTextView.setTypeface(Typeface.DEFAULT);

                    Log.d("levelreleaseparam", "tas: " + tas + "Po: " + Po + "P: " + P);

                    //calculate sight depression
                    final long sightDepressionResult = Math.round((3.14159 / 180) * Math.atan(
                            (selectedReleaseAltitudeAGL / bombRange)) * (180 / 3.14159) * 1000);

                    determinedSightDepressionResultTextView.setText(
                            Long.toString(sightDepressionResult) + "mrad.");
                    determinedSightDepressionResultTextView.setTextColor(Color.BLACK);
                    determinedSightDepressionResultTextView.setTypeface(Typeface.DEFAULT);

                    //hit patterns
                    int releaseModeInt = selectedReleaseMode.equals(RELEASE_MODE_ITEMS[1])? 1 : 2;
                    int numBombs = Integer.parseInt(selectedRippleQuantity) * releaseModeInt;

                    if (selectedWeapon.contains("CBU") || selectedWeapon.contains("Rockeye"))
                    {
                        //determine cluster splash pattern
                        PolynomialSplineFunction clusterFunction = interpolator.interpolate(
                                CLUSTER_SPLASH_PATTERN_BURST_ALT, getSplashPattern());

                        Log.d("levelrelparameters", "selectedBurstAlt = " + selectedBurstAltitude);

                        double cbuPatternDiameter = clusterFunction.value(selectedBurstAltitude);

                        determinedWidthCbuResultTextView.setText(
                                Long.toString(Math.round(cbuPatternDiameter)) + "ft."); //same for pair/single
                        determinedWidthCbuResultTextView.setTextColor(Color.BLACK);
                        determinedWidthCbuResultTextView.setTypeface(Typeface.DEFAULT);

                        determinedLengthCbuResultTextView.setText(
                                Long.toString(Math.round(
                                        cbuPatternDiameter + ((numBombs - 1) * selectedBombSpacing))) + "ft.");
                        determinedLengthCbuResultTextView.setTextColor(Color.BLACK);
                        determinedLengthCbuResultTextView.setTypeface(Typeface.DEFAULT);
                    }
                    else
                    {
                        //determined stick length
                        determinedStickLengthResultTextView.setText(
                                Integer.toString((numBombs - 1) * selectedBombSpacing) + "ft.");
                        determinedStickLengthResultTextView.setTypeface(Typeface.DEFAULT);
                        determinedStickLengthResultTextView.setTextColor(Color.BLACK);
                    }
                }
            }
        });

        return view;
    }

    /*****************************************************************
     * Sets arguments from level release weather conditions fragment.
     *****************************************************************/
    private void getArgsFromBundle()
    {
        useHpa = getArguments().getBoolean("useHpa");
        selectedAltimeter = getArguments().getDouble("selectedAltimeter");
        selectedCloudBase = getArguments().getInt("selectedCloudBase");
        selectedConLayer = getArguments().getInt("selectedConLayer");
        selectedTemperature = getArguments().getInt("selectedTemperature");
        selectedWindDirection = getArguments().getInt("selectedWindDirection");
        selectedWindSpeed = getArguments().getInt("selectedWindSpeed");
        selectedSituation = getArguments().getString("selectedSituation");
        selectedWeapon = getArguments().getString("selectedWeapon");
        Log.d("levelparameters", "selectedWeapon = " + selectedWeapon);
    }

    private double[] getSplashPattern()
    {
        double[] cbuPattern;

        if (selectedWeapon.contains("CBU-52"))
        {
            cbuPattern = CBU_52BB_SPLASH_PATTERN;
        }
        else if (selectedWeapon.contains("CBU-58"))
        {
            cbuPattern = CBU_58AB_SPLASH_PATTERN;
        }
        else if (selectedWeapon.contains("CBU-87"))
        {
            cbuPattern = CBU_87_SPLASH_PATTERN;
        }
        else if (selectedWeapon.contains("CBU-97"))
        {
            cbuPattern = CBU_97SFW_SPLASH_PATTERN;
        }
        else if (selectedWeapon.contains("Rockeye"))
        {
            cbuPattern = MK_20D_SPLASH_PATTERN;
        }
        else
        {
            cbuPattern = CBU_52BB_SPLASH_PATTERN;
        }

        return cbuPattern;
    }

    private void instantiateResources()
    {
        interpolator = new SplineInterpolator();

        calculateButton = (Button) view.findViewById(R.id.level_release_parameters_calculate_button);

        approachCourseEditText = (EditText) view.findViewById(R.id.level_approach_course_edit_text);
        bombSpacingEditText = (EditText) view.findViewById(R.id.level_select_bomb_spacing_edit_text);
        burstAltitudeEditText = (EditText) view.findViewById(R.id.level_selected_burst_altitude_edit_text);
        releaseAltitudeEditText = (EditText) view.findViewById(R.id.level_release_altitude_agl_edit_text);
        targetElevationEditText = (EditText) view.findViewById(R.id.level_target_elevation_edit_text);

        approachCourseEditText.setText("000°");
        bombSpacingEditText.setText("0ft.");
        burstAltitudeEditText.setText("2000ft. AGL");
        releaseAltitudeEditText.setText("5000ft. AGL");
        targetElevationEditText.setText("100ft. MSL");

        determinedBombRangeResultTextView = (TextView) view.findViewById(
                R.id.level_determined_bomb_range_result_text_view);
        determinedSightDepressionResultTextView = (TextView) view.findViewById(
                R.id.level_release_sight_depression_result_text_view);
        determinedMinSafeReleaseAltitudeResultTextView = (TextView) view.findViewById(
                R.id.level_min_safe_release_altitude_result_text_view);
        determinedReleaseAltitudeResultTextView = (TextView) view.findViewById(
                R.id.level_determined_release_altitude_result_text_view);
        determinedReleaseSpeedResultTextView = (TextView) view.findViewById(
                R.id.level_release_speed_result_text_view);
        selectedBurstAltitudeTextView = (TextView) view.findViewById(
                R.id.level_selected_burst_altitude_text_view);
        selectedBurstAltitudeLabelTextView = (TextView) view.findViewById(
                R.id.level_selected_burst_altitude_label_text_view);
        determinedLengthCbuTextView = (TextView) view.findViewById(
                R.id.level_determined_length_cbu_pattern_text_view);
        determinedLengthCbuLabelTextView = (TextView) view.findViewById(
                R.id.level_determined_length_cbu_pattern_label_text_view);
        determinedLengthCbuResultTextView = (TextView) view.findViewById(
                R.id.level_determined_length_cbu_pattern_result_text_view);
        determinedWidthCbuTextView = (TextView) view.findViewById(
                R.id.level_determined_width_cbu_pattern_text_view);
        determinedWidthCbuLabelTextView = (TextView) view.findViewById(
                R.id.level_determined_width_cbu_pattern_label_text_view);
        determinedWidthCbuResultTextView = (TextView) view.findViewById(
                R.id.level_determined_width_cbu_pattern_result_text_view);
        determinedStickLengthTextView = (TextView) view.findViewById(
                R.id.level_determined_stick_length_text_view);
        determinedStickLengthLabelTextView = (TextView) view.findViewById(
                R.id.level_determined_stick_length_label_text_view);
        determinedStickLengthResultTextView = (TextView) view.findViewById(
                R.id.level_determined_stick_length_result_text_view);

        if (selectedWeapon.contains("CBU"))
            determinedMinSafeReleaseAltitudeResultTextView.setText("(None for CBU)"); //be specific for user confidence

        if (selectedWeapon.contains("Rockeye"))
            determinedMinSafeReleaseAltitudeResultTextView.setText("(None for MK-20D)");

        if (selectedWeapon.contains("GBU"))
            determinedMinSafeReleaseAltitudeResultTextView.setText("(None for GBU)");

        releaseKtasSpinner = (Spinner) view.findViewById(R.id.level_release_ktas_spinner);
        releaseModeSpinner = (Spinner) view.findViewById(R.id.level_release_mode_spinner);
        rippleQuantitySpinner = (Spinner) view.findViewById(R.id.level_select_ripple_quantity_spinner);

        releaseKtasArrayAdapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_spinner_item, RELEASE_KTAS_ITEMS);
        releaseModeArrayAdapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_spinner_item, RELEASE_MODE_ITEMS);
        rippleQuantityArrayAdapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_spinner_item, RIPPLE_QUANTITY_ITEMS);
    }

    private boolean inputIsValid()
    {
        boolean finalValidity = false;

        if (!inputValidity.containsValue(false))
        {
            finalValidity = true;
        }
        else
        {
            Toast.makeText(getActivity(), "Form contains invalid input.", Toast.LENGTH_LONG).show();
        }

        return finalValidity;
    }

    private void determineSmsParametersToDisplay()
    {
        if (selectedWeapon.contains("CBU") || selectedWeapon.contains("Rockeye"))
        {
            selectedBurstAltitudeTextView.setVisibility(View.VISIBLE);
            selectedBurstAltitudeLabelTextView.setVisibility(View.VISIBLE);
            burstAltitudeEditText.setVisibility(View.VISIBLE);

            determinedLengthCbuTextView.setVisibility(View.VISIBLE);
            determinedLengthCbuLabelTextView.setVisibility(View.VISIBLE);
            determinedLengthCbuResultTextView.setVisibility(View.VISIBLE);
            determinedWidthCbuTextView.setVisibility(View.VISIBLE);
            determinedWidthCbuLabelTextView.setVisibility(View.VISIBLE);
            determinedWidthCbuResultTextView.setVisibility(View.VISIBLE);

            determinedStickLengthTextView.setVisibility(View.GONE);
            determinedStickLengthLabelTextView.setVisibility(View.GONE);
            determinedStickLengthResultTextView.setVisibility(View.GONE);

            inputValidity.put("selectedBurstAltitude", true);
        }
        else
        {
            selectedBurstAltitudeTextView.setVisibility(View.GONE);
            selectedBurstAltitudeLabelTextView.setVisibility(View.GONE);
            burstAltitudeEditText.setVisibility(View.GONE);

            determinedLengthCbuTextView.setVisibility(View.GONE);
            determinedLengthCbuLabelTextView.setVisibility(View.GONE);
            determinedLengthCbuResultTextView.setVisibility(View.GONE);
            determinedWidthCbuTextView.setVisibility(View.GONE);
            determinedWidthCbuLabelTextView.setVisibility(View.GONE);
            determinedWidthCbuResultTextView.setVisibility(View.GONE);

            determinedStickLengthTextView.setVisibility(View.VISIBLE);
            determinedStickLengthLabelTextView.setVisibility(View.VISIBLE);
            determinedStickLengthResultTextView.setVisibility(View.VISIBLE);
        }
    }
}
