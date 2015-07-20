package com.oldgoat5.bmstacticalreference.navigation.balkans;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.navigation.ZoomImageView;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 6/6/2015
 *********************************************************************/
public class SloveniaBalkansChartFragment extends Fragment
{
    Context CONTEXT;

    private Dialog dialog;
    private ImageView imageView;
    private View view;
    private ZoomImageView zoomImageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.slovenia_balkans_chart_fragment_layout, container, false);

        Log.d("SloveniaBalkans", "onCreateView()");

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        imageView = (ImageView) view.findViewById(R.id.slovenia_balkans_image_view);

        dialog = new Dialog(CONTEXT);
        zoomImageView = new ZoomImageView(CONTEXT);

        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                zoomImageView.setImageResource(R.drawable.slovenia_airbases);
                dialog.setContentView(zoomImageView);
                dialog.setTitle("Slovenia Airbases");
                dialog.show();
            }
        });

        return view;
    }
}
