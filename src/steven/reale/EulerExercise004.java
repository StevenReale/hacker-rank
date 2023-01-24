package steven.reale;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class EulerExercise004 {

    /*
    Finds the first 6-digit palindromic number less than a given N that is the product of two 3-digit numbers.
     */

    private static int palindrome(int input) {
        String[] strInput = Integer.toString(input).split("");
        int[] intArray = stringArrToIntArr(strInput);
        int testInt = 100 * intArray[0] + 10 * intArray[1] + intArray[2];

        //if given integer is already a palindrome, decrements accordingly. Then, it determines the starting 2 or 3 digits with which to construct first palindrome to test
        if (intArray[0] == intArray[5] && intArray[1] == intArray[4] && intArray[2] == intArray[3]) {
            testInt--; // 200 002
        }

        //main processing loop. Calls methods to 1) construct palindromes from testInt, and 2) test whether palindrome can be expressed as product of two integers.
        int testNum;
        while (true) {

            testNum = makePalindrome(testInt);
            if (isThreeDigitDivisible(testNum)) {
                return testNum;
            }
            testInt--;
        }

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

    //constructs a 6-digit palindrome given first three digits
    private static int makePalindrome(int startNum) { //998
        int[] intArray = stringArrToIntArr(Integer.toString(startNum).split(""));
        int palindrome = intArray[0] + 10 * intArray[1] + 100 * intArray[2] + 1000 * intArray[2] + 10000 * intArray[1] + 100000 * intArray[0];

        return palindrome;
    }

    //given an array of integers cast as strings, returns a corresponding array of integers
    private static int[] stringArrToIntArr(String[] inputString) {
        int numberOfDigits = inputString.length;
        int[] intArray = new int[numberOfDigits];

        for (int i = 0; i < numberOfDigits; i++) {
            intArray[i] = Integer.parseInt(inputString[i]);
        }
        return intArray;
    }

    //test if a 6-entry integer array is a palindrome
    private static boolean isPalindrome(int[] intArray) {
        int arrLength = intArray.length;
        return (intArray[0] == intArray[5] && intArray[1] == intArray[4] && (intArray[2] == intArray[3]));
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
        Set<Integer> palindromes = new HashSet<>();
        //run make palindrome for all 101 < n < 999, save each to a set
        for (int i = 100; i <= 999; i++) {
            palindromes.add(makePalindrome(i));
        }
        //run a test all method which checks to see if any are missing from the set, and which ones
        for (int i = 999999; i > 100000; i--) {
            if (isPalindrome(i)) {
                if (!palindromes.contains(i)) {
                    System.out.println(i + " was not generated");
                }
            }
        }

        //System.out.println(palindrome(101102));
    }
}
