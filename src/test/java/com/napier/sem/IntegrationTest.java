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
        app.connect("localhost:33060");

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
        String expectedCapital = "Ciudad de México";

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
    }

