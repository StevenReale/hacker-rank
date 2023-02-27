package steven.reale.thirtydays;

import java.util.Scanner;

/*
    The AdvancedArithmetic interface and the method declaration for the abstract divisorSum(n) method are provided for
    you.

    Complete the implementation of Calculator class, which implements the AdvancedArithmetic interface. The
    implementation for the divisorSum(n) method must return the sum of all divisors of n.
 */

//given code begins here
interface AdvancedArithmetic{
    int divisorSum(int n);
}
//given code ends here

class NewCalculator implements AdvancedArithmetic {
    public int divisorSum(int n) {

        int divisorSum = 1 + n;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if ((double) i == Math.sqrt(n)) {
                divisorSum += i;
            } else if (n % i == 0) {
                divisorSum += i + (n/i);
            }

        }

        return divisorSum;
    }
}

//given code begins here
public class Day19 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();

        AdvancedArithmetic myCalculator = new NewCalculator();
        int sum = myCalculator.divisorSum(n);
        System.out.println("I implemented: " + myCalculator.getClass().getInterfaces()[0].getName() );
        System.out.println(sum);
    }

}
//given code ends here