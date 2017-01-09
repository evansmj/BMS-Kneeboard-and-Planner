package com.oldgoat5.bmstacticalreference;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.tools.slidingtabs.PagerItem;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.SlidingTabLayout;

import java.util.ArrayList;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 ********************************************************************/
public class MainActivity extends FragmentActivity
{
    final ColorDrawable toolbarBackground = new ColorDrawable();
    final ColorDrawable sliderBackground = new ColorDrawable();

    private ArrayList<PagerItem> tabsList;
    private DrawerLayout drawerLayout;
    private ImageView drawerToggle;
    private ImageView settingsImageView;
    private ImageView aboutImageView;
    private ListView drawerListView;
    private ImageView uploadImageView;
    private MainFragmentPageAdapter fragmentPageAdapter;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_widget);
            SlidingTabLayout slidingTabLayout =
                    (SlidingTabLayout) findViewById(R.id.main_sliding_tabs);

            slidingTabLayout.setBackground(sliderBackground);
            toolbar.setBackground(toolbarBackground);
        }

        tabsList = new ArrayList<>();

        tabsList.add(new PagerItem("Load Card",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.dark_blue)));
        tabsList.add(new PagerItem("Tactical Reference",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.dark_blue)));
        tabsList.add(new PagerItem("Reference",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.dark_blue)));
        tabsList.add(new PagerItem("Fuel Calculator",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.dark_blue)));
        tabsList.add(new PagerItem("Navigation",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.dark_blue)));
        tabsList.add(new PagerItem("Mission Planner",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.dark_blue)));

        fragmentPageAdapter = new MainFragmentPageAdapter(getSupportFragmentManager(),
                MainActivity.this);

        viewPager = (ViewPager) findViewById(R.id.main_pager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener()
        {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
            {
                if (position >= fragmentPageAdapter.getCount() - 1) {
                    // Guard against ArrayIndexOutOfBoundsException
                    return;
                }
                final ColorFragment from = (ColorFragment) fragmentPageAdapter.getItem(position);
                final ColorFragment to = (ColorFragment) fragmentPageAdapter.getItem(position + 1);

                final int blendedToolbar = blendColors(
                        ContextCompat.getColor(getApplicationContext(), to.getBackgroundColor()),
                        ContextCompat.getColor(getApplicationContext(), from.getBackgroundColor()),
                        positionOffset);
                toolbarBackground.setColor(blendedToolbar);
                sliderBackground.setColor(blendedToolbar);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(blendedToolbar);
                }
            }

            @Override
            public void onPageSelected(int position)
            {

            }

            @Override
            public void onPageScrollStateChanged(int state)
            {

            }
        });

        viewPager.setAdapter(fragmentPageAdapter);

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

   private int blendColors(int from, int to, float ratio) {
        final float inverseRation = 1f - ratio;
        final float r = Color.red(from) * ratio + Color.red(to) * inverseRation;
        final float g = Color.green(from) * ratio + Color.green(to) * inverseRation;
        final float b = Color.blue(from) * ratio + Color.blue(to) * inverseRation;
        return Color.rgb((int) r, (int) g, (int) b);
    }

    private void setListeners()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerListView = (ListView) findViewById(R.id.left_drawer);

        drawerToggle = (ImageView) findViewById(R.id.drawer_toggle);
        settingsImageView = (ImageView) findViewById(R.id.settings_icon);
        uploadImageView = (ImageView) findViewById(R.id.upload_icon);

        drawerLayout.setScrimColor(
                ContextCompat.getColor(getApplicationContext(), R.color.steamed_glass));

        drawerListView.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1));
        drawerListView.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                toggleDrawer();
            }
        });
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

    private void selectItem(int position)
    {
        switch (position)
        {
            case 0:
                break;
            case 1:
                break;
        }
    }

    private void startAboutActivity()
    {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    private void startSettingsActivity()
    {
        Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
        startActivity(intent);
    }

    private void toggleDrawer()
    {
        if (drawerLayout == null)
        {
            return;
        }

        if (drawerLayout.isDrawerVisible(drawerListView))
        {
            drawerLayout.closeDrawer(drawerListView);
        }
        else
        {
            drawerLayout.openDrawer(drawerListView);
        }
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            selectItem(position);
        }
    }
}
