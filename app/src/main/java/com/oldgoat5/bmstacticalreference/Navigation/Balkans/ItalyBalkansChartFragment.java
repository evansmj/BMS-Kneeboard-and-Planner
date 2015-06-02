package com.oldgoat5.bmstacticalreference.Navigation.Balkans;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.Navigation.ZoomImageView;
import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * @author Michael Evans
 * @since 6/1/2015
 *********************************************************************/
public class ItalyBalkansChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayAdapter<String> adapter;
    private Dialog dialog;
    private ZoomImageView imageView1;
    private ZoomImageView imageView2;
    private ZoomImageView imageView3;
    private ListView listView;
    private String[][] airbases;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.italy_balkans_chart_fragment_layout, container, false);

        Log.d("italyBalkans", "onCreateView()");

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }
/*
        imageView1 = new ZoomImageView(CONTEXT);
        imageView1.setImageResource(R.drawable.italy_1_airbases);

        imageView2 = new ZoomImageView(CONTEXT);
        imageView2.setImageResource(R.drawable.italy_2_airbases);

        imageView3 = new ZoomImageView(CONTEXT);
        imageView3.setImageResource(R.drawable.italy_3_airbases);*/

        return view;
    }
}