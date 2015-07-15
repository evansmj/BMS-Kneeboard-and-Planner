package com.oldgoat5.bmstacticalreference.tacticalreference;

import java.io.IOException;
import java.util.ArrayList;

import android.app.Dialog;
import android.content.Context;
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
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

import org.w3c.dom.Text;

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
            "Cluster Bombs", "Guided Bombs", "Other"};
    private Context CONTEXT;

    private enum DialogViewType {NONE, WEAPON, SURFACE, STORE};

    private DBTools dbTools;
    private Dialog listDialog;
    private DialogViewType dialogViewType;
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
    private View listDialogView;
    private View view;

    //TODO on click of list view item, bringup page with full item info.

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
                        break;
                    case 2:
                        //show stores menu
                        dialogViewType = DialogViewType.STORE;
                        listView.setAdapter(null);
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
                        listView.setAdapter(null);
                        break;

                    case 2:
                        //use surface-air threats
                        dialogViewType = DialogViewType.SURFACE;
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
                        listView.setAdapter(null);
                        break;

                    case 1:
                        //show agm
                        adapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getAGMissiles());
                        listView.setAdapter(adapter);
                        break;

                    case 2:
                        //show as missiles
                        adapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getAAMissiles());
                        listView.setAdapter(adapter);
                        break;

                    case 3:
                        //show cbu
                        adapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getClusterBombs());
                        listView.setAdapter(adapter);
                        break;

                    case 4:
                        //show gbu
                        adapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getGuidedBombs());
                        listView.setAdapter(adapter);
                        break;

                    case 5:
                        //other
                        adapter = new WeaponUseListItemAdapter(getActivity(), dbTools.getOtherWeapons());
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
                //make a dialog
                listDialog = new Dialog(CONTEXT);
                listDialog.setContentView(R.layout.weapon_dialog_layout);

                //todo make method to switch between dialog types and populate them

                switch (dialogViewType)
                {
                    case WEAPON:
                       populateWeaponDialog();
                       break;

                    case SURFACE:
                        //populateSurfaceDialog();
                        break;

                    case STORE:
                        break;
                }


                listDialog.show();
            }
        });


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

    /*****************************************************************
     * Populates the listview dialog with weapon info.
     *****************************************************************/
    private void populateWeaponDialog()
    {
        listDialogView = listDialog.findViewById(R.id.weapon_dialog);

        listDialog.setTitle(((TextView) view.findViewById(
                R.id.weapon_name_text_view)).getText().toString());

        Log.d("TacRef", "weaponInfo name = " + ((TextView) view.findViewById(
                R.id.weapon_name_text_view)).getText().toString());

        String[] weaponInfo = dbTools.getWeaponInfo(((TextView) view.findViewById(
                R.id.weapon_name_text_view)).getText().toString());

        TextView weightTextView = (TextView) listDialogView.findViewById(R.id.weight_dialog_text_view);
        TextView dragTextView  = (TextView) listDialog.findViewById(R.id.drag_dialog_text_view);
        TextView blastRadiusTextView = (TextView) listDialogView.findViewById(R.id.blast_dialog_text_view);
        TextView rangeTextView = (TextView) listDialogView.findViewById(R.id.range_dialog_text_view);
        TextView damageTextView = (TextView) listDialogView.findViewById(R.id.damage_dialog_text_view);
        TextView guidanceTextView = (TextView) listDialogView.findViewById(R.id.guidance_dialog_text_view);
        TextView releaseTextView = (TextView) listDialogView.findViewById(R.id.release_dialog_text_view);
        TextView typeTextView = (TextView) listDialogView.findViewById(R.id.type_dialog_text_view);

        weightTextView.setText(weightTextView.getText().toString() + " " + weaponInfo[0]);
        dragTextView.setText(dragTextView.getText().toString() + " " + weaponInfo[1]);
        blastRadiusTextView.setText(blastRadiusTextView.getText().toString() + " " + weaponInfo[2]);

        int mileRange = Integer.parseInt(weaponInfo[3]);
        mileRange = (int) Math.ceil(mileRange * 0.539957); //convert km to nm

        rangeTextView.setText(rangeTextView.getText().toString() + " " + Integer.toString(mileRange));
        damageTextView.setText(damageTextView.getText().toString() + " " + weaponInfo[4]);
        guidanceTextView.setText(guidanceTextView.getText().toString() + " " + weaponInfo[5]);
        releaseTextView.setText(releaseTextView.getText().toString() + " " + weaponInfo[6]);
        typeTextView.setText(typeTextView.getText().toString() + " " + weaponInfo[7]);
    }
}
