package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Integration_Test {
    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");

    }


    /**
     * Function to integrated test for Countries in the world from the largest population to smallest
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

        System.out.println("Testing to retrieve the countries in the world from largest population to smallest is successfully!!");
        System.out.println("=================================================================================================");
        }
    }



