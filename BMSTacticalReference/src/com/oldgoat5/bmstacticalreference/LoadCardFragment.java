package com.oldgoat5.bmstacticalreference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class LoadCardFragment extends Fragment
{
    TextView grossWeightTextView;
    TextView totalDragTextView;
    View view;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.loadcard_fragment_layout, container, false);
        grossWeightTextView = (TextView) view.findViewById(R.id.grossWeightTextView);
        totalDragTextView = (TextView) view.findViewById(R.id.dragTextView);
        
        
        
        
        return view;
    }
    
}
