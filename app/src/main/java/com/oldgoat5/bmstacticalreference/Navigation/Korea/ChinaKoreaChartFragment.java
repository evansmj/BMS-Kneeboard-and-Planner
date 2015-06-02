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
 * Shows a list of Chinese charts in the KTO theater.
 *
 * @author Michael Evans
 * @since 5/8/2015
 *********************************************************************/
public class ChinaKoreaChartFragment extends Fragment
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
        view = inflater.inflate(R.layout.china_korea_chart_fragment_layout, container, false);

        airbases = new String[] {"Liuhe Airport Diagram", "Shenyang Airport Diagram"};

        adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1,
                airbases);
        //imageView = (ImageView) view.findViewById(R.id.chart_image_view);
        listView = (ListView) view.findViewById(R.id.china_korea_fragment_list_view);

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

                /*AlertDialog dialog = new AlertDialog.Builder(getActivity())
                        .setView(imageView)
                        //.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        //    @Override
                        //    public void onClick(DialogInterface dialog, int which) {
                         //       dialog.dismiss();
                         //   }
                        .create();*/
                /*AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                AlertDialog dialog = builder.create();
                dialog.setView(imageView,0,0,0,0);


                dialog.show();*/
                Log.d("China position: ", Integer.toString(position));

                switch(position)
                {
                    case 0:
                        imageView.setImageResource(R.drawable.liuhe_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[0]);
                        dialog.show();
                        break;

                    case 1:
                        imageView.setImageResource(R.drawable.shenyang_airport_diagram);
                        dialog.setContentView(imageView);
                        dialog.setTitle(airbases[1]);
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
