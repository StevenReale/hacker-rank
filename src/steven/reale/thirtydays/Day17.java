package steven.reale.thirtydays;

import java.util.Scanner;

/*
    Write a Calculator class with a single method: int power(int,int). The power method takes two integers, n and p,
    as parameters and returns the integer result of n^p. If either n or p is negative, then the method must throw an
    exception with the message: "n and p should be non-negative".
 */

class Calculator {
    int power (int base, int exponent) throws Exception {
        if (base < 0 || exponent < 0) {
            throw new Exception("n and p should be non-negative");
        }
        return (int) Math.pow(base, exponent);
    }
}

//given code begins here

class Day17 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int p = in.nextInt();
            Calculator myCalculator = new Calculator();
            try {
                int ans = myCalculator.power(n, p);
                System.out.println(ans);
            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        in.close();
    }
}
//given code ends here