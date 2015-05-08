package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

/*********************************************************************
 * @author Michael Evans
 * @version 5/8/2015
 *********************************************************************/
public class koreaNavigation extends Activity
{
    private Button chinaSelectButton;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.korea_navigation_activity_layout);

        chinaSelectButton = (Button) findViewById(R.id.china_select_button);
    }
}
