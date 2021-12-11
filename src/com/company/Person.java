package com.company;

import java.util.ArrayList;

public class Person {
    public String name;
    public ArrayList<Payment> thingsPaidFor;
    public ArrayList<Commodity> toPay;

    public Person(String name, ArrayList<Payment> thingsPaidFor, ArrayList<Commodity> toPay) {
        this.name = name;
        this.thingsPaidFor = thingsPaidFor;
        this.toPay = toPay;
    }
}
