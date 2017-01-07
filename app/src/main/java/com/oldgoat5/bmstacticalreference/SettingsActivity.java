package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 9/17/2015
 *********************************************************************/
public class SettingsActivity extends Activity
{
    private Button applyButton;
    private RadioGroup cardRadioGroup;
    private SharedPreferences settingsSharedPref;

    private int selectedCardSize;
    private int selectedRadioButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity_layout);

        settingsSharedPref = getApplicationContext().getSharedPreferences(
                DataCardFragment.SETTINGS_NAME, 0);

        selectedCardSize = settingsSharedPref.getInt("card_size",
                android.R.style.TextAppearance_Medium);

        instantiateResources();
        checkRadioButton();
        setListeners();
    }

    @Override
    public void onResume()
    {
        super.onResume();

        selectedCardSize = settingsSharedPref.getInt("card_size",
                android.R.style.TextAppearance_Medium);

        checkRadioButton();
    }

    private void checkRadioButton()
    {
        switch(selectedCardSize)
        {
            case android.R.style.TextAppearance_Small:
                selectedRadioButton = R.id.settings_activity_card_size_small_radio_button;
                break;
            case android.R.style.TextAppearance_Medium:
                selectedRadioButton = R.id.settings_activity_card_size_medium_radio_button;
                break;
            case android.R.style.TextAppearance_Large:
                selectedRadioButton = R.id.settings_activity_card_size_large_radio_button;
                break;
        }

        cardRadioGroup.check(selectedRadioButton);
    }

    private void instantiateResources()
    {
        applyButton = (Button) findViewById(R.id.settings_activity_apply_button);
        cardRadioGroup = (RadioGroup) findViewById(R.id.settings_activity_card_size_radio_group);
    }

    private void setListeners()
    {
        applyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                settingsSharedPref.edit().putInt("card_size", selectedCardSize).apply();

                finish();
            }
        });

        cardRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i)
            {
                switch (i)
                {
                    case R.id.settings_activity_card_size_small_radio_button:
                        selectedCardSize = android.R.style.TextAppearance_Small;
                        break;

                    case R.id.settings_activity_card_size_medium_radio_button:
                        selectedCardSize = android.R.style.TextAppearance_Medium;
                        break;

                    case R.id.settings_activity_card_size_large_radio_button:
                        selectedCardSize = android.R.style.TextAppearance_Large;
                        break;
                }
            }
        });
    }
}
