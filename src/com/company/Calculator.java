package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Calculator {
    // singleton of calculator
    static Calculator calculator;
    // List of all the commodities in the csv file
    public static ArrayList<Commodity> commodityList = new ArrayList<Commodity>();
    // List of all people and their payment details
    public static ArrayList<Person> personList = new ArrayList<Person>();
    public static final String folder = "C:\\Users\\mahee\\Desktop\\Projects\\GroupCostCalc\\csv\\";
    public static final int FIRSTPAYER = 1;

    /**
     *  Reads the csv file and sets the commodityList and personList
     */
    public static void readFile(String file) {
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            /* Read the first line -> we know it won't be empty */
            line = br.readLine();

            /* Reads each line of the csv file  */
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                /* Make the name, bsb, account num */
                String name = values[0];
                String bsb = values[1];
                String accNum = values[2];

                /* Make things paid */
                ArrayList<Payment> thingsPaid = createThingsPaid(values[4]);

                /* Make things to pay */
                ArrayList<String> toPay = createToPay(values[3]);

                /* Make new person with those values, add to personList */
                Person person = new Person(name, bsb, accNum, thingsPaid, toPay);
                personList.add(person);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Splits a line with all personal payments
     * @param line
     * @return
     */
    public static ArrayList<Payment> createThingsPaid (String line) {
        ArrayList<Payment> thingsPaid = new ArrayList<Payment>();
        String[] payments = line.split(";");

        for (int i=0; i< payments.length; i++) {
            // Make each payment into a new payment
            String[] individualPayment = payments[i].split(" ");
            Payment payment = new Payment(individualPayment[0], Float.parseFloat(individualPayment[1]));


            // Add payment to thingsPaid
            thingsPaid.add(payment);
        }
        return thingsPaid;
    }

    /**
     * Split a line with some names of commodities
     * If already in commodity list, add person
     * If not in commodity list, add it with person
     * @param line
     * @return
     */
    public static ArrayList<String> createToPay(String line) {
        // Create arraylist for the strings, and array to put the commodities
        // in the commodities list
        ArrayList<String> toPay = new ArrayList<String>();
        String[] things = line.split(" ");

        // Go through the commodity names in the line
        for (int i=0; i< things.length; i++) {
            Boolean found = false;
            // If commodity is in the commodity list, increase number of
            // people paying for it by 1
            for (int j=0; j < commodityList.size(); j++) {
                if (commodityList.get(j).getName().equals(things[i])) {
                    commodityList.get(j).addPerson();
                    found = true;
                    break;
                }
            }
            // If commodity is new, add it to the list and set number
            // of people paying for it at 1
            if (!found) {
                commodityList.add(new Commodity(things[i], FIRSTPAYER, 0));
            }
            // Add to person's array list
            toPay.add(things[i]);
        }
        return toPay;
    }

    public static void main(String[] args) {
	// write your code here
        readFile(folder + "Sample.csv");
        for (int i=0; i < personList.size(); i++) {
            System.out.println(personList.get(i).toString());
        }
//        System.out.println("\n");
//        for (int i=0; i < commodityList.size(); i++) {
//            System.out.println(commodityList.get(i).toString());
//        }
    }
}
