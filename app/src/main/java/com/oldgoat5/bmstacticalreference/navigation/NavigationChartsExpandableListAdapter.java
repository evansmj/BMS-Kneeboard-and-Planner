package com.oldgoat5.bmstacticalreference.navigation;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;
import java.util.HashMap;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * List adapter for expandable list views.
 *
 * @author Michael Evans
 * @since 11/8/2015
 *********************************************************************/
public class NavigationChartsExpandableListAdapter extends BaseExpandableListAdapter
{
    private final String DATA_CARD_NAME = "DataCard";

    private Context context;
    private ArrayList<String> airbases;
    private HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> airbaseCharts;
    private SharedPreferences dataCardSharedPref;

    /*****************************************************************
     * Constructor.
     *
     * @param context - The context.
     * @param airbases - a List<String> of airbases.
     * @param airbaseChartHashMap - an airbase:chart hash map.
     *****************************************************************/
    public NavigationChartsExpandableListAdapter(Context context, ArrayList<String> airbases,
            HashMap<String, ArrayList<NavigationChartsTuple<String, Integer>>> airbaseChartHashMap)
    {
        this.context = context;
        this.airbases = airbases;
        this.airbaseCharts = airbaseChartHashMap;

        dataCardSharedPref = context.getSharedPreferences(DATA_CARD_NAME, 0);
    }

    /*****************************************************************
     * Shows the airbase views.  Also handles the favorites click listener.
     *
     * @param groupPosition - The specified group
     * @param isExpanded - If the view is expanded
     * @param convertView - The view to recycle.
     * @param parent - The parent view
     * @return Returns a recycled view.
     *****************************************************************/
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                             ViewGroup parent)
    {
        GroupViewHolder groupViewHolder;

        final String airbaseTitle = (String) getGroup(groupPosition);

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.navigation_group_list_item, parent, false);
            groupViewHolder = new GroupViewHolder();

            groupViewHolder.favoritesButton = (Button)
                    convertView.findViewById(R.id.navigation_group_list_item_favorite_button);
            groupViewHolder.airbaseTextView = (TextView)
                    convertView.findViewById(R.id.navigation_group_list_item_name_text_view);

            convertView.setTag(groupViewHolder);
        }
        else
        {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        groupViewHolder.airbaseTextView.setText(airbaseTitle);

        groupViewHolder.favoritesButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //when clicked, add this set of charts to data card preferences,
                // either as home plate or alternate.

                //show dialog to set either home plate or alternate.
                final Dialog dialog = new Dialog(context);

                View dialogView = View.inflate(
                        context, R.layout.favorites_setter_dialog_layout, null);

                dialog.setContentView(dialogView);

                Button dialogHomeButton = (Button) dialogView.findViewById(
                        R.id.favorites_setter_home_plate_select_button);
                Button dialogAlternateButton = (Button) dialogView.findViewById(
                        R.id.favorites_setter_alternate_select_button);

                dialogHomeButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        SharedPreferences.Editor editor = dataCardSharedPref.edit();
                        editor.putString("favoriteHomePlate", airbaseTitle);
                        editor.apply();
                        dialog.dismiss();
                        Toast.makeText(context, "Saved as Home Plate", Toast.LENGTH_LONG).show();
                    }
                });

                dialogAlternateButton.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        SharedPreferences.Editor editor = dataCardSharedPref.edit();
                        editor.putString("favoriteHomePlate", airbaseTitle);
                        editor.apply();
                        dialog.dismiss();
                        Toast.makeText(context, "Saved as Alternate", Toast.LENGTH_LONG).show();
                    }
                });

                dialog.setTitle(R.string.set_as);
                dialog.show();
            }
        });

        groupViewHolder.airbaseTextView.setTypeface(null, Typeface.BOLD);

        //default padding is 6dp for simple_list_item, top 2dp, bottom 3dp
        float d = context.getResources().getDisplayMetrics().density;
        int paddingLeftRight = (int) (35 * d);
        int paddingTop = (int) (2 * d);
        int paddingBottom = (int) (3 * d);

        groupViewHolder.airbaseTextView.setPadding(
                paddingLeftRight, paddingTop, paddingLeftRight, paddingBottom);

        return convertView;
    }

    /*****************************************************************
     * Shows the charts view.
     *
     * @param groupPosition - The given group position
     * @param childPosition - The given child position
     * @param isLastChild - If this is the last child
     * @param convertView - The view to recycle.
     * @param parent - The parent view.
     * @return Returns the child view.
     *****************************************************************/
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                             View convertView, ViewGroup parent)
    {
        ChildViewHolder childViewHolder;

        String chartTitle = (String)
                ((NavigationChartsTuple) getChild(groupPosition, childPosition)).getTitle();

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.navigation_child_list_item, parent, false);
            childViewHolder = new ChildViewHolder();

            childViewHolder.chartTextView = (TextView)
                    convertView.findViewById(R.id.navigation_child_list_item_name_text_view);

            convertView.setTag(childViewHolder);
        }
        else
        {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        childViewHolder.chartTextView.setText(chartTitle);

        return convertView;
    }

    @Override
    public int getGroupCount()
    {
        return this.airbases.size();
    }

    /*****************************************************************
     * Returns the number of children in a specified group.
     *
     * @param groupPosition - The specified group.
     * @return Returns the number of children in the group.
     *****************************************************************/
    @Override
    public int getChildrenCount(int groupPosition)
    {
        try
        {
            return this.airbaseCharts.get(this.airbases.get(groupPosition)).size();
        }
        catch (NullPointerException e)
        {
            return 0;
        }
    }

    @Override
    public Object getGroup(int groupPosition)
    {
        return this.airbases.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition)
    {
        return this.airbaseCharts.get(this.airbases.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition)
    {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition)
    {
        return childPosition;
    }

    @Override
    public boolean hasStableIds()
    {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition)
    {
        return true;
    }

    private static class GroupViewHolder
    {
        TextView airbaseTextView;
        Button favoritesButton;
    }

    private static class ChildViewHolder
    {
        TextView chartTextView;
    }
}
