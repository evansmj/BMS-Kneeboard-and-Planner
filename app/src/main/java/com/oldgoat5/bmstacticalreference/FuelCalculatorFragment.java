package com.oldgoat5.bmstacticalreference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/*********************************************************************
 * Fuel calculator for the F-16 using ROT.
 *
 * @author Michael Evans
 * @since 5/21/2015
 *********************************************************************/
public class FuelCalculatorFragment extends Fragment
{
    private EditText homeAltEditText;
    private EditText tripEditText;
    private RadioButton lowRadioButton;
    private RadioButton medRadioButton;
    private RadioButton hiRadioButton;
    private RadioGroup radioGroup;
    private TextView homeAltTextView;
    private TextView bingoFuelTextView;
    private TextView jokerFuelTextView;
    private TextView totalFuelTextView;
    private TextView tripTextView;
    private View view;

    private int homeAltFuel;
    private int jokerFuel;
    private int bingoFuel;
    private int totalFuel;
    private int tripFuel;
    private int selectedAltitude;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.fuel_calculator_fragment_layout, container, false);

        homeAltEditText = (EditText) view.findViewById(R.id.distance_to_alternate_edit_text);
        tripEditText = (EditText) view.findViewById(R.id.trip_nm_edit_text);

        lowRadioButton = (RadioButton) view.findViewById(R.id.low_radio_button);
        medRadioButton = (RadioButton) view.findViewById(R.id.med_radio_button);
        hiRadioButton = (RadioButton) view.findViewById(R.id.hi_radio_button);

        radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

        bingoFuelTextView = (TextView) view.findViewById(R.id.bingo_result_text_view);
        jokerFuelTextView = (TextView) view.findViewById(R.id.joker_result_text_view);
        homeAltTextView = (TextView) view.findViewById(R.id.distance_to_alternate_text_view);
        totalFuelTextView = (TextView) view.findViewById(R.id.total_fuel_result_text_view);
        tripTextView = (TextView) view.findViewById(R.id.trip_nm_text_view);

        selectedAltitude = 1;

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
                Log.d("fuelcalc", "homeAlt.changed");
                Log.d("fuelCAlc", "homealt = " + editable.toString());

                if (editable.toString().length() > 0)
                {
                    try
                    {
                        homeAltFuel = Integer.parseInt(editable.toString());
                        calculateFuel();
                    }
                    catch (NumberFormatException e)
                    {
                        Log.d("fuelCalc", "invalid float homeAlt");
                    }
                }
                else
                    homeAltFuel = 0;
            }
        });

        tripEditText.addTextChangedListener(new TextWatcher()
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
                Log.d("fuelCalc", "trip.changed");
                Log.d("fuelCalc", "tripFuel = " + editable.toString());

                if (editable.toString().length() > 0)
                {
                    try
                    {
                        tripFuel = Integer.parseInt(editable.toString());
                        calculateFuel();
                    }
                    catch (NumberFormatException e)
                    {
                        Log.d("fuelcalc", "invalid float in trip");
                    }
                }
                else
                    tripFuel = 0;
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                Log.d("fuelCalc","radioG.changed");
                Log.d("fuelCalc", "i = " + Integer.toString(i));
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
                Log.d("fuelCalc", "radioGChanged selAlt = " + Integer.toString(selectedAltitude));
                calculateFuel();
            }
        });
        return view;
    }

    private void calculateFuel()
    {
        int total;

        Log.d("fuelCalc", "calcFuel called");
        Log.d("fuelCalc", "tripFuel = " + Integer.toString(tripFuel));
        Log.d("fuelCalc", "homeAltFuel = " + Integer.toString(tripFuel));
        Log.d("fuelCalc", "selectedAltitude= " + Integer.toString(selectedAltitude));

        switch (selectedAltitude)
        {
            case 0:
                total = 1200 + (tripFuel * 20) + (homeAltFuel * 15); //low
                break;
            case 1:
                total = 1200 + (tripFuel * 15) + (homeAltFuel * 15); //med
                break;
            case 2:
                total = 1200 + (tripFuel * 10) + (homeAltFuel * 15); //high
                break;
            default:
                total = 0;
                break;
        }

        bingoFuelTextView.setText(Integer.toString(total + 1000));
        jokerFuelTextView.setText(Integer.toString(total + 2000));
        totalFuelTextView.setText(Integer.toString(total));
    }
}
