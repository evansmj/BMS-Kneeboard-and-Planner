package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author michael
 * @since 9/17/2015
 *********************************************************************/
public class SettingsActivity extends Activity
{
    private Button applyButton;
    private RadioGroup cardRadioGroup;
    private SharedPreferences dataCardPref;

    private int selectedCardSize; //don't use enum, unnecessary overhead
    private int selectedRadioButton;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity_layout);

        instantiateResources();

        setListeners();
    }

    private void instantiateResources()
    {
        applyButton = (Button) findViewById(R.id.settings_activity_apply_button);
        cardRadioGroup = (RadioGroup) findViewById(R.id.settings_activity_card_size_radio_group);

        dataCardPref = getApplicationContext().getSharedPreferences("DataCard", 0);

        switch(dataCardPref.getInt("cardSize", 1))
        {
            case 0:
                selectedRadioButton = R.id.settings_activity_card_size_small_radio_button;
                break;
            case 1:
                selectedRadioButton = R.id.settings_activity_card_size_medium_radio_button;
                break;
            case 2:
                selectedRadioButton = R.id.settings_activity_card_size_large_radio_button;
                break;
        }

        cardRadioGroup.check(selectedRadioButton);
    }

    private void setListeners()
    {
        applyButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dataCardPref = getApplicationContext().getSharedPreferences(
                        "DataCard", 0);
                SharedPreferences.Editor editor = dataCardPref.edit();
                editor.putInt("cardSize", selectedCardSize);
                editor.apply();
                //todo make card redraw layout

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
                        selectedCardSize = 0; //small //don't use enum unless good idea
                        break;

                    case R.id.settings_activity_card_size_medium_radio_button:
                        selectedCardSize = 1; //medium
                        break;

                    case R.id.settings_activity_card_size_large_radio_button:
                        selectedCardSize = 2; //large
                        break;

                    default:
                        selectedCardSize = 1;
                        break;
                }
            }
        });
    }
}
