package com.oldgoat5.bmstacticalreference;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TacticalReferenceFragment extends Fragment
{
    private View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.tactical_reference_fragment_layout , 
            container, false); // TODO add tactical formation reference pictures.  
        return view;
    }
    
}
