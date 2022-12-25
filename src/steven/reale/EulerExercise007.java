package steven.reale;

import java.util.ArrayList;
import java.util.List;

public class EulerExercise007 {

    private static int nthPrime(int testNum) {
        List<Integer> primeList = new ArrayList<>();
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
