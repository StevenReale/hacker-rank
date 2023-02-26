package steven.reale.thirtydays;

import java.util.*;

/*
    The absolute difference between two integers, a and b, is written as |a-b|. The maximum absolute difference between
    two integers in a set of positive integers, elements, is the largest absolute difference between any two integers
    in elements.

    The Difference class is started for you in the editor. It has a private integer array (elements) for storing N
    non-negative integers, and a public integer (maximumDifference) for storing the maximum absolute difference.

    Task
    Complete the Difference class by writing the following:

        1. A class constructor that takes an array of integers as a parameter and saves it to the elements instance
           variable.
        2. A computeDifference method that finds the maximum absolute difference between any 2 numbers in elements and
           stores it in the maximumDifference instance variable.
 */

class Difference {
    private int[] elements;
    public int maximumDifference;

    // Add your code here
    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        int maxDifference = Math.abs(elements[0] - elements [1]);
        for (int i = 0; i < elements.length - 1; i++) {
            for (int j = i + 1; j < elements.length; j++) {
                int currentDiff = Math.abs(elements[i] - elements [j]);
                maxDifference = Math.max(maxDifference, currentDiff);
            }
        }
        this.maximumDifference = maxDifference;
    }
} // End of Difference class

//given code begins here
public class Day14 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}
//given code ends here