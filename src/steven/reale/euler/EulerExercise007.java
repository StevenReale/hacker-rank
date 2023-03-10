package steven.reale.euler;

import java.util.ArrayList;
import java.util.List;

/*
    Given N, returns the Nth prime number
 */

public class EulerExercise007 {

    private static List<Integer> primeList = new ArrayList<>();

    private static int nthPrime(int testNum) {
        if (primeList.size() == 0) {
            primeList.add(2);
            primeList.add(3);
        }

        int currentPrime = primeList.get(primeList.size() - 1) + 2;

        while (primeList.size() < testNum) {

            boolean noDivisors = true;
            for (Integer prime : primeList) {
                if (prime >= Math.sqrt(currentPrime) + 1) {
                    break;
                } else if (currentPrime % prime == 0) {
                    noDivisors = false;
                    break;
                }
            }
            if (noDivisors == true) {
                primeList.add(currentPrime);
            }

            currentPrime += 2;
        }

        return primeList.get(testNum - 1);
    }

    public static void main(String[] args) {
        System.out.println(nthPrime(6));
    }
}
