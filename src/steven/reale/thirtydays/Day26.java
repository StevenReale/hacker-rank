package steven.reale.thirtydays;

import java.util.Scanner;

/*
    Your local library needs your help! Given the expected and actual return dates for a library book, create a program
    that calculates the fine (if any). The fee structure is as follows:

        1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0).
        2. If the book is returned after the expected return day but still within the same calendar month and year as
           the expected return date, fine = 15 Hackos x (number of days late) .
        3. If the book is returned after the expected return month but still within the same calendar year as the
           expected return date, the fine = 500 Hackos x (number of montsh late) .
        4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000
           Hackos.
 */

public class Day26 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] stringDateReturned = scanner.nextLine().split(" ");
        String[] stringDateDue = scanner.nextLine().split(" ");
        int[] returned = new int[3];
        int[] due = new int[3];
        int hackosOwed;

        for (int i = 0; i < stringDateReturned.length; i++) {
            returned[i] = Integer.parseInt(stringDateReturned[i]);
            due[i] = Integer.parseInt(stringDateDue[i]);
        }

        if (returned[2] > due[2]) hackosOwed = 10000;
        else if (returned[2] == due[2] && returned [1] > due[1]) hackosOwed = 500 * (returned[1] - due[1]);
        else if (returned [1] == due[1] && returned[0] > due[0]) hackosOwed = 15 * (returned[0] - due[0]);
        else hackosOwed = 0;

        System.out.println(hackosOwed);
    }

}
