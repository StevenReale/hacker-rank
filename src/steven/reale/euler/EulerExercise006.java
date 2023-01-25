package steven.reale.euler;

/*
Given an N, returns the absolute difference between a) the sum of all squares integers 1 through N, and b) the square of the sum of all integers 1 through N
 */

public class EulerExercise006 {

    private static long sumSquareDiff(int givenNum) {
        long sumOfSquares = 0;
        for (int i = 1; i <= givenNum; i++) {
            sumOfSquares += i*i;
        }

        long sumOfGiven = givenNum * (givenNum + 1) / 2;
        long squareOfSums = sumOfGiven * sumOfGiven;

        return Math.abs(sumOfSquares - squareOfSums);

    }

    public static void main(String[] args) {
        System.out.println(sumSquareDiff(10));
    }
}
