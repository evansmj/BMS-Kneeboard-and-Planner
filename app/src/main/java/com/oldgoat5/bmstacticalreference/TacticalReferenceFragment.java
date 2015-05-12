package com.oldgoat5.bmstacticalreference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TacticalReferenceFragment extends Fragment
{
    private Button brevityDictionaryStartButton;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.tactical_reference_fragment_layout , 
            container, false);

        brevityDictionaryStartButton = (Button) view.findViewById(
                R.id.brevity_dictionary_select_button);

        brevityDictionaryStartButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startBrevityDictionaryActivity();
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
