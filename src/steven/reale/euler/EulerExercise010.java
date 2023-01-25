package steven.reale.euler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Returns the sum of all primes less than a given N.
 */

public class EulerExercise010 {

    // adapted pseudocode from https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes#Pseudocode
    private static int sieveOfEratosthenes(int given){
        if (given < 2) return 0;
        if (given == 2) return 2;

        boolean[] primes = new boolean[given+1];
        Arrays.fill(primes, true);
        int primeSum = 0;

        for (int i = 2; i <= given; i++) {
            if (primes[i]) {
                System.out.println(i + " is prime");
                primeSum += i;
                for (int j = i * i; j <= given; j += i) {
                    primes[j] = false;
                }
            }
        }

        return primeSum;

    }

    private static List<Integer> primes = new ArrayList<>();
    private static List<Integer> primeSums = new ArrayList<>();

    private static int primesUnder(int given) {
        if (primes.size() == 0) {
            primes.add(2);
            primes.add(3);
            primeSums.add(2);
            primeSums.add(5);
        }

        int currentPrimeTest = primes.get(primes.size()-1) + 2;

        if (given < 2) return 0;

        while (true) {
            System.out.println("Last prime is " + primes.get(primes.size() - 1) + " and given is " + given);

            //if given is smaller than last element of primes, then find the index of the next smallest prime, and return the element of primeSums with the same index
            if (currentPrimeTest > given) {
                int minIndex = 0;
                int maxIndex = primes.size() - 1;
                int currentIndex = maxIndex / 2;

                boolean shouldContinue = true;

                while (shouldContinue) {
                    System.out.println("Testing index " + currentIndex + " which has the prime " + primes.get(currentIndex));
                    if (primes.get(currentIndex) < given) {
                        minIndex = currentIndex;
                    } else {
                        maxIndex = currentIndex;
                    }
                    currentIndex = (int) Math.round((maxIndex + minIndex) / 2.0);
                    System.out.println("New current index: " + currentIndex);

                    if (currentIndex == 0 || currentIndex == primes.size() - 1) shouldContinue = false;
                    else if (primes.get(currentIndex) <= given && primes.get(currentIndex + 1) > given) shouldContinue = false;
                }
                return primeSums.get(currentIndex);
            }

            //if given is larger than last element of primes, then populate primes as needed until it appears, populating primeSums as we go
            else {
                int newPrimeSum = 0;
                while (currentPrimeTest <= given + 1) {
                    boolean primeFound = true;
                    for (Integer prime : primes) {
                        if (currentPrimeTest % prime == 0) {
                            primeFound = false;
                            break;
                        }
                    }
                    if (primeFound) {
                        System.out.println("Adding prime " + currentPrimeTest);
                        primes.add(currentPrimeTest);
                        newPrimeSum = currentPrimeTest + primeSums.get(primeSums.size() - 1);
                        primeSums.add(newPrimeSum);
                    }
                    currentPrimeTest += 2;
                }

            }
        }


    }

    public static void main(String[] args) {
        System.out.println(sieveOfEratosthenes(13));
    }
}
