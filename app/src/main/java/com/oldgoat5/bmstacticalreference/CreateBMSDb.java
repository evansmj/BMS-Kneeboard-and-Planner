
import java.sql.*;
import java.io.*;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVReader;

/*
 * Don't run this in app.
 *
 * Used to create a SQLite3 database.   
 * Uses the OpenCSV library http://opencsv.sourceforge.net/.
 * 
 */
public class CreateBMSDb 
{
   public static void main(String args[])
   {
      Connection connection = null;
      Statement statement;
      String id;
      String name;
      String weight;
      String drag;
      String damage;
      String guidance;
      String range;
      String blast;
      String info;
      
      try
      {
         Class.forName("org.sqlite.JDBC");
         connection = DriverManager.getConnection("jdbc:sqlite:BMSLoadDB.db");
         connection.setAutoCommit(false);
         System.out.println("opened database successfully");
         
         statement = connection.createStatement();
         String sql = "CREATE TABLE ordinance " + 
                      "(id INTEGER PRIMARY KEY, name TEXT, " + 
                      "weight INTEGER, drag INTEGER, damage_type TEXT, " +
                      "guidance TEXT, range_km INTEGER, " + 
                      "blast_radius INTEGER, " + "info TEXT);";
                      
         statement.executeUpdate(sql);
         System.out.print("after executeUpdate");
         statement.close();
         
         //now fill the table
         CSVReader reader = new CSVReader(new FileReader(
                                          "loadout database csv no labels.csv"));
         File file;
         Scanner scanner;
         String[] nextLine;
         
         file = new File("loadout database csv no labels.csv");
         scanner = new Scanner(file);
         System.out.print("\nbefore the for loop");
         for (int i = 0; i < 103; i++)
         {
            nextLine = reader.readNext();
            System.out.print(nextLine[0]);
            id = nextLine[0];
            name = nextLine[1];
            weight = nextLine[2];
            drag = nextLine[3];
            damage = nextLine[4];
            guidance = nextLine[5];
            range = nextLine[6];
            blast = nextLine[7];
            info = nextLine[8];
            
            System.out.println(id + name + weight + drag + damage + guidance + range + blast + info);
         
            statement = connection.createStatement();
            sql = "INSERT INTO ordinance (id, name, weight, drag, " +
                  "damage_type, guidance, range_km, blast_radius, info) " + 
                  "values (" + id + ", '" + name + "', " + weight + 
                  ", " + drag + ", '" + damage + "', '" + guidance + "', " + 
                  range + ", " + blast + ", '" + info + "');";
            statement.executeUpdate(sql);
         }
         System.out.print("\nafter the for loop\n.");
         statement.close();
         connection.commit();
         connection.close();
      }
      catch (Exception e)
      {
         System.err.println(e.getClass().getName() +
                             ": " + e.getMessage());
         System.exit(0); 
      }
      System.out.println("created table successfully");
   }
}
