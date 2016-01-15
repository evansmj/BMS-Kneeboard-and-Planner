package com.oldgoat5.bmstacticalreference;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsMapProvider;
import com.oldgoat5.bmstacticalreference.navigation.NavigationChartsTuple;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

import java.util.ArrayList;
import java.util.HashMap;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 ********************************************************************/
public class LoadCardFragment extends Fragment
{
    private final String DATA_CARD_NAME = "DataCard";
    private final String SETTINGS_NAME = "Settings";

    private Button clearDataButton;
    private Button homePlateButton;
    private Button alternateButton;
    private EditText aircraftTypeEditText;
    private EditText aircraftWeightEditText;
    private EditText aircraftTgpCodeEditText;
    private EditText aircraftToTypeEditText;
    private EditText aircraftRotateEditText;
    private EditText aircraftFloorEditText;
    private EditText aircraftMaxGEditText;
    private EditText aircraftMaxSpeedEditText;
    private EditText aircraftLstCodeEditText;
    private EditText aircraftToPowerEditText;
    private EditText aircraftToSpeedEditText;
    private EditText aircraftAlowEditText;
    private EditText callsignEditText;
    private EditText deliveryApproachCourseEditText;
    private EditText deliveryMsraEditText;
    private EditText deliveryBombRangeEditText;
    private EditText deliveryReleaseAltitudeEditText;
    private EditText deliveryReleaseSpeedEditText;
    private EditText deliverySightDepressionEditText;
    private EditText deliveryTimeOfFallEditText;
    private EditText deliveryTypeEditText;
    private EditText flightBingoEditText;
    private EditText flightElementNameEditText;
    private EditText flightElementIdmEditText;
    private EditText flightElementTcnEditText;
    private EditText flightLeadNameEditText;
    private EditText flightLeadIdmEditText;
    private EditText flightLeadTcnEditText;
    private EditText flightWing2NameEditText;
    private EditText flightWing2IdmEditText;
    private EditText flightWing2TcnEditText;
    private EditText flightWing4NameEditText;
    private EditText flightWing4IdmEditText;
    private EditText flightWing4TcnEditText;
    private EditText flightJokerEditText;
    private EditText flightNotesEditText;
    private EditText packageEditText;
    private EditText package1NameEditText;
    private EditText package1UhfEditText;
    private EditText package1VhfEditText;
    private EditText package1IdmEditText;
    private EditText package1TcnEditText;
    private EditText package1TaskingEditText;
    private EditText package2NameEditText;
    private EditText package2UhfEditText;
    private EditText package2VhfEditText;
    private EditText package2IdmEditText;
    private EditText package2TcnEditText;
    private EditText package2TaskingEditText;
    private EditText package3NameEditText;
    private EditText package3UhfEditText;
    private EditText package3VhfEditText;
    private EditText package3IdmEditText;
    private EditText package3TcnEditText;
    private EditText package3TaskingEditText;
    private EditText package4NameEditText;
    private EditText package4UhfEditText;
    private EditText package4VhfEditText;
    private EditText package4IdmEditText;
    private EditText package4TcnEditText;
    private EditText package4TaskingEditText;
    private EditText package5NameEditText;
    private EditText package5UhfEditText;
    private EditText package5VhfEditText;
    private EditText package5IdmEditText;
    private EditText package5TcnEditText;
    private EditText package5TaskingEditText;
    private EditText supportAwacsEditText;
    private EditText supportAwacsStationTimeEditText;
    private EditText supportJstarsEditText;
    private EditText supportJstarsStationTimeEditText;
    private EditText supportFacEditText;
    private EditText supportFacStationTimeEditText;
    private EditText supportTankerEditText;
    private EditText supportTankerStationTimeEditText;
    private EditText weaponBombSpacingEditText;
    private EditText weaponBurstAltitudeEditText;
    private EditText weaponClusterPatternLengthEditText;
    private EditText weaponClusterPatternWidthEditText;
    private EditText weaponReleaseModeEditText;
    private EditText weaponRippleQuantityEditText;
    private EditText weaponStickLengthEditText;
    private EditText weaponTypeEditText;
    private SharedPreferences dataCardSharedPref;
    private SharedPreferences settingsSharedPref;
    private View view;

