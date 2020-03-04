package com.oldgoat5.bmstacticalreference.reference;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Contains a searchable brevity dictionary.
 *
 * @author Michael Evans
 * @since 5/11/2015
 *********************************************************************/
public class BrevityDictionaryActivity extends AppCompatActivity
{
    // http://fas.org/man/dod-101/usaf/docs/mcm3-1-a1.htm

    private ArrayList<WordDefinitionObject> rowsArrayList;
    private BrevityDictionaryTable database;
    private DictionaryItemAdapter adapter;
    private ListView listView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brevity_dictionary_activity_layout);

        database = new BrevityDictionaryTable(this);
        listView = (ListView) findViewById(R.id.brevity_dictionary_list_view);
        rowsArrayList = new ArrayList<WordDefinitionObject>();
        toolbar = (Toolbar) findViewById(R.id.brevity_dictionary_tool_bar);

        toolbar.setTitleTextColor(ContextCompat.getColor(getApplicationContext(), R.color.silver));
        setSupportActionBar(toolbar);
        generateAllRows();

        handleIntent(getIntent());

        adapter = new DictionaryItemAdapter(getApplication(), rowsArrayList);

        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.brevity_dictionary_menu, menu);

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView)
                menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);

        ((EditText) searchView.findViewById(R.id.search_src_text)) //todo fix searchview
                .setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.silver));
        ((EditText)searchView.findViewById(R.id.search_src_text))
                .setHintTextColor(ContextCompat.getColor(getApplicationContext(), R.color.silver));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        handleIntent(intent);
    }

    private void generateAllRows()
    {
        boolean cursorIsNotNull = false;

        Cursor cursor = database.getAllWordsAndDefinitions();
        rowsArrayList.clear();

        do
        {
            try
            {
                if (cursor.moveToFirst())
                {
                    do
                    {
                        rowsArrayList.add(new WordDefinitionObject(cursor.getString(0),
                                cursor.getString(1)));
                    } while (cursor.moveToNext());
                }
                cursorIsNotNull = true;
            }
            catch (NullPointerException e)
            {
                //Log.d("BrevDict", "no getall words to add");
            }
        } while (!cursorIsNotNull);
    }

    private void handleIntent(Intent intent)
    {
        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = database.getWordMatches(query, null);

            rowsArrayList.clear();
            //do stuff with the cursor /display results
            //put them in listview
            try
            {
                if (cursor.moveToFirst())
                {
                    do
                    {
                        rowsArrayList.add(new WordDefinitionObject(cursor.getString(0),
                                cursor.getString(1)));
                    } while (cursor.moveToNext());
                }
            }
            catch (NullPointerException e)
            {
                generateAllRows();

                Toast toast = Toast.makeText(this, "No Match Found", Toast.LENGTH_LONG);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
