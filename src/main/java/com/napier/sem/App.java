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
            app.connect("localhost:33060" );
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
        // 23.	The population of people, people living in cities, and people not living in cities in each continent.
        ArrayList<Population> populations = app.populationcitycontinent();
        // print population data
        app.printPopulationReport(populations);


        // 24.	The population of people, people living in cities, and people not living in cities in each region.
        populations = app.populationcityregion();
        // print population data
        app.printPopulationReport(populations);


        //25.	The population of people, people living in cities, and people not living in cities in each country.
        populations = app.populationcitycountry();
        // print population data
        app.printPopulationReport(populations);


        // 26. Population in the world.
        app.populationworld();
        // get output from extracting total population in the world to put into markdown file
        String world =  app.populationworld();
        System.out.println(world);

        // 27. Population in the Continent
        app.populationcontinent("North America");
        // get output from extracting total population in the continent to put into markdown file
        String continent =  app.populationcontinent("North America");
        System.out.println(continent);

        // 28. Population in the Region
        app.populationregion("British Islands");
        // get output from extracting total population in the region to put into markdown file
        String region =  app.populationregion("British Islands");
        System.out.println(region);

        // 29. Population in the Country
        app.populationcountry("Myanmar");
        // get output from extracting total population in the country to put into markdown file
        String country =  app.populationcountry("Myanmar");
        System.out.println(country);

        // 30. Population in the District
        app.populationdistrict("Texas");
        // get output from extracting total population in the district to put into markdown file
        String district =  app.populationdistrict("Texas");
        System.out.println(district);

        // 31. Population in the City
        app.populationcity("Amsterdam");
        // get output from extracting total population in the city to put into markdown file
        String city =  app.populationcity("Amsterdam");
        System.out.println(city);
