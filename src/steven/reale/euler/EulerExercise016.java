package steven.reale.euler;

import java.math.BigInteger;

public class EulerExercise016 {

    /*
    Given an exponent N, returns the sum of all digits in 2^N
     */

    private static long powerSum(int givenNum) {
        BigInteger base = new BigInteger("2");
        BigInteger result = base.pow(givenNum);
        String output = result.toString();
        long sum = 0;

        for (int i = 0; i < output.length(); i++) {
            sum += Long.parseLong(output.substring(i, i+1));
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(powerSum(7));
    }
}
