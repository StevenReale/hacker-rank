package steven.reale.euler;

import java.math.BigInteger;

/*
Given an M x N grid, where M <= N, returns the number of different paths from top left to bottom right, modulo 10^9 + 7
 */

public class EulerExercise015 {
    private static BigInteger gridPaths(BigInteger smaller, BigInteger larger) {

        //Calculates (smaller + larger) choose (smaller) using the procedure outlined here: https://stackoverflow.com/a/2929897
        BigInteger N = smaller.add(larger);

        BigInteger currentNChooseK = BigInteger.ONE;
        for (BigInteger K = BigInteger.ZERO; K.compareTo(smaller) < 0; K = K.add(BigInteger.ONE)) {
            currentNChooseK = currentNChooseK.multiply(N.subtract(K)).divide(K.add(BigInteger.ONE));
        }
        return currentNChooseK.mod(new BigInteger("1000000007"));
    }

    public static void main(String[] args) {
        System.out.println(gridPaths(new BigInteger("3"), new BigInteger("2")));
    }
}
