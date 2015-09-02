package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 6/25/2015
 *********************************************************************/
public class WeaponUseListItemAdapter extends WeaponUseListArrayAdapter<WeaponUseList>
{
    private Context CONTEXT;
    private ArrayList<WeaponUseList> list;

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

            convertView = inflater.inflate(R.layout.weapon_item_layout, null);
            viewHolder = new ViewHolder();

            viewHolder.weaponNameTextView = (TextView) convertView.findViewById(
                    R.id.weapon_name_text_view);
            viewHolder.usesTextView = (TextView) convertView.findViewById(
                    R.id.uses_text_view);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.weaponNameTextView.setText(list.get(position).getWeaponName());

        String[] uses = list.get(position).getUses();
        String usesText = "";

        for (int i = 0; i < list.get(position).size(); i++)
        {
            usesText += "\n" + uses[i];
        }

        viewHolder.usesTextView.setText(usesText);

        if ((position % 2) == 0)
            convertView.setBackgroundColor(Color.parseColor("#E8F2FE"));

        return convertView;
    }

    private static class ViewHolder
    {
        TextView weaponNameTextView;
        TextView usesTextView;
    }


}
