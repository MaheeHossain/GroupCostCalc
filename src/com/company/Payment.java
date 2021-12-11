package com.company;

/**
 * Things person has paid for
 */
public class Payment {
    public Commodity thing;
    public int cost;

    public Payment(Commodity thing, int cost) {
        this.thing = thing;
        this.cost = cost;
    }

    public Commodity getThing() {
        return thing;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
