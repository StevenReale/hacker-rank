package steven.reale.thirtydays;

import java.io.*;

/*
Given an integer, n, print its first 10 multiples. Each multiple n * i  ( where 1 <= i <= 10 ) should be printed on
a new line in the form: "n x i = result".
 */

public class Day5 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        bufferedReader.close();

        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i) );
        }
    }

}
