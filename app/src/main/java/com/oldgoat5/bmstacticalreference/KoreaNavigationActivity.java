package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

/*********************************************************************
 * @author Michael Evans
 * @version 5/8/2015
 *********************************************************************/
public class KoreaNavigationActivity extends Activity
{
    private TabHost tabHost;
    private TabHost.TabSpec chinaTab;
    private TabHost.TabSpec japanTab;
    private TabHost.TabSpec northKoreaTab;
    private TabHost.TabSpec russiaTab;
    private TabHost.TabSpec southKoreaTab;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea_navigation_activity_layout);

        tabHost = (TabHost) findViewById(R.id.korea_navigation_tab_host);
        chinaTab = tabHost.newTabSpec("China Tab");
        japanTab = tabHost.newTabSpec("Japan Tab");
        northKoreaTab = tabHost.newTabSpec("North Korea Tab");
        russiaTab = tabHost.newTabSpec("Russia Tab");
        southKoreaTab = tabHost.newTabSpec("South Korea Tab");

        chinaTab.setIndicator("China");
        japanTab.setIndicator("Japan");
        northKoreaTab.setIndicator("North Korea");
        russiaTab.setIndicator("Russia");
        southKoreaTab.setIndicator("South Korea");

        chinaTab.setContent(new Intent(this, ChinaKoreaTabActivity.class));
        japanTab.setContent(new Intent(this, JapanKoreaTabActivity.class));
        northKoreaTab.setContent(new Intent(this, NorthKoreaTabActivity.class));
        russiaTab.setContent(new Intent(this, RussiaKoreaTabActivity.class));
        southKoreaTab.setContent(new Intent(this, SouthKoreaTabActivity.class));
    }
}
