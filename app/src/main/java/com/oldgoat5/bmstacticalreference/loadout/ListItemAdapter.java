package com.oldgoat5.bmstacticalreference.LoadOut;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

public class ListItemAdapter extends ArrayAdapter<OrdinanceObject>
{
    private final Context context;
    private final ArrayList<OrdinanceObject> itemsArrayList;
    
    public ListItemAdapter(Context context, 
            ArrayList<OrdinanceObject> itemsArrayList)
    {
        super(context, R.layout.ordinance_object, itemsArrayList);
        
        this.context = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        
        View rowView = inflater.inflate(
                R.layout.ordinance_object, parent, false);
        
        TextView nameView = (TextView) rowView.findViewById(
                R.id.weapon_name_list_item);
        nameView.setText((itemsArrayList).get(position).getName());
        
        TextView weightView = (TextView) rowView.findViewById(
                R.id.weight_list_item);
        weightView.setText((itemsArrayList).get(position).getWeight());
        
        TextView dragView = (TextView) rowView.findViewById(
                R.id.drag_list_item);
        dragView.setText((itemsArrayList).get(position).getDrag());
    
        TextView damageView = (TextView) rowView.findViewById(
                R.id.damage_list_item);
        damageView.setText((itemsArrayList).get(position).getDamage());

        TextView guidanceView = (TextView) rowView.findViewById(
                R.id.guidance_list_item);
        guidanceView.setText((itemsArrayList).get(position).getGuidance());

        TextView rangeView = (TextView) rowView.findViewById(
                R.id.range_list_item);
        rangeView.setText((itemsArrayList).get(position).getRange());

        TextView blastView = (TextView) rowView.findViewById(
                R.id.blast_list_item);
        blastView.setText((itemsArrayList).get(position).getBlast());

        TextView infoView = (TextView) rowView.findViewById(
                R.id.info_list_item);
        infoView.setText((itemsArrayList).get(position).getInfo());
        
        return rowView;
    }
}
