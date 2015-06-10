package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 6/9/2015
 ********************************************************************/
public class KoreaAirbaseArrayAdapter extends ArrayAdapter<String>
{
    private Context CONTEXT;

    private LayoutInflater inflater;
    private String[] airbases;
    private TextView textView;
    private View rowView;

    public KoreaAirbaseArrayAdapter(Context context, String[] airbases)
    {
        super(context, android.R.layout.simple_list_item_1, airbases);

        this.CONTEXT = context;
        this.airbases = airbases;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        textView = (TextView) rowView.findViewById(android.R.id.text1);
        textView.setText(airbases[position]);

        if (airbases[position].contains("Airport Diagram"))
        {
            textView.setTypeface(null, Typeface.BOLD);
            //rowView.setBackgroundColor(Color.parseColor("#E8F2FE"));
        }
        else if (!airbases[position].contains("Airstrips"))
        {
            textView.setPadding(150, 0, 0, 0);
        }

        return rowView;
    }
}
