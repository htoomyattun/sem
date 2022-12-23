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
////////////////////////////////////////////hmt
        // 1. All the countries in the world organised by largest population to smallest.
        ArrayList<Country> countries = app.countryworld();
        // Print All the countries in the world organised by largest population to smallest.
        app.printCountriesReport(countries);


        // 2. All the countries in a continent organised by largest population to smallest.
        countries = app.countrycontinent();
        // Print All the countries in a continent organised by largest population to smallest.
        app.printCountriesReport(countries);


        // 3.  All the countries in a region organised by largest population to smallest.
        countries = app.countryregion();
        // Print All the countries in a region organised by largest population to smallest.
        app.printCountriesReport(countries);


        // 4. The top N populated countries in the world where N is provided by the user.
        countries = app.countrytopnworld();
        // Print The top N populated countries in the world where N is provided by the user.
        app.printCountriesReport(countries);
///////////////////////////////////////////////////////////


////////////////////////////////////////////////////////////hah
        // 5.The top N populated countries in a continent where N is provided by the user.
        countries = app.countrytopncontinent();
        // Print The top N populated countries in a continent where N is provided by the user.
        app.printCountriesReport(countries);

        // 6. The top N populated countries in a region where N is provided by the user.
        countries = app.countrytopnregion();
        // Print Top populated Country in the region
        app.printCountriesReport(countries);

        // 7. All the cities in the world organised by largest population to smallest.
        ArrayList<City> cities = app.cityworld();
        // print city data
        app.printCitiesReport(cities);


///////////////////////////////////////////////////////////

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

/////////////////////////////////////////////////////////////hmt

    /**
     1. All the countries in the world organised by largest population to smallest.
     **/
    public ArrayList<Country> countryworld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\n1. All the countries in the world organised by largest population to smallest.\n");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }




    /**
     2. All the countries in a continent organised by largest population to smallest.
     **/
    public ArrayList<Country> countrycontinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String continent = "'Africa'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Continent="+ continent +" ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\n2. All the countries in a continent organised by largest population to smallest.\n");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }

    /**
     3. All the countries in a region organised by largest population to smallest.
     **/
    public ArrayList<Country> countryregion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            String region = "'Caribbean'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Region="+ region +" ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\n3.All the countries in a region organised by largest population to smallest.\n");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }
    /***
     4. The top N populated countries in the world where N is provided by the user.
     */
    public ArrayList<Country> countrytopnworld()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limit = 15;       // for N in a list of Top "N" populated country in the world
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID ORDER BY country.Population DESC LIMIT "+ limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\n4. The top " + limit + " populated countries in the world where N is provided by the user.\n");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }
///////////////////////////////////////////////////

///////////////////////////////////////////////////////////hah

    /**
     5.The top N populated countries in a continent where N is provided by the user.
     */
    public ArrayList<Country> countrytopncontinent()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limit = 15;       // for N in a list of Top "N" populated country in the world
            String continent = "'Asia'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Continent="+ continent + " ORDER BY country.Population DESC LIMIT "+limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\n5. The top "+ limit +" populated countries in "+ continent+" continent.");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }
    /**
     6. The top N populated countries in a region where N is provided by the user.
     */
    public ArrayList<Country> countrytopnregion()
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            int limit = 5;       // for N in a list of Top "N" populated country in the world
            String region = "'Eastern Asia'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Region="+ region + " ORDER BY country.Population DESC LIMIT "+limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries information
            ArrayList<Country> countries = new ArrayList<>();
            while (rset.next())
            {
                Country coun = new Country();
                coun.setCode(rset.getString("country.Code"));
                coun.setName(rset.getString("country.Name"));
                coun.setContinent(rset.getString("country.Continent"));
                coun.setRegion(rset.getString("country.Region"));
                coun.setPopulation(rset.getInt("country.Population"));
                coun.setCapital(rset.getString("city.Name"));
                countries.add(coun);
            }
            System.out.println("\n6. The top "+ limit +" populated countries in "+ region+" region.");
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country information");
            return null;
        }
    }

    /**
     7. All the cities in the world organised by largest population to smallest.
     **/
    public ArrayList<City> cityworld()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code ORDER BY city.Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<City> cities = new ArrayList<>();
            while (result.next())
            {
                City actiy = new City();
                actiy.setName(result.getString("city.Name"));
                actiy.setCountry(result.getString("country.Name"));
                actiy.setDistrict(result.getString("city.District"));
                actiy.setPopulation(result.getInt("city.Population"));
                cities.add(actiy);
            }
            System.out.println("\n7. All the cities in the world organised by largest population to smallest.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }




///////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////ttkk



///////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////
    // out put and print files for country
    public void printCountriesReport(ArrayList<Country> countries)
    {
        // Check Countries is not null
        if (countries == null)
        {
            System.out.println("No Countries");
            return;
        }
        // Print header
        System.out.printf("%-5s %-15s %-20s %-20s %-20s %-20s%n", "Code", "Name", "Continent", "Region", "Population", "Capital");
        System.out.println("\n");

        // Check Country is not empty
        if (!countries.isEmpty())
        {
            // Loop over all countries in the list
            for (Country coun : countries)
            {
                // Check Country contain null
                if (coun == null){
                    continue;}
                String country_string =
                        String.format("%-5s %-15s %-20s %-20s %-20s %-20s",
                                coun.getCode(), coun.getName(), coun.getContinent(), coun.getRegion(), coun.getPopulation(), coun.getCapital());
                System.out.println(country_string);
            }
        }
        else
        {
            String country_string = "Country Report List is empty";
            System.out.println(country_string);
        }
    }


/////////////////////////////////////////////////////////////
// out put and print files for city
    /**
     * Prints a list of cities.
     * @param cities The list of cities to print.
     */

    public void printCitiesReport(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n", "City Name", "Country Name", "District", "Population");
        System.out.println("\n");

        // Check City is not empty
        if (!cities.isEmpty())
        {
            // Loop over all cities in the list
            for (City city : cities) {
                // Check City contain null
                if (city == null){
                    continue;}
                String city_string =
                        String.format("%-25s %-25s %-25s %-25s",
                                city.getName(), city.getCountry(), city.getDistrict(), city.getPopulation());
                System.out.println(city_string);
            }
        }
        else
        {
            String city_string = "City Report List is empty";
            System.out.println(city_string);
        }
    }
////////////////////////////////////////////////////////////////

}