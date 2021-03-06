package com.oldgoat5.bmstacticalreference.reference;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Item adapter for the list view of brevity dictionary search results.
 *
 * @author Michael Evans
 * @since 5/12/2015
 *********************************************************************/
public class DictionaryItemAdapter extends ArrayAdapter<WordDefinitionObject>
{
    private final Context CONTEXT;
    private final ArrayList<WordDefinitionObject> itemsArrayList;

    private LayoutInflater inflater;
    private TextView wordView;
    private TextView definitionView;
    private View rowView;

    public DictionaryItemAdapter(Context context, ArrayList<WordDefinitionObject> itemsArrayList)
    {
        super(context, R.layout.word_definition_object_layout, itemsArrayList);

        this.CONTEXT = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;

        /*inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        rowView = inflater.inflate(R.layout.word_definition_object_layout, parent, false);

        wordView = (TextView) rowView.findViewById(R.id.brevity_dictionary_word_text_view);
        wordView.setText((itemsArrayList).get(position).getWord());

        definitionView = (TextView) rowView.findViewById(
                R.id.brevity_dictionary_definition_text_view);
        definitionView.setText((itemsArrayList).get(position).getDefinition());

        if ((position % 2) == 0)
        {
            rowView.setBackgroundColor(Color.parseColor("#E8F2FE"));
        }
        else
        {
            // odd color
        }*/

        if (convertView == null)
        {
            inflater = (LayoutInflater) CONTEXT.getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.word_definition_object_layout, parent, false);
            viewHolder = new ViewHolder();

            viewHolder.wordTextView = (TextView) convertView.findViewById(
                    R.id.brevity_dictionary_word_text_view);
            viewHolder.definitionTextView = (TextView) convertView.findViewById(
                    R.id.brevity_dictionary_definition_text_view);

            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.wordTextView.setText((itemsArrayList).get(position).getWord());
        viewHolder.definitionTextView.setText((itemsArrayList).get(position).getDefinition());

        if ((position % 2) == 0)
        {
            //maybe parse color faster than R.Color, reason for viewholder
            convertView.setBackgroundColor(Color.parseColor("#E8F2FE")); //light_blue
        }
        else
        {
            convertView.setBackgroundColor(Color.parseColor("#00000000"));//transparent
        }

        return convertView;
    }

    private static class ViewHolder
    {
        TextView wordTextView;
        TextView definitionTextView;
    }
}
