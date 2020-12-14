package com.KarthikNimma;

import java.io.PrintStream;

// PENDING..................................................................................
public class Dictionary {
    Node head;		// the reference to the head node

    public Dictionary(){
        head=null;
    }
    public Dictionary(final Dictionary dictionary){
        County temp_county = null;
        Node iter = dictionary.head;

        while(iter.next != null){
            temp_county = new County(iter.county_info);
            insert(temp_county);
            iter = iter.next;
        }
        temp_county = new County(iter.county_info);
        insert(temp_county);
    }


    // inserting a new element to a dictionary
    void insert(final County info) {
        Node data_node = new Node(info, null);

        if (head == null) {
            head = data_node;
        } else {
            Node iter = head;
            while (iter.next != null) {
                if (iter.county_info.FIPS[0] == info.FIPS[0]) {
                    iter.county_info.name = info.name;
                    iter.county_info.seat = info.seat;
                    iter.county_info.population = info.population;
                    iter.county_info.area = info.area;
                    return;
                } else {
                    iter = iter.next;
                }
            }
            if (iter.county_info.FIPS[0] == info.FIPS[0]) {
                iter.county_info.name = info.name;
                iter.county_info.seat = info.seat;
                iter.county_info.population = info.population;
                iter.county_info.area = info.area;
                return;
            }
                iter.next = data_node;
        }
    }

    // deleting an existing element from a dictionary
    boolean delete(final int[] FIPS)
    {
        Node temp = head;
        Node previous = temp;
        boolean check = false;

        if (head == null) {
            System.out.println("Invalid operation - Empty List");
        }
        else {
            if (temp.county_info.FIPS[0] == FIPS[0]) {
                head = temp.next;
                return true;
            }
            temp = temp.next;

            while (temp.next != null) {
                if (temp.county_info.FIPS[0] == FIPS[0]) {
                    System.out.println(1);
                    previous.next = temp.next;
                    return true;
                }
                previous = temp;
                temp = temp.next;
            }
            if (temp.county_info.FIPS[0] == FIPS[0]) {
                previous.next = null;
                return true;
            }
        }
        return false;
    }
    void  display(){
        for(Node iter  = head; iter!=null;iter = iter.next ){
            System.out.println(iter.county_info.toString());
        }
    }

}
