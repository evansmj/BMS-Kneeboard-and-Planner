package com.oldgoat5.bmstacticalreference.missionplanner.level;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.missionplanner.BombSelectDialog;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @version 7/17/2015
 *********************************************************************/
public class LevelBombMissionPlannerConditionsFragment extends Fragment
{
    final String[] situationItems = {"---", "Sunny", "Fair", "Poor", "Inclement"};

    private ArrayAdapter<String> situationsArrayAdapter;
    private BombSelectDialog bombSelectDialog;
    private Button nextButton;
    private Button selectBomb;
    private EditText windEditText;
    private EditText tempEditText;
    private EditText cloudBaseEditText;
    private EditText conLayerEditText;
    private Spinner situationsSpinner;
    private TextView selectedWeaponTextView;
    private View view;

    private int cloudBase;
    private int conLayer;
    private int localTimeOnTarget;
    private int windDirection;
    private int windSpeed;
    private String selectedSituation;
    private String selectedWeapon;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(
                R.layout.level_bomb_mission_planner_conditions_fragment_layout, container, false);

        nextButton = (Button) view.findViewById(R.id.level_bomb_conditions_fragment_next_button);
        selectBomb = (Button) view.findViewById(R.id.level_bomb_conditions_fragment_select_bomb_button);

        windEditText = (EditText) view.findViewById(R.id.winds_edit_text);
        windEditText.setText("000°@00kn.");
        tempEditText = (EditText) view.findViewById(R.id.temperature_edit_text);
        tempEditText.setText("20°C");

        selectedWeaponTextView = (TextView) view.findViewById(R.id.level_bomb_conditions_fragment_selected_weapon_text_view);

        situationsSpinner = (Spinner) view.findViewById(R.id.situation_spinner);

        situationsArrayAdapter = new ArrayAdapter<String>(
                this.getActivity(), android.R.layout.simple_spinner_item, situationItems);

        situationsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                switch (i)
                {
                    case 0:
                        selectedSituation = situationItems[i];
                        break;

                    case 1:
                        selectedSituation = situationItems[i];
                        break;

                    case 2:
                        selectedSituation = situationItems[i];
                        break;

                    case 3:
                        selectedSituation = situationItems[i];
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView)
            {

            }
        });

        situationsSpinner.setAdapter(situationsArrayAdapter);

        selectBomb.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //bring up dialog.
                bombSelectDialog = new BombSelectDialog(
                        getActivity(), BombSelectDialog.PlannerType.LEVEL);

                bombSelectDialog.setTitle("Level Release Bomb Select");
                bombSelectDialog.setContentView(R.layout.bomb_select_dialog);
                bombSelectDialog.show();

                bombSelectDialog.setDialogResult(new BombSelectDialog.OnDialogResult()
                {
                    @Override
                    public void setResult(String weaponName)
                    {
                        selectedWeapon = weaponName;
                        Log.d("levlConitionsFrag", "selectedWeapon = " + selectedWeapon);
                        selectedWeaponTextView.setText(selectedWeapon);
                        selectedWeaponTextView.setTextColor(Color.BLACK);
                    }
                });
            }
        });

        windEditText.addTextChangedListener(new TextWatcher()
        {
            String before;

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                Log.d("levelConFragment", "beforeTextChanged: " + charSequence);
                before = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
            {
                Log.d("levelConFragment", "onTextChanged: " + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                Log.d("levelConFragment", "afterTextChanged: " + editable.toString());
                if (editable.toString().length() == 3 && before.length() == 2)
                {
                    editable.append("°@");
                }
            }
        });

        windEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b && !windEditText.getText().toString().contains("kn."))
                {
                    String oldText = windEditText.getText().toString();
                    windEditText.setText(oldText + "kn.");
                }
            }
        });

        tempEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b && !tempEditText.getText().toString().contains("°C"))
                {
                    String oldText = tempEditText.getText().toString();
                    tempEditText.setText(oldText + "°C");
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //
            }
        });

        return view;
    }
}
