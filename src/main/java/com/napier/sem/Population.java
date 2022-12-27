package com.napier.sem;

public class Population {
    //country, continent or region name
    private String name;

    //country, continent or region total population
    private long totalpopulation;

    //country, continent or region total city population
    private String citypopulation;

    //country, continent or region total population not from city
    private String notcitypopulation;

    //set location name
    public void setName(String popname){
        name = popname;
    }

    //get location name
    public String getName(){
        return name;
    }

    // set location total population
    public void setTotalpopulation(long totalpopulation){
        this.totalpopulation = totalpopulation;
    }

    //get location total population
    public long getTotalpopulation(){
        return totalpopulation;
    }

    // set from city population
    public void setCitypopulation(String cpopulation){
        citypopulation = cpopulation;
    }

    // get from city population
    public String getCitypopulation(){
        return citypopulation;
    }

    // set not from city population
    public void setNotcitypopulation(String ncpopulation){
        notcitypopulation = ncpopulation;
    }

    // get not from city population
    public String getNotcitypopulation(){
        return notcitypopulation;
    }
}
