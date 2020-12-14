package com.KarthikNimma;

public class Main {

    public static void main(String[] args) {
	// write your code here

        County Butler = new County("Buttler", new int[]{17}, "Hamilton", 368130, 467.27);
        County Clinton = new County("Clinton", new int[]{27}, "Wilmington", 42040, 410.88);
        County Cuyahoga = new County("Cuyahoga", new int[]{35}, "Cleveland", 1249352, 458.49);
        County Franklin = new County("Franklin", new int[]{49}, "Columbus", 1264518, 539.87);
        County Hamilton = new County("Hamilton", new int[]{61}, "Cincinnati", 802374, 407.36);
        County Montgomery = new County("Montgomery", new int[]{113}, "Dayton", 535153, 461.68);

        Dictionary list2020 = new Dictionary();
        list2020.insert(Butler);
        list2020.insert(Clinton);
        list2020.insert(Cuyahoga);
        list2020.insert(Franklin);
        list2020.insert(Hamilton);
        list2020.insert(Montgomery);
        list2020.display();

        System.out.println();
        //  Question A
        Dictionary list2021 = new Dictionary(list2020);
        list2021.display();
        System.out.println();

//       Question B  Updating the value of Population in the Dictionary
        Node iter = list2021.head;
        while (iter.next!=null){
            iter.county_info.population += (0.06 * iter.county_info.population);
            iter = iter.next;
        }
        iter.county_info.population += (0.06 * iter.county_info.population);
        list2021.display();
        System.out.println();
        list2020.display();

//        Question C
        Dictionary list2022 = new Dictionary(list2021);
        System.out.println("list of 2022");
        list2022.display();
//        Question D

        Node Temp1 = list2022.head;
        Node Reference_to_buttler = null;

        while (Temp1.next != null) {
            if (Temp1.county_info.name.equals("Buttler")) {
                System.out.println(Temp1.county_info.FIPS[0] + "\n");

                Reference_to_buttler = Temp1;
            }
            Temp1 = Temp1.next;
        }
        if (Temp1.county_info.name.equals("Buttler")) {
            Reference_to_buttler = Temp1;
            Temp1 = Temp1.next;
        }

        Node Temp2 = list2022.head;
        Node Reference_to_hamilton = null;

        while (Temp2.next != null) {
            if (Temp2.county_info.name.equals("Hamilton")) {
                System.out.println(Temp2.county_info.FIPS[0] + "\n");
                Reference_to_hamilton = Temp2;
            }
            Temp2 = Temp2.next;
        }
        if (Temp2.county_info.name.equals("Hamilton")) {
            Reference_to_hamilton = Temp2;
            Temp2 = Temp2.next;
        }

        System.out.println(Reference_to_hamilton.county_info.FIPS[0] + "\n" + Reference_to_buttler.county_info.FIPS[0]);

        //Adding the Population and Area
        Reference_to_hamilton.county_info.area = Reference_to_hamilton.county_info.area + Reference_to_buttler.county_info.area;
        Reference_to_hamilton.county_info.population = Reference_to_hamilton.county_info.population + Reference_to_buttler.county_info.population;


        //Code for Delete
        list2022.delete(Reference_to_buttler.county_info.FIPS);
        System.out.println("\n\nList of 2022 after merging and deleting\n");
        list2022.display();
    }

}
