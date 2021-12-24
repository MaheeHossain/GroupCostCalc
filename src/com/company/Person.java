package com.company;

import java.util.ArrayList;

public class Person {
    public String name;
    public String bsb;
    public String accountNumber;
    public ArrayList<Payment> thingsPaidFor;
    public ArrayList<String> toPay;

    public Person(String name, String bsb, String accountNumber, ArrayList<Payment> thingsPaidFor, ArrayList<String> toPay) {
        this.name = name;
        this.bsb = bsb;
        this.accountNumber = accountNumber;
        this.thingsPaidFor = thingsPaidFor;
        this.toPay = toPay;
    }

    public String getName() {
        return name;
    }

    public String getBsb() {
        return bsb;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public ArrayList<Payment> getThingsPaidFor() {
        return thingsPaidFor;
    }

    public void setThingsPaidFor(ArrayList<Payment> thingsPaidFor) {
        this.thingsPaidFor = thingsPaidFor;
    }

    public ArrayList<String> getToPay() {
        return toPay;
    }

    public void setToPay(ArrayList<String> toPay) {
        this.toPay = toPay;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", bsb='" + bsb + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", thingsPaidFor=" + thingsPaidFor +
                ", toPay=" + toPay +
                '}';
    }
}
