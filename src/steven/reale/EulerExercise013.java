package steven.reale;

import java.math.BigInteger;
import java.util.Scanner;

/*
Sums n 50-digit integers and returns the first 10 digits of the result.
 */

public class EulerExercise013 {
    public static void main(String[] args) {
        BigInteger sum = new BigInteger("0");

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String nextValue = scanner.nextLine();
            sum = sum.add(BigInteger(nextValue));

        }
        String resultString = sum.toString();
        System.out.println(resultString.substring(0,10));

    }
}
