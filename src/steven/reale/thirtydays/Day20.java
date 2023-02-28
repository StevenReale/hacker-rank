package steven.reale.thirtydays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/*
    Given an array, a, of size n distinct elements, sort the array in ascending order using the Bubble Sort algorithm
    above. Once sorted, print three lines describing the number of swaps, and the first and last elements of the
    sorted array.
*/

public class Day20 {

//given code begins here
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        bufferedReader.close();
//given code ends here

        boolean hasSwapped = true;
        int totalSwaps = 0;

        while (hasSwapped) {

            hasSwapped = false;

            for (int i = 0; i < a.size() - 1; i++) {
                int temp;
                if (a.get(i + 1) < a.get(i)) {
                    temp = a.get(i);
                    a.set(i, a.get(i+1));
                    a.set(i+1, temp);
                    totalSwaps++;
                    hasSwapped = true;
                }
            }
        }

        System.out.println("Array is sorted in " + totalSwaps + " swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size()-1));

    }

}
