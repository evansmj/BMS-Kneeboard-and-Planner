package com.oldgoat5.bmstacticalreference;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.oldgoat5.bmstacticalreference.tools.slidingtabs.PagerItem;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.SlidingTabLayout;

import java.util.ArrayList;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 ********************************************************************/
public class MainActivity extends FragmentActivity
{
    int grossWeight;
    int totalDrag;

    private ArrayList<PagerItem> tabsList;
    private ImageView settingsImageView;
    private ImageView uploadImageView;
    private MainFragmentPageAdapter fragmentPageAdapter;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabsList = new ArrayList<PagerItem>();

        tabsList.add(new PagerItem("Load Card",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Tactical Reference",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Reference",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Fuel Calculator",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Navigation",
                getResources().getColor(R.color.silver), Color.GRAY));
        tabsList.add(new PagerItem("Mission Planner",
                getResources().getColor(R.color.silver), Color.GRAY));

        viewPager = (ViewPager) findViewById(R.id.main_pager);
        viewPager.setAdapter(new MainFragmentPageAdapter(getSupportFragmentManager(),
                MainActivity.this));

        slidingTabLayout = (SlidingTabLayout) findViewById(R.id.main_sliding_tabs);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setTabTitleTextColor("#D5DADD");
        slidingTabLayout.setViewPager(viewPager);

        slidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer()
        {
            @Override
            public int getIndicatorColor(int position)
            {
                return tabsList.get(position).getIndicatorColor();
            }

            public int getDividerColor(int position)
            {
                return tabsList.get(position).getDividerColor();
            }
        });

        setListeners();
    }

    private void setListeners()
    {
        settingsImageView = (ImageView) findViewById(R.id.settings_icon);
        uploadImageView = (ImageView) findViewById(R.id.upload_icon);

        settingsImageView.setOnClickListener(v -> startSettingsActivity());
        uploadImageView.setOnClickListener(v -> showUploadChoiceDialog());
    }

    private void showUploadChoiceDialog()
    {
        Dialog dialog = new Dialog(this);

        View dialogView = View.inflate(
                this, R.layout.data_card_upload_dialog_layout, null);

        Button gallery = (Button) dialogView.findViewById(R.id.data_card_upload_gallery_button);
        Button camera = (Button) dialogView.findViewById(R.id.data_card_upload_camera_button);

        dialog.setTitle("Select DataCard Upload method");
        dialog.setContentView(dialogView);
        dialog.show();
    }

    private void startSettingsActivity()
    {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }
}
