package com.KarthikNimma;

public class Node
{
    County county_info;	// the reference to the information of the county
    Node next;

    public Node(){
        county_info = new County();
        next=null;
    }
    public Node(final County county_info,final Node next) {
        this.county_info = county_info;
        this.next = next;
    }
}
