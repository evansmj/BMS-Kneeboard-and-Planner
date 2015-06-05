package com.oldgoat5.bmstacticalreference.Reference;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import android.util.Log;

import com.oldgoat5.bmstacticalreference.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*********************************************************************
 * @author Michael Evans
 * @since 5/12/2015
 *********************************************************************/
public class BrevityDictionaryTable
{
    private static final String TAG = "BrevityDictionaryDatabase";

    public static final String C_WORD = "WORD";
    public static final String C_DEFINITION = "DEFINITION";

    private static final String DB_NAME = "Brevity Dictionary";
    private static final String FTS_VIRTUAL_TABLE = "FTS";
    private static final int DB_VERSION = 1;

    private final DatabaseOpenHelper helper;

    public BrevityDictionaryTable(Context context)
    {
        helper = new DatabaseOpenHelper(context);
    }

    public Cursor getWordMatches(String query, String[] columns)
    {
        String selection = C_WORD + " MATCH ?";
        String[] args = new String[] {query + "*"};

        return query(selection, args, columns);
    }

    public Cursor getAllWordsAndDefinitions()
    {
        Log.d("brevTable", "inside getAllWords");

        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FTS_VIRTUAL_TABLE);

        Cursor cursor = builder.query(helper.getReadableDatabase(),
                new String[] {C_WORD, C_DEFINITION}, null, null, null, null, null);

        //Cursor cursor = helper.getReadableDatabase().rawQuery("SELECT * FROM FTS", null);

        //cursor.moveToFirst();
        //Log.d("testtest", cursor.getString(0));
        //cursor.moveToNext();
        //Log.d("movetonext", cursor.getString(0));

        if(cursor == null)
        {
            return null;
        }
        else if (!cursor.moveToFirst())
        {
            cursor.close();

            return null;
        }

        return cursor;
    }

    private Cursor query(String selection, String[] args, String[] columns)
    {
        SQLiteQueryBuilder builder = new SQLiteQueryBuilder();
        builder.setTables(FTS_VIRTUAL_TABLE);

        Cursor cursor = builder.query(helper.getReadableDatabase(),
                columns, selection, args, null, null, null);

        if (cursor == null)
        {
            return null;
        }
        else if (!cursor.moveToFirst())
        {
            cursor.close();

            return null;
        }

        return cursor;
    }


    /*****************************************************************
     * Inner helper class to execute queries.
     *****************************************************************/
    private static class DatabaseOpenHelper extends SQLiteOpenHelper
    {
        private final Context CONTEXT;
        private SQLiteDatabase database;

        private static final String FTS_TABLE_CREATE = "CREATE VIRTUAL TABLE " + FTS_VIRTUAL_TABLE +
                " USING fts3 (" + C_WORD + ", " + C_DEFINITION + ")";

        DatabaseOpenHelper(Context context)
        {
            super(context, DB_NAME, null, DB_VERSION);
            CONTEXT = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            database = db;
            database.execSQL(FTS_TABLE_CREATE);

            loadDictionary();
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldDb, int newDb)
        {
            db.execSQL("DROP TABLE IF EXISTS " + FTS_VIRTUAL_TABLE);
            onCreate(db);
        }

        private void loadDictionary()
        {
            new Thread(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        loadWords();
                    }
                    catch (IOException e)
                    {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }

        private void loadWords() throws IOException
        {
            final Resources resources = CONTEXT.getResources();
            InputStream inputStream = resources.openRawResource(R.raw.brevity_dictionary);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            try
            {
                String line;
                while ((line = reader.readLine()) != null)
                {
                    String[] strings = TextUtils.split(line, "-");
                    if (strings.length < 2) continue;
                    long id = addWord(strings[0].trim(), strings[1].trim());
                    if (id < 0)
                    {
                        Log.d("BrevityDictTable", "unable to add word");
                    }
                }
            }
            finally
            {
                reader.close();
            }
        }

        public long addWord(String word, String definition)
        {
            ContentValues initialValues = new ContentValues();
            initialValues.put(C_WORD, word);
            initialValues.put(C_DEFINITION, definition);

            return database.insert(FTS_VIRTUAL_TABLE, null, initialValues);
        }
    }//end inner class






} //end main class
