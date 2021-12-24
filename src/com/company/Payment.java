package com.company;

/**
 * Things person has paid for
 */
public class Payment {
    public String thing;
    public float cost;

    public Payment(String thing, float cost) {
        this.thing = thing;
        this.cost = cost;
    }

    public String getThing() {
        return thing;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return '{'+ thing + ", " + cost + '}';
    }
}
