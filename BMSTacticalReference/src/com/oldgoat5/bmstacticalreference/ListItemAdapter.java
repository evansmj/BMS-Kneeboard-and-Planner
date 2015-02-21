package com.oldgoat5.bmstacticalreference;

import java.util.ArrayList;

import android.app.LauncherActivity.ListItem;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListItemAdapter extends ArrayAdapter<RowItem>
{
    private final Context context;
    private final ArrayList<RowItem> itemsArrayList;
    
    public ListItemAdapter(Context context, ArrayList<RowItem> itemsArrayList)
    {
        super(context, R.layout.ordinance_list_item, itemsArrayList);
        
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(
                R.layout.ordinance_list_item, parent, false);
        TextView labelView = (TextView) rowView.findViewById(
                R.id.weapon_name_list_item);
        labelView.setText((itemsArrayList).get(position).getWeaponName());
        
        return rowView;
    }
}
