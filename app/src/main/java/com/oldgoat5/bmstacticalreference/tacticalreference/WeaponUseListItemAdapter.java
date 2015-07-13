package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
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

    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        //TODO use view holder
        View rowView = inflater.inflate(R.layout.weapon_item_layout, parent, false);

        TextView weaponName = (TextView) rowView.findViewById(R.id.weapon_name_text_view);
        weaponName.setText(list.get(position).getWeaponName());

        TextView usesTextView = (TextView) rowView.findViewById(R.id.uses_text_view);

        String[] uses = list.get(position).getUses();
        String usesText = "";

        for (int i = 0; i < list.get(position).size(); i++)
        {
            usesText += "\n" + uses[i];
        }

        usesTextView.setText(usesText);

        //TODO button click listener to show all information.

        return rowView;
    }


}
