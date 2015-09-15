package com.oldgoat5.bmstacticalreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/********************************************************************
 *Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 ********************************************************************/
public class LoadCardFragment extends Fragment
{
    private TextView grossWeightTextView;
    private TextView totalDragTextView;
    private View view;

    //todo reorganize tools package
    //todo setting to change text size.

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.loadcard_fragment_layout, container, false);
        //grossWeightTextView = (TextView) view.findViewById(R.id.grossWeightTextView);
        //totalDragTextView = (TextView) view.findViewById(R.id.dragTextView);
        
        SharedPreferences dataCard = getActivity().getSharedPreferences("DataCard", 0);

        int grossWeight = dataCard.getInt("grossWeight", 0);
        //grossWeightTextView.setText(grossWeight + "lbs");
        
        return view;
    }
    
}
