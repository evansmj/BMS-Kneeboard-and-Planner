package com.oldgoat5.bmstacticalreference.LoadOut;

import java.io.IOException;
import java.util.ArrayList;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;

import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * @author Michael Evans
 * @version 1/15/2015
 *
 * Allows user to specify F-16CJ load out on selected hard points.  
 *********************************************************************/
public class LoadOutFragment extends Fragment
{
    private final String[] items = new String[] {"android", "hello", "world", "test"}; //testing
    
    private boolean asymmetricMode;
    
    private DBTools dbTools;
    private CheckBox asymmetricCheckBox;
    private ImageView f16Image;
    private ListItemAdapter adapter; //testing
    private ListView listView;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;
    private RadioButton radioButton5;
    private RadioButton radioButton6;
    private RadioButton radioButton7;
    private RadioButton radioButton8;
    private RadioButton radioButton9;
    private View view;
    
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
        
        asymmetricCheckBox.setOnClickListener(new CheckBox.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (asymmetricMode)
                {
                    asymmetricMode = false;
                }
                else
                {
                    asymmetricMode = true;
                }
            }
        });
        
        radioButton1.setOnClickListener(new RadioButton.OnClickListener()
        {
            
            @Override
            public void onClick(View v)
            {
                //radioButton1.setSelected(!radioButton1.isChecked());
                if (asymmetricMode)
                {
                    Log.d("loudout button1", "true");
                    //radioButton1.toggle();
                    if (radioButton1.isChecked())
                    {
                        radioButton1.setChecked(false);
                    }
                    else
                    {
                        radioButton1.setChecked(true);
                    }
                    
                    //radioButton1.setChecked(false);
                }
                else
                {
                    Log.d("loudout button1", "false");
                    //radioButton1.toggle();
                    //radioButton9.toggle();
                    if (radioButton1.isChecked())
                    {
                        Log.d("loudout button1", "ischecked true");
                        radioButton1.setChecked(true);
                    }
                    if (!radioButton1.isSelected())
                    {
                        Log.d("loudout button1", "ischecked false");
                        radioButton1.setChecked(true);
                        radioButton9.setChecked(true);
                    }
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
                    Log.d("loudout button2", "true");
                    radioButton2.toggle();
                }
                else
                {
                    Log.d("loudout button2", "false");
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
                    Log.d("loudout button3", "true");
                    radioButton3.toggle();
                }
                else
                {
                    Log.d("loudout button3", "false");
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
                    Log.d("loudout button4", "true");
                    radioButton4.toggle();
                }
                else
                {
                    Log.d("loudout button4", "false");
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
                    Log.d("loudout button6", "true");
                    radioButton6.toggle();
                }
                else
                {
                    Log.d("loudout button6", "false");
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
                    Log.d("loudout button7", "true");
                    radioButton7.toggle();
                }
                else
                {
                    Log.d("loudout button7", "false");
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
                    Log.d("loudout button8", "true");
                    radioButton8.toggle();
                }
                else
                {
                    Log.d("loudout button8", "false");
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
                    Log.d("loudout button9", "true");
                    radioButton9.toggle();
                }
                else
                {
                    Log.d("loudout button9", "false");
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
