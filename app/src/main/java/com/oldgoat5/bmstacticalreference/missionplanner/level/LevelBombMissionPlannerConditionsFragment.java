package com.oldgoat5.bmstacticalreference.missionplanner.level;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.missionplanner.BombSelectDialog;

import java.text.DecimalFormat;

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
    private LevelBombMissionPlannerParametersFragment parametersFragment;
    private OnConditionsResult onConditionsResult;
    private Spinner situationsSpinner;
    private TextView selectedWeaponTextView;
    private View view;

    private int selectedCloudBase;
    private int selectedConLayer;
    private int selectedTemperature;
    private int selectedWindDirection;
    private int selectedWindSpeed;
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
        cloudBaseEditText = (EditText) view.findViewById(R.id.cloud_base_edit_text);
        cloudBaseEditText.setText("20000ft.");
        conLayerEditText = (EditText) view.findViewById(R.id.con_layer_edit_text);
        conLayerEditText.setText("30000ft.");

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
                    try
                    {
                        String oldText = windEditText.getText().toString();

                        if (oldText.length() > 5)
                        {
                            windEditText.setText(oldText + "kn.");

                            int heading = Integer.parseInt(oldText.substring(0, 3));

                            Log.d("LevelConFrag", "heading: " + heading);

                            if (heading > 360)
                            {
                                Toast.makeText(getActivity(),
                                        "Invalid Heading, must be < 360", Toast.LENGTH_LONG).show();
                            }

                            String speedText = windEditText.getText().toString().substring(5).replace("kn.", "");

                            Log.d("LevelconFrag", "wind Speed: " + speedText);

                            if (Integer.parseInt(speedText) > 99)
                            {
                                Toast.makeText(getActivity(),
                                        "Wind Speed may be excessive.", Toast.LENGTH_LONG).show();
                            }
                        } else
                        {
                            throw new NumberFormatException();
                        }
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(),
                                "Invalid Wind value.", Toast.LENGTH_LONG).show();
                    }
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

                    try
                    {
                        Integer.parseInt(oldText);
                        tempEditText.setText(oldText + "°C");
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(),
                                "Invalid Temperature value.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        cloudBaseEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b && !cloudBaseEditText.getText().toString().contains("ft."))
                {
                    String oldText = cloudBaseEditText.getText().toString();

                    try
                    {
                        if (oldText.contains(","))
                        {
                            oldText = oldText.replace(",", "");
                        }
                        Integer.parseInt(oldText);
                        cloudBaseEditText.setText(oldText + "ft.");
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(),
                                "Invalid Cloud Base value.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        conLayerEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
        {
            @Override
            public void onFocusChange(View view, boolean b)
            {
                if (!b && !conLayerEditText.getText().toString().contains("ft."))
                {
                    String oldText = conLayerEditText.getText().toString();

                    try
                    {
                        if (oldText.contains(","))
                        {
                            oldText = oldText.replace(",", "");
                        }
                        Integer.parseInt(oldText);
                        conLayerEditText.setText(oldText + "ft.");
                    }
                    catch (NumberFormatException e)
                    {
                        Toast.makeText(getActivity(),
                                "Invalid Condensation Layer value.", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //make sure situation is set then send input bundle to ParametersFragment.
                if (selectedSituation != "---")
                {
                    selectedWindDirection = Integer.parseInt(
                            windEditText.getText().toString().substring(0, 2));
                    selectedWindSpeed = Integer.parseInt(
                            windEditText.getText().toString().substring(5).replace("kn.", ""));
                    selectedTemperature = Integer.parseInt(
                            tempEditText.getText().toString().replace("°C", ""));
                    selectedCloudBase = Integer.parseInt(
                            cloudBaseEditText.getText().toString().replace("ft.", ""));
                    selectedConLayer = Integer.parseInt(
                            conLayerEditText.getText().toString().replace("ft.", ""));

                    //make bundle
                    Bundle bundle = new Bundle();
                    bundle.putInt("selectedWindDirection", selectedWindDirection);
                    bundle.putInt("selectedWindSpeed", selectedWindSpeed);
                    bundle.putInt("selectedTemperature", selectedTemperature);
                    bundle.putInt("selectedCloudBase", selectedCloudBase);
                    bundle.putInt("selectedConLayer", selectedConLayer);
                    bundle.putString("selectedSituation", selectedSituation);
                    bundle.putString("selectedWeapon", selectedWeapon);

                    //send to level bomb mission planner parameters fragment.

                    //parametersFragment = new LevelBombMissionPlannerParametersFragment();
                    //parametersFragment.setArguments(bundle);

                    if (onConditionsResult != null)
                    {
                        onConditionsResult.setBundle(bundle);
                    }
                }
                else
                {
                    //make toast invalid weather situation
                    Toast.makeText(getActivity(),
                        "Invalid Weather Situation value.", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

    public void setConditionsResult(OnConditionsResult result)
    {
        onConditionsResult = result;
    }

    public interface OnConditionsResult
    {
        void setBundle(Bundle bundle);
    }
}
