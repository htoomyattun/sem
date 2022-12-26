package com.napier.sem;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
public class UnitTests {
    static App app;

    @BeforeAll
    static void init() {
        app = new App();
    }

    // 1. Country Report
    @Test
    void countryworld() {
        System.out.println("1. Test Method of Country Report \n");
        ArrayList<Country> countries = new ArrayList<>();
        Country coun = new Country();
        coun.setCode("MMR");
        coun.setName("Myanmar");
        coun.setContinent("Asia");
        coun.setRegion("Southeast Asia");
        coun.setPopulation(45611000);
        coun.setCapital("Rangoon (Yangon)");
        countries.add(coun);
        app.printCountriesReport(countries);
        System.out.println("_______________________________________________________________________________________________________ \n");
    }

    // 2. City Report
    @Test
    void cityworld() {
        System.out.println("2. Test Method of City Report \n ");
        // Create cities Array List
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.setName("London");
        city.setCountry("United Kingdom");
        city.setDistrict("England ");
        city.setPopulation(7285000);
        cities.add(city);
        app.printCitiesReport(cities);
        System.out.println("_______________________________________________________________________________________________________ \n");
    }

}