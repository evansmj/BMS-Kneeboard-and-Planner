package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.ColorFragment;
import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tools.database.DBTools;

import java.io.IOException;
import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 1/15/2015
 *
 * Allows user to specify F-16CJ load out on selected hard points.  
 *********************************************************************/
public class TacticalReferenceFragment extends ColorFragment
{
    private final String[] loadTypeItems = new String[] {"---", "Weapons", "Stores"};
    private final String[] referenceTypeItems = new String[] {"---", "Munitions", "Surface-Air Threats"};
    private final String[] surfaceTypeItems = new String[] {"---", "Surface-Air Missiles",
            "Anti-Aircraft Artillery", "MANPADS"};
    private final String[] weaponTypeItems = new String[] {"---", "A-G Missiles", "A-A Missiles",
            "Cluster Bombs", "Guided Bombs", "Mark Bombs", "Other"};
    private Context CONTEXT;

    private enum DialogViewType {NONE, WEAPON, SURFACE, STORE};

    private AppBarLayout appBarLayout;
    private DBTools dbTools;
    private Dialog listDialog;
    private DialogViewType dialogViewType;
    private ArrayAdapter<String> loadTypeArrayAdapter;
    private ArrayAdapter<String> referenceTypeArrayAdapter;
    private ArrayAdapter<String> surfaceTypeArrayAdapter;
    private ArrayAdapter<String> weaponTypeArrayAdapter;
    private ListView listView;
    private Spinner loadTypeSpinner;
    private Spinner referenceTypeSpinner;
    private Spinner surfaceTypeSpinner;
    private Spinner weaponTypeSpinner;
    private StoreListItemAdapter storeAdapter;
    private TextView loadTypeTextView;
    private TextView surfaceTypeTextView;
    private TextView weaponTypeTextView;
    private ThreatListItemAdapter threatAdapter;
    private WeaponUseListItemAdapter weaponAdapter;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.tactical_reference_fragment_layout, container, false);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        appBarLayout = (AppBarLayout) getActivity().findViewById(R.id.app_bar_layout);

        loadTypeTextView = (TextView) view.findViewById(R.id.load_type_text_view);
        surfaceTypeTextView = (TextView) view.findViewById(R.id.surface_type_text_view);
        weaponTypeTextView = (TextView) view.findViewById(R.id.weapon_type_text_view);

        loadTypeSpinner = (Spinner) view.findViewById(R.id.load_type_spinner);
        referenceTypeSpinner = (Spinner) view.findViewById(R.id.reference_type_spinner);
        surfaceTypeSpinner = (Spinner) view.findViewById(R.id.surface_type_spinner);
        weaponTypeSpinner = (Spinner) view.findViewById(R.id.weapon_type_spinner);

        loadTypeArrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, loadTypeItems);
        referenceTypeArrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, referenceTypeItems);
        surfaceTypeArrayAdapter = new ArrayAdapter<String>(this.getActivity(),
                android.R.layout.simple_list_item_1, surfaceTypeItems);
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
                        dialogViewType = DialogViewType.NONE;
                        listView.setAdapter(null);
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        weaponTypeSpinner.setSelection(0);
                        break;

                    case 1:
                        //show weapons menu
                        dialogViewType = DialogViewType.WEAPON;
                        listView.setAdapter(null);
                        weaponTypeTextView.setVisibility(View.VISIBLE);
                        weaponTypeSpinner.setVisibility(View.VISIBLE);
                        weaponTypeSpinner.setSelection(0);
                        break;

                    case 2:
                        //show stores menu
                        dialogViewType = DialogViewType.STORE;
                        storeAdapter = new StoreListItemAdapter(CONTEXT, dbTools.getStores());
                        listView.setAdapter(storeAdapter);
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
                        dialogViewType = DialogViewType.NONE;
                        loadTypeTextView.setVisibility(View.GONE);
                        loadTypeSpinner.setVisibility(View.GONE);
                        loadTypeSpinner.setSelection(0);
                        surfaceTypeTextView.setVisibility(View.GONE);
                        surfaceTypeSpinner.setVisibility(View.GONE);
                        surfaceTypeSpinner.setSelection(0);
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        weaponTypeSpinner.setSelection(0);
                        listView.setAdapter(null);
                        break;

                    case 1:
                        //show munitions menus
                        loadTypeTextView.setVisibility(View.VISIBLE);
                        loadTypeSpinner.setVisibility(View.VISIBLE);
                        loadTypeSpinner.setSelection(0);
                        surfaceTypeSpinner.setVisibility(View.GONE);
                        surfaceTypeTextView.setVisibility(View.GONE);
                        drawListViewBelow(i);
                        listView.setAdapter(null);
                        break;

                    case 2:
                        //use surface-air threats
                        dialogViewType = DialogViewType.SURFACE;
                        loadTypeTextView.setVisibility(View.GONE);
                        loadTypeSpinner.setVisibility(View.GONE);
                        surfaceTypeTextView.setVisibility(View.VISIBLE);
                        surfaceTypeSpinner.setVisibility(View.VISIBLE);
                        surfaceTypeSpinner.setSelection(0);
                        weaponTypeTextView.setVisibility(View.GONE);
                        weaponTypeSpinner.setVisibility(View.GONE);
                        drawListViewBelow(i);
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

        surfaceTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        //hide all
                        listView.setAdapter(null);
                        break;

                    case 1:
                        //show sams
                        threatAdapter = new ThreatListItemAdapter(
                                CONTEXT, dbTools.getThreats(surfaceTypeItems[i]));
                        listView.setAdapter(threatAdapter);
                        break;

                    case 2:
                        //show aaa
                        threatAdapter = new ThreatListItemAdapter(
                                CONTEXT, dbTools.getThreats(surfaceTypeItems[i]));
                        listView.setAdapter(threatAdapter);
                        break;

                    case 3:
                        //show manpads
                        threatAdapter = new ThreatListItemAdapter(
                                CONTEXT, dbTools.getThreats(surfaceTypeItems[i]));
                        listView.setAdapter(threatAdapter);
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
                        listView.setAdapter(null);
                        break;

                    case 1:
                        //show agm
                        weaponAdapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getAGMissiles());
                        listView.setAdapter(weaponAdapter);
                        break;

                    case 2:
                        //show as missiles
                        weaponAdapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getAAMissiles());
                        listView.setAdapter(weaponAdapter);
                        break;

                    case 3:
                        //show cbu
                        weaponAdapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getClusterBombs());
                        listView.setAdapter(weaponAdapter);
                        break;

                    case 4:
                        //show gbu
                        weaponAdapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getGuidedBombs());
                        listView.setAdapter(weaponAdapter);
                        break;

                    case 5:
                        //show mark
                        weaponAdapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getMarkBombs());
                        listView.setAdapter(weaponAdapter);
                        break;

                    case 6:
                        //other
                        weaponAdapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getOtherWeapons());
                        listView.setAdapter(weaponAdapter);
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent)
            {
                //select nothing
            }
        });

        listView = (ListView) view.findViewById(R.id.loadout_list_view);
        //TODO after 1.0 add advanced search dialog popup
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View rowView, int position, long id)
            {
                switch (dialogViewType)
                {
                    case WEAPON:
                        listDialog = new Dialog(CONTEXT);
                        listDialog.setContentView(R.layout.weapon_dialog_layout);
                        view = rowView;
                        dbTools.populateWeaponDialog(listDialog, view);
                        listDialog.show();
                        break;

                    case SURFACE:
                        listDialog = new Dialog(CONTEXT);
                        listDialog.setContentView(R.layout.threat_dialog_layout);
                        view = rowView;
                        dbTools.populateThreatDialog(listDialog, view);
                        listDialog.show();
                        break;

                    case STORE:
                        break;
                }
            }
        });

        loadTypeSpinner.setAdapter(loadTypeArrayAdapter);
        referenceTypeSpinner.setAdapter(referenceTypeArrayAdapter);
        surfaceTypeSpinner.setAdapter(surfaceTypeArrayAdapter);
        weaponTypeSpinner.setAdapter(weaponTypeArrayAdapter);

        //Log.d("LoadOutFragment", "getactivity=" + getActivity().toString());

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
            //Log.d("loadoutfragment", "openDataBase() try");
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

    @Override
    public int getBackgroundColor()
    {
        return R.color.toolbar_red;
    }

    @Override
    public void setUserVisibleHint(boolean visible)
    {
        if (visible && appBarLayout != null)
        {
            appBarLayout.setExpanded(false, true);
        }
    }
    
    /*****************************************************************
     * Generates all tacticalreference data for start of app for the listview
     * items.
     * 
     * @return Returns an ArrayList of all database 
     *****************************************************************/
    private ArrayList<OrdnanceObject> generateData()
    {
        //Log.d("loadoutfragment", "begin generateData()");
        //ArrayList<RowItem> items;
        ArrayList<OrdnanceObject> dataList;
        
        dataList = dbTools.getAllRows();
        
        //Log.d("loadoutfragment", "after db.getAllRows()");
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

    /*****************************************************************
     * Draws the listview to be below the selected parameter
     *
     * @param spinnerId - The spinner to draw the listView under.
     *****************************************************************/
    private void drawListViewBelow(int spinnerId)
    {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        switch (spinnerId)
        {
            case 1:
                layoutParams.addRule(RelativeLayout.BELOW, R.id.load_type_spinner);
                listView.setLayoutParams(layoutParams);
                break;

            case 2:
                layoutParams.addRule(RelativeLayout.BELOW, R.id.surface_type_spinner);
                listView.setLayoutParams(layoutParams);
                break;
        }
    }
}
