package steven.reale;

public class EulerExercise004 {

    /*
    Finds the first 6-digit palindromic number less than a given N that is the product of two 3-digit numbers.
     */

    public static int palindrome(int input) {
        String[] strInput = Integer.toString(input).split("");
        int[] intArray = stringArrToIntArr(strInput);
        int testInt;

        //if given integer is already a palindrome, decrements accordingly. Then, it determines the starting 2 or 3 digits with which to construct first palindrome to test
        if (isPalindrome(intArray)) {
            intArray[2] -= 1;
        }
        testInt = 100 * intArray[0] + 10 * intArray[1] + intArray[2];


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
    public static boolean isThreeDigitDivisible(int testNum) {
        for (int testDivisor = 100; testDivisor <= 999; testDivisor++) {
            if (testNum % testDivisor == 0 && testNum / testDivisor >= 100 && testNum / testDivisor <= 999) {
                System.out.println(testNum + " divided by " + testDivisor + " equals " + testNum / testDivisor);
                return true;
            }
        }
        return false;
    }

    //constructs a 6-digit palindrome given first three digits
    public static int makePalindrome(int startNum) {
        int[] intArray = stringArrToIntArr(Integer.toString(startNum).split(""));
        int palindrome = intArray[0] + 10 * intArray[1] + 100 * intArray[2] + 1000 * intArray[2] + 10000 * intArray[1] + 100000 * intArray[0];
        System.out.println("Palindrome found: " + palindrome);
        return palindrome;
    }


    //given an array of integers cast as strings, returns a corresponding array of integers
    public static int[] stringArrToIntArr(String[] inputString) {
        int numberOfDigits = inputString.length;
        int[] intArray = new int[numberOfDigits];

        for (int i = 0; i < numberOfDigits; i++) {
            intArray[i] = Integer.parseInt(inputString[i]);
        }
        return intArray;
    }

    //test if a 6-entry integer array is a palindrome
    public static boolean isPalindrome(int[] intArray) {
        int arrLength = intArray.length;
        return (intArray[0] == intArray[arrLength - 1] && intArray[1] == intArray[arrLength - 2] && (intArray[2] == intArray[3]) || arrLength == 5);
    }

    public static void main(String[] args) {
        System.out.println(palindrome(199199));
    }
}
