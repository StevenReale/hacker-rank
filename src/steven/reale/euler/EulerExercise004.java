package steven.reale.euler;

import java.util.ArrayList;
import java.util.List;

/*
    Finds the first 6-digit palindromic number less than a given N that is the product of two 3-digit numbers.
    Thanks to Douglas Doughty (github.com/douglasdoughty) for working through this solution with me.
*/

public class EulerExercise004 {

    private static int palindrome(int input) {

        for (int i = input - 1; i > 100000; i--) {
            if (isPalindrome(i) && isThreeDigitDivisible(i)) {
                return i;
            }
        }
        return -1;
    }

    //tests if an integer can be expressed as the product of two 3-digit integers
    private static boolean isThreeDigitDivisible(int testNum) {
        for (int testDivisor = 100; testDivisor <= 999; testDivisor++) {
            if (testNum % testDivisor == 0 && testNum / testDivisor >= 100 && testNum / testDivisor <= 999) {
                System.out.println(testNum + " divided by " + testDivisor + " equals " + testNum / testDivisor);
                return true;
            }
        }
        return false;
    }

    private static boolean isPalindrome(int testInt) {
        List<Integer> intList = new ArrayList<>();
        while (testInt > 0) {
            intList.add(testInt % 10);
            testInt /= 10;

        }
        return intList.get(0) == intList.get(5) && intList.get(1) == intList.get(4) && intList.get(2) == intList.get(3);
    }

    public static void main(String[] args) {


        System.out.println(palindrome(999999));
  }
}
