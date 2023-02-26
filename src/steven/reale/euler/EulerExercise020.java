package steven.reale.euler;

import java.math.BigInteger;

public class EulerExercise020 {

    private static long factorialSum(int n) {
        BigInteger nFactorial = factorial(BigInteger.valueOf(n));
        long factorialSum = 0;

        while (nFactorial.compareTo(BigInteger.ZERO) > 0) {
        factorialSum += nFactorial.mod(BigInteger.TEN).longValue();
        nFactorial = nFactorial.divide(BigInteger.TEN);
        }

        return factorialSum;
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.equals(BigInteger.ONE) || n.equals(BigInteger.ZERO)) return BigInteger.ONE;
        else {
           return n.multiply(factorial(n.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {
        System.out.println(factorialSum(1000));
    }
}
