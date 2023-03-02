package steven.reale.thirtydays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/*
    Consider a database table, Emails, which has the attributes First Name and Email ID. Given N rows of data simulating
    the Emails table, print an alphabetically-ordered list of people whose email address ends in @gmail.com.
 */

public class Day28 {

    public static void main(String[] args) throws IOException {
        List<String> names = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, N).forEach(NItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                String firstName = firstMultipleInput[0];

                String emailID = firstMultipleInput[1];

                if (emailID.matches(".*@gmail\\.com$")) {
                    names.add(firstName);
                }

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });

        Collections.sort(names);

        for (String name : names) {
            System.out.println(name);
        }

        bufferedReader.close();
    }
}
