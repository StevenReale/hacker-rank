package steven.reale;
import java.util.Scanner;

/*
Returns the sum of all even Fibonacci numbers that are less than a given N.
 */

public class EulerExercise002 {

    public static long evenFib(long maxValue) {
        long evenSum = 0;
        long firstDigit = 1;
        long secondDigit = 1;
        long nextDigit = 0;

        while (nextDigit < maxValue) {
            if (nextDigit % 2 == 0) evenSum += nextDigit;
            firstDigit = secondDigit;
            secondDigit = nextDigit;
            nextDigit = firstDigit + secondDigit;
        }

        return evenSum;
    }

    public static void main(String[] args) {
        System.out.println(evenFib(100000000));
    }
}
