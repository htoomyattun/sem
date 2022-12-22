package com.napier.sem;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class App
{
    /**
     * Main function of the program
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) throws IOException {
        // Create new Application
        App app = new App();

        // Connect to database
        if (args.length < 1)
        {
            app.connect("localhost:33060");
        }
        else
        {
            app.connect(args[0]);
        }


        // Disconnect from database
        app.disconnect();
    }



    /**
     * Connection to MySQL database.
     */
    private static Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database ...");
            try
            {
                // Wait a bit for db to start
//                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?" +
                        "allowPublicKeyRetrieval=true&useSSL=false", "root", "thuta");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            }
//            catch (InterruptedException ie)
//            {
//                System.out.println("Thread interrupted? Should not happen.");
//            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        if (con != null)
        {
            try
            {
                // Close connection
                con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }


    /**
     * (1) All the countries in the world organised by largest population to smallest.
     */
    public ArrayList<Country> worldCountryLargeToSmall()
    {
        try {
            // sql query
            String strSelect = "SELECT Code, Name, Continent, Region, Population, Capital FROM " +
                    "country ORDER BY Population DESC;";
            // Get countries from query
            // return
            return worldcountrypop(strSelect);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get top populated countries in the world");
            return null;
        }
    }

    /**
     * Get Countries from SQL query
     * @param strSelect SQL Query String
     * @return return an ArrayList containing countries
     */
    public ArrayList<Country> worldcountrypop(String strSelect) {
        try {
            // create the java statement
            Statement stmt = con.createStatement();
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new country if valid
            ArrayList<Country> country = new ArrayList<>();
            if (!rset.next())
                return null;
            else {
                do {
                    Country ctry = new Country();
                    ctry.setCode(rset.getString("Code"));
                    ctry.setName(rset.getString("Name"));
                    ctry.setContinent(rset.getString("Continent"));
                    ctry.setRegion(rset.getString("Region"));
                    ctry.setPopulation(rset.getLong("Population"));
                    ctry.setCapital(rset.getString("Capital"));
                    country.add(ctry);



                } while (rset.next());
                // Close ResultSet and Statement
                closeResultSetAndStatement(rset, stmt);
                return country;
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country");
            return null;
        }
    }




    /**
     * Close ResultSet and Statement
     * @param rset ResultSet
     * @param stmt Statement
     * @throws SQLException throws an instance of SQLException
     */
    public static void closeResultSetAndStatement(ResultSet rset, Statement stmt) throws SQLException {
        // Close ResultSet and Statement
        rset.close();
        stmt.close();
    }
}