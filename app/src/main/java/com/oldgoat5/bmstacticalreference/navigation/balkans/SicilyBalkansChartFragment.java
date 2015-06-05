package com.oldgoat5.bmstacticalreference.navigation.balkans;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * @author Michael Evans
 * @since 6/2/2015
 *********************************************************************/
public class SicilyBalkansChartFragment extends Fragment
{
    Context CONTEXT;

    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.sicily_balkans_chart_fragment_layout, container, false);

        Log.d("SicilyBalkans", "onCreateView()");

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        return view;
    }
}
