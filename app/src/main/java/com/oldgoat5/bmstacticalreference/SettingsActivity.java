package com.oldgoat5.bmstacticalreference;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioGroup;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 9/17/2015
 *********************************************************************/
public class SettingsActivity extends AppCompatActivity
{
    private Button applyButton;
    private ImageView aboutButton;
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
        aboutButton = (ImageView) findViewById(R.id.about_icon);
        applyButton = (Button) findViewById(R.id.settings_activity_apply_button);
        cardRadioGroup = (RadioGroup) findViewById(R.id.settings_activity_card_size_radio_group);
        Toolbar toolbar = (Toolbar) findViewById(R.id.settings_activity_toolbar);
        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.silver));
        setSupportActionBar(toolbar);
    }

    private void setListeners()
    {
        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
            }
        });

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
