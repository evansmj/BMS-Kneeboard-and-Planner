package com.oldgoat5.bmstacticalreference;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListFragment;
import android.app.LauncherActivity.ListItem;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

/*********************************************************************
 * @author Michael Evans
 * @version 1/15/2015
 *
 * Allows user to specify F-16CJ load out on selected hard points.  
 *********************************************************************/
public class LoadOutFragment extends Fragment
{
    final String[] items = new String[] {"android", "hello", "world", "test"}; //testing
    
    boolean asymmetricMode;
    
    DBTools dbTools;
    CheckBox asymmetricCheckBox;
    ImageView f16Image;
    ListItemAdapter adapter; //testing
    ListView listView;
    RadioButton radioButton1;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    RadioButton radioButton6;
    RadioButton radioButton7;
    RadioButton radioButton8;
    RadioButton radioButton9;
    View view;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, 
            Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.loadout_fragment_layout, container, false);
        
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
        
        Log.d("loadoutfragment", "before adapter");
        
        adapter = new ListItemAdapter(
                this.getActivity(), generateData());
        
        Log.d("loadoutfragment", "after adapter");
        asymmetricCheckBox = (CheckBox) view.findViewById(
                R.id.asymmetricCheckBox);
        
        asymmetricMode = false;
        
        f16Image = (ImageView) view.findViewById(R.id.f16_image);
        
        listView = (ListView) view.findViewById(R.id.listViewLoadout);
        
        radioButton1 = (RadioButton) view.findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) view.findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) view.findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) view.findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) view.findViewById(R.id.radioButton5);
        radioButton6 = (RadioButton) view.findViewById(R.id.radioButton6);        
        radioButton7 = (RadioButton) view.findViewById(R.id.radioButton7);        
        radioButton8 = (RadioButton) view.findViewById(R.id.radioButton8);  
        radioButton9 = (RadioButton) view.findViewById(R.id.radioButton9);
        
        listView.setAdapter(adapter);
        
        //TODO radio button logic
        radioButton1.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton1.toggle();
                }
                else
                {
                    radioButton1.toggle();
                    radioButton9.toggle();
                }
            }
        });
        
        radioButton2.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton2.toggle();
                }
                else
                {
                    radioButton2.toggle();
                    radioButton8.toggle();
                }
            }
        });
        
        radioButton3.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton3.toggle();
                }
                else
                {
                    radioButton3.toggle();
                    radioButton7.toggle();
                }
            }
        });
        
        radioButton4.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton4.toggle();
                }
                else
                {
                    radioButton4.toggle();
                    radioButton6.toggle();
                }
            }
        });
        
        radioButton5.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                radioButton5.toggle();
            }
        });
        
        radioButton6.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton6.toggle();
                }
                else
                {
                    radioButton6.toggle();
                    radioButton4.toggle();
                }
            }
        });
        
        radioButton7.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton7.toggle();
                }
                else
                {
                    radioButton7.toggle();
                    radioButton3.toggle();
                }
            }
        });
        
        radioButton8.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton8.toggle();
                }
                else
                {
                    radioButton8.toggle();
                    radioButton2.toggle();
                }
            }
        });
        
        radioButton9.setOnClickListener(new RadioButton.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    radioButton9.toggle();
                }
                else
                {
                    radioButton9.toggle();
                    radioButton1.toggle();
                }
            }
        });
        
        return view;
    }
    
    /*****************************************************************
     * Generates all loadout data for start of app for the listview
     * items.
     * 
     * @return Returns an ArrayList of all database 
     *****************************************************************/
    private ArrayList<OrdinanceObject> generateData()
    {
        Log.d("loadoutfragment", "begin generateData()");
        //ArrayList<RowItem> items;
        ArrayList<OrdinanceObject> dataList;
        
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
    
}
