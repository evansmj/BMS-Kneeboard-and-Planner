package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/*********************************************************************
 * Shows a list of Chinese charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class ChinaKoreaTabActivity extends Activity
{
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private String[] airbases;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.china_korea_tab_activity_layout);

        airbases = new String[] {"base 1", "base 2"};
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, airbases);
        listView = (ListView) findViewById(R.id.china_korea_tab_list_view);

        listView.setAdapter(adapter);
    }
}
