package steven.reale.euler;

/*
    Finds the largest product a*b*c where a, b, and c are a Pythagorean triple such that a, b, and c sum to a given N
 */

public class EulerExercise009 {

    /*
    Method adapts procedure found here: https://r-knott.surrey.ac.uk/Pythag/pythag.html Section 2.1
     */
    private static int pythagTriple(int tripleSum) {
        int a;
        int b;
        int c;
        int maxValue = -1;

        for (a = 3; a < tripleSum / 3; a++) {

            for (int testFactor = 1; testFactor <= a; testFactor++) {

                if ((a*a) % testFactor == 0) {

                    int P = (a*a) / testFactor;
                    int Q = testFactor;
                    b = (P - Q) / 2;
                    c = (P + Q) / 2;

                    if (P % 2 == Q % 2 && (a + b + c == tripleSum) && a * b * c > maxValue) maxValue = a * b * c;
                }
            }
        }

    return maxValue;

    }

    private static int pythagTripleBrute(int tripleSum) {
        int a;
        int b;
        int c;
        int maxValue = -1;

        for (a = 1; a < tripleSum/2; a++) {
            for (b = 1; b < tripleSum/2; b++) {
                c = tripleSum - a - b;
                if (c <= 0) break;
                if (a*a + b*b == c*c && a*b*c > maxValue) maxValue = a*b*c;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
        System.out.println(pythagTriple(1000));
    }
}
