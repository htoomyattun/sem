package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060", 30000);

    }


    /**
     * 1 Function to integrated test for Countries in the world from the largest population to smallest
     */
    @Test
    void testCountries_World() {
        String expectedCode = "MMR";
        String expectedName = "Myanmar";
        String expectedContinent = "Asia";
        String expectedRegion = "Southeast Asia";
        long expectedPopulation = 45611000;
        String expectedCapital = "Rangoon (Yangon)";

        ArrayList<Country> countries = app.countryworld();
        String actualCode = countries.get(25).getCode();
        String actualName = countries.get(25).getName();
        String actualContinent = countries.get(25).getContinent();
        String actualRegion = countries.get(25).getRegion();
        long actualPopulation = countries.get(25).getPopulation();
        String actualCapital = countries.get(25).getCapital();


        assertEquals(expectedCode,actualCode);
        assertEquals(expectedName,actualName);
        assertEquals(expectedContinent,actualContinent);
        assertEquals(expectedRegion,actualRegion);
        assertEquals(expectedPopulation,actualPopulation);
        assertEquals(expectedCapital,actualCapital);

        System.out.println("Populated countries in the world from largest population to smallest Test completed successfully!!");
        System.out.println("=================================================================================================");
        }




    /**
     *2, Function to integrated test for Countries in the continent from the largest population to smallest
     */
    @Test
    void Countries_Continent_test() {

        String expectedCode = "JPN";
        String expectedName = "Japan";
        String expectedContinent = "Asia";
        String expectedRegion = "Eastern Asia";
        int expectedPopulation = 126714000;
        String expectedCapital = "Tokyo";

        ArrayList<Country> countries = app.countrycontinent();

        assertEquals(expectedCode,countries.get(5).getCode());
        assertEquals(expectedName,countries.get(5).getName());
        assertEquals(expectedContinent,countries.get(5).getContinent());
        assertEquals(expectedRegion,countries.get(5).getRegion());
        assertEquals(expectedPopulation,countries.get(5).getPopulation());
        assertEquals(expectedCapital,countries.get(5).getCapital());

        System.out.println("Populated Countries in a Continent Test completed Successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * 3. Function to integrated test for Countries in the region from the largest population to smallest
     */
    @Test
    void Countries_Region_test() {

        String expectedCode = "MEX";
        String expectedName = "Mexico";
        String expectedContinent = "North America";
        String expectedRegion = "Central America";
        int expectedPopulation = 98881000;
        String expectedCapital = "Ciudad de M??xico";

        ArrayList<Country> countries = app.countryregion();

        assertEquals(expectedCode,countries.get(0).getCode());
        assertEquals(expectedName,countries.get(0).getName());
        assertEquals(expectedContinent,countries.get(0).getContinent());
        assertEquals(expectedRegion,countries.get(0).getRegion());
        assertEquals(expectedPopulation,countries.get(0).getPopulation());
        assertEquals(expectedCapital,countries.get(0).getCapital());

        System.out.println("Populated Countries in a Region Test completed Successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     * 4. Function to integrated test for Top N populated Country in the World
     */
    @Test
    void TopNCountries_World_test() {

        String expectedCode = "USA";
        String expectedName = "United States";
        String expectedContinent = "North America";
        String expectedRegion = "North America";
        int expectedPopulation = 278357000;
        String expectedCapital = "Washington";

        ArrayList<Country> countries = app.countrytopnworld();

        assertEquals(expectedCode,countries.get(2).getCode());
        assertEquals(expectedName,countries.get(2).getName());
        assertEquals(expectedContinent,countries.get(2).getContinent());
        assertEquals(expectedRegion,countries.get(2).getRegion());
        assertEquals(expectedPopulation,countries.get(2).getPopulation());
        assertEquals(expectedCapital,countries.get(2).getCapital());

        System.out.println("Top N populated Countries in the World Test completed successfully");
        System.out.println("=================================================================================================");
    }

    /**
     * 5. Function to integrated test for Top N populated Country in the Continent
     */
    @Test
    void TopNCountries_continent_test() {

        String expectedCode = "CHN";
        String expectedName = "China";
        String expectedContinent = "Asia";
        String expectedRegion = "Eastern Asia";
        int expectedPopulation = 1277558000  ;
        String expectedCapital = "Peking";

        ArrayList<Country> countries = app.countrytopncontinent();

        assertEquals(expectedCode, countries.get(0).getCode());
        assertEquals(expectedName, countries.get(0).getName());
        assertEquals(expectedContinent, countries.get(0).getContinent());
        assertEquals(expectedRegion, countries.get(0).getRegion());
        assertEquals(expectedPopulation, countries.get(0).getPopulation());
        assertEquals(expectedCapital, countries.get(0).getCapital());

        System.out.println("Top N populated Countries in the Continent Test completed successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * 6. Function to integrated test for Top N populated Country in the Region
     */
    @Test
    void TopNCountries_region_test() {

        String expectedCode = "THA";
        String expectedName = "Thailand";
        String expectedContinent = "Asia";
        String expectedRegion = "Southeast Asia";
        int expectedPopulation = 61399000   ;
        String expectedCapital = "Bangkok";

        ArrayList<Country> countries = app.countrytopnregion();

        assertEquals(expectedCode, countries.get(3).getCode());
        assertEquals(expectedName, countries.get(3).getName());
        assertEquals(expectedContinent, countries.get(3).getContinent());
        assertEquals(expectedRegion, countries.get(3).getRegion());
        assertEquals(expectedPopulation, countries.get(3).getPopulation());
        assertEquals(expectedCapital, countries.get(3).getCapital());

        System.out.println("Top N populated Countries in the Region Test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     * 7. All the cities in the world organised by largest population to smallest.
     */
    @Test
    void Cities_World_Test() {

        String expectedName = "Seoul";
        String expectedCountry = "South Korea";
        String expectedDistrict = "Seoul";
        int expectedPopulation = 9_981_619;

        ArrayList<City> cities = app.cityworld();

        assertEquals(expectedName,cities.get(1).getName());
        assertEquals(expectedCountry,cities.get(1).getCountry());
        assertEquals(expectedDistrict,cities.get(1).getDistrict());
        assertEquals(expectedPopulation,cities.get(1).getPopulation());

        System.out.println("All the cities in the world from largest population to smallest testing completed successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     *8. Function to integrated test for Cities in the continent from the largest population to smallest
     */
    @Test
    void test_Cities_Continent() {

        String expectedName = "Istanbul";
        String expectedCountry = "Turkey";
        String expectedDistrict = "Istanbul";
        int expectedPopulation = 8787958  ;

        ArrayList<City> cities = app.citycontinent();

        assertEquals(expectedName,cities.get(5).getName());
        assertEquals(expectedCountry,cities.get(5).getCountry());
        assertEquals(expectedDistrict,cities.get(5).getDistrict());
        assertEquals(expectedPopulation,cities.get(5).getPopulation());

        System.out.println("All the cities in the continent from largest population to smallest testing completed successfully!!");
        System.out.println("=================================================================================================");
    }


    /**
     *9. Function to integrated test for Cities in the region from the largest population to smallest
     */
    @Test
    void CityinRegionTest() {

        ArrayList<City> cities = app.cityregion();
        assertEquals(297, cities.size());


        System.out.println("Testing to retrieve the cities in the region from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     *10 Function to integrated test for Cities in the country from the largest population to smallest
     */
    @Test
    void Cities_Country_Test() {

        String expectedName = "Mandalay";
        String expectedCountry = "Myanmar";
        String expectedDistrict = "Mandalay";
        int expectedPopulation = 885300  ;

        ArrayList<City> cities = app.citycountry();

        assertEquals(expectedName,cities.get(1).getName());
        assertEquals(expectedCountry,cities.get(1).getCountry());
        assertEquals(expectedDistrict,cities.get(1).getDistrict());
        assertEquals(expectedPopulation,cities.get(1).getPopulation());

        System.out.println("ALl the cities in the country from largest population to smallest testing completed successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     *11 Function to integrated test for Cities in the district from the largest population to smallest
     */
    @Test
    void Cities_District_Test() {

        String expectedName = "Miami";
        String expectedCountry = "United States";
        String expectedDistrict = "Florida";
        int expectedPopulation = 362470 ;

        ArrayList<City> cities = app.citydistrict();

        assertEquals(expectedName,cities.get(1).getName());
        assertEquals(expectedCountry,cities.get(1).getCountry());
        assertEquals(expectedDistrict,cities.get(1).getDistrict());
        assertEquals(expectedPopulation,cities.get(1).getPopulation());

        System.out.println("All the cities in the district from largest population to smallest completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     *12 Function to integrated test for Top N populated Cities in the world
     */
    @Test
    void TopNCities_World_Test() {

        String expectedName = "Seoul";
        String expectedCountry = "South Korea";
        String expectedDistrict = "Seoul";
        int expectedPopulation =  9981619 ;

        ArrayList<City> cities = app.citytopnworld();

        assertEquals(expectedName,cities.get(1).getName());
        assertEquals(expectedCountry,cities.get(1).getCountry());
        assertEquals(expectedDistrict,cities.get(1).getDistrict());
        assertEquals(expectedPopulation,cities.get(1).getPopulation());

        System.out.println("Testing of retrieving Top N populated cities in the world completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     *13. Function to integrated test for Top N populated Cities in the Continent
     */
    @Test
    void TopNCities_Continent_Test() {

        String expectedName = "Sydney";
        String expectedCountry = "Australia";
        String expectedDistrict = "New South Wales";
        int expectedPopulation = 3276207;

        ArrayList<City> cities = app.citytopncontinent();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Top N populated cities in the continent test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     *14. Function to integrated test for Top N populated Cities in the region
     */
    @Test
    void TopNCities_Region_Test() {

        String expectedName = "Berlin";
        String expectedCountry = "Germany";
        String expectedDistrict = "Berliini";
        int expectedPopulation = 3386667  ;

        ArrayList<City> cities = app.citytopnregion();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Top N populated cities in the region test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     * 15. Function to integrated test for Top N populated Cities in the Country
     */
    @Test
    void TopNCities_Countries() {

        String expectedName = "Paris";
        String expectedCountry = "France";
        String expectedDistrict = "??le-de-France";
        int expectedPopulation = 2125246  ;

        ArrayList<City> cities = app.citytopncountry();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Top N populated cities in the Country test completed successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * 16. Function to integrated test for Top N populated Cities in the District
     */
    @Test
    void TopNCities_District() {

        String expectedName = "Los Angeles";
        String expectedCountry = "United States";
        String expectedDistrict = "California";
        int expectedPopulation = 3694820  ;

        ArrayList<City> cities = app.citytopndistrict();

        assertEquals(expectedName,cities.get(0).getName());
        assertEquals(expectedCountry,cities.get(0).getCountry());
        assertEquals(expectedDistrict,cities.get(0).getDistrict());
        assertEquals(expectedPopulation,cities.get(0).getPopulation());

        System.out.println("Top N populated cities in the District test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     *17. Function to integrated test for Capital Cities in the world from the largest population to smallest
     */
    @Test
    void Num_Test_CCWorld() {

        ArrayList<Capital> cap_cities = app.capitalworld();
        assertEquals(232, cap_cities.size());

        System.out.println("All the capital cities in the world from largest population to smallest test completed successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     *18, Function to integrated test for Capital Cities in the world from the largest population to smallest
     */
    @Test
    void Num_Test_CCContinent() {

        ArrayList<Capital> cap_cities = app.capitalcontinent();
        assertEquals(51, cap_cities.size());

        System.out.println("All the capital cities in the Continent from largest population to smallest test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     * 19.Function to integrated test for Capital Cities in the Region from the largest population to smallest
     */
    @Test
    void Test_CCRegion() {

        String expectedName = "Abu Dhabi";
        String expectedCountry = "United Arab Emirates";
        String expectedDistrict = "Abu Dhabi";
        int expectedPopulation = 398695 ;

        ArrayList<Capital> cap_cities = app.capitalregion();

        assertEquals(expectedName,cap_cities.get(11).getName());
        assertEquals(expectedCountry,cap_cities.get(11).getCountry());
        assertEquals(expectedDistrict,cap_cities.get(11).getDistrict());
        assertEquals(expectedPopulation,cap_cities.get(11).getPopulation());

        System.out.println("All the Populated Capital Cities in the Region test completed Successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     * 20.Function to integrated test for Top N populated capital cities in the World test completed successfully
     */
    @Test
    void Test_TopNCC_World() {

        String expectedName = "Moscow";
        String expectedCountry = "Russian Federation";
        String expectedDistrict = "Moscow (City)";
        int expectedPopulation = 8389200 ;

        ArrayList<Capital> cap_cities = app.capitaltopnworld();

        assertEquals(expectedName,cap_cities.get(3).getName());
        assertEquals(expectedCountry,cap_cities.get(3).getCountry());
        assertEquals(expectedDistrict,cap_cities.get(3).getDistrict());
        assertEquals(expectedPopulation,cap_cities.get(3).getPopulation());

        System.out.println("Top N populated capital cities in the World test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     * 21.Function to integrated test for Top N populated capital cities in the Continent test completed successfully
     */
    @Test
    void TopNCC_Continent_Test() {

        String expectedName = "Taipei";
        String expectedCountry = "Taiwan";
        String expectedDistrict = "Taipei";
        int expectedPopulation = 2641312  ;

        ArrayList<Capital> cap_cities = app.capitaltopncontinent();

        assertEquals(expectedName,cap_cities.get(12).getName());
        assertEquals(expectedCountry,cap_cities.get(12).getCountry());
        assertEquals(expectedDistrict,cap_cities.get(12).getDistrict());
        assertEquals(expectedPopulation,cap_cities.get(12).getPopulation());

        System.out.println("Top N populated capital cities in the Continent test completed successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     * 22.Function to integrated test for Top N populated capital cities in the Region test completed successfully
     */
    @Test
    void TopN_CC_Region_Test() {

        String expectedName = "Victoria";
        String expectedCountry = "Hong Kong";
        String expectedDistrict = "Hongkong";
        int expectedPopulation = 1312637   ;

        ArrayList<Capital> cap_cities = app.capitaltopnregion();

        assertEquals(expectedName,cap_cities.get(5).getName());
        assertEquals(expectedCountry,cap_cities.get(5).getCountry());
        assertEquals(expectedDistrict,cap_cities.get(5).getDistrict());
        assertEquals(expectedPopulation,cap_cities.get(5).getPopulation());

        System.out.println("Top N populated capital cities in the Region test completed successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     *23. Function to integrated test for information of number of population of people, people living in cities, and people not living in cities in each continent
     * */
    @Test
    void test_Population_City_Continent() {
        String expectedName = "Oceania";
        int expectedCountry = 30401150;
        String expectedDistrict = "13886149(45.68%)";
        String expectedPopulation ="16515001(54.32%)";

        ArrayList<Population> populations = app.populationcitycontinent();

        assertEquals(expectedName,populations.get(1).getName());
        assertEquals(expectedCountry,populations.get(1).getTotalpopulation());
        assertEquals(expectedDistrict,populations.get(1).getCitypopulation());
        assertEquals(expectedPopulation,populations.get(1).getNotcitypopulation());


        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each continent is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     *24. Function to integrated test for information of number of population of people, people living in cities, and people not living in cities in each region
     * */
    @Test
    void test_Population_City_Region() {

        ArrayList<Population> populations = app.populationcityregion();
        assertEquals(23, populations.size());

        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each region is successfully!!");
        System.out.println("=================================================================================================");
    }

    /**
     *25. Function to integrated test for information of number of population of people, people living in cities, and people not living in cities in each country
     * */
    @Test
    void test_Population_City_Country() {

        ArrayList<Population> populations = app.populationcitycountry();
        assertEquals(232, populations.size());

        System.out.println("Testing to retrieve the number of population of people, people living in cities, and people not living in cities in each country is successfully!!");
        System.out.println("=================================================================================================");
    }
    /**
     *26. Function to integrated test for Population of the World
     * */
    @Test
    void TotalPopulation_World() {
        // Extract total population in the world

        //expected output of number of people in the world
        String expectedOutput = "\n26. Population in the world is 6078749450.";
        //actual output of  number of people in the world
        String actualOutput = app.populationworld();
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Population of the World Testing completed Successfully.");
        System.out.println("=================================================================================================");
    }
    /**
     *27. Function to integrated test for Total Population in a Continent
     * */
    @Test
    void TotalPopulation_Continent() {
        // Extract total population in the continent
        String continent = "North America";
        //expected output of number of people in the Asia Continent
        String expectedOutput = "\n27. Population in North America Continent is 482993000.";
        //actual output of  number of people in the Asia Continent
        String actualOutput = app.populationcontinent(continent);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Population of the " + continent + " continent testing completed successfully");
        System.out.println("=================================================================================================");
    }
    /**
     *28. Function to integrated test for Total Population in a Region
     * */
    @Test
    void TotalPopulation_Region() {
        // Extract total population in the region
        String region = "British Islands";
        //expected output of number of people in the Caribbean Region
        String expectedOutput = "\n28. Population in British Islands Region is 63398500.";
        //actual output of  number of people in the Caribbean Region
        String actualOutput = app.populationregion(region);
        assertEquals(expectedOutput, actualOutput);

        System.out.println("Population of the " + region + " region testing completed successfully");
        System.out.println("=================================================================================================");
    }
    /**
     *29. Function to integrated test for Total Population in a Country
     * */
    @Test
    void TotalPopulation_Country() {
        // Extract total population in the country
        String country = "Myanmar";
        //expected output of number of people in the Denmark Country
        String expectedOutput = "\n29. Population in Myanmar Country is 45611000.";
        //actual output of  number of people in the Denmark Country
        String actualOutput = app.populationcountry(country);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Population of" + country + " country testing completed successfully");
        System.out.println("=================================================================================================");
    }
    /**
     *30. Function to integrated test for Total Population in a District
     * */
    @Test
    void TotalPopulation_District() {
        // Extract total population in the district
        String district = "Texas";
        //expected output of number of people in the Gujarat District
        String expectedOutput = "\n30. Population in Texas District is 9208281.";
        //actual output of  number of people in the Gujarat District
        String actualOutput = app.populationdistrict(district);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Population of " + district + " district testing completed successfully");
        System.out.println("=================================================================================================");
    }
    /**
     *31. Function to integrated test for Total Population in a City
     * */
    @Test
    void TotalPopulation_City(){
        // Extract total population in the city
        String city = "Amsterdam";
        //expected output of number of people in the Seoul city
        String expectedOutput = "\n31. Population in Amsterdam City is 731200.";
        //actual output of  number of people in the Seoul City
        String actualOutput = app.populationcity(city);
        assertEquals(expectedOutput, actualOutput);
        System.out.println("Population of " + city + " city testing completed successfully");
        System.out.println("=================================================================================================");
    }
    /**
     * 32. languages from greatest number to smallest, including the percentage of the world population
     * */
    @Test
    void LanguangePop_Test() {

        String expectedName = "Chinese";
        long expectedPopulation = 1191843539;
        float expectedPercentage = (float) 19.606724;

        ArrayList<Language> langu = app.languagepop();
        String actualName = String.valueOf(langu.get(0).getName());
        long actualPopulation = langu.get(0).getPopulation();
        float actualPercentage = langu.get(0).getPercentage();

        assertEquals(expectedName,actualName);
        assertEquals(expectedPopulation,actualPopulation);
        assertEquals(expectedPercentage,actualPercentage);

        System.out.println("Population of people who speaks certain languages report testing completed successfully.");
        System.out.println("=================================================================================================");
    }


    ////////Null Number Testing                        //////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *. Function to integrated testing for null nunmbers for countries in the world/Continent/Region
     * */

    @Test
    void TestEmptyCountries(){
        ArrayList <Country> countriesworld = app.countryworld();
        assertTrue(countriesworld.size() > 0);
        System.out.println("Testing for countries in world array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <Country> countriescontinent = app.countrycontinent();
        assertTrue(countriescontinent.size() > 0);
        System.out.println("Testing for countries in continent array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <Country> countries_region = app.countryregion();
        assertTrue(countries_region.size() > 0);
        System.out.println("Testing for countries in region array size not being zero completed");
        System.out.println("=================================================================================================");

    }
    /**
     *. Function to integrated testing for Empty
     *   nunmbers for cities in the world/Continent/Region/Country/District
     * */

    @Test
    void TestEmptyCities(){
        ArrayList <City> citiesworld = app.cityworld();
        assertTrue(citiesworld.size() > 0);
        System.out.println("Testing for Cities in world array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <City> citiescontinent = app.citycontinent();
        assertTrue(citiescontinent.size() > 0);
        System.out.println("Testing for Cities in continent array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <City> citiesregion = app.cityregion();
        assertTrue(citiesregion.size() > 0);
        System.out.println("Testing for Cities in region array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <City> citiescountry = app.citycountry();
        assertTrue(citiescountry.size() > 0);
        System.out.println("Testing for Cities in country array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <City> citiesdistrict = app.citydistrict();
        assertTrue(citiesdistrict.size() > 0);
        System.out.println("Testing for Cities in district array size not being zero completed");
        System.out.println("=================================================================================================");
    }
    /**
     *. Function to integrated testing for null nunmbers for capital cities in the world/Continent/Region
     * */
    @Test
    void TestEmptyCCity(){
        ArrayList <Capital> capworld = app.capitalworld();
        assertTrue(capworld.size() > 0);
        System.out.println("Testing for Capital city in world array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <Capital> capcontinent = app.capitalcontinent();
        assertTrue(capcontinent.size() > 0);
        System.out.println("Testing for Capital city in the continent array size not being zero completed");
        System.out.println("=================================================================================================");

        ArrayList <Capital> capregion = app.capitalregion();
        assertTrue(capregion.size() > 0);
        System.out.println("Testing for Capital city in the region array size not being zero completed");
        System.out.println("=================================================================================================");
    }
   


}
