package com.oldgoat5.bmstacticalreference;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/********************************************************************
 *Copyright © Michael Evans - All Rights Reserved.
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
    private EditText deliveryApproachCourseEditText;
    private EditText deliveryMsraEditText;
    private EditText deliveryBombRangeEditText;
    private EditText deliveryReleaseAltitudeEditText;
    private EditText deliveryReleaseSpeedEditText;
    private EditText deliverySightDepressionEditText;
    private EditText deliveryTimeOfFallEditText;
    private EditText deliveryTypeEditText;
    private EditText flightBingoEditText;
    private EditText flightJokerEditText;
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

        flightBingoEditText = (EditText) view.findViewById(R.id.data_card_bingo_edit_text);
        flightJokerEditText = (EditText) view.findViewById(R.id.data_card_joker_edit_text);

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

        //Flight section
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
    }
}
