package com.oldgoat5.bmstacticalreference.navigation.korea;

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

import com.oldgoat5.bmstacticalreference.navigation.ZoomImageView;
import com.oldgoat5.bmstacticalreference.R;

/*********************************************************************
 * Shows a list of North Korean charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class NorthKoreaChartFragment extends Fragment
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
        view = inflater.inflate(R.layout.north_korea_chart_fragment_layout, container, false);

        airbases = new String[]{"East-West Airstrips", "North-South Airstrips",
                "Haeju Airport Diagram", "Hwangju Airport Diagram",
                "Hwangsuwon Airport Diagram", "Hyon-Ni Airport Diagram",
                "Iwon Airport Diagram", "Kaech`on Airport Diagram",
                "Koksan Airport Diagram", "Kuum-ni Airport Diagram",
                "Kwail Airport Diagram", "Manp`o Airport Diagram", "Mirim Airport Diagram",
                "Onch`on Airport Diagram", "Ongjin Airport Diagram", "Orang Airport Diagram",
                "Panghyon Airport Diagram", "Pukch`ang-up Airport Diagram",
                "Samjiyon-up Airport Diagram", "Sondok Airport Diagram",
                "Sunan (Pyongyang) Airport Diagram", "Sunch`on Airport Diagram",
                "T`aech`on Airport Diagram", "Taetan Airport Diagram", "Toksan Airport Diagram",
                "Uiju Airport Diagram", "Wonsan Airport Diagram"};

        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                airbases);

        listView = (ListView) view.findViewById(R.id.north_korea_fragment_list_view);

        if (this.isAdded())
        {
            CONTEXT = getActivity();
        }

        dialog = new Dialog(CONTEXT);
        imageView = new ZoomImageView(CONTEXT);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                           int position, long id)
            {
                Log.d("North Korea position: ", Integer.toString(position));

                switch (position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.north_korea_east_west_airstrips);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[0]);
                        dialog.show();
                        break;

                    case 1:
                        imageView.setImageResource(R.drawable.north_korea_north_south_airstrips);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[1]);
                        dialog.show();
                        break;

                    case 2:
                        imageView.setImageResource(R.drawable.haeju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[2]);
                        dialog.show();
                        break;

                    case 3:
                        imageView.setImageResource(R.drawable.hwangju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[3]);
                        dialog.show();
                        break;

                    case 4:
                        imageView.setImageResource(R.drawable.hwangsuwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[4]);
                        dialog.show();
                        break;

                    case 5:
                        imageView.setImageResource(R.drawable.hyonni_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[5]);
                        dialog.show();
                        break;

                    case 6:
                        imageView.setImageResource(R.drawable.iwon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[6]);
                        dialog.show();
                        break;

                    case 7:
                        imageView.setImageResource(R.drawable.kaechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[7]);
                        dialog.show();
                        break;

                    case 8:
                        imageView.setImageResource(R.drawable.koksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[8]);
                        dialog.show();
                        break;

                    case 9:
                        imageView.setImageResource(R.drawable.kuumni_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[9]);
                        dialog.show();
                        break;

                    case 10:
                        imageView.setImageResource(R.drawable.kwail_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[19]);
                        dialog.show();
                        break;

                    case 11:
                        imageView.setImageResource(R.drawable.manpo_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[11]);
                        dialog.show();
                        break;

                    case 12:
                        imageView.setImageResource(R.drawable.mirim_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[12]);
                        dialog.show();
                        break;

                    case 13:
                        imageView.setImageResource(R.drawable.onchon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[13]);
                        dialog.show();
                        break;

                    case 14:
                        imageView.setImageResource(R.drawable.ongjin_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[14]);
                        dialog.show();
                        break;

                    case 15:
                        imageView.setImageResource(R.drawable.orang_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[15]);
                        dialog.show();
                        break;

                    case 16:
                        imageView.setImageResource(R.drawable.panghyon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[16]);
                        dialog.show();
                        break;

                    case 17:
                        imageView.setImageResource(R.drawable.pukchangup_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[17]);
                        dialog.show();
                        break;

                    case 18:
                        imageView.setImageResource(R.drawable.samjiyonup_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[18]);
                        dialog.show();
                        break;

                    case 19:
                        imageView.setImageResource(R.drawable.sondok_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[19]);
                        dialog.show();
                        break;

                    case 20:
                        imageView.setImageResource(R.drawable.sunan_pyongyang_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[20]);
                        dialog.show();
                        break;

                    case 21:
                        imageView.setImageResource(R.drawable.sunchon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[21]);
                        dialog.show();
                        break;

                    case 22:
                        imageView.setImageResource(R.drawable.taechon_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[22]);
                        dialog.show();
                        break;

                    case 23:
                        imageView.setImageResource(R.drawable.taetan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[23]);
                        dialog.show();
                        break;

                    case 24:
                        imageView.setImageResource(R.drawable.toksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[24]);
                        dialog.show();
                        break;

                    case 25:
                        imageView.setImageResource(R.drawable.uiju_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[25]);
                        dialog.show();
                        break;

                    case 26:
                        imageView.setImageResource(R.drawable.toksan_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[26]);
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
