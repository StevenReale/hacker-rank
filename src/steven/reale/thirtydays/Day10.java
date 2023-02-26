package steven.reale.thirtydays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Given a base-10 integer, n, convert it to binary (base-2). Then find and print the base-10 integer denoting the
maximum number of consecutive 1's in n's binary representation.
 */

public class Day10 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        bufferedReader.close();

        String binary = "";
        while (n > 0) {
            binary = n % 2 + binary;
            n /= 2;
        }

        int consecutiveOneCount = 0;
        int maxCount = consecutiveOneCount;
        boolean consecutive = false;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                if (consecutive) consecutiveOneCount++;
                else {
                    consecutiveOneCount = 1;
                }
                consecutive = true;
            } else {
                consecutive = false;
            }
            maxCount = Math.max(maxCount, consecutiveOneCount);
        }

        System.out.println(maxCount);
    }

}
