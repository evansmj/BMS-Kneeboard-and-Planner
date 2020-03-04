package com.oldgoat5.bmstacticalreference.reference;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.appbar.AppBarLayout;
import com.oldgoat5.bmstacticalreference.ColorFragment;
import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 ********************************************************************/
public class ReferenceFragment extends ColorFragment
{
    Context CONTEXT;

    private AppBarLayout appBarLayout;
    private Dialog dialog;
    private Button brevityDictionaryStartButton;
    private Button carrierFrequenciesButton;
    private Button defaultFrequenciesButton;
    private Button fuelCalculatorButton;
    private Button navigationSteerpointsButton;
    private Button takeoffCalculatorButton;
    private Button tacanIlsCheckListButton;
    private ZoomImageView tacanIlsCheckListImageView;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.reference_fragment_layout,
            container, false);

        appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar_layout);

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
        takeoffCalculatorButton = (Button) view.findViewById(R.id.takeoff_calculator_select_button);
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
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
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
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
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
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });

        takeoffCalculatorButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startTakeoffCalculatorActivity();
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
                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean visible)
    {
        if (visible && appBarLayout != null)
        {
            appBarLayout.setExpanded(true, true);
        }
    }

    @Override
    public int getBackgroundColor()
    {
        return R.color.toolbar_gray;
    }

    @Override
    public int getStatusBarColor()
    {
        return R.color.statusbar_gray;
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

    private void startTakeoffCalculatorActivity()
    {
        Intent intent = new Intent(getActivity(), TakeoffCalculatorActivity.class);
        startActivity(intent);
    }
}
