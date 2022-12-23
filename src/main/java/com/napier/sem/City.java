package com.napier.sem;

/**
 * City
 */
public class City {

    //    city name
    private String name;

    //    country of city
    private String country;

    //    district of city
    private String district;

    //    population of city
    private int population;

    //      set city name
    public void setName(String cname){
        name =  cname;
    }

    //get city name
    public String getName(){
        return name;
    }

    //set country
    public void setCountry(String ccountry){
        country = ccountry;
    }

    //get country
    public String getCountry(){
        return country;
    }

    //set district
    public void setDistrict(String cdistrict){
        district = cdistrict;
    }

    //get district
    public String getDistrict(){
        return district;
    }

    //set population
    public void setPopulation(int cpopulation){
        population = cpopulation;
    }

    //get population
    public int getPopulation(){
        return population;
    }
}