package com.oldgoat5.bmstacticalreference.navigation.aegean;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 8/29/2015
 *********************************************************************/
public class AegeanAirbaseArrayAdapter extends ArrayAdapter<String>
{
    private Context CONTEXT;

    private LayoutInflater inflater;
    private String[] charts;
    private TextView textView;
    private View rowView;

    public AegeanAirbaseArrayAdapter(Context context, String[] charts)
    {
        super(context, android.R.layout.simple_list_item_1, charts);

        this.CONTEXT = context;
        this.charts = charts;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        rowView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);

        textView = (TextView) rowView.findViewById(android.R.id.text1);
        textView.setText(charts[position]);

        if (charts[position].contains("Airport Diagram"))
        {
            textView.setTypeface(null, Typeface.BOLD);
            //rowView.setBackgroundColor(Color.parseColor("#E8F2FE"));
        }
        else if (!charts[position].contains("Assimi") || !charts[position].contains("Sakyatan"))
        {
            textView.setPadding(150, 0, 0, 0);
        }

        return rowView;
    }

}
