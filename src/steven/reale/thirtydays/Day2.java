package steven.reale.thirtydays;

import java.io.*;

/*
Given the meal price (base cost of a meal), tip percent (the percentage of the meal price being added as tip),
and tax percent (the percentage of the meal price being added as tax) for a meal, find and print the meal's total cost.
Round the result to the nearest integer.
 */


public class Day2 {

    public static void solve(double meal_cost, int tip_percent, int tax_percent) {
        // Write your code here
        System.out.println( Math.round(meal_cost + meal_cost * tip_percent / 100 + meal_cost * tax_percent / 100) );
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        double meal_cost = Double.parseDouble(bufferedReader.readLine().trim());

        int tip_percent = Integer.parseInt(bufferedReader.readLine().trim());

        int tax_percent = Integer.parseInt(bufferedReader.readLine().trim());

        solve(meal_cost, tip_percent, tax_percent);

        bufferedReader.close();
    }

}
