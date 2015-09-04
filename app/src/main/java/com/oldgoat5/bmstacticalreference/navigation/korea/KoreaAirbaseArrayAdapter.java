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
        ViewHolder viewHolder;

        if (convertView == null)
        {

            inflater = (LayoutInflater) CONTEXT.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(android.R.layout.simple_list_item_1, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.airbaseNameTextView = (TextView) convertView.findViewById(android.R.id.text1);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.airbaseNameTextView.setText(airbases[position]);

        if (airbases[position].contains("Airport Diagram"))
        {
            viewHolder.airbaseNameTextView.setTypeface(null, Typeface.BOLD);
            //default padding 6dp for simple_list_item
            int dpValue = 6;
            float d = CONTEXT.getResources().getDisplayMetrics().density;
            int padding = (int) (dpValue * d);
            viewHolder.airbaseNameTextView.setPadding(padding, 0, 0, padding);
        }
        else if (!airbases[position].contains("Airstrips"))
        {
            int dpValue = 75;
            float d = CONTEXT.getResources().getDisplayMetrics().density;
            int padding = (int) (dpValue * d);
            viewHolder.airbaseNameTextView.setPadding(padding, 0, 0, 0);
            viewHolder.airbaseNameTextView.setTypeface(Typeface.DEFAULT);
        }

        return convertView;
    }

    private static class ViewHolder
    {
        TextView airbaseNameTextView;
    }
}
