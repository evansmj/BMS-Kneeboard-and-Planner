package com.oldgoat5.bmstacticalreference.missionplanner;

import android.app.Dialog;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tacticalreference.DBTools;
import com.oldgoat5.bmstacticalreference.tacticalreference.WeaponUseListItemAdapter;

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
    private Button cancelButton;
    private Button selectButton;
    private Button viewBombInfoButton;
    private DBTools dbTools;
    private Dialog bombDialog;
    private Spinner typeSpinner;
    private Spinner idSpinner;
    private TextView idTextView;
    private TextView typeTextView;
    private WeaponUseListItemAdapter idArrayAdapter;
    private View bombDialogView;
    private View weaponView;

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

        selectButton = (Button) findViewById(R.id.bomb_select_dialog_ok_button);
        cancelButton = (Button) findViewById(R.id.bomb_select_dialog_cancel_button);
        viewBombInfoButton = (Button) findViewById(R.id.bomb_select_dialog_view_bomb_info_button);

        idSpinner = (Spinner) findViewById(R.id.bomb_select_dialog_select_bomb_spinner);
        typeSpinner = (Spinner) findViewById(R.id.bomb_select_dialog_type_select_spinner);

        typeTextView = (TextView) findViewById(R.id.bomb_select_dialog_type_select_text_view);
        idTextView = (TextView) findViewById(R.id.bomb_select_dialog_select_bomb_text_view);

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
                        selectButton.setVisibility(View.GONE);
                        cancelButton.setVisibility(View.GONE);
                        idTextView.setVisibility(View.GONE);
                        viewBombInfoButton.setVisibility(View.GONE);
                        idSpinner.setVisibility(View.GONE);
                        idSpinner.setAdapter(null);
                        break;

                    case 1:
                        //show blu
                        break;

                    case 2:
                        //show cbu
                        idArrayAdapter = new WeaponUseListItemAdapter(CONTEXT, dbTools.getClusterBombs());
                        idSpinner.setAdapter(idArrayAdapter);
                        idTextView.setVisibility(View.VISIBLE);
                        idSpinner.setVisibility(View.VISIBLE);
                        viewBombInfoButton.setVisibility(View.VISIBLE);
                        selectButton.setVisibility(View.VISIBLE);
                        cancelButton.setVisibility(View.VISIBLE);
                        break;

                    case 3:
                        //show mk
                        idArrayAdapter = new WeaponUseListItemAdapter(CONTEXT, dbTools.getMarkBombs());
                        idSpinner.setAdapter(idArrayAdapter);
                        idTextView.setVisibility(View.VISIBLE);
                        idSpinner.setVisibility(View.VISIBLE);
                        viewBombInfoButton.setVisibility(View.VISIBLE);
                        selectButton.setVisibility(View.VISIBLE);
                        cancelButton.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        idSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View rowView, int i, long l)
            {
                bombDialog = new Dialog(CONTEXT);
                bombDialog.setContentView(R.layout.weapon_dialog_layout);
                weaponView = rowView;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        viewBombInfoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                bombDialogView = dbTools.populateWeaponDialog(bombDialog, weaponView);
                bombDialog.show();
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