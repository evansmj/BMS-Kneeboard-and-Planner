package com.oldgoat5.bmstacticalreference.Navigation.Korea;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.oldgoat5.bmstacticalreference.Navigation.ZoomImageView;
import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Shows a list of Japanese charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class JapanKoreaChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayAdapter<String> adapter;
    private Dialog dialog;
    private ZoomImageView imageView;
    private ListView listView;
    private String[] airbases;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.japan_korea_chart_fragment_layout, container, false);

        airbases = new String[] {"Fukuoka (Kadena) Airport Diagram", "Fukuoka (Kadena) Departure",
            "Fukuoka (Kadena) ADIZ Crossing", "Fukuoka (Kadena) ILS RWY 01",
            "Fukuoka (Kadena) ILS RWY 19", "Fukuoka (Kadena) TACAN RWY 15",
            "Fukuoka (Kadena) TACAN RWY 33"};

        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                airbases);
        listView = (ListView) view.findViewById(R.id.japan_korea_fragment_list_view);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        dialog = new Dialog(CONTEXT);
        imageView = new ZoomImageView(CONTEXT);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
        {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,
                                           int position, long id)
            {
                Log.d("Japan position: ", Integer.toString(position));

                switch(position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[0]);
                        dialog.show();
                        break;

                    case 1:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_departure);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[1]);
                        dialog.show();
                        break;

                    case 2:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_adiz_crossing);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[2]);
                        dialog.show();
                        break;

                    case 3:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_ils_rwy_01);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[3]);
                        dialog.show();
                        break;

                    case 4:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_ils_rwy_19);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[4]);
                        dialog.show();
                        break;

                    case 5:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_tacan_rwy_15);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[5]);
                        dialog.show();
                        break;

                    case 6:
                        imageView.setImageResource(R.drawable.fukuoka_kadena_tacan_rwy_33);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[6]);
                        dialog.show();
                        break;

                }
                // Return true to consume the click event. In this case the
                // onListItemClick listener is not called anymore.
                return false;
            }
        });

        listView.setAdapter(adapter);

        return view;
    }

}
