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
            app.connect("localhost:33060, 3000" );
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

////////////////////////////////////////////////////////////ttkk

        // 8.All the cities in a continent organised by largest population to smallest.
        cities = app.citycontinent();
        // print city data
        app.printCitiesReport(cities);

        // 9. All the cities in a region organised by largest population to smallest.
        cities = app.cityregion();
        // print city data
        app.printCitiesReport(cities);

        // 10. All the cities in a country organised by largest population to smallest.
        cities = app.citycountry();
        // print city data
        app.printCitiesReport(cities);

        // 11. All the cities in a district organised by largest population to smallest.
        cities = app.citydistrict();
        // print city data
        app.printCitiesReport(cities);


///////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////
        // 12.	The top N populated cities in the world where N is provided by the user.
        cities = app.citytopnworld();
        // print city data
        app.printCitiesReport(cities);


        // 13.	The top N populated cities in a continent where N is provided by the user.
        cities = app.citytopncontinent();
        // print city data
        app.printCitiesReport(cities);


        // 14.	The top N populated cities in a region where N is provided by the user.
        cities = app.citytopnregion();
        // print city data
        app.printCitiesReport(cities);


        // 15.	The top N populated cities in a country where N is provided by the user.
        cities = app.citytopncountry();
        // print city data
        app.printCitiesReport(cities);


        // 16.	The top N populated cities in a district where N is provided by the user.
        cities = app.citytopndistrict();
        // print city data
        app.printCitiesReport(cities);


        // 17.	All the capital cities in the world organised by largest population to smallest.
        ArrayList<Capital> cap_cities = app.capitalworld();
        // print city data
        app.printCapitalCityReport(cap_cities);



        // 18.	All the capital cities in a continent organised by largest population to smallest.
        cap_cities = app.capitalcontinent();
        // print city data
        app.printCapitalCityReport(cap_cities);


        // 19.	All the capital cities in a region organised by largest to smallest.
        cap_cities = app.capitalregion();
        // print city data
        app.printCapitalCityReport(cap_cities);


        // 20.	The top N populated capital cities in the world where N is provided by the user.
        cap_cities = app.capitaltopnworld();
        // print city data
        app.printCapitalCityReport(cap_cities);


        // 21.	The top N populated capital cities in a continent where N is provided by the user.
        cap_cities = app.capitaltopncontinent();
        // print city data
        app.printCapitalCityReport(cap_cities);


        // 22.	The top N populated capital cities in a region where N is provided by the user.
        cap_cities = app.capitaltopnregion();
        // print city data
        app.printCapitalCityReport(cap_cities);
/////////////////////////////////////////////




//////////////////////////////////////////////////////////
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
            String continent = "'Asia'";
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
            System.out.println("\n2. All the countries in "+continent+" organised by largest population to smallest.\n");
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
            String region = "'Southeast Asia'";
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
            System.out.println("\n3.All the countries in "+region+" organised by largest population to smallest.\n");
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
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Continent="+ continent + " ORDER BY country.Population DESC LIMIT "+ limit;
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
            String region = "'Southeast Asia'";
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
    /**
     8. All the cities in a continent organised by largest population to smallest.
     **/
    public ArrayList<City> citycontinent()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String continent = "'Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE country.Continent="+ continent  +" ORDER BY city.Population DESC;";

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
            System.out.println("\n8. All the cities in" +continent+" organised by largest population to smallest.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }


    /**
     9. All the cities in a region organised by largest population to smallest.
     **/

    public ArrayList<City> cityregion()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String region = "'Southeast Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE country.Region="+region+" ORDER BY city.Population DESC;";

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
            System.out.println("\n9. All the cities in "+region+" organised by largest population to smallest. ");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }


    /**
     10.All the cities in a country organised by largest population to smallest.
     **/


    public ArrayList<City> citycountry()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String country = "'Myanmar'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE country.name="+country+" ORDER BY city.Population DESC;";

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
            System.out.println("\n10. All the cities in "+country+" organised by largest population to smallest. country sorted by largest to smallest population\n");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }

    /**
     11. All the cities in a district organised by largest population to smallest.
     **/
    public ArrayList<City> citydistrict()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String district = "'Rangoon [Yangon]'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on city.CountryCode=country.Code WHERE city.District="+district+" ORDER BY city.Population DESC;";

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
            System.out.println("\n11. All the cities in "+district+" organised by largest population to smallest. \n");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get Cities in the world database");
            return null;
        }
    }


