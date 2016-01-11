package com.oldgoat5.bmstacticalreference.reference;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 ********************************************************************/
public class ReferenceFragment extends Fragment
{
    Context CONTEXT;

    private Dialog dialog;
    private Button brevityDictionaryStartButton;
    private Button carrierFrequenciesButton;
    private Button defaultFrequenciesButton;
    private Button fuelCalculatorButton;
    private Button navigationSteerpointsButton;
    private Button tacanIlsCheckListButton;
    private ZoomImageView tacanIlsCheckListImageView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.reference_fragment_layout,
            container, false);

        brevityDictionaryStartButton = (Button) view.findViewById(
                R.id.brevity_dictionary_select_button);
        carrierFrequenciesButton = (Button) view.findViewById(
                R.id.carrier_frequencies_select_button);
        defaultFrequenciesButton = (Button) view.findViewById(
                R.id.default_frequencies_select_button);
        fuelCalculatorButton = (Button) view.findViewById(
                R.id.fuel_calculator_select_button);
        navigationSteerpointsButton = (Button) view.findViewById(
                R.id.navigation_steerpoints_select_button);
        tacanIlsCheckListButton = (Button) view.findViewById(
                R.id.tacan_ils_checklist_select_button);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        dialog = new Dialog(CONTEXT);

        tacanIlsCheckListImageView = new ZoomImageView(CONTEXT);

        brevityDictionaryStartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startBrevityDictionaryActivity();
            }
        });

        carrierFrequenciesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                dialog.setContentView(R.layout.carrier_frequencies_dialog_layout);
                dialog.setTitle("Carrier Frequencies");
                dialog.show();
            }
        });

        defaultFrequenciesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.setContentView(R.layout.default_frequencies_view);
                dialog.setTitle("Default Frequencies");
                dialog.show();
            }
        });

        fuelCalculatorButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startFuelCalculatorActivity();
            }
        });

        navigationSteerpointsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                dialog.setContentView(R.layout.navigation_steerpoints_view);
                dialog.setTitle(R.string.steerpoints);
                dialog.show();
            }
        });

        tacanIlsCheckListButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                tacanIlsCheckListImageView.setImageResource(R.drawable.tacan_ils_checklist);
                dialog.setContentView(tacanIlsCheckListImageView);
                dialog.setTitle("Tacan ILS Checklist");
                dialog.show();
            }
        });

        return view;
    }

    /*****************************************************************
     * Starts the brevity dictionary activity.
     *****************************************************************/
    private void startBrevityDictionaryActivity()
    {
        Intent intent = new Intent(getActivity(), BrevityDictionaryActivity.class);
        startActivity(intent);
    }

    private void startFuelCalculatorActivity()
    {
        Intent intent = new Intent(getActivity(), FuelCalculatorActivity.class);
        startActivity(intent);
    }
}
