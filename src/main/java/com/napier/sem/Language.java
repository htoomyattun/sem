package com.napier.sem;

public class Language {
    private String Name;

    //  Population of the language spoken
    private long Population;

    // Percentage of language spoken in the world
    private float Percentage;

    //      set language name
    public void setName(String lname){
        Name =  lname;
    }

    //get name of language to be able to access by another class
    public String getName(){
        return Name;
    }

    //      set Population of language spoken
    public void setPopulation(long lpopulation){
        Population =  lpopulation;
    }

    //get Population of language spoken to be able to access by another class
    public long getPopulation(){
        return Population;
    }

    //      set Population of language spoken
    public void setPercentage(float lpercentage){
        Percentage =  lpercentage;
    }

    //get Population Percentage of language spoken to be able to access by another class
    public float getPercentage(){
        return Percentage;
    }
}