///////////////////////////////////////////////////////////////
    /***
     12.	The top N populated cities in the world where N is provided by the user.
     */
    public ArrayList<City> citytopnworld()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
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
            System.out.println("\12. The top " + limit + " populated cities in the world. \n");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in the world!!");
            return null;
        }
    }

    /**
     13.	The top N populated cities in a continent where N is provided by the user.
     */
    public ArrayList<City> citytopncontinent()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;
            String continent = "Asia";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Continent='" + continent
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
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
            System.out.println("\n13. The top " + limit + " populated cities in " + continent +" continent");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a continent!!");
            return null;
        }
    }


    /**
     14.	The top N populated cities in a region where N is provided by the user.
     */
    public ArrayList<City> citytopnregion()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;
            String region= "Southeast Asia";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Region='" + region
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
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
            System.out.println("\n14.\tThe top " + limit + " populated cities in " + region +" region.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a region!!");
            return null;
        }
    }


    /**
     15.	The top N populated cities in a country where N is provided by the user.
     */
    public ArrayList<City> citytopncountry()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;
            String country= "Myanmar";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Name='" + country
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
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
            System.out.println("\n15. The top " + limit + "  populated cities in " + country +" country.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a country!!");
            return null;
        }
    }

    /**
     16.	The top N populated cities in a district where N is provided by the user.
     */
    public ArrayList<City> citytopndistrict()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;
            String district = "Rangoon [Yangon]";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE city.District='" + district
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city information
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
            System.out.println("\n16. The top " + limit + " populated cities in " + district +" district.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities in a district!!");
            return null;
        }
    }

    /**
     17.	All the capital cities in the world organised by largest population to smallest.
     **/

    public ArrayList<Capital> capitalworld()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement

            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID ORDER BY Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\n17. All the capital cities in the world organised by largest population to smallest.");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }

    /**
     18.	All the capital cities in a continent organised by largest population to smallest.
     **/

    public ArrayList<Capital> capitalcontinent()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String continent = "'Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Continent=" + continent +" ORDER BY Population DESC;";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\n18. All the capital cities in "+continent+" continent organised by largest population to smallest.");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }
    /**
     19.	All the capital cities in a region organised by largest to smallest.
     **/

    public ArrayList<Capital> capitalregion()
    {
        try
        {
            // Create an SQL statement
            Statement sql = con.createStatement();

            // Create string for SQL statement
            String region = "'Southeast Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Region="+region+" ORDER BY Population DESC; ";

            // Execute SQL statement
            ResultSet result = sql.executeQuery(getCityReports);

            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\n19. All the capital cities in "+region+" region organised by largest to smallest. ");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get capital cities in the world database");
            return null;
        }
    }


    /***
     20.	The top N populated capital cities in the world where N is provided by the user.
     */
    public ArrayList<Capital> capitaltopnworld()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;       // for N in a list of Top "N" populated cities in the world
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\n20. The top " + limit + " populated capital cities in the world. ");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated capital cities in the world!!");
            return null;
        }
    }


    /***
     21.	The top N populated capital cities in a continent where N is provided by the user.
     */
    public ArrayList<Capital> capitaltopncontinent()
    {
        try
        {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;       // for N in a list of Top "N" populated cities in the world
            String continent ="'Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Continent="+continent+" ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next())
            {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\n21. The top  " + limit + " populated capital cities in "+continent+" continent.");
            return cap_cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated capital cities in the continent ");
            return null;
        }
    }


    /***
     22.	The top N populated capital cities in a region where N is provided by the user.
     */
    public ArrayList<Capital> capitaltopnregion()
    {
        try {
            Statement stmt = con.createStatement();  // Create an SQL statement
            // Create string for SQL statement
            int limit = 5;       // for N in a list of Top "N" populated cities in the world
            String region = "'Southeast Asia'";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population FROM city INNER JOIN country on country.capital = city.ID WHERE country.Region=" + region + " ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
            // Extract city data
            ArrayList<Capital> cap_cities = new ArrayList<>();
            while (result.next()) {
                Capital ca = new Capital();
                ca.setName(result.getString("city.Name"));
                ca.setCountry(result.getString("country.Name"));
                ca.setDistrict(result.getString("city.District"));
                ca.setPopulation(result.getInt("city.Population"));
                cap_cities.add(ca);
            }
            System.out.println("\n22. The top " + limit + " populated capital cities in  " + region + " region.");
            return cap_cities;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated capital cities in the region ");
            return null;
        }
    }


    /////////////////////////////////////////////////////////////
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
        System.out.printf("%-5s %-15s %-20s %-20s %-20s %-20s%n", "Code", "Name", "Continent", "Region", "Population", "Capital \n");
//        System.out.println("\n");

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


    public void printCitiesReport(ArrayList<City> cities)
    {
        // Check cities is not null
        if (cities == null)
        {
            System.out.println("No cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n", "City Name", "Country Name", "District", "Population \n");
//        System.out.println("\n");

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
    /** Function to Print Capital City
     * @param cap_cities to print list of capital cities **/
    public void printCapitalCityReport(ArrayList<Capital> cap_cities)
    {
        // Check capital cities is not null
        if (cap_cities == null)
        {
            System.out.println("No capital cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n", "City Name", "Country Name", "District", "Population");

        // Check Capital City is not empty
        if (!cap_cities.isEmpty())
        {
            // Loop over all capital cities in the list
            for (Capital city : cap_cities) {
                // Check Capital City contain null
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
            String city_string = "Capital City Report List is empty";
            System.out.println(city_string);
        }
    }

///////////////////////////////////////////////////////////
}