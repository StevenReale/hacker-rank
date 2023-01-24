package steven.reale;

public class EulerExercise004 {

    /*
    Finds the first 6-digit palindromic number less than a given N that is the product of two 3-digit numbers.
     */

    private static int palindrome(int input) {
        String[] strInput = Integer.toString(input).split("");
        int[] intArray = stringArrToIntArr(strInput);
        int testInt;

        //if given integer is already a palindrome, decrements accordingly. Then, it determines the starting 2 or 3 digits with which to construct first palindrome to test
        if (isPalindrome(intArray)) {
            intArray[2] -= 1; // 998 999
        }
        testInt = 100 * intArray[0] + 10 * intArray[1] + intArray[2]; //998


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

    public static void main(String[] args) {
        int num = 999999;
        while (num > 101101) {
            num = palindrome(num);

        }
        //System.out.println(palindrome(821128));
    }
}
