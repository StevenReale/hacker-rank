package steven.reale;

import java.util.ArrayList;
import java.util.List;

public class EulerExercise012 {

    private static int triangular(int given) {
        int triangleIndex = 1;
        int triangle;

        while(true) {
            triangle = triangleIndex * (triangleIndex + 1) / 2;
            if (numDivisors(triangle) > given) return triangle;
            triangleIndex++;
        }

    }

    private static int numDivisors(int triangle) {
        int numDivisors = 0;
        for (int i = 1; i <= Math.sqrt(triangle); i++) {
            if (Math.sqrt(triangle) == i) numDivisors++;
            else if (triangle % i == 0) numDivisors += 2;
        }
        return numDivisors;
    }

    public static void main(String[] args) {
        System.out.println(triangular(4));
    }
}
