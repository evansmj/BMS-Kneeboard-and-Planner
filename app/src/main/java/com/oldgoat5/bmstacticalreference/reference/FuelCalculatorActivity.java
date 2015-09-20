package com.oldgoat5.bmstacticalreference.reference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Fuel calculator for the F-16 using ROT.
 *
 * @author Michael Evans
 * @since 5/21/2015
 *********************************************************************/
public class FuelCalculatorActivity extends Activity
{
    private Button saveToDataCardButton;
    private EditText homeAltEditText;
    private EditText returnLegEditText;
    private EditText jokerOffsetEditText;
    private RadioButton lowRadioButton;
    private RadioButton medRadioButton;
    private RadioButton hiRadioButton;
    private RadioGroup altitudeRadioGroup;
    private RadioGroup weatherRadioGroup;
    private TextView bingoFuelResultTextView;
    private TextView jokerFuelResultTextView;
    private TextView savedStatusTextView;

    private int homeAltMiles;
    private int returnLegMiles;
    private int selectedAltitude;
    private int selectedJokerOffset;
    private int weatherConditions;

    @Override
    public void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fuel_calculator_activity_layout);

        instantiateResources();

        selectedAltitude = 1;
        selectedJokerOffset = 1000;
        weatherConditions = 0;

        homeAltEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                //Log.d("fuelcalc", "homeAlt.changed");
                //Log.d("fuelCAlc", "homealt = " + editable.toString());

                if (editable.toString().length() > 0)
                {
                    try
                    {
                        homeAltMiles = Integer.parseInt(editable.toString());
                        calculateFuel();
                    }
                    catch (NumberFormatException e)
                    {
                        //Log.d("fuelCalc", "invalid float homeAlt");
                    }
                }
                else
                    homeAltMiles = 0;
            }
        });

        returnLegEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                if (editable.toString().length() > 0)
                {
                    try
                    {
                        returnLegMiles = Integer.parseInt(editable.toString());
                        calculateFuel();
                    }
                    catch (NumberFormatException e)
                    {
                        //Log.d("fuelcalc", "invalid float in trip");
                    }
                }
                else
                {
                    returnLegMiles = 0;
                    jokerFuelResultTextView.setText("");
                    bingoFuelResultTextView.setText("");
                    savedStatusTextView.setVisibility(View.GONE);
                    savedStatusTextView.setText("");
                }
            }
        });

        altitudeRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                //Log.d("fuelCalc", "radioG.changed");
                //Log.d("fuelCalc", "i = " + Integer.toString(i));
                switch (i)
                {
                    case R.id.low_radio_button:
                        selectedAltitude = 0; //low
                        break;
                    case R.id.med_radio_button:
                        selectedAltitude = 1; //med
                        break;
                    case R.id.hi_radio_button:
                        selectedAltitude = 2; //high
                        break;
                    default:
                        selectedAltitude = 1;
                        break;
                }
                //Log.d("fuelCalc", "radioGChanged selAlt = " + Integer.toString(selectedAltitude));
                calculateFuel();
            }
        });

        weatherRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                switch (i)
                {
                    case R.id.vmc_radio_button:
                        weatherConditions = 400;
                        break;

                    case R.id.imc_radio_button:
                        weatherConditions = 800;
                        break;

                    default:
                        weatherConditions = 400;
                        break;
                }

                calculateFuel();
            }
        });

        jokerOffsetEditText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                try
                {
                    selectedJokerOffset = Integer.parseInt(editable.toString());
                    calculateFuel();
                }
                catch (NumberFormatException e)
                {
                    Toast.makeText(FuelCalculatorActivity.this, "Invalid Joker Offset",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

        saveToDataCardButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                saveToSharedPreferences();
            }
        });
    }

    private void calculateFuel()
    {
        int total;

        //Log.d("fuelCalc", "calcFuel called");
        //Log.d("fuelCalc", "tripFuel = " + Integer.toString(returnLegMiles));
        //Log.d("fuelCalc", "homeAltFuel = " + Integer.toString(returnLegMiles));
        //Log.d("fuelCalc", "selectedAltitude= " + Integer.toString(selectedAltitude));

        switch (selectedAltitude)
        {
            case 0:
                total = 1200 + weatherConditions + (returnLegMiles * 20) + (homeAltMiles * 10); //low
                break;

            case 1:
                total = 1200 + weatherConditions + (returnLegMiles * 15) + (homeAltMiles * 10); //med
                break;

            case 2:
                total = 1200 + weatherConditions + (returnLegMiles * 10) + (homeAltMiles * 10); //high
                break;

            default:
                total = 0;
                break;
        }

        bingoFuelResultTextView.setText(Integer.toString(total) + " lbs");
        jokerFuelResultTextView.setText(Integer.toString(total + selectedJokerOffset) + " lbs");
    }

    private void instantiateResources()
    {
        saveToDataCardButton = (Button) findViewById(R.id.fuel_calculator_save_results_button);

        homeAltEditText = (EditText) findViewById(R.id.distance_to_alternate_edit_text);
        jokerOffsetEditText = (EditText) findViewById(R.id.joker_offset_edit_text);
        returnLegEditText = (EditText) findViewById(R.id.trip_nm_edit_text);

        jokerOffsetEditText.setText("1000");

        lowRadioButton = (RadioButton) findViewById(R.id.low_radio_button);
        medRadioButton = (RadioButton) findViewById(R.id.med_radio_button);
        hiRadioButton = (RadioButton) findViewById(R.id.hi_radio_button);

        altitudeRadioGroup = (RadioGroup) findViewById(R.id.alt_radio_group);
        weatherRadioGroup = (RadioGroup) findViewById(R.id.weather_radio_group);

        bingoFuelResultTextView = (TextView) findViewById(R.id.bingo_result_text_view);
        jokerFuelResultTextView = (TextView) findViewById(R.id.joker_result_text_view);
        savedStatusTextView = (TextView) findViewById(R.id.fuel_calculator_saved_status_text_view);

        altitudeRadioGroup.check(R.id.med_radio_button);
        weatherRadioGroup.check(R.id.vmc_radio_button);
    }

    private void saveToSharedPreferences()
    {
        try
        {
            SharedPreferences dataCard = getSharedPreferences("DataCard", 0);
            SharedPreferences.Editor editor = dataCard.edit();

            editor.putString("joker", jokerFuelResultTextView.getText().toString());

            editor.putString("bingo", bingoFuelResultTextView.getText().toString());

            editor.apply();

            savedStatusTextView.setText("Saved OK");
            savedStatusTextView.setTextColor(getResources().getColor(R.color.green));
            savedStatusTextView.setVisibility(View.VISIBLE);
        }
        catch (NumberFormatException e)
        {
            savedStatusTextView.setText("Invalid values");
            savedStatusTextView.setTextColor(getResources().getColor(R.color.dark_red));
            savedStatusTextView.setVisibility(View.VISIBLE);
        }
    }
}