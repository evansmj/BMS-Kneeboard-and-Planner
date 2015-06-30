package com.oldgoat5.bmstacticalreference.tacticalreference;

import java.io.IOException;
import java.util.ArrayList;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 1/15/2015
 *
 * Allows user to specify F-16CJ load out on selected hard points.  
 *********************************************************************/
public class TacticalReferenceFragment extends Fragment
{
    private final String[] loadTypeItems = new String[] {"---", "Weapons", "Stores"};
    private final String[] referenceTypeItems = new String[] {"---", "Munitions", "Surface-Air Threats"};
    private final String[] weaponTypeItems = new String[] {"---", "A-G Missiles", "A-A Missiles",
            "Bombs", "Rockets"};

    private DBTools dbTools;
    private ArrayAdapter<String> loadTypeArrayAdapter;
    private ArrayAdapter<String> referenceTypeArrayAdapter;
    private ArrayAdapter<String> weaponTypeArrayAdapter;
    private ListItemAdapter databaseAdapter;
    private ListView listView;
    private Spinner loadTypeSpinner;
    private Spinner referenceTypeSpinner;
    private Spinner weaponTypeSpinner;
    private TextView loadTypeTextView;
    private TextView weaponTypeTextView;
    private WeaponUseListItemAdapter adapter;
    private View view;
    //TODO on click of list view item, bringup page with full item info.
    //TODO weaponitem shows name, usages.  click for more
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.tactical_reference_fragment_layout, container, false);

        loadTypeTextView = (TextView) view.findViewById(R.id.load_type_text_view);
        weaponTypeTextView = (TextView) view.findViewById(R.id.weapon_type_text_view);

        loadTypeSpinner = (Spinner) view.findViewById(R.id.load_type_spinner);
        weaponTypeSpinner = (Spinner) view.findViewById(R.id.weapon_type_spinner);

        referenceTypeSpinner = (Spinner) view.findViewById(R.id.reference_type_spinner);

        loadTypeArrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, loadTypeItems);
        referenceTypeArrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, referenceTypeItems);
        weaponTypeArrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, weaponTypeItems);

        loadTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id)
            {
                switch(pos)
                {
                    case 0:
                        //hide all menus.
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        break;
                    case 1:
                        //show weapons menu
                        weaponTypeTextView.setVisibility(View.VISIBLE);
                        weaponTypeSpinner.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        //show stores  menu
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent)
            {
                //hide menus.
            }
        });

        referenceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        loadTypeTextView.setVisibility(View.GONE);
                        loadTypeSpinner.setVisibility(View.GONE);
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        listView.setAdapter(null);
                        break;

                    case 1:
                        //show weapons menus
                        loadTypeTextView.setVisibility(View.VISIBLE);
                        loadTypeSpinner.setVisibility(View.VISIBLE);
                        listView.setAdapter(null);
                        break;
                    case 2:
                        //use surface-air threats
                        loadTypeTextView.setVisibility(View.GONE);
                        loadTypeSpinner.setVisibility(View.GONE);
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        listView.setAdapter(null);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {
                //select nothing
            }
        });

        weaponTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id)
            {
                switch (pos)
                {
                    ///select ag, aa, bombs, rockets
                    case 0:
                        break;

                    case 1:
                        //show ag weapons
                        adapter = new WeaponUseListItemAdapter(getActivity(), generateAGM());
                        listView.setAdapter(adapter);
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent)
            {
                //select nothing
            }
        });

        listView = (ListView) view.findViewById(R.id.loadout_list_view);

        loadTypeSpinner.setAdapter(loadTypeArrayAdapter);
        referenceTypeSpinner.setAdapter(referenceTypeArrayAdapter);
        weaponTypeSpinner.setAdapter(weaponTypeArrayAdapter);

        Log.d("LoadOutFragment", "getactivity=" + getActivity().toString());
        dbTools = new DBTools(getActivity());

        try
        {
            dbTools.createDatabase();
        }
        catch (IOException e)
        {
            throw new Error("LoadoutFragment: Unable to create database ");
        }
        
        try
        {
            Log.d("loadoutfragment", "openDataBase() try");
            dbTools.openDatabase();
        }
        catch (SQLiteException sqle)
        {
            throw sqle;
        }

        //databaseAdapter = new ListItemAdapter(
        //        this.getActivity(), generateData());

        //listView.setAdapter(databaseAdapter);

        return view;
    }
    
    /*****************************************************************
     * Generates all tacticalreference data for start of app for the listview
     * items.
     * 
     * @return Returns an ArrayList of all database 
     *****************************************************************/
    private ArrayList<OrdnanceObject> generateData()
    {
        Log.d("loadoutfragment", "begin generateData()");
        //ArrayList<RowItem> items;
        ArrayList<OrdnanceObject> dataList;
        
        dataList = dbTools.getAllRows();
        
        Log.d("loadoutfragment", "after db.getAllRows()");
        /*items = new ArrayList<RowItem>();
        
        //or call method from dbtools get all rows
        
        dataList = dbTools.getAllRows();
        
        
        //hashData format HashMap<String, String> :: <attribute, 
        for (int i = 0; i < dataList.size(); i++)
        {
            items.add(new OrdinanceObject(dataList.get(i).getId(), 
                    dataList.get(i).getName(), dataList.get(i).getWeight(), 
                    dataList.get(i).getDrag(), dataList.get(i).getDamage(),
                    dataList.get(i).getGuidance(), dataList.get(i).getRange(),
                    dataList.get(i).getBlast(), dataList.get(i).getInfo());
        }
        items.add(new RowItem("0", "item 1", "999"));*/
        
        return dataList;
    }

    private ArrayList<WeaponUseList> generateAGM()
    {
        return dbTools.getAGMissiles();
    }
}
