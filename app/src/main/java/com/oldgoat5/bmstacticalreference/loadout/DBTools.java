package com.oldgoat5.bmstacticalreference.LoadOut;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;

public class DBTools extends SQLiteOpenHelper
{
    //TODO rename ordinance table to ordnance.  or rename to load.
    private final Context CONTEXT;
    
    private static String DB_PATH;
    private static String DB_NAME = "BMSLoadDB.db";
    
    private SQLiteDatabase database;
    
    public DBTools(Context context)
    {
        super(context, DB_NAME, null, 1);
        Log.d("DBTools", "constructor");
        this.CONTEXT = context;
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        //DB_PATH = Environment.getExternalStorageDirectory();
        Log.d("constructor, DB_PATH=", DB_PATH);
        Log.d("cnstructor, context=", context.toString());
    }
    
    public void createDatabase() throws IOException
    {
        boolean dbExists = checkDatabase();
        Log.d("dbtools", "createDataBase()");
        
        if (!dbExists)
        {
            Log.d("DBTools", "if !dbExists called");
     
            database = this.getReadableDatabase();
            
            try
            {
                copyDatabase();
            } 
            catch(IOException e)
            {
                Log.d("dbtools", "EXCEPTION copydb()");
                e.printStackTrace();
                //throw new Error("Could not copy database");
            }
        }
        /*if (!dbExists)
        {
            this.getReadableDatabase();
            this.close();
            try
            {
                checkDataBase();
            }
            catch (IOException e)
            {
                throw new Error("Error copying database");
            }
        }*/
    }
    
    private boolean checkDatabase() throws IOException
    {
        //SQLiteDatabase checkDb = null;
        File file = CONTEXT.getDatabasePath(DB_NAME);
        return file.exists();
        
        /*try
        {
            String path = DB_PATH + DB_NAME;
            checkDb = SQLiteDatabase.openDatabase(
                    path, null, SQLiteDatabase.OPEN_READONLY);
            Log.d("DBTools", "checkDatabase() try");
        }
        catch (SQLiteException e)
        {
            throw new Error("database does't exist");
        }
        
        if(checkDb != null)
        {
            checkDb.close();
        }
        
        return checkDb != null;*/
        
        /*if (!dbFile.exists())
        {
            Log.d("DBTools.java", "checkdb() if!dbFile.exists called");
            dbFile.getParentFile().mkdirs();
            copyDataBase(CONTEXT.getAssets().open(DB_PATH), 
            new FileOutputStream(DB_PATH));
        }*/
    }
    
    private void copyDatabase() throws IOException
    {
        /*boolean repeat = true;
        byte buffer[] = new byte[1024];
        int length = 0;
        
        while (repeat)
        {
            length = inputStream.read(buffer);
            
            if (length == -1)
            {
                repeat = false;
            }
            else
            {
                outputStream.write(buffer, 0, length);
            }
            
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        }*/
        Log.d("dbtools", "start copyDatabase");
        
        InputStream input = CONTEXT.getAssets().open(DB_NAME);
        Log.d("input=", input.toString());
        
        String outFileName = DB_PATH + DB_NAME;
        
        OutputStream output = new FileOutputStream(outFileName);
        Log.d("output", output.toString());
        
        byte[] buffer = new byte[1024];
        int length;
        while ((length = input.read(buffer)) > 0)
        {
            output.write(buffer, 0, length);
        }
        output.flush();
        output.close();
        input.close();
        
    }
    
    public void openDatabase() throws SQLException
    {
        String path = DB_PATH + DB_NAME;
        database = SQLiteDatabase.openDatabase(
                path, null, SQLiteDatabase.OPEN_READONLY);
    }
    
    /*****************************************************************
     * Gets all rows from the database and orders them by id.  
     * 
     * @return Returns a HashMap of all rows in the database.
     *****************************************************************/
    public ArrayList<OrdinanceObject> getAllRows()
    {
        Log.d("dbtools", "begin getAllRows()");
        Log.d("myDataBase path", database.getPath());
        Log.d("myDataBase version", Integer.toString(database.getVersion()));
        
        //ArrayList<HashMap<String, String>> rowsArrayList;
        ArrayList<OrdinanceObject> rowsArrayList;
        //HashMap<String, String> rowMap = new HashMap<String, String>();
        
        //rowsArrayList = new ArrayList<HashMap<String, String>>();
        rowsArrayList = new ArrayList<OrdinanceObject>();
        
        String selectQuery = "SELECT * FROM ordinance ORDER BY _id";
        
        //SQLiteDatabase database = this.getReadableDatabase();
        database = this.getReadableDatabase();
        
        Log.d("dbtools", "before cursor = db.rawQuery");
        
        //////////it is breaking here.  check the myDataBase stuff. ////////////////////////////////// 
        Log.d("my DataBase test", database.toString());
        
        Cursor cursor = database.rawQuery(selectQuery, null);
        //Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        
        Log.d("dbtools", "after cursor raw query");
        
        
        //make an object type of ordinance.  stick these into array list.  
        if (cursor.moveToFirst())
        {
            do
            {
                rowsArrayList.add(new OrdinanceObject(cursor.getString(0),
                        cursor.getString(1), cursor.getString(2), 
                        cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8)));
                //
            } while (cursor.moveToNext());
        }
        
        return rowsArrayList;
    }
    
    @Override
    public synchronized void close()
    {
        if (database != null)
        {
            database.close();
        }
        super.close();
    }
    
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        //TODO
        Log.d("DBTools", "onCreate(db)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO Auto-generated method stub
    }
}
