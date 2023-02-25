package steven.reale.euler;

import java.util.ArrayList;
import java.util.List;

public class EulerExercise010 {

    private static long sumOfPrimesUnderN(int given, List<Integer> primes) {
        int index = 0;
        long sum = 0;
        while (index < primes.size() && primes.get(index) <= given) {
            System.out.println(index + " " + primes.get(index));
            sum += primes.get(index);
            index++;
        }
        return sum;

    }

    private static boolean isPrime(int testNum) {

        for (int i = 3; i < Math.sqrt(testNum) + 1; i += 2) {
            if (testNum % i == 0) {
                return false;
            }
        }

        return true;
    }
    private static List<Integer> getPrimeList() {
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 3; i < 1000000; i += 2) {
            if (isPrime(i)){
                primes.add(i);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        List<Integer> primes = getPrimeList();

        System.out.println(sumOfPrimesUnderN(1000000, primes));
    }
}

//build two parts. First part generates list up to max specification. Second part creates an array using the first
//part. For HackerRank, I do this manually, but the code that I submit to Github does this automatically

