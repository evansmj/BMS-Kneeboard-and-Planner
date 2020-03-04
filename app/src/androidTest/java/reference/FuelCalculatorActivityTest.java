package reference;

import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.reference.FuelCalculatorActivity;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 10/19/2015
 *********************************************************************/
public class FuelCalculatorActivityTest extends
        ActivityInstrumentationTestCase2<FuelCalculatorActivity>
{
    private FuelCalculatorActivity fuelCalculatorActivity;

    private Button saveToDataCardButton;
    private EditText homeAltEditText;
    private EditText returnLegEditText;
    private EditText jokerOffsetEditText;
    private RadioGroup altitudeRadioGroup;
    private RadioGroup weatherRadioGroup;
    private TextView bingoFuelResultTextView;
    private TextView jokerFuelResultTextView;
    private TextView savedStatusTextView;

    public FuelCalculatorActivityTest()
    {
        super(FuelCalculatorActivity.class);

        //firstTest_label();
    }

    @Override
    public void setUp() throws Exception
    {
        super.setUp();

        instantiateResources();
    }

    public void testPreconditions()
    {
        assertNotNull("fuelCalculatorActivity is null", fuelCalculatorActivity);
        assertNotNull("saveToDataCardButton is null", saveToDataCardButton);
        assertNotNull("homeAltEditText is null", homeAltEditText);
        assertNotNull("returnLegEditText is null", returnLegEditText);
        assertNotNull("jokerOffsetEditText is null", jokerOffsetEditText);
        assertNotNull("altitudeRadioGroup is null", altitudeRadioGroup);
        assertNotNull("weatherRadioGroup is null", weatherRadioGroup);
        assertNotNull("bingoFuelResultTextView is null", bingoFuelResultTextView);
        assertNotNull("jokerFuelResultTextView is null", jokerFuelResultTextView);
        assertNotNull("savedStatusTextView is null", savedStatusTextView);
    }

    public void testfirstTest_label() throws Exception
    {
        assertEquals(true, true);
    }

    private void instantiateResources()
    {
        fuelCalculatorActivity = getActivity();

        saveToDataCardButton = (Button) fuelCalculatorActivity.findViewById(
                R.id.fuel_calculator_save_results_button);

        homeAltEditText = (EditText) fuelCalculatorActivity.findViewById(
                R.id.distance_to_alternate_edit_text);
        jokerOffsetEditText = (EditText) fuelCalculatorActivity.findViewById(
                R.id.joker_offset_edit_text);
        returnLegEditText = (EditText) fuelCalculatorActivity.findViewById(
                R.id.trip_nm_edit_text);

        //jokerOffsetEditText.setText("1000");

        altitudeRadioGroup = (RadioGroup) fuelCalculatorActivity.findViewById(
                R.id.alt_radio_group);
        weatherRadioGroup = (RadioGroup) fuelCalculatorActivity.findViewById(
                R.id.weather_radio_group);

        bingoFuelResultTextView = (TextView) fuelCalculatorActivity.findViewById(
                R.id.bingo_result_text_view);
        jokerFuelResultTextView = (TextView) fuelCalculatorActivity.findViewById(
                R.id.joker_result_text_view);
        savedStatusTextView = (TextView) fuelCalculatorActivity.findViewById(
                R.id.fuel_calculator_saved_status_text_view);

        altitudeRadioGroup.check(R.id.med_radio_button);
        weatherRadioGroup.check(R.id.vmc_radio_button);
    }
}
