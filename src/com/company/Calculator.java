package com.company;

import java.io.FileReader;
import java.util.ArrayList;

public class Calculator {
    static Calculator calculator;
    public ArrayList<Commodity> commodityList;
    public ArrayList<Person> personList;

    public static void readFile(String file) {
        try {
            // Create an object of filereader
            // class with CSV file as a parameter.
            FileReader filereader = new FileReader(file);

            // create csvReader object passing
            // file reader as a parameter
//            CSVReader csvReader = new CSVReader(filereader);
            String[] nextRecord;

            // we are going to read data line by line
//            while ((nextRecord = csvReader.readNext()) != null) {
//                for (String cell : nextRecord) {
//                    System.out.print(cell + "\t");
//                }
//                System.out.println();
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
	// write your code here
    }
}
