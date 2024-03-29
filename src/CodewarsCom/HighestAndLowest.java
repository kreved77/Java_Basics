package CodewarsCom;

/*
https://www.codewars.com/kata/554b4ac871d6813a03000035
*/

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class HighestAndLowest {
    public static void main(String[] args) {

        // Test DATA
//        String quote = "1 2 3 4 5";
//        String quote = "1 2 -3 4 5";
//        String quote = "1 9 3 4 -5";
        String quote = "8 3 -5 42 -1 0 0 -9 4 7 4 -4";
//        String quote = "8 3 -5 42aaaaa -1 0 0 -9 4 7 4 -4";
//        String quote = "8.0 3 -5 4.2aaaaa -1 0 0 -9 4 7 4 -4";
//        String quote = "";
//        String quote = null;

        System.out.println(highAndLow(quote));
        System.out.println(highAndLowWithFormatException(quote));
        System.out.println(highAndLow2(quote));
        System.out.println(highAndLow3(quote));
    }

    public static String highAndLow(String numbers) {
        // Code here or
        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        for (String e : numbers.split(" ")) {
//            System.out.println("e = " + e);
//            if ( Integer.parseInt(e) > max) {
//                max = Integer.valueOf(e);
//            }
//            if ( Integer.parseInt(e) < min){
//                min = Integer.valueOf(e);
//            }
            int value = Integer.parseInt(e);
            max = value > max ? value : max;
            min = value < min ? value : min;
        }
//        return (max + " " + min);
        return String.format("%s %s", max, min);
    }

    public static String highAndLowWithFormatException(String numbers) {
        // Code here or

        if (!numbers.matches("[\\-0-9 ]+")) throw new RuntimeException("NumberFormatException - not a valid input.");
//        if (numbers == null || !numbers.matches("[\\-0-9 ]+")) return null;

        Integer max = Integer.MIN_VALUE;
        Integer min = Integer.MAX_VALUE;
        for (String e : numbers.split(" ")) {
            try{
                int value = Integer.parseInt(e);
                max = value > max ? value : max;
                min = value < min ? value : min;
            }
            catch (NumberFormatException ex){
                System.out.println("NumberFormatException - not a valid input.");
                ex.printStackTrace();
            }
        }
        return String.format("%s %s", max, min);
    }

    public static String highAndLow2(String numbers) {
        // Code here or
        List<Integer> list = new ArrayList<>();
        for (String e : numbers.split(" ")) {
            list.add(Integer.parseInt(e));
        }
        Collections.sort(list);
        return String.format("%s %s", list.get(list.size() - 1), list.get(0));
    }

    public static String highAndLow3(String numbers) {
        // Code here or
        List<Integer> list = Arrays.stream(numbers.split("\\s"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return ("%s %s" .formatted(Collections.max(list), Collections.min(list)) );
    }
}
