package steven.reale.euler;

import java.util.HashMap;

public class EulerExercise021 {
    private static HashMap<Integer, Integer> divisorSums = new HashMap<>();

    private static int amicable(int n) {
        int counter = 2;
        int sum = 0;
        while (counter < n) {
            int divisorSum = getDivisorSum(counter);
            int potentialAmicable = getDivisorSum(divisorSum);
            if (counter == potentialAmicable && divisorSum != potentialAmicable && potentialAmicable < n) {
                sum += counter;
            }
            counter++;
        }
        return sum;
    }

    private static int getDivisorSum(int value) {
        if (divisorSums.containsKey(value)){
            return divisorSums.get(value);
        }
        int sum = 0;
        for (int i = 1; i <= Math.sqrt(value); i++){
            if (i == Math.sqrt(value)) {
                sum += Math.sqrt(value);
            } else if ( value % i == 0) {
                sum += i;
                if (i > 1) {
                    sum += value / i;
                }
            }
        }
        divisorSums.put(value, sum);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(amicable(300));
    }
}
