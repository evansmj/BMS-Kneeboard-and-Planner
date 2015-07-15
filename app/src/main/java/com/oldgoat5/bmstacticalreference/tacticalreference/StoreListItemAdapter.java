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
public class StoreListItemAdapter extends ArrayAdapter<StoreObject>
{
    private final Context CONTEXT;
    private final ArrayList<StoreObject> itemsArrayList;

    public StoreListItemAdapter(Context context, ArrayList<StoreObject> itemsArrayList)
    {
        super(context, R.layout.store_object_layout, itemsArrayList);

        this.CONTEXT = context;
        this.itemsArrayList = itemsArrayList;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(
                R.layout.store_object_layout, parent, false);

        TextView nameTextView = (TextView) rowView.findViewById(R.id.store_name_text_view);
        TextView weightTextView = (TextView) rowView.findViewById(R.id.store_weight_text_view);
        TextView dragTextView = (TextView) rowView.findViewById(R.id.store_drag_text_view);

        nameTextView.setText((itemsArrayList).get(position).getName());
        weightTextView.setText(Integer.toString((itemsArrayList).get(position).getWeight()));
        dragTextView.setText(Integer.toString((itemsArrayList).get(position).getDrag()));

        if ((position % 2) == 0)
        {
            rowView.setBackgroundColor(Color.parseColor("#E8F2FE"));
        }
        else
        {
            // odd color
        }

        return rowView;
    }


}
