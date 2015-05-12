package com.oldgoat5.bmstacticalreference;

import android.app.Activity;
import android.app.LauncherActivity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/*********************************************************************
 * Contains a searchable brevity dictionary.
 *
 * @author Michael Evans
 * @since 5/11/2015
 *********************************************************************/
public class BrevityDictionaryActivity extends Activity
{
    // http://fas.org/man/dod-101/usaf/docs/mcm3-1-a1.htm

    private ArrayList<WordDefinitionObject> rowsArrayList;
    private BrevityDictionaryTable database = new BrevityDictionaryTable(this);
    private DictionaryItemAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.brevity_dictionary_activity_layout);

        listView = (ListView) findViewById(R.id.brevity_dictionary_list_view);
        rowsArrayList = new ArrayList<WordDefinitionObject>();

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
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();

        searchView.setSearchableInfo(manager.getSearchableInfo(getComponentName()));

        return true;
    }

    @Override
    protected void onNewIntent(Intent intent)
    {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent)
    {
        if (Intent.ACTION_SEARCH.equals(intent.getAction()))
        {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Cursor cursor = database.getWordMatches(query, null);
            //do stuff with the cursor /display results
            //put them in listview
            if (cursor.moveToFirst())
            {
                do
                {
                    rowsArrayList.add(new WordDefinitionObject(cursor.getString(0),
                            cursor.getString(1)));
                } while (cursor.moveToNext());
            }
        }
    }
}
