package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 7/15/2015
 *********************************************************************/
public class ThreatListItemAdapter extends ArrayAdapter<ThreatObject>
{
    private final Context CONTEXT;
    private final ArrayList<ThreatObject> itemsArrayList;

    public ThreatListItemAdapter(Context context, ArrayList<ThreatObject> itemsArrayList)
    {
        super(context, R.layout.threat_object_layout, itemsArrayList);

        this.CONTEXT = context;
        this.itemsArrayList = itemsArrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(
                    R.layout.threat_object_layout, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.nameTextView = (TextView) convertView.findViewById(
                                                                        R.id.threat_name_text_view);
            viewHolder.minEngRangeTextView = (TextView) convertView.findViewById(
                                                               R.id.threat_min_eng_range_text_view);
            viewHolder.guidanceTextView = (TextView) convertView.findViewById(
                                                                    R.id.threat_guidance_text_view);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.nameTextView.setText((itemsArrayList).get(position).getName());
        viewHolder.minEngRangeTextView.setText("\nMinEngRange: " + Integer.toString(
                (itemsArrayList).get(position).getMinEngRange()) + " ft.");
        viewHolder.guidanceTextView.setText("Guidance: " + (itemsArrayList).get(position)
                                                                           .getGuidance());

        if ((position % 2) == 0)
        {
            convertView.setBackgroundColor(CONTEXT.getResources().getColor(R.color.light_red));
        }
        else
        {
            convertView.setBackgroundColor(CONTEXT.getResources().getColor(R.color.transparent));
        }

        return convertView;
    }

    private static class ViewHolder
    {
        TextView nameTextView;
        TextView minEngRangeTextView;
        TextView guidanceTextView;
    }
}
