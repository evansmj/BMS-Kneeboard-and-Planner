package com.oldgoat5.bmstacticalreference.reference;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.DataCardFragment;
import com.oldgoat5.bmstacticalreference.R;

import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.OutOfRangeException;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 1/12/2016
 ********************************************************************/
public class TakeoffCalculatorActivity extends AppCompatActivity
{
    private final double[] GROSS_WEIGHT_X = {17900, 18400, 19000, 20100, 20700, 21300, 21800, 22400,
        22900 ,23500, 24100, 24600, 25300, 25900, 26500, 27200, 27500, 28400, 29000, 29600, 30400,
        31000, 31600, 32400, 33000, 33600, 34400, 35100, 35800, 36600, 37700, 38000, 38800, 39500,
        39900, 40200, 41200, 42000, 42800, 43600, 44500, 45400, 46100, 47000, 48000};
    private final double[] TAKEOFF_SPEED_Y = {120, 122, 124, 126, 128, 130, 132, 134, 136, 138, 140,
            142, 144, 146, 148, 150, 152, 154, 156, 158, 160, 162, 164, 166, 168, 170, 172, 174, 176,
            178, 180, 182, 184, 186, 188, 190, 192, 194, 196, 198, 200, 202, 204, 206, 208};

    private final int minWeight = 17900;
    private final int maxWeight = 48000;

    private Button saveToDataCardButton;
    private EditText grossWeightEditText;
    private PolynomialSplineFunction takeoffSpeedFunction;
    private PowerSettingEnum selectedPowerSetting;
    private RadioGroup takeoffPowerRadioGroup;
    private SplineInterpolator interpolator;
    private TextView grossWeightLabelTextView;
    private TextView rotateResultTextView;
    private TextView savedStatusTextView;
    private TextView takeoffSpeedResultTextView;

