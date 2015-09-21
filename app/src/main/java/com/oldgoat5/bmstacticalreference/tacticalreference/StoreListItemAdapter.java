package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
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
        ViewHolder viewHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.store_object_layout, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.name = (TextView) convertView.findViewById(R.id.store_name_text_view);
            viewHolder.weight = (TextView) convertView.findViewById(R.id.store_weight_text_view);
            viewHolder.drag = (TextView) convertView.findViewById(R.id.store_drag_text_view);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText((itemsArrayList).get(position).getName());
        viewHolder.weight.setText("\nWeight: " + Integer.toString((itemsArrayList).get(position).getWeight()));
        viewHolder.drag.setText("Drag: " + Integer.toString((itemsArrayList).get(position).getDrag()));

        if ((position % 2) == 0)
        {
            convertView.setBackgroundColor(CONTEXT.getResources().getColor(R.color.light_blue));
        }
        else
        {
            convertView.setBackgroundColor(CONTEXT.getResources().getColor(R.color.transparent));
        }

        return convertView;
    }

    private static class ViewHolder
    {
        TextView name;
        TextView weight;
        TextView drag;
    }

}
