package steven.reale.euler;

import java.util.HashMap;
import java.util.Map;

/*
Returns the smallest positive number that is divisible by 1 through a given N
 */

public class EulerExercise005 {

    private static int allMultiples(int givenNum) {
        if (givenNum == 1) return 1;

        Map<Integer, Integer> multiples = new HashMap<>();
        multiples.put(2, 1);
        boolean noMultiple;
        int result = 1;

        for (int i = 3; i <= givenNum; i++) {
            noMultiple = true;
            for (Map.Entry<Integer, Integer> currentPrime : multiples.entrySet()) { //refactoring with hashmaps. Start here
                int testNum = i;
                int timesDivided = 0;
                int currentInt = currentPrime.getKey();


                while (testNum % currentInt == 0) {
                    timesDivided++;
                    noMultiple = false;
                    testNum /= currentInt;

                }
                if (currentPrime.getValue() < timesDivided) {
                    multiples.put(currentInt, timesDivided);
                }
            }
            if (noMultiple) {
                multiples.put(i, 1);
                }
        }
        for (Integer prime : multiples.keySet()) {
            result *= Math.pow(prime, multiples.get(prime));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(allMultiples(10));
    }
}
