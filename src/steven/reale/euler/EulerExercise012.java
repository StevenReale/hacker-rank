package steven.reale.euler;

/*
    Returns the first triangular number to have more than a given N divisors
 */

import java.util.HashMap;
import java.util.Scanner;

public class EulerExercise012 {
    private static HashMap<Integer, Integer> divisorMap = new HashMap<Integer, Integer>();
    private static int triangular(int given) {
        int triangleIndex = 1;
        int triangle;

        while(true) {
            triangle = triangleIndex * (triangleIndex + 1) / 2;
            if (numDivisors(triangle) > given) return triangle;
            triangleIndex++;
        }
    }

    private static int numDivisors(int triangle) {
        if(divisorMap.containsKey(triangle)) {
            return divisorMap.get(triangle);
        }

        int numDivisors = 0;
        for (int i = 1; i <= Math.sqrt(triangle); i++) {
            if (Math.sqrt(triangle) == i) numDivisors++;
            else if (triangle % i == 0) numDivisors += 2;
        }
        divisorMap.put(triangle, numDivisors);
        return numDivisors;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i<testCases; i++) {
            int currentTestCase = scanner.nextInt();
            System.out.println(triangular(currentTestCase));
        }
        
        scanner.close();
    }
}
