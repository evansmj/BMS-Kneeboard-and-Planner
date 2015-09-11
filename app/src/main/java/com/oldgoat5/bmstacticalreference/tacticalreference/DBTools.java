package com.oldgoat5.bmstacticalreference.tacticalreference;

import android.app.Dialog;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.oldgoat5.bmstacticalreference.R;

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
    //todo verify threat values
    
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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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
     * Gets BLU and BDU
     *
     * @return Returns an ArrayList of the results.
     *****************************************************************/
    public ArrayList<WeaponUseList> getLiveAndDummyBombUnits()
    {
        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                "FROM load " +
                "  JOIN weapon_info ON load._id = weapon_info._id " +
                "WHERE weapon_type_id = 2 " +
                "  OR weapon_type_id = 3 " +
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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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

    /*****************************************************************
     * Gets the weight of the desired load
     * @param name - The load whose weight is to be returned.
     * @return Returns integer weight of the load.
     *****************************************************************/
    public int getLoadWeight(String name)
    {
        final String queryWeight = "SELECT weight " +
                                   "FROM load " +
                                   "WHERE name = \"" + name + "\"";

        int weight = 0;

        database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(queryWeight, null);

        if (cursor.moveToNext())
            weight = cursor.getInt(0);

        cursor.close();

        return weight;
    }

    /*****************************************************************
     * Get the drag of the desired load
     * @param name - The load whose drag is to be returned.
     * @return Returns integer drag of the load.
     *****************************************************************/
    public int getLoadDrag(String name)
    {
        final String queryDrag = "SELECT drag " +
                                 "FROM load " +
                                 "WHERE name = \"" + name + "\"";

        int drag = 0;
        database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(queryDrag, null);

        if (cursor.moveToNext())
            drag = cursor.getInt(0);

        cursor.close();

        return drag;
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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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
    public ArrayList<WeaponUseList> getMarkBombs()
    {
        final String queryGetDistinctNames = "SELECT DISTINCT name " +
                "FROM load " +
                "  JOIN weapon_info ON load._id = weapon_info._id " +
                "WHERE weapon_type_id = 6 " +
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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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
            tempUseList.setWeaponDrag(getLoadDrag(name));
            tempUseList.setWeaponWeight(getLoadWeight(name));

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

    /*****************************************************************
     * Gets stores.
     *
     * @return Returns an array of the results.
     *****************************************************************/
    public ArrayList<StoreObject> getStores()
    {
        ArrayList<StoreObject> storeList;

        String query = "SELECT name, weight, drag " +
                       "FROM load " +
                       "WHERE load_type_id = 1 " +
                       "ORDER BY name ";

        database = getWritableDatabase();
        storeList = new ArrayList<StoreObject>();

        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do
            {
                storeList.add(new StoreObject(cursor.getString(0), cursor.getInt(1),
                        cursor.getInt(2)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return storeList;
    }

    /*****************************************************************
     * Get surface threats
     *
     * @param threatType - The type of threats to return.
     * @return Returns an ArrayList of ThreatObjects.
     *****************************************************************/
    public ArrayList<ThreatObject> getThreats(String threatType)
    {
        ArrayList<ThreatObject> threatList;

        threatList = new ArrayList<ThreatObject>();

        final String query = "SELECT name, maxtof, weight, range_km, min_eng_range, min_eng_alt, " +
                "max_eng_alt, g.type, f.firecontrol, t.type " +
                "FROM threat " +
                "  JOIN guidance_type AS g ON threat.guidance_id = g._id " +
                "  JOIN firecontrol_type AS f ON threat.firecontrol_id = f._id " +
                "  JOIN threat_type AS t ON threat.threat_type_id = t._id " +
                "WHERE t.type = \"" + threatType + "\" " +
                "ORDER BY name";

        Log.d("dbTools", "threatType: " + threatType);

        database = getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        if (cursor.moveToFirst())
        {
            do
            {
                threatList.add(new ThreatObject(cursor.getString(0), cursor.getInt(1),
                        cursor.getInt(2), cursor.getInt(3), cursor.getInt(4), cursor.getInt(5),
                        cursor.getInt(6), cursor.getString(7), cursor.getString(8),
                        cursor.getString(9)));
            } while (cursor.moveToNext());
        }

        cursor.close();

        return threatList;
    }

    /*****************************************************************
     * Get threat info.
     *
     * @param threatName - the name of the threat to get info for.
     *
     * @return Returns an array of the results.
     *****************************************************************/
    public String[] getThreatInfo(String threatName)
    {
        String[] threatInfo = new String[9];

        String query = "SELECT maxtof, weight, range_km, min_eng_range, min_eng_alt, " +
                       "max_eng_alt, g.type, f.firecontrol, t.type " +
                       "FROM threat " +
                       "  JOIN guidance_type AS g ON guidance_id = g._id " +
                       "  JOIN firecontrol_type AS f ON firecontrol_id = f._id " +
                       "  JOIN threat_type AS t ON threat_type_id = t._id " +
                       "WHERE name = \"" + threatName + "\"";

        database = getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        cursor.moveToFirst();

        for (int i = 0; i < threatInfo.length; i++)
        {
            threatInfo[i] = cursor.getString(i);
        }

        cursor.close();

        return threatInfo;
    }

    /*****************************************************************
     * Gets weapon info
     *
     * @param weaponName - the name of the weapon to get info for.
     *
     * @return Returns an array of the results.
     *****************************************************************/
    public String[] getWeaponInfo(String weaponName)
    {
        Log.d("DBTools", "getWeaponInfo: " + weaponName);
        String[] weaponInfo = new String[8];

        String query = "SELECT weight, " +
                       "  drag, " +
                       "  blast_radius, " +
                       "  range_km, " +
                       "  d.type, " +
                       "  g.type, " +
                       "  release_brevity, " +
                       "  w.type " +
                       "FROM load " +
                       "  JOIN weapon_info on load._id = weapon_info._id " +
                       "  JOIN damage_type AS d ON weapon_info.damage_id = d._id " +
                       "  JOIN guidance_type AS g ON weapon_info.guidance_id = g._id " +
                       "  JOIN weapon_type AS w ON weapon_info.weapon_type_id = w._id " +
                       "WHERE name = \"" + weaponName + "\"";

        database = getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);

        cursor.moveToFirst();

        for (int i = 0; i < 8; i++)
        {
            weaponInfo[i] = cursor.getString(i);
        }

        cursor.close();

        return weaponInfo;
    }

    /*****************************************************************
     * Populates the threat dialog.
     *****************************************************************/
    public View populateThreatDialog(Dialog listDialog, View view)
    {
        View listDialogView = listDialog.findViewById(R.id.threat_dialog);

        listDialog.setTitle(((TextView) view.findViewById(
                R.id.threat_name_text_view)).getText().toString());

        Log.d("TacRef", "threatInfo name = " + ((TextView) view.findViewById(
                R.id.threat_name_text_view)).getText().toString());

        String[] threatInfo = getThreatInfo(((TextView) view.findViewById(
                R.id.threat_name_text_view)).getText().toString());

        Log.d("TacRef", "threatInfo[0] " + threatInfo[0]);

        TextView maxTOFTextView = (TextView) listDialogView.findViewById(R.id.threat_maxtof_dialog_text_view);
        TextView weightTextView = (TextView) listDialogView.findViewById(R.id.threat_weight_dialog_text_view);
        TextView rangeTextView = (TextView) listDialogView.findViewById(R.id.threat_range_km_dialog_text_view);
        TextView minEngRangeTextView = (TextView) listDialogView.findViewById(R.id.threat_min_eng_range_dialog_text_view);
        TextView minEngAltTextView = (TextView) listDialogView.findViewById(R.id.threat_min_eng_alt_dialog_text_view);
        TextView maxEngAltTextView = (TextView) listDialogView.findViewById(R.id.threat_max_alt_dialog_text_view);
        TextView guidanceTextView = (TextView) listDialogView.findViewById(R.id.threat_guidance_dialog_text_view);
        TextView fireControlTextView = (TextView) listDialogView.findViewById(R.id.threat_firecontrol_dialog_text_view);
        TextView typeTextView = (TextView) listDialogView.findViewById(R.id.threat_type_dialog_text_view);

        maxTOFTextView.setText(maxTOFTextView.getText().toString() + " " + threatInfo[0] + " sec.");
        weightTextView.setText(weightTextView.getText().toString() + " " + threatInfo[1] + " lbs.");

        int mileRange = Integer.parseInt(threatInfo[2]);
        mileRange = (int) Math.ceil(mileRange * 0.539957); //convert to km then round up.

        rangeTextView.setText(rangeTextView.getText().toString() + " " + Integer.toString(mileRange) + " nmi.");
        minEngRangeTextView.setText(minEngRangeTextView.getText().toString() + " " + threatInfo[3] + " ft.");
        minEngAltTextView.setText(minEngAltTextView.getText().toString() + " " + threatInfo[4] + " ft.");
        maxEngAltTextView.setText(maxEngAltTextView.getText().toString() + " " + threatInfo[5] + " ft.");
        guidanceTextView.setText(guidanceTextView.getText().toString() + " " + threatInfo[6]);
        fireControlTextView.setText(fireControlTextView.getText().toString() + " " + threatInfo[7]);
        typeTextView.setText(typeTextView.getText().toString() + " " + threatInfo[8]);

        return listDialogView;
    }

    /*****************************************************************
     * Populates the list view dialog with weapon info.
     *****************************************************************/
    public View populateWeaponDialog(Dialog listDialog, View view)
    {
        View listDialogView = listDialog.findViewById(R.id.weapon_dialog);

        listDialog.setTitle(((TextView) view.findViewById(
                R.id.weapon_name_text_view)).getText().toString());

        Log.d("TacRef", "weaponInfo name = " + ((TextView) view.findViewById(
                R.id.weapon_name_text_view)).getText().toString());

        String[] weaponInfo = getWeaponInfo(((TextView) view.findViewById(
                R.id.weapon_name_text_view)).getText().toString());

        TextView weightTextView = (TextView) listDialogView.findViewById(R.id.weight_dialog_text_view);
        TextView dragTextView  = (TextView) listDialog.findViewById(R.id.drag_dialog_text_view);
        TextView blastRadiusTextView = (TextView) listDialogView.findViewById(R.id.blast_dialog_text_view);
        TextView rangeTextView = (TextView) listDialogView.findViewById(R.id.range_dialog_text_view);
        TextView damageTextView = (TextView) listDialogView.findViewById(R.id.damage_dialog_text_view);
        TextView guidanceTextView = (TextView) listDialogView.findViewById(R.id.guidance_dialog_text_view);
        TextView releaseTextView = (TextView) listDialogView.findViewById(R.id.release_dialog_text_view);
        TextView typeTextView = (TextView) listDialogView.findViewById(R.id.type_dialog_text_view);

        weightTextView.setText(weightTextView.getText().toString() + " " + weaponInfo[0] + " lbs.");
        dragTextView.setText(dragTextView.getText().toString() + " " + weaponInfo[1]);
        blastRadiusTextView.setText(blastRadiusTextView.getText().toString() + " " + weaponInfo[2] + " ft.");

        int mileRange = Integer.parseInt(weaponInfo[3]);
        mileRange = (int) Math.ceil(mileRange * 0.539957); //convert km to nm then round up.

        rangeTextView.setText(rangeTextView.getText().toString() + " " + Integer.toString(mileRange) + " nmi.");
        damageTextView.setText(damageTextView.getText().toString() + " " + weaponInfo[4]);
        guidanceTextView.setText(guidanceTextView.getText().toString() + " " + weaponInfo[5]);
        releaseTextView.setText(releaseTextView.getText().toString() + " " + weaponInfo[6]);
        typeTextView.setText(typeTextView.getText().toString() + " " + weaponInfo[7]);

        return listDialogView;
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
