package com.company;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVReader {

    public static void main(String[] args) {
        final String folder = "C:\\Users\\mahee\\Desktop\\Projects\\GroupCostCalc\\csv\\";
        String path = folder + "Sample.csv";
        String line = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                String[] values = line.split(",");
                System.out.println(values[0]);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
