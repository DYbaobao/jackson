package com.jackson.json.databinding;

/**
 * Hello world!
 *
 */
public class Province
{
    public String name;
    public int  population;
    public String [] city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String[] getCity() {
        return city;
    }

    public void setCity(String[] city) {
        this.city = city;
    }

   /* public static void main(String[] args )
    {
        System.out.println( "Hello World!" );
    }*/
}
