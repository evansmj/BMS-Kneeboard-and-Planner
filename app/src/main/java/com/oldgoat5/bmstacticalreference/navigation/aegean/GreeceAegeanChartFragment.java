package com.oldgoat5.bmstacticalreference.navigation.aegean;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.tools.views.ZoomImageView;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 8/29/2015
 *********************************************************************/
public class GreeceAegeanChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayAdapter<String> adapter;
    private Dialog dialog;
    private ZoomImageView imageView;
    private ListView listView;
    private String[] charts;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.greece_aegean_chart_fragment_layout, container, false);

        charts = new String[] {"Assimi Range Diagram", "Assimi Area Chart", "Assimi Targets List",
                               "Diagoras Airport Diagram", "Diagoras SID RWY 08 & 26",
                               "Diagoras ILS/DME RWY 26", "Ifaistos Airport Diagram",
                               "Ifaistos SID RWY 03 N", "Ifaistos SID RWY 03 S",
                               "Ifaistos SID RWY 21 N", "Ifaistos SID RWY 21 S",
                               "Ifaistos TACAN RWY 03", "I. Daskalogiannis Airport Diagram",
                               "I. Daskalogiannis SID RWY 11 NE", "I. Daskalogiannis SID RWY 11 S",
                               "I. Daskalogiannis SID RWY 29 NE", "I. Daskalogiannis SID RWY 29 NS",
                               "I. Daskalogiannis STAR RWY 11", "I. Daskalogiannis STAR RWY 29",
                               "I. Daskalogiannis TACAN RWY 11", "I. Daskalogiannis TACAN RWY 29",
                               "I. Daskalogiannis VFR", "Kasteli Airport Diagram",
                               "Kasteli SID RWY 02", "Kasteli SID RWY 20",
                               "Kasteli TACAN RWY 02", "Larissa Airport Diagram",
                               "Larissa SID RWY 08 N", "Larissa SID RWY 08 SE",
                               "Larissa SID RWY 26 NE", "Larissa SID RWY 26 S",
                               "Larissa TACAN RWY 08", "Mikonos Airport Diagram",
                               "Mikonos VORTAC RWY 34", "Nea Anchialos Airport Diagram",
                               "Nea Anchialos SID RWY 08", "Nea Anchialos SID RWY 26",
                               "Nea Anchialos TACAN RWY 26", "Nea Anchialos ILS/DME RWY 26",
                               "Santorini Airport Diagram", "Santorini SID RWY 16 & 34",
                               "Santorini TACAN RWY 16", "Santorini TACAN RWY 34",
                               "Tanagra Airport Diagram", "Tanagra SID RWY 11 NE",
                               "Tanagra SID RWY 11 W", "Tanagra SID RWY 29 N",
                               "Tanagra SID RWY 29 S", "Tanagra TACAN RWY 29",
                               "Tanagra ILS/DME RWY 29"};

        adapter = new AegeanAirbaseArrayAdapter(this.getActivity(), charts);
        listView = (ListView) view.findViewById(R.id.greece_aegean_fragment_list_view);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        dialog = new Dialog(CONTEXT);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        imageView = new ZoomImageView(CONTEXT);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id)
            {

                switch (position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.assimi_range_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.assimi_area_chart);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.assimi_target_list);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.diagoras_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.diagoras_sid_rwy_08_26);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.diagoras_ils_dme_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.ifaistos_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.ifaistos_sid_rwy_03_n);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.ifaistos_sid_rwy_03_s);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.ifaistos_sid_rwy_21_n);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.ifaistos_sid_rwy_21_s);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.ifaistos_tacan_rwy_03);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_sid_rwy_11_ne);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_sid_rwy_11_s);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 15:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_sid_rwy_29_ne);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 16:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_sid_rwy_29_ns);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 17:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_star_rwy_11);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 18:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_star_rwy_29);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 19:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_tacan_rwy_11);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 20:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_tacan_rwy_29);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 21:
                        imageView.setImageResource(R.drawable.i_daskalogiannis_vfr);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 22:
                        imageView.setImageResource(R.drawable.kasteli_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 23:
                        imageView.setImageResource(R.drawable.kasteli_sid_rwy_02);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 24:
                        imageView.setImageResource(R.drawable.kasteli_sid_rwy_20);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 25:
                        imageView.setImageResource(R.drawable.kasteli_tacan_rwy_02);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 26:
                        imageView.setImageResource(R.drawable.larissa_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 27:
                        imageView.setImageResource(R.drawable.larissa_sid_rwy_08_n);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 28:
                        imageView.setImageResource(R.drawable.larissa_sid_rwy_08_se);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 29:
                        imageView.setImageResource(R.drawable.larissa_sid_rwy_26_ne);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 30:
                        imageView.setImageResource(R.drawable.larissa_sid_rwy_26_s);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 31:
                        imageView.setImageResource(R.drawable.larissa_tacan_rwy_08);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 32:
                        imageView.setImageResource(R.drawable.mikonos_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 33:
                        imageView.setImageResource(R.drawable.mikonos_vortac_rwy_34);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 34:
                        imageView.setImageResource(R.drawable.nea_anchialos_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 35:
                        imageView.setImageResource(R.drawable.nea_anchialos_sid_rwy_08);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 36:
                        imageView.setImageResource(R.drawable.nea_anchialos_sid_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 37:
                        imageView.setImageResource(R.drawable.nea_anchialos_tacan_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 38:
                        imageView.setImageResource(R.drawable.nea_anchialos_ils_dme_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 39:
                        imageView.setImageResource(R.drawable.santorini_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 40:
                        imageView.setImageResource(R.drawable.santorini_sid_rwy_16_34);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 41:
                        imageView.setImageResource(R.drawable.santorini_tacan_rwy_16);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 42:
                        imageView.setImageResource(R.drawable.santorini_tacan_rwy_34);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 43:
                        imageView.setImageResource(R.drawable.tanagra_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 44:
                        imageView.setImageResource(R.drawable.tanagra_sid_rwy_11_ne);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 45:
                        imageView.setImageResource(R.drawable.tanagra_sid_rwy_11_w);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 46:
                        imageView.setImageResource(R.drawable.tanagra_sid_rwy_29_n);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 47:
                        imageView.setImageResource(R.drawable.tanagra_sid_rwy_29_s);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 48:
                        imageView.setImageResource(R.drawable.tanagra_tacan_rwy_29);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 49:
                        imageView.setImageResource(R.drawable.tanagra_ils_dme_rwy_29);
                        dialog.setContentView(imageView);
                        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                                WindowManager.LayoutParams.MATCH_PARENT);
                        dialog.setCanceledOnTouchOutside(false);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                }
                // Return true to consume the click event. In this case the
                // onListItemClick listener is not called anymore.
                //return false;
            }
        });

        listView.setAdapter(adapter);

        return view;
    }
}
