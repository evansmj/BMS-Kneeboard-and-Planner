package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 6/25/2015
 *********************************************************************/
public class WeaponUseListItemAdapter extends WeaponUseListArrayAdapter<WeaponUseList>
{
    private final Context CONTEXT;
    private final ArrayList<WeaponUseList> list;

    private String weightString;
    private String dragString;

    public WeaponUseListItemAdapter(Context context, ArrayList<WeaponUseList> list)
    {
        super(context, R.layout.weapon_item_layout, list);

        this.CONTEXT = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.weapon_item_layout, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.weaponNameTextView = (TextView) convertView.findViewById(
                    R.id.weapon_name_text_view);
            viewHolder.weightTextView = (TextView) convertView.findViewById(
                    R.id.weapon_weight_text_view);
            viewHolder.dragTextView = (TextView) convertView.findViewById(
                    R.id.weapon_drag_text_view);
            viewHolder.usesTextView = (TextView) convertView.findViewById(
                    R.id.uses_text_view);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        weightString = String.format(CONTEXT.getString(
                R.string.weapon_weight_output), list.get(position).getWeaponWeight());
        dragString = String.format(CONTEXT.getString(R.string.weapon_drag_output),
                list.get(position).getWeaponDrag());

        viewHolder.weaponNameTextView.setText(list.get(position).getWeaponName());
        viewHolder.weightTextView.setText(weightString);
        viewHolder.dragTextView.setText(dragString);

        String[] uses = list.get(position).getUses();
        String usesText = "";

        usesText += uses[0];

        for (int i = 1; i < list.get(position).size(); i++)
        {
            usesText += "\n" + uses[i];
        }

        viewHolder.usesTextView.setText(usesText);
        viewHolder.usesTextView.setTypeface(null, Typeface.ITALIC);
        viewHolder.usesTextView.setTextColor(CONTEXT.getResources().getColor(R.color.brown));

        if ((position % 2) == 0)
            convertView.setBackgroundColor(CONTEXT.getResources().getColor(R.color.light_blue));
        else
            convertView.setBackgroundColor(CONTEXT.getResources().getColor(R.color.transparent));

        return convertView;
    }

    private static class ViewHolder
    {
        TextView weaponNameTextView;
        TextView weightTextView;
        TextView dragTextView;
        TextView usesTextView;
    }
}
