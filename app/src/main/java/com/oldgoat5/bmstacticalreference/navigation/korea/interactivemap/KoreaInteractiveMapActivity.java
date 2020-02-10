package com.oldgoat5.bmstacticalreference.navigation.korea.interactivemap;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 3/6/2016
 *
 * Contains RedDog's Korea Interactive Map.
 *********************************************************************/
public class KoreaInteractiveMapActivity extends Activity
{
    private final String lowMap = "file:///android_asset/korea_interactive_map/" +
            "Interactive Map for Korea (BMS 4.33).html";

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea_interactive_map_activity);

        instantiateResources();
    }

    @Override
    public void onBackPressed()
    {
        if (webView.canGoBack())
        {
            webView.goBack();
        }
        else
        {
            super.onBackPressed();
        }
    }

    private void instantiateResources()
    {
        webView = (WebView) findViewById(R.id.korea_interactive_map_web_view);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.setInitialScale(1);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(lowMap);
    }
}
