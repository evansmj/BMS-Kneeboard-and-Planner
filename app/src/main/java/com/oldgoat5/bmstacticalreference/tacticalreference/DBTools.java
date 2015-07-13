package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class DBTools extends SQLiteAssetHelper
{
    private final Context CONTEXT;
    
    private static String DB_PATH;
    private static String DB_NAME = "BMSLoadDB.db";
    /**
     * //TODO Increment DB_VERSION after database updates before release.
     */
    private static int DB_VERSION = 1;

    private SQLiteDatabase database;
    
    public DBTools(Context context)
    {
        super(context, DB_NAME, null, DB_VERSION);
        Log.d("DBTools", "constructor");
        this.CONTEXT = context;
        DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        //DB_PATH = Environment.getExternalStorageDirectory();
        setForcedUpgrade();
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

            database = this.getWritableDatabase();

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
                path, null, SQLiteDatabase.OPEN_READWRITE);
    }
    
    /*****************************************************************
     * Gets all rows from the database and orders them by id.  
     * 
     * @return Returns an ArrayList of all rows in the database.
     *****************************************************************/
    public ArrayList<OrdnanceObject> getAllRows()
    {
        Log.d("dbtools", "begin getAllRows()");
        Log.d("myDataBase path", database.getPath());
        Log.d("myDataBase version", Integer.toString(database.getVersion()));
        
        //ArrayList<HashMap<String, String>> rowsArrayList;
        ArrayList<OrdnanceObject> rowsArrayList;
        //HashMap<String, String> rowMap = new HashMap<String, String>();
        
        //rowsArrayList = new ArrayList<HashMap<String, String>>();
        rowsArrayList = new ArrayList<OrdnanceObject>();
        
        String selectQuery = "SELECT * FROM ordinance ORDER BY _id";
        
        //SQLiteDatabase database = this.getReadableDatabase();
        database = this.getWritableDatabase();
        
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
                rowsArrayList.add(new OrdnanceObject(cursor.getString(0),
                        cursor.getString(1), cursor.getString(2), 
                        cursor.getString(3), cursor.getString(4),
                        cursor.getString(5), cursor.getString(6),
                        cursor.getString(7), cursor.getString(8)));
                //
            } while (cursor.moveToNext());
        }
        
        return rowsArrayList;
    }

    /*****************************************************************
     * Gets Air to Air Missiles
     *
     * @return Returns an ArrayList of the results.
     *****************************************************************/
    public ArrayList<WeaponUseList> getAAMissiles()
    {
        /*final String query = "SELECT name, use" +
                             "FROM load" +
                             "  JOIN load_uses ON load._id = load_uses._id" +
                             "  JOIN weapon_type ON load._id = weapon_type._id" +
                             "WHERE load_type_id = 0" +
                             "  AND type = \"Air-Ground Missile\"" +
                             "ORDER BY name, use";*/

        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                "FROM load " +
                "  JOIN weapon_info ON load._id = weapon_info._id " +
                "WHERE weapon_type_id = 1 " +
                "ORDER BY name";

        ArrayList<WeaponUseList> masterUseList;
        ArrayList<String> weaponNames;
        Cursor cursorGetDistinctNames;
        //HashMap<String, ArrayList<String>> weaponUseMap;

        weaponNames = new ArrayList<String>();
        masterUseList = new ArrayList<WeaponUseList>();
        //weaponUseMap = new HashMap<String, ArrayList<String>>();
        database = this.getWritableDatabase();

        cursorGetDistinctNames = database.rawQuery(queryGetDistinctNames, null);

        //get list of distinct agm weapons.
        if (cursorGetDistinctNames.moveToFirst())
        {
            do
            {
                weaponNames.add(cursorGetDistinctNames.getString(0));
            } while (cursorGetDistinctNames.moveToNext());
        }

        cursorGetDistinctNames.close();

        //get list of uses for each weapon.
        for (String name : weaponNames)
        {
            WeaponUseList tempUseList = new WeaponUseList();

            //get list

            String query = "SELECT use " +
                    "FROM load " +
                    "  JOIN load_uses ON load._id = load_uses._id " +
                    "WHERE name = \"" + name + "\" " +
                    "ORDER BY use";

            database = this.getWritableDatabase();

            Cursor cursor = database.rawQuery(query, null);

            tempUseList.setWeaponName(name);

            if (cursor.moveToNext())
            {
                do
                {
                    tempUseList.addUse(cursor.getString(0));
                } while (cursor.moveToNext());
            }

            cursor.close();
            //add the weaponlist to the arraylist (weaponUseList).

            masterUseList.add(tempUseList);
        }

        return masterUseList;
    }

    /*****************************************************************
     * Gets Air to Ground Missiles
     *
     * @return Returns an ArrayList of the results.
     *****************************************************************/
    public ArrayList<WeaponUseList> getAGMissiles()
    {
        /*final String query = "SELECT name, use" +
                             "FROM load" +
                             "  JOIN load_uses ON load._id = load_uses._id" +
                             "  JOIN weapon_type ON load._id = weapon_type._id" +
                             "WHERE load_type_id = 0" +
                             "  AND type = \"Air-Ground Missile\"" +
                             "ORDER BY name, use";*/

        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                                             "FROM load " +
                                             "  JOIN weapon_info ON load._id = weapon_info._id " +
                                             "WHERE weapon_type_id = 0 " +
                                             "ORDER BY name";

        ArrayList<WeaponUseList> masterUseList;
        ArrayList<String> weaponNames;
        Cursor cursorGetDistinctNames;
        //HashMap<String, ArrayList<String>> weaponUseMap;

        weaponNames = new ArrayList<String>();
        masterUseList = new ArrayList<WeaponUseList>();
        //weaponUseMap = new HashMap<String, ArrayList<String>>();
        database = this.getWritableDatabase();

        cursorGetDistinctNames = database.rawQuery(queryGetDistinctNames, null);

        //get list of distinct agm weapons.
        if (cursorGetDistinctNames.moveToFirst())
        {
            do
            {
                weaponNames.add(cursorGetDistinctNames.getString(0));
            } while (cursorGetDistinctNames.moveToNext());
        }

        cursorGetDistinctNames.close();

        //get list of uses for each weapon.
        for (String name : weaponNames)
        {
            WeaponUseList tempUseList = new WeaponUseList();

            //get list

            String query = "SELECT use " +
                           "FROM load " +
                           "  JOIN load_uses ON load._id = load_uses._id " +
                           "WHERE name = \"" + name + "\" " +
                           "ORDER BY use";

            database = this.getWritableDatabase();

            Cursor cursor = database.rawQuery(query, null);

            tempUseList.setWeaponName(name);

            if (cursor.moveToNext())
            {
                do
                {
                    tempUseList.addUse(cursor.getString(0));
                } while (cursor.moveToNext());
            }

            cursor.close();
            //add the weaponlist to the arraylist (weaponUseList).

            masterUseList.add(tempUseList);
        }

        return masterUseList;
    }

    /*****************************************************************
     * Gets Cluster Bomb Units
     *
     * @return Returns an ArrayList of the results.
     *****************************************************************/
    public ArrayList<WeaponUseList> getClusterBombs()
    {
        /*final String query = "SELECT name, use" +
                             "FROM load" +
                             "  JOIN load_uses ON load._id = load_uses._id" +
                             "  JOIN weapon_type ON load._id = weapon_type._id" +
                             "WHERE load_type_id = 0" +
                             "  AND type = \"Air-Ground Missile\"" +
                             "ORDER BY name, use";*/

        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                "FROM load " +
                "  JOIN weapon_info ON load._id = weapon_info._id " +
                "WHERE weapon_type_id = 4 " +
                "ORDER BY name";

        ArrayList<WeaponUseList> masterUseList;
        ArrayList<String> weaponNames;
        Cursor cursorGetDistinctNames;
        //HashMap<String, ArrayList<String>> weaponUseMap;

        weaponNames = new ArrayList<String>();
        masterUseList = new ArrayList<WeaponUseList>();
        //weaponUseMap = new HashMap<String, ArrayList<String>>();
        database = this.getWritableDatabase();

        cursorGetDistinctNames = database.rawQuery(queryGetDistinctNames, null);

        //get list of distinct weapons.
        if (cursorGetDistinctNames.moveToFirst())
        {
            do
            {
                weaponNames.add(cursorGetDistinctNames.getString(0));
            } while (cursorGetDistinctNames.moveToNext());
        }

        cursorGetDistinctNames.close();

        //get list of uses for each weapon.
        for (String name : weaponNames)
        {
            WeaponUseList tempUseList = new WeaponUseList();

            //get list

            String query = "SELECT use " +
                    "FROM load " +
                    "  JOIN load_uses ON load._id = load_uses._id " +
                    "WHERE name = \"" + name + "\" " +
                    "ORDER BY use";

            database = this.getWritableDatabase();

            Cursor cursor = database.rawQuery(query, null);

            tempUseList.setWeaponName(name);

            if (cursor.moveToNext())
            {
                do
                {
                    tempUseList.addUse(cursor.getString(0));
                } while (cursor.moveToNext());
            }

            cursor.close();
            //add the weaponlist to the arraylist (weaponUseList).

            masterUseList.add(tempUseList);
        }

        return masterUseList;
    }

    /*****************************************************************
     * Gets Guided Bomb Units
     *
     * @return Returns an ArrayList of the results.
     *****************************************************************/
    public ArrayList<WeaponUseList> getGuidedBombs()
    {
        /*final String query = "SELECT name, use" +
                             "FROM load" +
                             "  JOIN load_uses ON load._id = load_uses._id" +
                             "  JOIN weapon_type ON load._id = weapon_type._id" +
                             "WHERE load_type_id = 0" +
                             "  AND type = \"Air-Ground Missile\"" +
                             "ORDER BY name, use";*/

        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                "FROM load " +
                "  JOIN weapon_info ON load._id = weapon_info._id " +
                "WHERE weapon_type_id = 5 " +
                "ORDER BY name";

        ArrayList<WeaponUseList> masterUseList;
        ArrayList<String> weaponNames;
        Cursor cursorGetDistinctNames;
        //HashMap<String, ArrayList<String>> weaponUseMap;

        weaponNames = new ArrayList<String>();
        masterUseList = new ArrayList<WeaponUseList>();
        //weaponUseMap = new HashMap<String, ArrayList<String>>();
        database = this.getWritableDatabase();

        cursorGetDistinctNames = database.rawQuery(queryGetDistinctNames, null);

        //get list of distinct weapons.
        if (cursorGetDistinctNames.moveToFirst())
        {
            do
            {
                weaponNames.add(cursorGetDistinctNames.getString(0));
            } while (cursorGetDistinctNames.moveToNext());
        }

        cursorGetDistinctNames.close();

        //get list of uses for each weapon.
        for (String name : weaponNames)
        {
            WeaponUseList tempUseList = new WeaponUseList();

            //get list

            String query = "SELECT use " +
                    "FROM load " +
                    "  JOIN load_uses ON load._id = load_uses._id " +
                    "WHERE name = \"" + name + "\" " +
                    "ORDER BY use";

            database = this.getWritableDatabase();

            Cursor cursor = database.rawQuery(query, null);

            tempUseList.setWeaponName(name);

            if (cursor.moveToNext())
            {
                do
                {
                    tempUseList.addUse(cursor.getString(0));
                } while (cursor.moveToNext());
            }

            cursor.close();
            //add the weaponlist to the arraylist (weaponUseList).

            masterUseList.add(tempUseList);
        }

        return masterUseList;
    }

    /*****************************************************************
     * Gets Other weapons.
     *
     * @return Returns an ArrayList of the results.
     *****************************************************************/
    public ArrayList<WeaponUseList> getOtherWeapons()
    {
        /*final String query = "SELECT name, use" +
                             "FROM load" +
                             "  JOIN load_uses ON load._id = load_uses._id" +
                             "  JOIN weapon_type ON load._id = weapon_type._id" +
                             "WHERE load_type_id = 0" +
                             "  AND type = \"Air-Ground Missile\"" +
                             "ORDER BY name, use";*/

        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                "FROM load " +
                "  JOIN weapon_info ON load._id = weapon_info._id " +
                "WHERE weapon_type_id = 2 " +
                "  OR weapon_type_id = 3 " +
                "  OR weapon_type_id = 6 " +
                "  OR weapon_type_id = 7 " +
                "  OR weapon_type_id = 8 " +
                "ORDER BY name";

        ArrayList<WeaponUseList> masterUseList;
        ArrayList<String> weaponNames;
        Cursor cursorGetDistinctNames;
        //HashMap<String, ArrayList<String>> weaponUseMap;

        weaponNames = new ArrayList<String>();
        masterUseList = new ArrayList<WeaponUseList>();
        //weaponUseMap = new HashMap<String, ArrayList<String>>();
        database = this.getWritableDatabase();

        cursorGetDistinctNames = database.rawQuery(queryGetDistinctNames, null);

        //get list of distinct weapons.
        if (cursorGetDistinctNames.moveToFirst())
        {
            do
            {
                weaponNames.add(cursorGetDistinctNames.getString(0));
            } while (cursorGetDistinctNames.moveToNext());
        }

        cursorGetDistinctNames.close();

        //get list of uses for each weapon.
        for (String name : weaponNames)
        {
            WeaponUseList tempUseList = new WeaponUseList();

            //get list

            String query = "SELECT use " +
                    "FROM load " +
                    "  JOIN load_uses ON load._id = load_uses._id " +
                    "WHERE name = \"" + name + "\" " +
                    "ORDER BY use";

            database = this.getWritableDatabase();

            Cursor cursor = database.rawQuery(query, null);

            tempUseList.setWeaponName(name);

            if (cursor.moveToNext())
            {
                do
                {
                    tempUseList.addUse(cursor.getString(0));
                } while (cursor.moveToNext());
            }

            cursor.close();
            //add the weaponlist to the arraylist (weaponUseList).
            //Log.d("DBTools otherlist", " " + tempUseList.size());

            masterUseList.add(tempUseList);
        }

        return masterUseList;
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
    
    /*@Override
    public void onCreate(SQLiteDatabase db)
    {
        //called when app .getReadableDatabase() is called
        Log.d("DBTools", "onCreate(db)");
    }*/

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (oldVersion < newVersion)
        {
            try
            {
                // delete existing?
                database.close();
                this.getWritableDatabase().close();
                CONTEXT.deleteDatabase(DB_NAME);
                // Copy the db from assests
                copyDatabase();

                Log.d("DBTools", "onUpgrade success");
            }
            catch (IOException e)
            {
                Log.d("DBtools", "onUpgrade failed");
            }
        }
    }
}
