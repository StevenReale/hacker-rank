package steven.reale.euler;

/*
    Accepts N names from console and scores them by multiplying their alphabetical rank by the sum of the score of
    their letters ('A' = 1, 'B' = 2, etc.). Then, returns the score for M queries.
 */

import java.util.*;

public class EulerExercise022 {
    private static HashMap<String, Integer> nameScores = new HashMap<>();

    private static void createNameScoreMap(List<String> names) {
        Collections.sort(names);
        for (int i = 0; i < names.size(); i++) {
            int score = scoreName(names.get(i)) * (i + 1);
            nameScores.put(names.get(i), score);
        }
    }

    private static int scoreName (String name) {
        int sum = 0;
        for (int i = 0; i < name.length(); i++) {
            sum += name.charAt(i) - 64;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();
        for (int i = 0; i<testCases; i++) {
            names.add(scanner.nextLine());
        }

        createNameScoreMap(names);

        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i<queries; i++) {
            String query = scanner.nextLine();
            System.out.println(nameScores.get(query));
        }

        scanner.close();
    }
}
