package com.oldgoat5.bmstacticalreference;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.PagerItem;
import com.oldgoat5.bmstacticalreference.tools.slidingtabs.SlidingTabLayout;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 ********************************************************************/
public class MainActivity extends FragmentActivity
{
    final ColorDrawable toolbarBackground = new ColorDrawable();
    final ColorDrawable sliderBackground = new ColorDrawable();

    private AppBarLayout appBarLayout;
    private ArrayList<PagerItem> tabsList;
    private DrawerLayout drawerLayout;
    private ImageView drawerToggle;
    private ImageView serverImageView;
    private ImageView settingsImageView;
    private ImageView uploadImageView;
    private MainFragmentPageAdapter fragmentPageAdapter;
    private RelativeLayout drawerChildLayout;
    private RequestQueue requestQueue;
    private SlidingTabLayout slidingTabLayout;
    private ViewPager viewPager;
    private WebView serverWebView;

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
                getResources().getColor(R.color.toolbar_blue)));
        tabsList.add(new PagerItem("Tactical Reference",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.toolbar_blue)));
        tabsList.add(new PagerItem("Reference",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.toolbar_blue)));
        tabsList.add(new PagerItem("Fuel Calculator",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.toolbar_blue)));
        tabsList.add(new PagerItem("Navigation",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.toolbar_blue)));
        tabsList.add(new PagerItem("Mission Planner",
                getResources().getColor(R.color.silver),
                getResources().getColor(R.color.toolbar_blue)));

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

                final int blendedStatusbar = blendColors(
                        ContextCompat.getColor(getApplicationContext(), to.getStatusBarColor()),
                        ContextCompat.getColor(getApplicationContext(), from.getStatusBarColor()),
                        positionOffset);

                toolbarBackground.setColor(blendedToolbar);
                sliderBackground.setColor(blendedToolbar);
                if (drawerChildLayout != null)
                {
                    drawerChildLayout.setBackgroundColor(blendedToolbar);
                }

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Window window = getWindow();
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    window.setStatusBarColor(blendedStatusbar);
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

    @Override
    public void onStop()
    {
        super.onStop();
        if (requestQueue != null)
        {
            requestQueue.cancelAll(this);
        }
    }

   private int blendColors(int from, int to, float ratio) {
        final float inverseRation = 1f - ratio;
        final float r = Color.red(from) * ratio + Color.red(to) * inverseRation;
        final float g = Color.green(from) * ratio + Color.green(to) * inverseRation;
        final float b = Color.blue(from) * ratio + Color.blue(to) * inverseRation;
        return Color.rgb((int) r, (int) g, (int) b);
    }

    private void loadFOServerViewer()
    {
        final String url = "http://www.falcon-online.org/forum";
        ImageView serverImageView = (ImageView) findViewById(R.id.left_drawer_image_view);
        Button forceServerImageButton = (Button)
                findViewById(R.id.left_drawer_force_server_image_button);
        TextView errorTextView = (TextView) findViewById(R.id.left_drawer_web_view_error_text_view);
        serverWebView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),
                R.color.falcon_online_background));

        forceServerImageButton.setOnClickListener(v ->
        {
            downloadServerImage();
            forceServerImageButton.setVisibility(View.GONE);
        });
        requestQueue = Volley.newRequestQueue(this);
        StringRequest request = new StringRequest(Request.Method.GET, url,
                response ->
                {
                    serverWebView.setVisibility(View.VISIBLE);
                    errorTextView.setVisibility(View.GONE);
                    Document dom = Jsoup.parse(response);
                    Element serverViewDiv = dom.getElementById("sp_block_25");
                    serverWebView.loadData(serverViewDiv.html(), "text/html", "UTF-8");
                    String divText = serverViewDiv.html();
                    int tempIndex = 0;
                    int offlineCount = 0;
                    while (tempIndex != -1)
                    {
                        tempIndex = divText.indexOf("OFFLINE", tempIndex);
                        if (tempIndex != -1)
                        {
                            offlineCount++;
                            tempIndex += "OFFLINE".length();
                        }
                    }
                    if (offlineCount < 2)
                    {
                        downloadServerImage();
                    } else
                    {
                        serverImageView.setVisibility(View.GONE);
                        forceServerImageButton.setVisibility(View.VISIBLE);
                    }
                }, error ->
                {
                    serverWebView.setVisibility(View.GONE);
                    errorTextView.setVisibility(View.GONE);
                    serverImageView.setVisibility(View.GONE);
                });
        request.setTag(this);
        requestQueue.add(request);
    }

    public void downloadServerImage()
    {
        final Bitmap[] serverBitmap = {null};

        new AsyncTask<Void, Void, Void>()
        {
            @Override
            protected Void doInBackground(Void... params)
            {
                try
                {
                    InputStream is = (InputStream) new URL(
                            "http://falcon-online.org/server/viewer/wincap.jpg").getContent();
                    serverBitmap[0] = BitmapFactory.decodeStream(is);
                } catch (IOException e)
                {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Void result)
            {
                if (serverBitmap != null)
                {
                    serverImageView.setVisibility(View.VISIBLE);
                    serverImageView.setImageBitmap(serverBitmap[0]);
                }
            }
        }.execute();
    }

    private void setListeners()
    {
        appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerChildLayout = (RelativeLayout) findViewById(R.id.left_drawer);

        drawerToggle = (ImageView) findViewById(R.id.drawer_toggle);
        serverImageView = (ImageView) findViewById(R.id.left_drawer_image_view);
        settingsImageView = (ImageView) findViewById(R.id.settings_icon);
        uploadImageView = (ImageView) findViewById(R.id.upload_icon);

        drawerLayout.setScrimColor(
                ContextCompat.getColor(getApplicationContext(), R.color.steamed_glass));

        serverWebView = (WebView) findViewById(R.id.left_drawer_web_view);

        drawerToggle.setOnClickListener(v -> toggleDrawer());

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

    private void toggleDrawer()
    {
        if (drawerLayout == null)
        {
            return;
        }

        if (drawerLayout.isDrawerVisible(drawerChildLayout))
        {
            drawerLayout.closeDrawer(drawerChildLayout);
            if (requestQueue != null)
            {
                requestQueue.cancelAll(this);
            }
            serverWebView.setVisibility(View.GONE);
            serverImageView.setVisibility(View.GONE);
            serverWebView.loadUrl("about:blank");
            serverImageView.setImageBitmap(null);
        }
        else
        {
            if (appBarLayout != null)
            {
                appBarLayout.setExpanded(true, true);
            }
            drawerLayout.openDrawer(drawerChildLayout);
            loadFOServerViewer();
        }
    }
}
