package com.oldgoat5.bmstacticalreference;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/*********************************************************************
 * Item adapter for the list view of brevity dictionary search results.
 *
 * @author Michael Evans
 * @since 5/12/2015
 *********************************************************************/
public class DictionaryItemAdapter extends ArrayAdapter<WordDefinitionObject>
{
    private final Context CONTEXT;
    private final ArrayList<WordDefinitionObject> itemsArrayList;

    public DictionaryItemAdapter(Context context, ArrayList<WordDefinitionObject> itemsArrayList)
    {
        super(context, R.layout.word_definition_object_layout, itemsArrayList);

        this.CONTEXT = context;
        this.itemsArrayList = itemsArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater = (LayoutInflater) CONTEXT.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.word_definition_object_layout, parent, false);

        TextView wordView = (TextView) rowView.findViewById(R.id.brevity_dictionary_word_text_view);
        wordView.setText((itemsArrayList).get(position).getWord());

        TextView definitionView = (TextView) rowView.findViewById(
                R.id.brevity_dictionary_definition_text_view);
        definitionView.setText((itemsArrayList).get(position).getDefinition());

        return rowView;
    }
}
