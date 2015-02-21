
import java.sql.*;
import java.io.*;
import java.util.Scanner;

import au.com.bytecode.opencsv.CSVReader;

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
         String sql = "create table Ordinance " + 
                      "(id integer primary key, name text, " + 
                      "weight integer, drag integer, damage_type text, " +
                      "guidance text, range_km integer, " + 
                      "blast_radius integer, " + "info text);";
                      
         statement.executeUpdate(sql);
         statement.close();
         
         //now fill the table
         CSVReader reader = new CSVReader(new FileReader(
                                          "loadout database csv.csv"));
         File file;
         Scanner scanner;
         String[] nextLine;
         
         file = new File("loadout database csv.csv");
         scanner = new Scanner(file);
         
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
            
         
            statement = connection.createStatement();
            sql = "insert into Ordinance (id, name, weight, drag, " +
                  "damage_type, guidance, range_km, blast_radius, info) " + 
                  "values (" + id + ", '" + name + "', " + weight + 
                  ", " + drag + ", '" + damage + "', '" + guidance + "', " + 
                  range + ", " + blast + ", '" + info + "');";
            statement.executeUpdate(sql);
         }
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
