package steven.reale;

import java.util.HashMap;
import java.util.Map;

public class EulerExercise017 {

    final static long ONE_TRILLION = 1_000_000_000_000L;
    final static long ONE_BILLION = 1_000_000_000L;
    final static long ONE_MILLION = 1_000_000L;
    final static long ONE_THOUSAND = 1_000;

    private static String numToWord(long given) {
        String output = "";

        if (given >= ONE_TRILLION) {
            output += "One Trillion";
            given -= ONE_TRILLION;
        }

        String currentNum = "";
        if (given >= ONE_BILLION) {
            if (!output.equals("")) output = output + " ";
            output = output + parseNum(given, ONE_BILLION) + " Billion";
            currentNum = Long.toString(given);
            given = Long.parseLong(currentNum.substring(currentNum.length() - 9));
        }

        if (given >= ONE_MILLION) {
            if (!output.equals("")) output = output + " ";
            output = output + parseNum(given, ONE_MILLION) + " Million";
            currentNum = Long.toString(given);
            given = Long.parseLong(currentNum.substring(currentNum.length() - 6));
        }

        if (given >= ONE_THOUSAND) {
            if (!output.equals("")) output = output + " ";
            output = output + parseNum(given, ONE_THOUSAND) + " Thousand";
            currentNum = Long.toString(given);
            given = Long.parseLong(currentNum.substring(currentNum.length() - 3));
        }

        if (given > 0) {
            if (!output.equals("")) output = output + " ";
            output = output + parseHundred(Long.toString(given));
        }

        return output;
    }

    private static String parseNum(long given, long scale) {
        int lengthChopper = 0;
        int intScale = (int) scale;
        switch (intScale) {
            case 1_000_000_000:
                lengthChopper = 9;
                break;
            case 1_000_000:
                lengthChopper = 6;
                break;
            case 1_000:
                lengthChopper = 3;
        }
        String currentNum = Long.toString(given);
        currentNum = currentNum.substring(0, currentNum.length() - lengthChopper);
        return parseHundred(currentNum);
    }

    private static String parseHundred(String hundred) {
        final Map<Integer, String> numWords = populateNumWords();
        String hundredString = "";

        if (Integer.parseInt(hundred) >= 100) {
            hundredString += numWords.get(Integer.parseInt(hundred.substring(0, 1))) + " " + "Hundred";
            hundred = hundred.substring(1);
        }

        int currentNum = Integer.parseInt(hundred);
        if (currentNum > 0) {
            if (!hundredString.equals("")) hundredString = hundredString + " ";
            if (currentNum >= 20) {
                int tens = 0;
                while (currentNum >= 10) {
                    tens += 10;
                    currentNum -= 10;
                }
                hundredString = hundredString + numWords.get(tens);
            }

            if (currentNum > 0) {
                if (!hundredString.equals("") && !hundredString.substring(hundredString.length()-1).equals(" ")) hundredString = hundredString + " ";
                hundredString = hundredString + numWords.get(currentNum);
            }
        }

        return hundredString;
}

    private static Map<Integer, String> populateNumWords() {
        Map<Integer, String> numWords = new HashMap<>();
        numWords.put(1, "One");
        numWords.put(2, "Two");
        numWords.put(3, "Three");
        numWords.put(4, "Four");
        numWords.put(5, "Five");
        numWords.put(6, "Six");
        numWords.put(7, "Seven");
        numWords.put(8, "Eight");
        numWords.put(9, "Nine");
        numWords.put(10, "Ten");
        numWords.put(11, "Eleven");
        numWords.put(12, "Twelve");
        numWords.put(13, "Thirteen");
        numWords.put(14, "Fourteen");
        numWords.put(15, "Fifteen");
        numWords.put(16, "Sixteen");
        numWords.put(17, "Seventeen");
        numWords.put(18, "Eighteen");
        numWords.put(19, "Nineteen");
        numWords.put(20, "Twenty");
        numWords.put(30, "Thirty");
        numWords.put(40, "Forty");
        numWords.put(50, "Fifty");
        numWords.put(60, "Sixty");
        numWords.put(70, "Seventy");
        numWords.put(80, "Eighty");
        numWords.put(90, "Ninety");

        return numWords;
    }

    public static void main(String[] args) {
        System.out.println(numToWord(120000));
    }
}
