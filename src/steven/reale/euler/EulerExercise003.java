package steven.reale.euler;

import java.util.*;

/*
Returns the largest prime factor of a given N.
 */

public class EulerExercise003 {

    private static List<Long> listOfPrimes = new ArrayList<>();

    private static long largestPrimeFactor(long startingNum) {
        if (listOfPrimes.size() == 0) {
            listOfPrimes.add(2L);
            listOfPrimes.add(3L);
        }

        long currentPrime = listOfPrimes.get(0);
        long lastPrimeOfList = listOfPrimes.get(listOfPrimes.size() - 1);
        int currentListIndex = 0;

        while (currentPrime <= Math.sqrt(startingNum)) {
            if (currentPrime * currentPrime == startingNum) {
                return currentPrime;
            }

            while (startingNum % currentPrime == 0) {
                startingNum /= currentPrime;
            }

            if (currentPrime < lastPrimeOfList) {
                currentListIndex++;
                currentPrime = listOfPrimes.get(currentListIndex);
            } else {
                currentPrime = getNextPrime(currentPrime);
            }
        }

        return startingNum;
    }

    private static long getNextPrime(long previousPrime) {
        long nextPrime = previousPrime + 2;
        boolean confirmedNotPrime = false;

        while (true) {
            for (long testPrime : listOfPrimes) {
                if (nextPrime % testPrime == 0) {
                    confirmedNotPrime = true;
                    break;
                }
            }

            if (confirmedNotPrime) {
                nextPrime += 2;
                confirmedNotPrime = false;
            } else {
                listOfPrimes.add(nextPrime);
                return nextPrime;
            }

        }
    }

    public static void main(String[] args) {
        System.out.println(largestPrimeFactor(25));
    }

}
