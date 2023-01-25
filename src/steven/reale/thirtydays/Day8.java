package steven.reale.thirtydays;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day8 {

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