//////////////////////////////////////////////////////////

        // 32. language spoken population
        ArrayList<Language> languanges = app.languagepop();
        // print language data
        app.printLanguageReport(languanges);






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
            // Extract countries data
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
            System.out.println("Failed to get country data");
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
            // Extract countries data
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
            System.out.println("Failed to get country data");
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
            String region = "'Central America'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Region="+ region +" ORDER BY country.Population DESC";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries data
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
            System.out.println("Failed to get country data");
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
            // Extract countries data
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
            System.out.println("Failed to get country data");
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
            // Extract countries data
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
            System.out.println("Failed to get country data");
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
            int limit = 15;       // for N in a list of Top "N" populated country in the world
            String region = "'Southeast Asia'";
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.Code, country.Name, country.Continent, country.Region, country.Population, city.Name FROM country INNER JOIN city on country.capital = city.ID WHERE country.Region="+ region + " ORDER BY country.Population DESC LIMIT "+limit;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Extract countries data
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
            System.out.println("Failed to get country data");
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
            System.out.println("Failed to get Cities data");
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
            System.out.println("Failed to get Cities data");
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
            System.out.println("Failed to get Cities data");
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
            System.out.println("Failed to get Cities data");
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
            String district = "'Florida'";
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
            System.out.println("Failed to get Cities data");
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
            int limit = 15;
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
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
            System.out.println("\12. The top " + limit + " populated cities in the world. \n");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities data");
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
            int limit = 15;
            String continent = "Oceania";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Continent='" + continent
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
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
            System.out.println("\n13. The top " + limit + " populated cities in " + continent +" continent");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities data");
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
            int limit = 15;
            String region= "Western Europe";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Region='" + region
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
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
            System.out.println("\n14.\tThe top " + limit + " populated cities in " + region +" region.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities data");
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
            int limit = 15;
            String country= "France";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE country.Name='" + country
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
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
            System.out.println("\n15. The top " + limit + "  populated cities in " + country +" country.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities data");
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
            int limit = 15;
            String district = "California";
            String getCityReports =
                    "SELECT city.Name, country.Name, city.District, city.Population "
                            + "FROM city INNER JOIN country on city.CountryCode=country.Code "
                            + "WHERE city.District='" + district
                            + "' ORDER BY Population DESC LIMIT " + limit;
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(getCityReports);
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
            System.out.println("\n16. The top " + limit + " populated cities in " + district +" district.");
            return cities;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of top N populated cities data");
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
            System.out.println("Failed to get capital cities data");
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
            System.out.println("Failed to get capital cities data");
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
            String region = "'Middle East'";
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
            System.out.println("Failed to get capital cities data");
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
            int limit = 15;       // for N in a list of Top "N" populated cities in the world
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
            System.out.println("Failed to get a list of top N populated capital cities data");
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
            int limit = 15;       // for N in a list of Top "N" populated cities in the world
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
            System.out.println("Failed to get a list of top N populated capital cities data ");
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
            int limit = 15;       // for N in a list of Top "N" populated cities in the world
            String region = "'Eastern Asia'";
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
            System.out.println("Failed to get a list of top N populated capital cities data ");
            return null;
        }
    }


    /////////////////////////////////////////////////////////////
    /***
     23.	The population of people, people living in cities, and people not living in cities in each continent.
     */
    public ArrayList<Population> populationcitycontinent()
    {
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPopulationReports_Country = "SELECT Continent, SUM(Population) FROM country "
                    + "GROUP BY Continent HAVING SUM(Population)>0 ORDER BY Continent DESC;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Continent, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Continent ORDER BY country.Continent DESC;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population data
            ArrayList<Population> populations = new ArrayList<>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();

                pop.setName(result_1.getString("Continent"));
                pop.setTotalpopulation(result_1.getLong("SUM(Population)"));

                long citypop = result_2.getLong("SUM(city.Population)");
                Float citypercentage = (float) ((citypop * 100.00) / pop.getTotalpopulation());
                pop.setCitypopulation(citypop + "(" + String.format("%.2f%%", citypercentage) + ")");

                long notcitypop = pop.getTotalpopulation() - citypop;
                Float notcitypercentage = (float) ((notcitypop * 100.00) / pop.getTotalpopulation());
                pop.setNotcitypopulation(notcitypop + "(" + String.format("%.2f%%", notcitypercentage) + ")");

                populations.add(pop);
            }
            System.out.println("\n23. The population of people, people living in cities, and people not living in cities in each continent.");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each continent");
            return null;
        }
    }


    /***
     24.	The population of people, people living in cities, and people not living in cities in each region.
     */
    public ArrayList<Population> populationcityregion()
    {
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPopulationReports_Country = "SELECT Region, SUM(Population) FROM country "
                    + "GROUP BY Region HAVING SUM(Population)>0 ORDER BY Region DESC;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Region, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Region ORDER BY country.Region DESC;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population data
            ArrayList<Population> populations = new ArrayList<>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();

                pop.setName(result_1.getString("Region"));
                pop.setTotalpopulation(result_1.getLong("SUM(Population)"));
                long citypop = result_2.getLong("SUM(city.Population)");
                Float citypercentage = (float) ((citypop * 100.00) / pop.getTotalpopulation());
                pop.setCitypopulation(citypop + "(" + String.format("%.2f%%", citypercentage) + ")");
                long notcitypop = pop.getTotalpopulation() - citypop;
                Float notcitypercentage = (float) ((notcitypop * 100.00) / pop.getTotalpopulation());
                pop.setNotcitypopulation(notcitypop + "(" + String.format("%.2f%%", notcitypercentage) + ")");
                populations.add(pop);
            }
            System.out.println("\n24. The population of people, people living in cities, and people not living in cities in each region.");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each region.");
            return null;
        }
    }

    /***
     25.	The population of people, people living in cities, and people not living in cities in each country.
     */
    public ArrayList<Population> populationcitycountry()
    {
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPopulationReports_Country = "SELECT Name, Population FROM country "
                    + "HAVING Population>0 ORDER BY Name ASC;";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPopulationReports_Country);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getPopulationReports_City = "SELECT country.Name, SUM(city.Population) FROM city "
                    + "INNER JOIN country ON city.CountryCode=country.Code "
                    + "GROUP BY country.Name ORDER BY country.Name ASC;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getPopulationReports_City);

            // Extract total population data
            ArrayList<Population> populations = new ArrayList<>();
            while (result_1.next() & result_2.next())
            {
                Population pop = new Population();

                pop.setName(result_1.getString("Name"));
                pop.setTotalpopulation(result_1.getLong("Population"));

                long citypop = result_2.getLong("SUM(city.Population)");
                float citypercentage;
                long notcitypop;
                float notcitypercentage;

                if (pop.getTotalpopulation() > citypop) {
                    citypercentage = (float) ((citypop * 100.00) / pop.getTotalpopulation());
                    notcitypop = pop.getTotalpopulation() - citypop;
                    notcitypercentage = (float) ((notcitypop * 100.00) / pop.getTotalpopulation());
                }
                else{
                    citypercentage = (float) ((citypop * 100.00) / citypop);
                    notcitypop = citypop - pop.getTotalpopulation();
                    notcitypercentage = (float) ((notcitypop * 100.00) / citypop);
                    citypercentage = citypercentage - notcitypercentage;
                }
                pop.setCitypopulation(citypop + "(" + String.format("%.2f%%", citypercentage) + ")");
                pop.setNotcitypopulation(notcitypop + "(" + String.format("%.2f%%", notcitypercentage) + ")");

                populations.add(pop);
            }
            System.out.println("\n25. The population of people, people living in cities, and people not living in cities in each country.");
            return populations;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get a list of the population of people, people living in cities, and people not living in cities in each country.");
            return null;
        }
    }
