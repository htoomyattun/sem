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

    // 1. Country Report Testing  //////////////////////////////////////////////////
    @Test
    void CountriesReportTest() {
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
        System.out.println("\n_______________________________________________________________________________________________________ \n");
    }
    /**
     * Prints when country report is null.
     */
    @Test
    void CountriesReportTestNull()
    {
        System.out.println("Countries Report Null Testing~~\n");
        app.printCountriesReport(null);
        System.out.println("=================================================================================================\n");
    }
    /**
     * Prints when country report contain null.
     */
    @Test
    void CountriesReportTestContainNull()
    {
        System.out.println("Countries Report Contain Null Testing~~\n");
        ArrayList<Country> countries = new ArrayList<>();
        countries.add(null);
        app.printCountriesReport(countries);
        System.out.println("=================================================================================================\n");

    }
    /**
     * Prints when country report is empty.
     */
    @Test
    void CountriesReportTestEmpty()
    {
        System.out.println("Countries Report Empty Testing~~\n");
        ArrayList<Country> countries = new ArrayList<>();
        app.printCountriesReport(countries);
        System.out.println("=================================================================================================\n");

    }

//////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////

    // 2. City Report Testing
    @Test
    void CitiesreportTest() {
        System.out.println("2. Test Method of City Report \n ");
        // Create cities Array List
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.setName("Dublin");
        city.setCountry("Ireland");
        city.setDistrict("Leinster");
        city.setPopulation(481854);
        cities.add(city);
        app.printCitiesReport(cities);
        System.out.println("_____________________________________________________________________________________ \n");
    }

    /**
     * Prints when City report is null.
     */
    @Test
    void CityReportTestNull()
    {
        System.out.println("City Report Null Testing~~");
        app.printCitiesReport(null);
        System.out.println("=================================================================================================\n");
    }

    /**
     * Prints when City report is empty.
     */
    @Test
    void CityReportTestEmpty()
    {
        System.out.println("City Report Empty Testing~~\n");
        ArrayList<City> cities = new ArrayList<>();
        app.printCitiesReport(cities);
        System.out.println("=================================================================================================\n");

    }

    /**
     * Prints when City report contain null.
     */
    @Test
    void CityReportTestContainNull()
    {
        System.out.println("City Report Contain Null Testing~~");
        ArrayList<City> cities = new ArrayList<>();
        cities.add(null);
        app.printCitiesReport(cities);
        System.out.println("=================================================================================================\n");

}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

// 3. Capital Cities Report Testing
@Test
void CCityReportTest()
{
    System.out.println("3. Test Method of Capital City Report~~");
    ArrayList<Capital> cap_cities = new ArrayList<>();
    Capital ca = new Capital();
    ca.setName("Tokyo");
    ca.setCountry("Japan");
    ca.setDistrict("Tokyo-to");
    ca.setPopulation(7980230 );
    cap_cities.add(ca);
    app.printCapitalCityReport(cap_cities);
    System.out.println("=================================================================================================\n");
}

    /**
     * Prints when Capital City report is null.
     */
    @Test
    void CCityReportTestNull()
    {
        System.out.println("Capital City Report Null Testing~~");
        app.printCapitalCityReport(null);
        System.out.println("=================================================================================================\n");
    }

    /**
     * Prints when Capital City report is empty.
     */
    @Test
    void CCityReportTestEmpty()
    {
        System.out.println("Capital City Report Empty Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<>();
        app.printCapitalCityReport(cap_cities);
        System.out.println("=================================================================================================\n");

    }

    /**
     * Prints when Capital City report contain null.
     */
    @Test
    void CCityReportTestContainNull()
    {
        System.out.println("Capital City Report Contain Null Testing~~");
        ArrayList<Capital> cap_cities = new ArrayList<>();
        cap_cities.add(null);
        app.printCapitalCityReport(cap_cities);
        System.out.println("=================================================================================================\n");

    }

    /**
     * Population Report Testing
     */
    @Test
    void PopulationReportTest()
    {
        System.out.println("4. Test Method for Population Report~~");
        ArrayList<Population> populations = new ArrayList<>();
        Population pop = new Population();
        pop.setName("Czech Republic ");
        pop.setTotalpopulation( 10278100 );
        pop.setCitypopulation(2634711+"("+25.63+"%)");
        pop.setNotcitypopulation(7643389+"("+74.37+"%)");
        populations.add(pop);
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================\n");
    }
    // 4.Population Report Test
    /**
     * Prints when Population report is null.
     */
    @Test
    void PopulationReportTestNull()
    {
        System.out.println("Population Report Null Testing~~");
        app.printPopulationReport(null);
        System.out.println("=================================================================================================\n");
    }

    /**
     * Prints when Population report is empty.
     */
    @Test
    void PopulationReportTestEmpty()
    {
        System.out.println("Population Report Empty Testing~~");
        ArrayList<Population> populations = new ArrayList<>();
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================\n");

    }

    /**
     * Prints when Population report contain null.
     */
    @Test
    void printPopulationReportTestContainNull()
    {
        System.out.println("Population Report Contain Null Testing~~");
        ArrayList<Population> populations = new ArrayList<>();
        populations.add(null);
        app.printPopulationReport(populations);
        System.out.println("=================================================================================================");

    }

// 5. Language Report Test
// 3. Capital Cities Report Testing
@Test
void LanguageReportTest()
{
    System.out.println("5. Test Method of Language Report~~");
    ArrayList<Language> languages = new ArrayList<>();
    Language la = new Language();
    la.setName("China");
    la.setPopulation(Long.parseLong("1191843539"));
    la.setPercentage(19.61f);
    languages.add(la);
    app.printLanguageReport(languages);
    System.out.println("=================================================================================================\n");
}
    /**
     * Prints when Population report is empty.
     */
    @Test
    void LanguageoReportTestEmpty()
    {
        System.out.println("Language Report Empty Testing~~");
        ArrayList<Language> languages = new ArrayList<>();
        app.printLanguageReport(languages);
        System.out.println("=================================================================================================\n");

    }

    /**
     * Prints when Population report contain null.
     */
    @Test
    void printLanguageReportTestContainNull()
    {
        System.out.println("Language Report Contain Null Testing~~");
        ArrayList<Language> languages = new ArrayList<>();
        languages.add(null);
        app.printLanguageReport(languages);
        System.out.println("=================================================================================================");

    }




    }