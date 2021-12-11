package com.company;

/**
 * Thing that was paid for and people will have to pay for
 */
public class Commodity {
    public String name;
    public int peoplePaying;
    public int totalCost;

    public Commodity(String name, int peoplePaying, int totalCost) {
        this.name = name;
        this.peoplePaying = peoplePaying;
        this.totalCost = totalCost;
    }

    public String getName() {
        return name;
    }

    public int getPeoplePaying() {
        return peoplePaying;
    }

    public void setPeoplePaying(int peoplePaying) {
        this.peoplePaying = peoplePaying;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }
}