////////////////////////////////////////////////////////////////
    /***
     26.	Population in the world.
     */
    public String populationworld()
    {
        String popp = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country;";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotalpopulation(result.getLong("SUM(Population)"));
            }
            popp = "\n26. Population in the world is " + pop.getTotalpopulation() + ".";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popp;
    }

    /***
     27.	Population in the Continent
     */
    public String populationcontinent(String continent)
    {
        String popp = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country WHERE Continent='"+continent+"'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotalpopulation(result.getLong("SUM(Population)"));
            }

            popp = "\n27. Population in " + continent + " Continent is " + pop.getTotalpopulation() +".";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popp;
    }
    /***
     28.	Population in the Region
     */
    public String populationregion(String region) {
        String popp = "";
        try {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country WHERE Region='" + region + "'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next()) {
                pop.setTotalpopulation(result.getLong("SUM(Population)"));
            }

            popp = "\n28. Population in " + region + " Region is " + pop.getTotalpopulation() + ".";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popp;
    }

    /***
     29.	Population in the Country
     */
    public String populationcountry(String country)
    {
        String popp = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM country WHERE Name='"+country+"'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotalpopulation(result.getLong("SUM(Population)"));
            }

            popp = "\n29. Population in " + country + " Country is " + pop.getTotalpopulation() + ".";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popp;
    }

    /***
     30.	Population in the District
     */
    public String populationdistrict(String district)
    {
        String popp = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT SUM(Population) FROM city WHERE District='"+district+"'";
            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotalpopulation(result.getLong("SUM(Population)"));
            }

            popp = "\n30. Population in " + district + " District is " + pop.getTotalpopulation() + ".";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popp;
    }

    /***
     31.	Population in the City
     */
    public String populationcity(String city)
    {
        String popp = "";
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect = "SELECT Population FROM city WHERE Name='"+city+"'";

            // Execute SQL statement
            ResultSet result = stmt.executeQuery(strSelect);
            // Extract population
            Population pop = new Population();
            while (result.next())
            {
                pop.setTotalpopulation(result.getLong("Population"));
            }

            popp = "\n31. Population in " + city + " City is " + pop.getTotalpopulation() + ".";
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population data");
        }
        return popp;
    }


    /**
     * 32. languages from greatest number to smallest, including the percentage of the world population
     */
    public ArrayList<Language> languagepop(){
        System.out.println("\n32. Population of people who uses certain languages\n");
        try
        {
            Statement stmt_1 = con.createStatement();  // Create a first SQL statement
            // Create string for the first SQL statement
            String getPeopleSpeakLanguage = "SELECT countrylanguage.Language, Sum((countrylanguage.Percentage/100)*country.Population) as totalpopulation FROM countrylanguage, country WHERE country.Code = countrylanguage.CountryCode and countrylanguage.Language IN ('Chinese', 'English', 'Hindi','Spanish','Arabic' ) GROUP BY countrylanguage.Language  ORDER BY totalpopulation desc";
            // Execute the first SQL statement
            ResultSet result_1 = stmt_1.executeQuery(getPeopleSpeakLanguage);

            Statement stmt_2 = con.createStatement();  // Create a second SQL statement
            // Create string for the second SQL statement
            String getWorldPopulation = "select Sum(Population) as worldpopulation from country;";
            // Execute the second SQL statement
            ResultSet result_2 = stmt_2.executeQuery(getWorldPopulation);

            ArrayList<Language> language = new ArrayList<>();

            float worldpopulation = 0;

            while (result_2.next()){
                worldpopulation = result_2.getLong("worldpopulation");
            }

            while (result_1.next()) {

                // Calculate percentage of people who speak a language in the world
                long languagenum = result_1.getLong("totalpopulation");

                float percent = ((float)languagenum / worldpopulation) * (float)(100.00);

                Language langu = new Language();
                langu.setName(result_1.getString("countrylanguage.Language"));
                langu.setPopulation(result_1.getLong("totalpopulation"));
                langu.setPercentage(percent);

                language.add(langu);

            }


            return language;

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get population of speakers");
            return null;

        }

    }






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
        System.out.printf("%-5s %-15s %-20s %-20s %-20s %-20s%n\n", "Code", "Name", "Continent", "Region", "Population", "Capital ");
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
        System.out.printf("%-25s %-25s %-25s %-25s%n\n", "City Name", "Country Name", "District", "Population ");
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
// out put and print files for capital
    public void printCapitalCityReport(ArrayList<Capital> capitalcities)
    {
        // Check capital cities is not null
        if (capitalcities == null)
        {
            System.out.println("No capital cities");
            return;
        }
        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n\n", "City Name", "Country Name", "District", "Population");

        // Check Capital City is not empty
        if (!capitalcities.isEmpty())
        {
            // Loop over all capital cities in the list
            for (Capital city : capitalcities) {
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
// out put and print files for population
    public void printPopulationReport(ArrayList<Population> populations)
    {
        // Check populations is not null
        if (populations == null)
        {
            System.out.println("No population for given data.");
            return;
        }

        // Print header
        System.out.printf("%-25s %-25s %-25s %-25s%n\n", "Place", "Total Population", "Population of City", "Population not from City");


        // Check populations is not empty
        if (!populations.isEmpty())
        {
            // Loop over all cities in the list
            for (Population population : populations) {
                // Check population contain null
                if (population == null){
                    continue;}
                String population_string =
                        String.format("%-25s %-25s %-25s %-25s",
                                population.getName(), population.getTotalpopulation(), population.getCitypopulation(), population.getNotcitypopulation());

                System.out.println(population_string);
            }
        }
        else
        {
            String population_string = "Population Report List is empty";
            System.out.println(population_string);
        }
    }
    public void printLanguageReport(ArrayList<Language> language)
    {
        // Check data is not null
        if (language == null)
        {
            System.out.println("No Data");
            return;
        }
        // Print header
        System.out.printf("%-30s %-30s %-30s%n\n","Language","Population","Percentage");


        // Check Country is not empty
        if (!language.isEmpty())
        {
            // Loop over all countries in the list
            for (Language langu : language)
            {
                // Check Country contain null
                if (langu == null){
                    continue;}
                String lan_string =
                        String.format("%-30s %-30s %-30s%n",
                                langu.getName(),langu.getPopulation(),String.format("%.2f%%", langu.getPercentage()));
                System.out.println(lan_string);
            }
        }
        else
        {
            String country_string = "Country Report List is empty";
            System.out.println(country_string);
        }
    }

}
/// Output and Print Language
