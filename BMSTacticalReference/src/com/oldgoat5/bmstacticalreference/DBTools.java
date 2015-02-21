package com.oldgoat5.bmstacticalreference;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBTools extends SQLiteOpenHelper
{
    private static String DB_PATH = "/data/data/com.oldgoat5.bmstacticalreference"
            + "/databases/";
    private static String DB_NAME = "BMSLoadDB";
    private SQLiteDatabase myDataBase;
    private final Context myContext;
    
    public DBTools (Context context)
    {
        super(context, DB_NAME, null, 1);
        this.myContext = context;
    }
    
    public void createDataBase() throws IOException
    {
        boolean dbExists = checkDataBase();
        
        if (!dbExists)
        {
            this.getReadableDatabase();
            try
            {
                copyDataBase();
            }
            catch (IOException e)
            {
                throw new Error("Error copying database");
            }
        }
    }
    
    private boolean checkDataBase()
    {
        SQLiteDatabase checkDb = null;
        
        try
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
        return checkDb != null ? true : false;
    }
    
    private void copyDataBase() throws IOException
    {
        InputStream myInput = myContext.getAssets().open(DB_NAME);
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
        myInput.close();
    }
    
    public void openDataBase() throws SQLException
    {
        String myPath = DB_PATH + DB_NAME;
        myDataBase = SQLiteDatabase.openDatabase(
                myPath, null, SQLiteDatabase.OPEN_READONLY);
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
    public void onCreate (SQLiteDatabase db)
    {
        //TODO
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        // TODO Auto-generated method stub
    }
}
