package steven.reale;
import java.util.Scanner;

public class EulerExercise002 {

    public static long evenFib(long maxValue) {
        long evenSum = 0;
        long firstDigit = 1;
        long secondDigit = 1;
        long nextDigit = 0;

        while (nextDigit < maxValue) {
            if (nextDigit % 2 == 0) evenSum += nextDigit;
            firstDigit = secondDigit;
            secondDigit = nextDigit;
            nextDigit = firstDigit + secondDigit;
        }

        return evenSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(evenFib(n));
        }
    }
}