    private int dataCardTextSize;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.loadcard_fragment_layout, container, false);

        //Log.d("LoadCardFragment", "on Create View()");

        instantiateResources();
        setListeners();
        loadDataCard();
        dataCardTextSize = getSelectedCardSize();
        changeTextAppearance(dataCardTextSize);

        //Log.d("LoadCardFragment", "onCreate() dataTextSize = " + dataCardTextSize);

        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

        //Log.d("LoadCardFragment", "on Resume()");
        //Log.d("LoadCardFragment", "on Resume() dataCardTextSize = " + dataCardTextSize);
        loadDataCard();
        changeTextAppearance(dataCardTextSize);
        //Log.d("LoadCardFragment", "on Resume end textSize = " + dataCardTextSize);
    }

    @Override
    public void onPause()
    {
        super.onPause();

        //Log.d("LoadCardFragment", "on Pause()");
        //Log.d("LoadCardFragment", "on Pause() dataCardTextSize = " + dataCardTextSize);
        saveDataCard();
    }

    private int getSelectedCardSize()
    {
        int selectedCardSize;

        switch (settingsSharedPref.getInt("card_size", 1))
        {
            case 0:
                selectedCardSize = android.R.style.TextAppearance_Small;
                break;
            case 1:
                selectedCardSize = android.R.style.TextAppearance_Medium;
                break;
            case 2:
                selectedCardSize = android.R.style.TextAppearance_Large;
                break;
            default:
                selectedCardSize = android.R.style.TextAppearance_Medium;
        }

        return selectedCardSize;
    }

    /*****************************************************************
     * Go through all children and change text appearance.
     * @param size - Size of text appearance to use.
     *****************************************************************/
    private void changeTextAppearance(int size)
    {
        View child = ((ViewGroup)view).getChildAt(0);
        ////Log.d("LoadCardFragment", child.toString());

        for (int i = 0; i < ((ViewGroup)child).getChildCount(); i++)
        {
            View grandchild = ((ViewGroup)child).getChildAt(i);
            ////Log.d("LoadCardFragment", grandchild.toString());
            //if there is text view or edit text, change textappearance size.

            if (grandchild.toString().contains("text_view"))
            {
                TextView grandchildTextView = (TextView) grandchild;
                grandchildTextView.setTextAppearance(this.getActivity(), size);
                grandchildTextView.setTextColor(Color.BLACK);
            }
            if (grandchild.toString().contains("edit_text"))
            {
                EditText grandchildEditText = (EditText) grandchild;
                grandchildEditText.setTextAppearance(this.getActivity(), size);
                grandchildEditText.setTextColor(Color.BLACK);
            }

            if (grandchild.toString().contains("data_card_package_uhf_vhf_relative_layout"))
            {
                ////Log.d("LoadCardFragment", "grandchild.tostring() = " + grandchild.toString());

                for (int x = 0; x < ((ViewGroup)grandchild).getChildCount(); x++)
                {
                    View greatgrandchild = ((ViewGroup)grandchild).getChildAt(x);

                    if (greatgrandchild.toString().contains("text_view"))
                    {
                        TextView greatgrandchildTextView = (TextView) greatgrandchild;
                        greatgrandchildTextView.setTextAppearance(this.getActivity(), size);
                        greatgrandchildTextView.setTextColor(Color.BLACK);
                    }
                    if (greatgrandchild.toString().contains("edit_text"))
                    {
                        EditText greatgrandchildEditText = (EditText) greatgrandchild;
                        greatgrandchildEditText.setTextAppearance(this.getActivity(), size);
                        greatgrandchildEditText.setTextColor(Color.BLACK);
                    }
                }
            }
        }
    }

    private void instantiateResources()
    {
        clearDataButton = (Button) view.findViewById(R.id.data_card_clear_button);
        homePlateButton = (Button) view.findViewById(R.id.data_card_navigation_home_plate_button);
        alternateButton = (Button) view.findViewById(R.id.data_card_navigation_alternate_button);

        dataCardSharedPref = getActivity().getSharedPreferences(DATA_CARD_NAME, 0);
        settingsSharedPref = getActivity().getSharedPreferences(SETTINGS_NAME, 0);

        deliveryApproachCourseEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_approach_course_edit_text);
        deliveryBombRangeEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_range_edit_text);
        deliveryMsraEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_min_safe_rel_alt_edit_text);
        deliveryReleaseAltitudeEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_release_altitude_edit_text);
        deliveryReleaseSpeedEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_release_speed_edit_text);
        deliverySightDepressionEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_sight_depression_edit_text);
        deliveryTimeOfFallEditText = (EditText) view.findViewById(
                R.id.data_card_delivery_time_of_fall_edit_text);
        deliveryTypeEditText = (EditText) view.findViewById(R.id.data_card_delivery_type_edit_text);

        callsignEditText = (EditText) view.findViewById(R.id.data_card_callsign_edit_text);
        packageEditText = (EditText) view.findViewById(R.id.data_card_package_edit_text);

        //aircraft section
        aircraftTypeEditText = (EditText) view.findViewById(R.id.data_card_aircraft_type_edit_text);
        aircraftWeightEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_weight_edit_text);
        aircraftTgpCodeEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_tgp_code_edit_text);
        aircraftToTypeEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_to_type_edit_text);
        aircraftRotateEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_rotate_edit_text);
        aircraftFloorEditText = (EditText) view.findViewById(R.id.data_card_flight_floor_edit_text);
        aircraftMaxGEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_max_g_edit_text);
        aircraftMaxSpeedEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_max_speed_edit_text);
        aircraftLstCodeEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_lst_code_edit_text);
        aircraftToPowerEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_to_power_edit_text);
        aircraftToSpeedEditText = (EditText) view.findViewById(
                R.id.data_card_aircraft_takeoff_speed_edit_text);
        aircraftAlowEditText = (EditText) view.findViewById(R.id.data_card_flight_alow_edit_text);

        flightBingoEditText = (EditText) view.findViewById(R.id.data_card_bingo_edit_text);
        flightJokerEditText = (EditText) view.findViewById(R.id.data_card_joker_edit_text);

        //flight section
        flightLeadNameEditText = (EditText) view.findViewById(R.id.data_card_lead_edit_text);
        flightLeadIdmEditText = (EditText) view.findViewById(R.id.data_card_lead_idm_edit_text);
        flightLeadTcnEditText = (EditText) view.findViewById(R.id.data_card_lead_tcn_edit_text);

        flightWing2NameEditText = (EditText) view.findViewById(R.id.data_card_wing2_edit_text);
        flightWing2IdmEditText = (EditText) view.findViewById(R.id.data_card_wing2_idm_edit_text);
        flightWing2TcnEditText = (EditText) view.findViewById(R.id.data_card_wing2_tcn_edit_text);

        flightElementNameEditText = (EditText) view.findViewById(R.id.data_card_element_edit_text);
        flightElementIdmEditText = (EditText) view.findViewById(
                R.id.data_card_element_idm_edit_text);
        flightElementTcnEditText = (EditText) view.findViewById(
                R.id.data_card_element_tcn_edit_text);

        flightWing4NameEditText = (EditText) view.findViewById(R.id.data_card_wing4_edit_text);
        flightWing4IdmEditText = (EditText) view.findViewById(R.id.data_card_wing4_idm_edit_text);
        flightWing4TcnEditText = (EditText) view.findViewById(R.id.data_card_wing4_tcn_edit_text);

        flightNotesEditText = (EditText) view.findViewById(R.id.data_card_flight_notes_edit_text);

        //package section
        package1NameEditText = (EditText) view.findViewById(R.id.data_card_package1_edit_text);
        package1UhfEditText = (EditText) view.findViewById(R.id.data_card_package1_uhf_edit_text);
        package1VhfEditText = (EditText) view.findViewById(R.id.data_card_package1_vhf_edit_text);
        package1IdmEditText = (EditText) view.findViewById(R.id.data_card_package1_idm_edit_text);
        package1TcnEditText = (EditText) view.findViewById(R.id.data_card_package1_tcn_edit_text);
        package1TaskingEditText = (EditText) view.findViewById(
                R.id.data_card_package1_tasking_edit_text);

        package2NameEditText = (EditText) view.findViewById(R.id.data_card_package2_edit_text);
        package2UhfEditText = (EditText) view.findViewById(R.id.data_card_package2_uhf_edit_text);
        package2VhfEditText = (EditText) view.findViewById(R.id.data_card_package2_vhf_edit_text);
        package2IdmEditText = (EditText) view.findViewById(R.id.data_card_package2_idm_edit_text);
        package2TcnEditText = (EditText) view.findViewById(R.id.data_card_package2_tcn_edit_text);
        package2TaskingEditText = (EditText) view.findViewById(
                R.id.data_card_package2_tasking_edit_text);

        package3NameEditText = (EditText) view.findViewById(R.id.data_card_package3_edit_text);
        package3UhfEditText = (EditText) view.findViewById(R.id.data_card_package3_uhf_edit_text);
        package3VhfEditText = (EditText) view.findViewById(R.id.data_card_package3_vhf_edit_text);
        package3IdmEditText = (EditText) view.findViewById(R.id.data_card_package3_idm_edit_text);
        package3TcnEditText = (EditText) view.findViewById(R.id.data_card_package3_tcn_edit_text);
        package3TaskingEditText = (EditText) view.findViewById(
                R.id.data_card_package3_tasking_edit_text);

        package4NameEditText = (EditText) view.findViewById(R.id.data_card_package4_edit_text);
        package4UhfEditText = (EditText) view.findViewById(R.id.data_card_package4_uhf_edit_text);
        package4VhfEditText = (EditText) view.findViewById(R.id.data_card_package4_vhf_edit_text);
        package4IdmEditText = (EditText) view.findViewById(R.id.data_card_package4_idm_edit_text);
        package4TcnEditText = (EditText) view.findViewById(R.id.data_card_package4_tcn_edit_text);
        package4TaskingEditText = (EditText) view.findViewById(
                R.id.data_card_package4_tasking_edit_text);

        package5NameEditText = (EditText) view.findViewById(R.id.data_card_package5_edit_text);
        package5UhfEditText = (EditText) view.findViewById(R.id.data_card_package5_uhf_edit_text);
        package5VhfEditText = (EditText) view.findViewById(R.id.data_card_package5_vhf_edit_text);
        package5IdmEditText = (EditText) view.findViewById(R.id.data_card_package5_idm_edit_text);
        package5TcnEditText = (EditText) view.findViewById(R.id.data_card_package5_tcn_edit_text);
        package5TaskingEditText = (EditText) view.findViewById(
                R.id.data_card_package5_tasking_edit_text);

        //support section
        supportAwacsEditText = (EditText) view.findViewById(R.id.data_card_flight_awacs_edit_text);
        supportAwacsStationTimeEditText = (EditText) view.findViewById(
                R.id.data_card_flight_awacs_tos_edit_text);
        supportJstarsEditText = (EditText) view.findViewById(R.id.data_card_flight_jstars_edit_text);
        supportJstarsStationTimeEditText = (EditText) view.findViewById(
                R.id.data_card_flight_jstars_tos_edit_text);
        supportFacEditText = (EditText) view.findViewById(R.id.data_card_flight_fac_edit_text);
        supportFacStationTimeEditText = (EditText) view.findViewById(
                R.id.data_card_flight_fac_tos_edit_text);
        supportTankerEditText = (EditText) view.findViewById(
                R.id.data_card_flight_tanker_edit_text);
        supportTankerStationTimeEditText = (EditText) view.findViewById(
                R.id.data_card_flight_tanker_tos_edit_text);

        weaponBombSpacingEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_spacing_edit_text);
        weaponBurstAltitudeEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_burst_altitude_edit_text);
        weaponClusterPatternLengthEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_cbu_pattern_length_edit_text);
        weaponClusterPatternWidthEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_cbu_pattern_width_edit_text);
        weaponReleaseModeEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_release_mode_edit_text);
        weaponRippleQuantityEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_ripple_quantity_edit_text);
        weaponStickLengthEditText = (EditText) view.findViewById(
                R.id.data_card_weapon_stick_length_edit_text);
        weaponTypeEditText = (EditText) view.findViewById(R.id.data_card_weapon_type_edit_text);
    }

    private void loadDataCard()
    {
        dataCardTextSize = settingsSharedPref.getInt("card_size",
                android.R.style.TextAppearance_Medium);

        callsignEditText.setText(dataCardSharedPref.getString("callsign", ""));
        packageEditText.setText(dataCardSharedPref.getString("package", ""));

        //aircraft section
        aircraftTypeEditText.setText(dataCardSharedPref.getString("aircraft_type", ""));
        aircraftWeightEditText.setText(dataCardSharedPref.getString("aircraft_weight", ""));
        aircraftTgpCodeEditText.setText(dataCardSharedPref.getString("aircraft_tgp_code", ""));
        aircraftToTypeEditText.setText(dataCardSharedPref.getString("aircraft_to_type", ""));
        aircraftRotateEditText.setText(dataCardSharedPref.getString("aircraft_rotate", ""));
        aircraftFloorEditText.setText(dataCardSharedPref.getString("aircraft_floor", ""));
        aircraftMaxGEditText.setText(dataCardSharedPref.getString("aircraft_max_g", ""));
        aircraftMaxSpeedEditText.setText(dataCardSharedPref.getString("aircraft_max_speed", ""));
        aircraftLstCodeEditText.setText(dataCardSharedPref.getString("aircraft_lst_code", ""));
        aircraftToPowerEditText.setText(dataCardSharedPref.getString("aircraft_to_power", ""));
        aircraftToSpeedEditText.setText(dataCardSharedPref.getString("aircraft_to_speed", ""));
        aircraftAlowEditText.setText(dataCardSharedPref.getString("aircraft_alow", ""));

        //Delivery section
        deliveryApproachCourseEditText.setText(
                dataCardSharedPref.getString("approach_course", "000°"));
        deliveryBombRangeEditText.setText(dataCardSharedPref.getString("bomb_range", "00000ft"));
        deliveryReleaseAltitudeEditText.setText(dataCardSharedPref.getString(
                "release_altitude_msl", "0000ft. MSL"));
        deliveryReleaseSpeedEditText.setText(
                dataCardSharedPref.getString("release_speed_kcas", "000 KCAS"));
        deliverySightDepressionEditText.setText(
                dataCardSharedPref.getString("sight_depression", "260mrad."));
        deliveryTimeOfFallEditText.setText(
                dataCardSharedPref.getString("bomb_time_of_fall", "00.0s"));
        deliveryTypeEditText.setText(dataCardSharedPref.getString("release_profile", ""));
        deliveryMsraEditText.setText(dataCardSharedPref.getString("msra", "0000ft. AGL"));

        //Flight section
        flightLeadNameEditText.setText(dataCardSharedPref.getString("lead_name", ""));
        flightLeadIdmEditText.setText(dataCardSharedPref.getString("lead_idm", ""));
        flightLeadTcnEditText.setText(dataCardSharedPref.getString("lead_tcn", ""));

        flightWing2NameEditText.setText(dataCardSharedPref.getString("wing2_name", ""));
        flightWing2IdmEditText.setText(dataCardSharedPref.getString("wing2_idm", ""));
        flightWing2TcnEditText.setText(dataCardSharedPref.getString("wing2_tcn", ""));

        flightElementNameEditText.setText(dataCardSharedPref.getString("element_name", ""));
        flightElementIdmEditText.setText(dataCardSharedPref.getString("element_idm", ""));
        flightElementTcnEditText.setText(dataCardSharedPref.getString("element_tcn", ""));

        flightWing4NameEditText.setText(dataCardSharedPref.getString("wing4_name", ""));
        flightWing4IdmEditText.setText(dataCardSharedPref.getString("wing4_idm", ""));
        flightWing4TcnEditText.setText(dataCardSharedPref.getString("wing4_tcn", ""));

        flightNotesEditText.setText(dataCardSharedPref.getString("flight_notes", ""));

        //package section
        package1NameEditText.setText(dataCardSharedPref.getString("package1_name", ""));
        package1UhfEditText.setText(dataCardSharedPref.getString("package1_uhf", ""));
        package1VhfEditText.setText(dataCardSharedPref.getString("package1_vhf", ""));
        package1IdmEditText.setText(dataCardSharedPref.getString("package1_idm", ""));
        package1TcnEditText.setText(dataCardSharedPref.getString("package1_tcn", ""));
        package1TaskingEditText.setText(dataCardSharedPref.getString("package1_tasking", ""));

        package2NameEditText.setText(dataCardSharedPref.getString("package2_name", ""));
        package2UhfEditText.setText(dataCardSharedPref.getString("package2_uhf", ""));
        package2VhfEditText.setText(dataCardSharedPref.getString("package2_vhf", ""));
        package2IdmEditText.setText(dataCardSharedPref.getString("package2_idm", ""));
        package2TcnEditText.setText(dataCardSharedPref.getString("package2_tcn", ""));
        package2TaskingEditText.setText(dataCardSharedPref.getString("package2_tasking", ""));

        package3NameEditText.setText(dataCardSharedPref.getString("package3_name", ""));
        package3UhfEditText.setText(dataCardSharedPref.getString("package3_uhf", ""));
        package3VhfEditText.setText(dataCardSharedPref.getString("package3_vhf", ""));
        package3IdmEditText.setText(dataCardSharedPref.getString("package3_idm", ""));
        package3TcnEditText.setText(dataCardSharedPref.getString("package3_tcn", ""));
        package3TaskingEditText.setText(dataCardSharedPref.getString("package3_tasking", ""));

        package4NameEditText.setText(dataCardSharedPref.getString("package4_name", ""));
        package4UhfEditText.setText(dataCardSharedPref.getString("package4_uhf", ""));
        package4VhfEditText.setText(dataCardSharedPref.getString("package4_vhf", ""));
        package4IdmEditText.setText(dataCardSharedPref.getString("package4_idm", ""));
        package4TcnEditText.setText(dataCardSharedPref.getString("package4_tcn", ""));
        package4TaskingEditText.setText(dataCardSharedPref.getString("package4_tasking", ""));

        package5NameEditText.setText(dataCardSharedPref.getString("package5_name", ""));
        package5UhfEditText.setText(dataCardSharedPref.getString("package5_uhf", ""));
        package5VhfEditText.setText(dataCardSharedPref.getString("package5_vhf", ""));
        package5IdmEditText.setText(dataCardSharedPref.getString("package5_idm", ""));
        package5TcnEditText.setText(dataCardSharedPref.getString("package5_tcn", ""));
        package5TaskingEditText.setText(dataCardSharedPref.getString("package5_tasking", ""));

        //support section
        supportAwacsEditText.setText(dataCardSharedPref.getString("awacs_name", ""));
        supportAwacsStationTimeEditText.setText(dataCardSharedPref.getString("awacs_tos", ""));
        supportJstarsEditText.setText(dataCardSharedPref.getString("jstars_name", ""));
        supportJstarsStationTimeEditText.setText(dataCardSharedPref.getString("jstars_tos", ""));
        supportFacEditText.setText(dataCardSharedPref.getString("fac_name", ""));
        supportFacStationTimeEditText.setText(dataCardSharedPref.getString("fac_tos", ""));
        supportTankerEditText.setText(dataCardSharedPref.getString("tanker_name", ""));
        supportTankerStationTimeEditText.setText(dataCardSharedPref.getString("tanker_tos", ""));

        flightBingoEditText.setText(dataCardSharedPref.getString("bingo", "2500 lbs"));
        flightJokerEditText.setText(dataCardSharedPref.getString("joker", "3500 lbs"));

        //Navigation section
        homePlateButton.setText(
            String.format(getContext().getString(R.string.navigation_home_plate_template),
            dataCardSharedPref.getString("home_plate", "None")));

        alternateButton.setText(
            String.format(getContext().getString(R.string.navigation_alternate_template),
            dataCardSharedPref.getString("alternate", "None")));

        //Weapon section
        weaponBombSpacingEditText.setText(dataCardSharedPref.getString("bomb_spacing", "175ft."));
        weaponBurstAltitudeEditText.setText(dataCardSharedPref.getString(
                "burst_altitude", "0000ft. AGL"));
        weaponClusterPatternLengthEditText.setText(
                dataCardSharedPref.getString("pattern_length", ""));
        weaponClusterPatternWidthEditText.setText(
                dataCardSharedPref.getString("pattern_width", ""));
        weaponReleaseModeEditText.setText(dataCardSharedPref.getString("release_mode", "Single"));
        weaponRippleQuantityEditText.setText(dataCardSharedPref.getString("ripple", "1"));
        weaponStickLengthEditText.setText(dataCardSharedPref.getString("stick_length", ""));
        weaponTypeEditText.setText(dataCardSharedPref.getString("weapon_type", ""));
    }

    private void saveDataCard()
    {
        //save current card
        SharedPreferences.Editor editor = dataCardSharedPref.edit();

        editor.putString("callsign", callsignEditText.getText().toString());
        editor.putString("package", packageEditText.getText().toString());

        //aircraft section
        editor.putString("aircraft_type", aircraftTypeEditText.getText().toString());
        editor.putString("aircraft_weight", aircraftWeightEditText.getText().toString());
        editor.putString("aircraft_tgp_code", aircraftTgpCodeEditText.getText().toString());
        editor.putString("aircraft_to_type", aircraftToTypeEditText.getText().toString());
        editor.putString("aircraft_rotate", aircraftRotateEditText.getText().toString());
        editor.putString("aircraft_floor", aircraftFloorEditText.getText().toString());
        editor.putString("aircraft_max_g", aircraftMaxGEditText.getText().toString());
        editor.putString("aircraft_max_speed", aircraftMaxSpeedEditText.getText().toString());
        editor.putString("aircraft_lst_code", aircraftLstCodeEditText.getText().toString());
        editor.putString("aircraft_to_power", aircraftToPowerEditText.getText().toString());
        editor.putString("aircraft_to_speed", aircraftToSpeedEditText.getText().toString());
        editor.putString("aircraft_alow", aircraftAlowEditText.getText().toString());

        //Flight section
        editor.putString("lead_name", flightLeadNameEditText.getText().toString());
        editor.putString("lead_idm", flightLeadIdmEditText.getText().toString());
        editor.putString("lead_tcn", flightLeadTcnEditText.getText().toString());

        editor.putString("wing2_name", flightWing2NameEditText.getText().toString());
        editor.putString("wing2_idm", flightWing2IdmEditText.getText().toString());
        editor.putString("wing2_tcn", flightWing2TcnEditText.getText().toString());

        editor.putString("element_name", flightElementNameEditText.getText().toString());
        editor.putString("element_idm", flightElementIdmEditText.getText().toString());
        editor.putString("element_tcn", flightElementTcnEditText.getText().toString());

        editor.putString("wing4_name", flightWing4NameEditText.getText().toString());
        editor.putString("wing4_idm", flightWing4IdmEditText.getText().toString());
        editor.putString("wing4_tcn", flightWing4TcnEditText.getText().toString());

        editor.putString("flight_notes", flightNotesEditText.getText().toString());

        //package section
        editor.putString("package1_name", package1NameEditText.getText().toString());
        editor.putString("package1_uhf", package1UhfEditText.getText().toString());
        editor.putString("package1_vhf", package1VhfEditText.getText().toString());
        editor.putString("package1_idm", package1IdmEditText.getText().toString());
        editor.putString("package1_tcn", package1TcnEditText.getText().toString());
        editor.putString("package1_tasking", package1TaskingEditText.getText().toString());

        editor.putString("package2_name", package2NameEditText.getText().toString());
        editor.putString("package2_uhf", package2UhfEditText.getText().toString());
        editor.putString("package2_vhf", package2VhfEditText.getText().toString());
        editor.putString("package2_idm", package2IdmEditText.getText().toString());
        editor.putString("package2_tcn", package2TcnEditText.getText().toString());
        editor.putString("package2_tasking", package2TaskingEditText.getText().toString());

        editor.putString("package3_name", package3NameEditText.getText().toString());
        editor.putString("package3_uhf", package3UhfEditText.getText().toString());
        editor.putString("package3_vhf", package3VhfEditText.getText().toString());
        editor.putString("package3_idm", package3IdmEditText.getText().toString());
        editor.putString("package3_tcn", package3TcnEditText.getText().toString());
        editor.putString("package3_tasking", package3TaskingEditText.getText().toString());

        editor.putString("package4_name", package4NameEditText.getText().toString());
        editor.putString("package4_uhf", package4UhfEditText.getText().toString());
        editor.putString("package4_vhf", package4VhfEditText.getText().toString());
        editor.putString("package4_idm", package4IdmEditText.getText().toString());
        editor.putString("package4_tcn", package4TcnEditText.getText().toString());
        editor.putString("package4_tasking", package4TaskingEditText.getText().toString());

        editor.putString("package5_name", package5NameEditText.getText().toString());
        editor.putString("package5_uhf", package5UhfEditText.getText().toString());
        editor.putString("package5_vhf", package5VhfEditText.getText().toString());
        editor.putString("package5_idm", package5IdmEditText.getText().toString());
        editor.putString("package5_tcn", package5TcnEditText.getText().toString());
        editor.putString("package5_tasking", package5TaskingEditText.getText().toString());

        //support section
        editor.putString("awacs_name", supportAwacsEditText.getText().toString());
        editor.putString("awacs_tos", supportAwacsStationTimeEditText.getText().toString());
        editor.putString("jstars_name", supportJstarsEditText.getText().toString());
        editor.putString("jstars_tos", supportJstarsStationTimeEditText.getText().toString());
        editor.putString("fac_name", supportFacEditText.getText().toString());
        editor.putString("fac_tos", supportFacStationTimeEditText.getText().toString());
        editor.putString("tanker_name", supportTankerEditText.getText().toString());
        editor.putString("tanker_tos", supportTankerStationTimeEditText.getText().toString());

        editor.putString("bingo", flightBingoEditText.getText().toString());
        editor.putString("joker", flightJokerEditText.getText().toString());

        //Delivery section
        editor.putString("approach_course", deliveryApproachCourseEditText.getText().toString());
        editor.putString("bomb_range", deliveryBombRangeEditText.getText().toString());
        editor.putString("release_altitude_msl",
                deliveryReleaseAltitudeEditText.getText().toString());
        editor.putString("release_speed_kcas", deliveryReleaseSpeedEditText.getText().toString());
        editor.putString("sight_depression", deliverySightDepressionEditText.getText().toString());
        editor.putString("bomb_time_of_fall", deliveryTimeOfFallEditText.getText().toString());
        editor.putString("release_profile", deliveryTypeEditText.getText().toString());
        editor.putString("msra", deliveryMsraEditText.getText().toString());
        editor.putString("bomb_spacing", weaponBombSpacingEditText.getText().toString());
        editor.putString("burst_altitude", weaponBurstAltitudeEditText.getText().toString());
        editor.putString("pattern_length", weaponClusterPatternLengthEditText.getText().toString());
        editor.putString("pattern_width", weaponClusterPatternWidthEditText.getText().toString());
        editor.putString("release_mode", weaponReleaseModeEditText.getText().toString());
        editor.putString("ripple", weaponRippleQuantityEditText.getText().toString());
        editor.putString("stick_length", weaponStickLengthEditText.getText().toString());
        editor.putString("weapon_type", weaponTypeEditText.getText().toString());

        editor.apply();
    }

    private void setListeners()
    {
        clearDataButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dataCardTextSize = getSelectedCardSize();
                //Log.d("LoadCardFragment", "start button, dataCardTextSize = " + dataCardTextSize);

                dataCardSharedPref.edit().clear().apply();
                loadDataCard();
                //Log.d("LoadCardFragment", "end button, dataCardTextSize = " + dataCardTextSize);
            }
        });

        homePlateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //show dialog with charts of this airbase.
                Dialog dialog = new Dialog(getContext());
                View dialogView = View.inflate(
                        getContext(), R.layout.loadcard_chart_dialog_layout, null);
                ListView listView = (ListView) dialogView.findViewById(
                        R.id.loadcard_chart_dialog_list_view);

                //get provider
                NavigationChartsMapProvider provider = new NavigationChartsMapProvider();

                //find out which country
                String country;
                String selectedBase;
                HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> airbaseHashMap =
                        new HashMap<>();

                country = dataCardSharedPref.getString("home_plate_country", "None");
                selectedBase = dataCardSharedPref.getString("home_plate", "None");

                if (selectedBase.equals("None"))
                {
                    return;
                }

                switch (country)
                {
                    case "south_korea":
                        provider.setSouthKorea();
                        airbaseHashMap = provider.getSouthKoreaHashMap();
                        break;

                    case "north_korea":
                        provider.setNorthKorea();
                        airbaseHashMap = provider.getNorthKoreaHashMap();
                        break;

                    case "japan_korea":
                        provider.setJapanKorea();
                        airbaseHashMap = provider.getJapanKoreaHashMap();
                        break;

                    case "russia_korea":
                        provider.setRussiaKorea();
                        airbaseHashMap = provider.getRussiaKoreaHashMap();
                        break;

                    case "china_korea":
                        provider.setChinaKorea();
                        airbaseHashMap = provider.getChinaKoreaHashMap();
                        break;
                }

                //make adapter
                final ArrayList<NavigationChartsTuple<String, Integer>> tupleArrayList;
                String[] charts;

                tupleArrayList = airbaseHashMap.get(selectedBase);

                charts = new String[tupleArrayList.size()];

                for (int i = 0; i < charts.length; i++)
                {
                    charts[i] = tupleArrayList.get(i).getTitle();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getContext(), android.R.layout.simple_list_item_1, charts);

                //set adapter
                listView.setAdapter(arrayAdapter);
                dialog.setContentView(dialogView);
                dialog.setTitle(selectedBase);

                //set listener for list view
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        //show image view of the chart drawable
                        Dialog imageDialog = new Dialog(getContext());
                        ZoomImageView imageView = new ZoomImageView(getContext());

                        imageView.setImageResource(
                                    tupleArrayList.get(position).getDrawable());
                        imageDialog.setContentView(imageView);
                        imageDialog.setTitle(tupleArrayList.get(position).getTitle());
                        imageDialog.getWindow().setLayout(
                                WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        imageDialog.setCanceledOnTouchOutside(false);
                        imageDialog.show();
                    }
                });

                dialog.show();
            }
        });

        alternateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //show dialog with charts of this airbase.
                Dialog dialog = new Dialog(getContext());
                View dialogView = View.inflate(
                        getContext(), R.layout.loadcard_chart_dialog_layout, null);
                ListView listView = (ListView) dialogView.findViewById(
                        R.id.loadcard_chart_dialog_list_view);

                //get provider
                NavigationChartsMapProvider provider = new NavigationChartsMapProvider();

                //find out which country
                String country;
                String selectedBase;
                HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> airbaseHashMap =
                        new HashMap<>();

                country = dataCardSharedPref.getString("alternate_country", "None");
                selectedBase = dataCardSharedPref.getString("alternate", "None");

                if (selectedBase.equals("None"))
                {
                    return;
                }

                switch (country)
                {
                    case "south_korea":
                        provider.setSouthKorea();
                        airbaseHashMap = provider.getSouthKoreaHashMap();
                        break;

                    case "north_korea":
                        provider.setNorthKorea();
                        airbaseHashMap = provider.getNorthKoreaHashMap();
                        break;

                    case "japan_korea":
                        provider.setJapanKorea();
                        airbaseHashMap = provider.getJapanKoreaHashMap();
                        break;

                    case "russia_korea":
                        provider.setRussiaKorea();
                        airbaseHashMap = provider.getRussiaKoreaHashMap();
                        break;

                    case "china_korea":
                        provider.setChinaKorea();
                        airbaseHashMap = provider.getChinaKoreaHashMap();
                        break;
                }

                //make adapter
                final ArrayList<NavigationChartsTuple<String, Integer>> tupleArrayList;
                String[] charts;

                tupleArrayList = airbaseHashMap.get(selectedBase);

                charts = new String[tupleArrayList.size()];

                for (int i = 0; i < charts.length; i++)
                {
                    charts[i] = tupleArrayList.get(i).getTitle();
                }

                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                        getContext(), android.R.layout.simple_list_item_1, charts);

                //set adapter
                listView.setAdapter(arrayAdapter);
                dialog.setContentView(dialogView);
                dialog.setTitle(selectedBase);

                //set listener for list view
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                    {
                        //show image view of the chart drawable
                        Dialog imageDialog = new Dialog(getContext());
                        ZoomImageView imageView = new ZoomImageView(getContext());

                        imageView.setImageResource(
                                tupleArrayList.get(position).getDrawable());
                        imageDialog.setContentView(imageView);
                        imageDialog.setTitle(tupleArrayList.get(position).getTitle());
                        imageDialog.getWindow().setLayout(
                                WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        imageDialog.setCanceledOnTouchOutside(false);
                        imageDialog.show();
                    }
                });

                dialog.show();
            }
        });
    }
}
