package steven.reale.thirtydays;

import java.io.*;

/*
Create a function that, given an integer (2 <= n <= 12), uses recursion to return the value of n!
 */

public class Day9 {

    public static int factorial(int n) {
        if (n == 1) return 1;
        else return n * factorial(n-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int result = factorial(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }

}
