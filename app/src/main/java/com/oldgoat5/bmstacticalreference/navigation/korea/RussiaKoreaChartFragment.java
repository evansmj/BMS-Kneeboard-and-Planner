package com.oldgoat5.bmstacticalreference.navigation.korea;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.PointF;
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
 * Shows a list of Russian charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class RussiaKoreaChartFragment extends Fragment
{
    Context CONTEXT;

    private ArrayAdapter<String> adapter;
    private Dialog dialog;
    private ZoomImageView imageView;
    private ListView listView;
    private Matrix matrix;
    private Matrix savedMatrix;
    private Object mode;
    private PointF start;
    private String[] airbases;
    private View view;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        view = inflater.inflate(R.layout.russia_korea_chart_fragment_layout, container, false);

        airbases = new String[] {"Nachodka Airport Diagram"};

        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                airbases);
        listView = (ListView) view.findViewById(R.id.russia_korea_fragment_list_view);

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
                Log.d("Russia position: ", Integer.toString(position));

                switch(position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.nachodka_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[0]);
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