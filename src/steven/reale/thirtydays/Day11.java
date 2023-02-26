package steven.reale.thirtydays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
    Given a 6 x 6 2D Array, A, we define an hourglass in A to be a subset of values with indices falling in A's
    graphical representation:

    a b c
      d
    e f g

    Calculate the hourglass sum for every hourglass in A, then print the maximum hourglass sum.
 */

public class Day11 {

    public static void main(String[] args) throws IOException {

        //given begins here
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        //given ends here

        int maxSum = -9 * 7; //because hourglasses are 7 cells each, and minimum value per cell is -9
        for (int i = 0; i < 4; i++) {
            int localSum = 0;
            for (int j = 0; j < 4; j++) {
                localSum = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) +
                        arr.get(i+1).get(j+1) + arr.get(i + 2).get(j) + arr.get(i + 2).get(j+1) +
                        arr.get(i + 2).get(j+2);
                maxSum = Math.max(maxSum, localSum);
            }
        }
        System.out.println(maxSum);
    }

}
