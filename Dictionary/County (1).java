package com.KarthikNimma;

import java.util.Arrays;

public class County {
    String name;		// county name
    int[] FIPS;		// FIPS code
    String seat;		// county seat
    long population;	// population number
    double area;		// area in sq mi.

    public County(){
        FIPS = new int[1];
    }
    public County(String name, int[] FIPS, String seat, long population, double area) {
        this.name = name;
        this.FIPS = FIPS;
        this.seat = seat;
        this.population = population;
        this.area = area;
    }
//    COPY CONSTRUCTOR
    public County(final County county){
        name = county.name;
        FIPS = new int[county.FIPS.length];
        for(int i=0;i<county.FIPS.length;i++){
            FIPS[i] = county.FIPS[i];
        }
        seat = county.seat;
        population = county.population;
        area = county.area;
    }

    @Override
    public String toString() {
        return "County{" +
                "name='" + name + '\'' +
                ", FIPS=" + Arrays.toString(FIPS) +
                ", seat='" + seat + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }
}
