package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 6/25/2015
 *********************************************************************/
public class WeaponUseListArrayAdapter<WeaponUseList> extends BaseAdapter
{
    private ArrayList<WeaponUseList> list;
    private Context CONTEXT;
    private int resource;
    private LayoutInflater layoutInflater;

    public WeaponUseListArrayAdapter(Context context, int resource, ArrayList<WeaponUseList> list)
    {
        this.CONTEXT = context;
        this.layoutInflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.list = list;
        this.resource = resource;
    }

    @Override
    public int getCount()
    {
        return list.size();
    }

    /**
     * Returns an individual weapons use list.
     *
     * @param i The id of the row to return.
     * @return Returns the 1st dimension row.
     */
    @Override
    public Object getItem(int i)
    {
        return list.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return list.get(i).hashCode();
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent)
    {
        View view;

        if (convertView == null)
        {
            view = layoutInflater.inflate(resource, parent, false);
        }
        else
        {
            view = convertView;
        }

        return view;
    }
}
