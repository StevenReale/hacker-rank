package steven.reale.thirtydays;

import java.util.Scanner;

/*
Complete the code below by following the given instructions.
 */

public class Day1 {

    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        /* Declare second integer, double, and String variables. */
        int newInt;
        double newDouble;
        String newString;

        /* Read and save an integer, double, and String to your variables.*/
        // Note: If you have trouble reading the entire String, please go back and review the Tutorial closely.

        newInt = scan.nextInt();
        newDouble = scan.nextDouble();
        scan.nextLine();
        newString = scan.nextLine();

        /* Print the sum of both integer variables on a new line. */
        System.out.println(i + newInt);

        /* Print the sum of the double variables on a new line. */
        System.out.println(d + newDouble);

        /* Concatenate and print the String variables on a new line;
        	the 's' variable above should be printed first. */

        System.out.println(s + newString);

        scan.close();
    }

}
