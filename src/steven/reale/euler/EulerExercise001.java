package steven.reale.euler;

/*
    Returns the sum of all multiples of 3 and 5 that are less than a given N.
 */

public class EulerExercise001 {

    private static long multipleSum (long n) {
        long multiplesOfThree = (n - 1) / 3;
        long multiplesOfFive = (n - 1) / 5;
        long multiplesOfFifteen = (n - 1) / 15;
        long sumOfAllThrees = sumOfAll(multiplesOfThree, 3);
        long sumOfAllFives = sumOfAll(multiplesOfFive, 5);
        long sumOfAllFifteens = sumOfAll(multiplesOfFifteen, 15);

        return sumOfAllThrees + sumOfAllFives - sumOfAllFifteens;
    }

    private static long sumOfAll(long multiplesCount, long multiplesOf) {
        return multiplesCount * (multiplesCount + 1) * multiplesOf / 2;
    }

    private static long multipleSumBruteForce (int n) {
        int maxLoop = n;
        long runningSum = 0;
        for (int i = 3; i < maxLoop; i++) {
            if (i % 3 == 0 || i % 5 ==0) {
                runningSum += i;
            }
        }
        return runningSum;
    }

    public static void main(String[] args) {
        System.out.println(multipleSum(1000000000));

    }

}
