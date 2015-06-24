package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * @author Michael Evans
 * @since 6/24/2015
 *********************************************************************/
public class WeaponUseListItemAdapter extends ArrayAdapter<WeaponUseList>
{
    private Context CONTEXT;
    private WeaponUseList weaponUseList;
    public WeaponUseListItemAdapter(Context context,
                           WeaponUseList weaponUseList)
    {
        super(context, R.layout.ordinance_object, weaponUseList);

        this.CONTEXT = context;
        this.weaponUseList = weaponUseList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(
                R.layout.ordinance_object, parent, false);

        TextView nameView = (TextView) rowView.findViewById(
                R.id.weapon_name_list_item);
        nameView.setText((weaponUseList).get(position).getName());

        return rowView;
    }
}
