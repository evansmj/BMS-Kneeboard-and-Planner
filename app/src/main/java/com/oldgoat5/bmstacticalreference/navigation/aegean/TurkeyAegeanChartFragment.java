package com.oldgoat5.bmstacticalreference.navigation.aegean;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.R;
import com.oldgoat5.bmstacticalreference.navigation.ZoomImageView;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * @author Michael Evans
 * @since 8/30/2015
 *********************************************************************/
public class TurkeyAegeanChartFragment extends Fragment
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
        view = inflater.inflate(R.layout.turkey_aegean_chart_fragment_layout, container, false);

        charts = new String[] {"Sakyatan Range Diagram", "Sakyatan Area Chart", "Sakyatan Targets List",
                               "Akinci Airport Diagram", "Akinci SID RWY 03", "Akinci SID RWY 21",
                               "Akinci TACAN RWY 21", "Antalya Airport Diagram", "Antalya TACAN RWY 16R",
                               "Bandirma Airport Diagram", "Bandirma SID RWY 01 & 19", "Bandirma ILS/DME RWY 01",
                               "Cardak Airport Diagram", "Cardak ILS/DME RWY 26", "Cigli Airport Diagram",
                               "Cigli ILS/DME RWY 16", "Konya Airport Diagram", "Konya SID RWY 01 NE",
                               "Konya SID RWY 01 SW", "Konya SID RWY 19 NE", "Konya SID RWY 19 SW",
                               "Konya ILS/DME RWY 01", "Merkez Airport Diagram", "Merkez SID RWY 01 NE",
                               "Merkez SID RWY 01 SW", "Merkez SID RWY 19 SE", "Merkez SID RWY 19 NW",
                               "Merkez TACAN RWY 01", "Merkez ILS/DME RWY 01"};

        adapter = new AegeanAirbaseArrayAdapter(this.getActivity(), charts);
        listView = (ListView) view.findViewById(R.id.turkey_aegean_fragment_list_view);

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
                Log.d("Turkey position: ", Integer.toString(position));

                switch (position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.sakyatan_range_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 1:
                        imageView.setImageResource(R.drawable.sakyatan_area_chart);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 2:
                        imageView.setImageResource(R.drawable.sakyatan_target_list);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 3:
                        imageView.setImageResource(R.drawable.akinci_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 4:
                        imageView.setImageResource(R.drawable.akinci_sid_rwy_03);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 5:
                        imageView.setImageResource(R.drawable.akinci_sid_rwy_21);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 6:
                        imageView.setImageResource(R.drawable.akinci_tacan_rwy_16r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 7:
                        imageView.setImageResource(R.drawable.antalya_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 8:
                        imageView.setImageResource(R.drawable.antalya_tacan_rwy_16r);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 9:
                        imageView.setImageResource(R.drawable.bandirma_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 10:
                        imageView.setImageResource(R.drawable.bandirma_sid_rwy_01_19);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 11:
                        imageView.setImageResource(R.drawable.bandirma_ils_dme_rwy_01);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 12:
                        imageView.setImageResource(R.drawable.cardak_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 13:
                        imageView.setImageResource(R.drawable.cardak_ils_dme_rwy_26);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 14:
                        imageView.setImageResource(R.drawable.cigli_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 15:
                        imageView.setImageResource(R.drawable.cigli_ils_dme_rwy_16);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 16:
                        imageView.setImageResource(R.drawable.konya_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 17:
                        imageView.setImageResource(R.drawable.konya_sid_rwy_01_ne);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 18:
                        imageView.setImageResource(R.drawable.konya_sid_rwy_01_sw);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 19:
                        imageView.setImageResource(R.drawable.konya_sid_rwy_19_ne);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 20:
                        imageView.setImageResource(R.drawable.konya_sid_rwy_19_sw);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 21:
                        imageView.setImageResource(R.drawable.konya_ils_dme_rwy_01);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 22:
                        imageView.setImageResource(R.drawable.merkez_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 23:
                        imageView.setImageResource(R.drawable.merkez_sid_rwy_01_ne);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 24:
                        imageView.setImageResource(R.drawable.merkez_sid_rwy_01_sw);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 25:
                        imageView.setImageResource(R.drawable.merkez_sid_rwy_19_se);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 26:
                        imageView.setImageResource(R.drawable.merkez_sid_rwy_19_nw);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 27:
                        imageView.setImageResource(R.drawable.merkez_tacan_rwy_01);
                        dialog.setContentView(imageView);
                        dialog.setTitle(charts[position]);
                        dialog.show();
                        break;
                    case 28:
                        imageView.setImageResource(R.drawable.merkez_ils_dme_rwy_01);
                        dialog.setContentView(imageView);
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
