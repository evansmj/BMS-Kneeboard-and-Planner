package com.oldgoat5.bmstacticalreference;

import java.util.ArrayList;

import android.content.Context;
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
        super(context, R.layout.row_item, itemsArrayList);
        
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        
        View rowView = inflater.inflate(
                R.layout.row_item, parent, false);
        
        TextView nameView = (TextView) rowView.findViewById(
                R.id.weapon_name_list_item);
        nameView.setText((itemsArrayList).get(position).getWeaponName());
        
        TextView weightView = (TextView) rowView.findViewById(
                    R.id.weight_list_item);
        weightView.setText((itemsArrayList).get(position).getWeight());
        
        return rowView;
    }
}
