package com.oldgoat5.bmstacticalreference.reference;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.oldgoat5.bmstacticalreference.R;

import java.util.ArrayList;

/*********************************************************************
 * Copyright © Michael Evans - All Rights Reserved.
 *
 * Contains a searchable brevity dictionary.
 *
 * @author Michael Evans
 * @since 5/11/2015
 *********************************************************************/
public class BrevityDictionaryActivity extends Activity
{
    // http://fas.org/man/dod-101/usaf/docs/mcm3-1-a1.htm

    private ArrayList<WordDefinitionObject> rowsArrayList;
    private BrevityDictionaryTable database;
    private DictionaryItemAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brevity_dictionary_activity_layout);

        //Log.d("dictionaryActivity", "onCreate()");

        database = new BrevityDictionaryTable(this);
        listView = (ListView) findViewById(R.id.brevity_dictionary_list_view);
        rowsArrayList = new ArrayList<WordDefinitionObject>();

        generateAllRows();
        ////Log.d("brevDict::", "rowsArrayList before intent call:");
        ////Log.d("brevDict::", rowsArrayList.get(0).getWord());
        ////Log.d("brevDict::", rowsArrayList.get(1).getWord());
        ////Log.d("brevDict::", rowsArrayList.get(2).getWord());

        handleIntent(getIntent());

        //Log.d("brevdict", "before adapter=");
        adapter = new DictionaryItemAdapter(getApplication(), rowsArrayList);

        //Log.d("brevdict", "before .setadapter");
        listView.setAdapter(adapter);
        //Log.d("brevdict", "after .setadapter");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //Log.d("dictionaryActivity", "onCreateOptionsMenu()" + menu);

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.brevity_dictionary_menu, menu);

        SearchManager manager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        //Log.d("dictionaryActivity", "searchView = " + searchView);

        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(true);

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        handleIntent(intent);
    }

    private void generateAllRows()
    {
        //Log.d("brevDictActivity", "inside generateAllRows()");
        boolean cursorIsNotNull = false;

        Cursor cursor = database.getAllWordsAndDefinitions();
        rowsArrayList.clear();

        do
        {
            try
            {
                if (cursor.moveToFirst())
                {
                    //Log.d("brevDictAct", "inside if cursor.moveToFirst()");
                    do
                    {
                        ////Log.d("brevDictAct", "inside do");
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
        //Log.d("dictionaryActivity", "handleIntent()");

        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            //Log.d("dictionaryActivity", "ACTION_SEARCH intent called");

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
                //Log.d("breviyyDict", "null cursor no search match found");
                generateAllRows();

                Toast toast = Toast.makeText(this, "No Match Found", Toast.LENGTH_LONG);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }
}
