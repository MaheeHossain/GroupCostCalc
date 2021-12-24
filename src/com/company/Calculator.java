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
                ArrayList<Payment> thingsPaid = new ArrayList<Payment>();


                /* Make things to pay */
                // Split values[3]. If already in commodity list, add person
                // If not in commodity list, add it with person
                ArrayList<String> toPay = new ArrayList<String>();
                String[] things = values[3].split(" ");
                for (int i=0; i< things.length; i++) {
                    Boolean found = false;
                    // If commodity is in the commodity list
                    for (int j=0; j < commodityList.size(); j++) {
                        if (commodityList.get(j).getName().equals(things[i])) {
                            commodityList.get(j).addPerson();
                            found = true;
                            break;
                        }
                    }
                    // If commodity is new
                    if (!found) {
                        commodityList.add(new Commodity(things[i], 1, 0));
                    }
                    // Add to person's array list
                    toPay.add(things[i]);
                }

                /* Make new person with those values, add to personList */
                Person person = new Person(name, bsb, accNum, thingsPaid, toPay);
                personList.add(person);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public ArrayList<String> createToPay(String things) {
//
//    }

    public static void main(String[] args) {
	// write your code here
        readFile(folder + "Sample.csv");
        for (int i=0; i < personList.size(); i++) {
            System.out.println(personList.get(i).toString());
        }
        System.out.println("\n");
        for (int i=0; i < commodityList.size(); i++) {
            System.out.println(commodityList.get(i).toString());
        }
    }
}
