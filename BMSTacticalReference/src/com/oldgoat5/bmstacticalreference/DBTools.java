package com.oldgoat5.bmstacticalreference;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBTools extends SQLiteOpenHelper
{
    private final Context CONTEXT;
    
    //private static String DB_PATH = "/data/data/com.oldgoat5.bmstacticalreference"
      //      + "/databases/";
    private static String DB_PATH;
    private static String DB_NAME = "BMSLoadDB";
    
    private SQLiteDatabase myDataBase;
    
    public DBTools (Context context)
    {
        super(context, DB_NAME, null, 1);
        Log.d("DBTools", "constructor");
        this.CONTEXT = context;
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
    }
    
    public void createDataBase() throws IOException
    {
        //boolean dbExists = checkDataBase();
        Log.d("dbtools", "createDataBase()");
        
        checkDataBase();
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
    
    private void checkDataBase() throws IOException
    {
        //SQLiteDatabase checkDb = null;
        File dbFile = new File(DB_PATH);
        
        if (dbFile.exists())
        {
            Log.d("DBTools.java", "checkdb() if!dbFile.exists called");
            dbFile.getParentFile().mkdirs();
            copyDataBase(CONTEXT.getAssets().open(DB_PATH), 
            new FileOutputStream(DB_PATH));
        }
        
        
        /*try
        {
            String myPath = DB_PATH + DB_NAME;
            checkDb = SQLiteDatabase.openDatabase(
                    myPath, null, SQLiteDatabase.OPEN_READONLY);
        }
        catch (SQLiteException e)
        {
            Log.d("DBCreate.java", "database not created yet");
        }
        
        if (checkDb != null)
        {
            checkDb.close();
        }
        return checkDb != null ? true : false;*/
    }
    
    private void copyDataBase(InputStream inputStream, 
            OutputStream outputStream) throws IOException
    {
        boolean repeat = true;
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
        }
        
        /*InputStream myInput = myContext.getAssets().open(DB_NAME);
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        
        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0)
        {
            myOutput.write(buffer, 0, length);
        }
        myOutput.flush();
        myOutput.close();
        myInput.close();*/
        
    }
    
    public void openDataBase() throws SQLException
    {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(
                myPath, null, SQLiteDatabase.OPEN_READONLY);
    }
    
    /*****************************************************************
     * Gets all rows from the database and orders them by id.  
     * 
     * @return Returns a HashMap of all rows in the database.
     *****************************************************************/
    public ArrayList<OrdinanceObject> getAllRows()
    {
        Log.d("dbtools", "begin getAllRows()");
        Log.d("myDataBase path", myDataBase.getPath());
        Log.d("myDataBase version", Integer.toString(myDataBase.getVersion()));
        
        //ArrayList<HashMap<String, String>> rowsArrayList;
        ArrayList<OrdinanceObject> rowsArrayList;
        //HashMap<String, String> rowMap = new HashMap<String, String>();
        
        //rowsArrayList = new ArrayList<HashMap<String, String>>();
        rowsArrayList = new ArrayList<OrdinanceObject>();
        
        String selectQuery = "SELECT * FROM ordinance ORDER BY id";
        
        //SQLiteDatabase database = this.getReadableDatabase();
        myDataBase = this.getReadableDatabase();
        
        Log.d("dbtools", "before cursor = db.rawQuery");
        
        //////////it is breaking here.  check the myDataBase stuff. ////////////////////////////////// 
        Log.d("my DataBase test", myDataBase.toString());
        
        Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        //Cursor cursor = myDataBase.rawQuery(selectQuery, null);
        
        Log.d("dbtools", "after cursor raw query");
        
        
        //make an object type of ordinance.  stick these into array list.  
        if (cursor.moveToFirst())
        {
            do
            {
                rowsArrayList.add(new OrdinanceObject(cursor.getInt(0),
                        cursor.getString(1), cursor.getInt(2), 
                        cursor.getInt(3), cursor.getString(4),
                        cursor.getString(5), cursor.getInt(6),
                        cursor.getInt(7), cursor.getString(8)));
                //
            } while (cursor.moveToNext());
        }
        
        
        /*if (cursor.moveToFirst())
        {
            do
            {
                rowMap = new HashMap<String, String>();
                rowMap.put("id", cursor.getString(0));
                rowMap.put("name", cursor.getString(1));
                rowMap.put("weight", cursor.getString(2));
                rowMap.put("drag", cursor.getString(3));
                rowMap.put("damage", cursor.getString(4));
                rowMap.put("guidance", cursor.getString(5));
                rowMap.put("range", cursor.getString(6));
                rowMap.put("blast", cursor.getString(7));
                rowMap.put("info", cursor.getString(8));
                rowsArrayList.add(rowMap);
            }while (cursor.moveToNext());
        }*/
        
        return rowsArrayList;
    }
    
    

    @Override
    public synchronized void close()
    {
        if (myDataBase != null)
        {
            myDataBase.close();
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
