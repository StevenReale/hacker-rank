package steven.reale.thirtydays;

import java.util.Scanner;

/*
Given a string, S, of length N that is indexed from 0 to N-1, print its even-indexed and odd-indexed characters as 2
space-separated strings on a single line.

Example:
    s = adbecf
    Output: "abc def"
 */

public class Day6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String parseString = scanner.nextLine();
            for (int even = 0; even < parseString.length(); even += 2) {
                System.out.print(parseString.charAt(even));
            }
            System.out.print(" ");

            for (int odd = 1; odd < parseString.length(); odd += 2) {
                System.out.print(parseString.charAt(odd));
            }
            System.out.println();
        }

        scanner.close();
    }

}
