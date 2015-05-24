package com.oldgoat5.bmstacticalreference;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ReferenceFragment extends Fragment
{
    Context CONTEXT;

    private Dialog defaultFrequenciesDialog;
    private Dialog navigationSteerpointsDialog;
    private Button brevityDictionaryStartButton;
    private Button defaultFrequenciesButton;
    private Button navigationSteerpointsButton;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.reference_fragment_layout,
            container, false);

        brevityDictionaryStartButton = (Button) view.findViewById(
                R.id.brevity_dictionary_select_button);
        defaultFrequenciesButton = (Button) view.findViewById(
                R.id.default_frequencies_select_button);
        navigationSteerpointsButton = (Button) view.findViewById(
                R.id.navigation_steerpoints_select_button);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        navigationSteerpointsDialog = new Dialog(CONTEXT);
        defaultFrequenciesDialog = new Dialog(CONTEXT);

        brevityDictionaryStartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startBrevityDictionaryActivity();
            }
        });

        defaultFrequenciesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                defaultFrequenciesDialog.setContentView(R.layout.default_frequencies_view);
                defaultFrequenciesDialog.setTitle("Default Frequencies");
                defaultFrequenciesDialog.show();
            }
        });

        navigationSteerpointsButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                navigationSteerpointsDialog.setContentView(R.layout.navigation_steerpoints_view);
                navigationSteerpointsDialog.setTitle(R.string.steerpoints);
                navigationSteerpointsDialog.show();
            }
        });

        // TODO add tactical formation reference pictures.
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
}
