package com.oldgoat5.bmstacticalreference.navigation;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;
import java.util.HashMap;

/*********************************************************************
 * List adapter for expandable list views.
 *
 * @author Michael Evans
 * @since 11/8/2015
 *********************************************************************/
public class NavigationChartsExpandableListAdapter extends BaseExpandableListAdapter
{
    private Context context;
    private ArrayList<String> airbases;
    private HashMap<String, ArrayList<String>> airbaseCharts;

    /*****************************************************************
     * Constructor.
     *
     * @param context - The context.
     * @param airbases - a List<String> of airbases.
     * @param airbaseChartHashMap - an airbase:chart hash map.
     *****************************************************************/
    public NavigationChartsExpandableListAdapter(Context context, ArrayList<String> airbases,
            HashMap<String, ArrayList<String>> airbaseChartHashMap)
    {
        this.context = context;
        this.airbases = airbases;
        this.airbaseCharts = airbaseChartHashMap;
    }

    /*****************************************************************
     * Shows the airbase views.
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

        String airbaseTitle = (String) getGroup(groupPosition);

        if (convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.navigation_group_list_item, parent, false);
            groupViewHolder = new GroupViewHolder();

            groupViewHolder.airbaseTextView = (TextView)
                    convertView.findViewById(R.id.navigation_group_list_item_name_text_view);

            convertView.setTag(groupViewHolder);
        }
        else
        {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        groupViewHolder.airbaseTextView.setText(airbaseTitle);

        groupViewHolder.airbaseTextView.setTypeface(null, Typeface.BOLD);

        //default padding 6dp for simple_list_item, top 2dp, bottom 3dp
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

        String chart = (String) getChild(groupPosition, childPosition);

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

        childViewHolder.chartTextView.setText(chart);

        return convertView;
    }

    @Override
    public int getGroupCount()
    {
        return this.airbases.size();
    }

    @Override
    public int getChildrenCount(int groupPosition)
    {
        return this.airbaseCharts.get(this.airbases.get(groupPosition)).size();
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
    }

    private static class ChildViewHolder
    {
        TextView chartTextView;
    }
}
