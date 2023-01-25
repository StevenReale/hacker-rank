package steven.reale.euler;

import java.util.HashMap;
import java.util.Map;

/*
Finds the largest starting number for the longest Collatz chain with a starting number smaller than a given N.
 */

public class EulerExercise014 {
    private static Map<Long, Long> collatzPairs = new HashMap<>();

    private static long collatz (long startingNum) {

        if (collatzPairs.size() == 0) {
            collatzPairs.put(1L, 1L);

        }
        long maxChainLength = 1;
        long maxChainIndex = 1;
        for (long i = 1; i <= startingNum; i++) {

            if (collatzPairs.get(i) == null) {
                generateCollatz(i);
            }
            if (collatzPairs.get(i) >= maxChainLength) {
                maxChainIndex = i;
                maxChainLength = collatzPairs.get(i);
            }
        }

        return maxChainIndex;
    }

    private static long generateCollatz(long startingNum) {
        long currentCollatz = startingNum;
        long nextCollatz;
        long chainLength = 0;
        while (collatzPairs.get(currentCollatz) == null) {
            if (currentCollatz % 2 == 0) {
                nextCollatz = currentCollatz / 2;
            } else {
                nextCollatz = 3 * currentCollatz + 1;
            }
            chainLength = generateCollatz(nextCollatz) + 1;
            collatzPairs.put(currentCollatz, chainLength);

        }
        return collatzPairs.get(currentCollatz);
    }


    public static void main(String[] args) {
        System.out.println(collatz(15));
    }
}