    private double calculatedRotateSpeed;
    private double calculatedTakeoffSpeed;
    private int selectedGrossWeight;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.takeoff_calculator_activity_layout);

        instantiateResources();
        setListeners();
    }

    /*****************************************************************
     * Calculates rotate and takeoff speeds.
     *****************************************************************/
    private void calculateTakeoffSpeeds()
    {
        //get takeoff speed
        calculatedTakeoffSpeed = takeoffSpeedFunction.value(selectedGrossWeight);

        grossWeightLabelTextView.setTextColor(
                ContextCompat.getColor(getApplicationContext(), R.color.gray));

        //apply rotate to takeoff speed
        switch (selectedPowerSetting)
        {
            case MIL:
                calculatedRotateSpeed = calculatedTakeoffSpeed - 10;
                break;

            case MAXAB:
                calculatedRotateSpeed = calculatedTakeoffSpeed - 15;
                break;
        }

        //report results in formatted strings
        rotateResultTextView.setText(
                String.format(getApplicationContext().getString(
                                R.string.takeoff_speed_result),
                        (int) calculatedRotateSpeed));

        takeoffSpeedResultTextView.setText(
                String.format(getApplicationContext().getString(
                                R.string.takeoff_speed_result),
                        (int) calculatedTakeoffSpeed));

        savedStatusTextView.setVisibility(View.GONE);
    }

    /*****************************************************************
     * Handles when there is invalid input
     ****************************************************************/
    private void invalidate()
    {
        grossWeightLabelTextView.setTextColor(Color.RED);
        calculatedRotateSpeed = 0;
        calculatedTakeoffSpeed = 0;
        selectedGrossWeight = 0;
        rotateResultTextView.setText("");
        takeoffSpeedResultTextView.setText("");
    }

    /*****************************************************************
     * Instantiates resources for this class.
     *****************************************************************/
    private void instantiateResources()
    {
        Toolbar toolbar = (Toolbar) findViewById(R.id.takeoff_calculator_tool_bar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.silver));
        setSupportActionBar(toolbar);

        interpolator = new SplineInterpolator();
        takeoffSpeedFunction = interpolator.interpolate(GROSS_WEIGHT_X, TAKEOFF_SPEED_Y);
        selectedPowerSetting = PowerSettingEnum.MAXAB;

        saveToDataCardButton = (Button) findViewById(
                R.id.takeoff_calculator_save_to_data_card_button);

        grossWeightEditText = (EditText) findViewById(
                R.id.takeoff_calculator_gross_weight_edit_text);

        takeoffPowerRadioGroup = (RadioGroup) findViewById(
                R.id.takeoff_calculator_takeoff_power_radio_group);

        grossWeightLabelTextView = (TextView) findViewById(
                R.id.takeoff_calculator_gross_weight_description);
        rotateResultTextView = (TextView) findViewById(
                R.id.takeoff_calculator_rotate_result_text_view);
        savedStatusTextView = (TextView) findViewById(
                R.id.takeoff_calculator_saved_status_text_view);
        takeoffSpeedResultTextView = (TextView) findViewById(
                R.id.takeoff_calculator_takeoff_speed_result_text_view);
    }

    /*****************************************************************
     * Set up listeners
     *****************************************************************/
    private void setListeners()
    {
        grossWeightEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                try
                {
                    int weight = Integer.parseInt(editable.toString());

                    if ((weight >= minWeight) && (weight <= maxWeight))
                    {
                        selectedGrossWeight = weight;
                        calculateTakeoffSpeeds();
                    }
                    else
                    {
                        invalidate();
                    }
                }
                catch (NumberFormatException e)
                {
                    invalidate();
                }

            }
        });

        saveToDataCardButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //check if valid
                if (selectedGrossWeight != 0)
                {
                    SharedPreferences dataCardSharedPref = getSharedPreferences(
                            DataCardFragment.DATA_CARD_NAME, 0);
                    SharedPreferences.Editor editor = dataCardSharedPref.edit();

                    editor.putString("aircraft_rotate", rotateResultTextView.getText().toString());
                    editor.putString("aircraft_to_speed",
                            takeoffSpeedResultTextView.getText().toString());
                    editor.putString("aircraft_weight", Integer.toString(
                            selectedGrossWeight)+ " lbs");

                    switch (selectedPowerSetting)
                    {
                        case MIL:
                            editor.putString("aircraft_to_power", "MIL");
                            break;

                        case MAXAB:
                            editor.putString("aircraft_to_power", "Max AB");
                            break;
                    }

                    editor.apply();

                    savedStatusTextView.setText(
                            getApplicationContext().getString(R.string.saved_ok));
                    savedStatusTextView.setTextColor(
                            ContextCompat.getColor(getApplicationContext(), R.color.green));
                    savedStatusTextView.setVisibility(View.VISIBLE);
                }
                else
                {
                    savedStatusTextView.setText(
                            getApplicationContext().getString(R.string.invalid_input));
                    savedStatusTextView.setTextColor(
                            ContextCompat.getColor(getApplicationContext(), R.color.dark_red));
                    savedStatusTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        takeoffPowerRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.takeoff_calculator_mil_power_radio_button:
                        selectedPowerSetting = PowerSettingEnum.MIL;
                        break;

                    case R.id.takeoff_calculator_max_ab_power_radio_button:
                        selectedPowerSetting = PowerSettingEnum.MAXAB;
                        break;

                    default:
                        selectedPowerSetting = PowerSettingEnum.MAXAB;
                        break;
                }

                try
                {
                    int weight = Integer.parseInt(grossWeightEditText.getText().toString());
                    if (weight >= 17900 && weight <= 48000)
                        calculateTakeoffSpeeds();
                    else
                        throw new OutOfRangeException(weight, minWeight, maxWeight);
                }
                catch (NumberFormatException e)
                {
                    //do nothing if user just switched, so red doesn't show up for nothing.
                }
                catch (OutOfRangeException e)
                {
                    invalidate();
                }
            }
        });
    }

    /*****************************************************************
     * Enum for power settings
     *****************************************************************/
    private enum PowerSettingEnum
    {
        MIL, MAXAB
    }
}
