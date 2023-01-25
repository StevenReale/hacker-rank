package steven.reale.thirtydays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {

    /*
    Given n names and phone numbers, assemble a phone book that maps friends' names to their respective phone numbers.
    You will then be given an unknown number of names to query your phone book for. For each name queried, print the
    associated entry from your phone book on a new line in the form "name=phoneNumber"; if an entry for name is not
    found, print "Not found" instead.
     */

    public static void main(String []argh){

        Map<String, Integer> phoneBook = new HashMap<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            phoneBook.put(name, phone);
        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here
            if (!phoneBook.containsKey(s)) {
                System.out.println("Not found");
            } else {
                System.out.println(s + "=" + phoneBook.get(s));
            }
        }
        in.close();
    }

}
