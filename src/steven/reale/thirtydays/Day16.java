package steven.reale.thirtydays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    Read a string, S, and print its integer value; if S cannot be converted to an integer,
    print "Bad String".
 */

public class Day16 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();
        try {
            int newNum = Integer.parseInt(S);
            System.out.println(newNum);
        } catch (Exception e) {
            System.out.println("Bad String");
        }

        bufferedReader.close();
    }

}
