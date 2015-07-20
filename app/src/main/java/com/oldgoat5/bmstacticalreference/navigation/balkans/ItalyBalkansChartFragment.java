package com.oldgoat5.bmstacticalreference.navigation.balkans;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
 * @since 6/1/2015
 *********************************************************************/
public class ItalyBalkansChartFragment extends Fragment
{
    Context CONTEXT;

    private Dialog dialog;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private View view;
    private ZoomImageView zoomImageView;

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

        //TODO add - if infochart ImageView onClick(), show ZoomImageView dialog with chart to allow easy zooming.

        dialog = new Dialog(CONTEXT);
        zoomImageView = new ZoomImageView(CONTEXT);
        imageView1 = (ImageView) view.findViewById(R.id.italy_balkans_image_view1);
        imageView2 = (ImageView) view.findViewById(R.id.italy_balkans_image_view2);
        imageView3 = (ImageView) view.findViewById(R.id.italy_balkans_image_view3);

        imageView1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //((ViewGroup) view.getParent()).removeView(view);
                zoomImageView.setImageResource(R.drawable.italy_1_airbases);
                dialog.setContentView(zoomImageView);
                dialog.setTitle("Italy Airbases");
                dialog.show();
                dialog.setOnDismissListener(new DialogInterface.OnDismissListener()
                {
                    @Override
                    public void onDismiss(DialogInterface dialogInterface)
                    {

                    }
                });
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //((ViewGroup) view.getParent()).removeView(view);
                zoomImageView.setImageResource(R.drawable.italy_2_airbases);
                dialog.setContentView(zoomImageView);
                dialog.setTitle("Italy Airbases");
                dialog.show();
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //((ViewGroup) view.getParent()).removeView(view);
                zoomImageView.setImageResource(R.drawable.italy_3_airbases);
                dialog.setContentView(zoomImageView);
                dialog.setTitle("Italy Airbases");
                dialog.show();
            }
        });

        return view;
    }
}
