package com.oldgoat5.bmstacticalreference.missionplanner;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tacticalreference.DBTools;

import java.io.IOException;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 7/21/2015
 *********************************************************************/
public class BombSelectDialog extends Dialog
{
    private Context CONTEXT;

    public enum PlannerType {LEVEL, DIVE, LOFT, POPUP};

    public PlannerType plannerType;

    private ArrayAdapter<String> typeArrayAdapter;
    private DBTools dbTools;
    private Spinner typeSpinner;

    private String[] bombTypeItems;

    public BombSelectDialog(Context context, PlannerType plannerType)
    {
        super(context);

        this.CONTEXT = context;
        this.plannerType = plannerType;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        switch (plannerType)
        {
            case LEVEL:
                //cbu, mk, blu107
                bombTypeItems = new String[] {"---", "BLU", "CBU","MK"};
                break;

            case DIVE:
                break;

            case LOFT:
                break;

            case POPUP:
                break;
        }

        typeSpinner = (Spinner) findViewById(R.id.bomb_select_dialog_type_select_spinner);

        typeArrayAdapter = new ArrayAdapter<String>(
                CONTEXT, android.R.layout.simple_list_item_1, bombTypeItems);

        typeSpinner.setAdapter(typeArrayAdapter);

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        //hide number
                        break;

                    case 1:
                        //show blu
                        break;

                    case 2:
                        //show cbu
                        break;

                    case 3:
                        //show mk
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        //open database

        dbTools = new DBTools(CONTEXT);

        try
        {
            dbTools.createDatabase();
        }
        catch (IOException e)
        {
            throw new Error("BombSelectDialog: Unable to create database ");
        }

        try
        {
            Log.d("BombSelectDialog", "openDataBase() try");
            dbTools.openDatabase();
        }
        catch (SQLiteException sqle)
        {
            throw sqle;
        }

    }
}