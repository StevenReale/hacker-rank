package steven.reale.thirtydays;

import java.util.Scanner;

/*
    A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself.
    Given a number, n, determine and print whether it is "Prime" or "Not prime". If possible, come up with an
    O(sqrt(n)) algorithm.
 */

public class Day25 {

    private static boolean isPrime(int n) {
        if (n == 2) {
            return true;
        }
        else if (n == 1 || n % 2 == 0) return false;
        else {
                for (int i = 3; i < Math.sqrt(n) + 1 ; i += 2) {
                    if (n % i == 0) {
                        return false;
                    }
                }
            }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int i = 0; i < testCases; i++) {
            if (isPrime(in.nextInt())) System.out.println("Prime");
            else System.out.println("Not prime");
        }
    }
}
