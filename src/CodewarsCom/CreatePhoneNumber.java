package CodewarsCom;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
https://www.codewars.com/kata/525f50e3b73515a6db000b83
*/

public class CreatePhoneNumber {
    public static void main(String[] args) {
        int[] test = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        String res = createPhoneNumber(test);
        System.out.println(res);
        System.out.println(createPhoneNumber2(test));
        System.out.println(createPhoneNumber3(test));
        System.out.println(createPhoneNumber4(test));
        System.out.println(createPhoneNumber5(test));
    }


    public static String createPhoneNumber(int[] numbers) {
            // Your code here!
            String template = "(%d%d%d) %d%d%d-%d%d%d%d";
            String result = String.format(template, numbers[0], numbers[1], numbers[2],
                    numbers[3], numbers[4], numbers[5], numbers[6],
                    numbers[7], numbers[8], numbers[9], numbers[0]);
//       System.out.println(result);
            return result;
    }

    public static String createPhoneNumber2(int[] numbers) {
        // Your code here!
        return Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining())
                .replaceFirst("^(\\d{3})(\\d{3})(\\d{4})$", "($1) $2-$3");
    }

    public static String createPhoneNumber3(int[] numbers) {
        // Your code here!
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }

    public static String createPhoneNumber4(int[] numbers) {
        // Your code here!
        String phoneNumber = new String("(xxx) xxx-xxxx");
        for (int i : numbers) {
            phoneNumber = phoneNumber.replaceFirst("x", Integer.toString(i));
        }
        return phoneNumber;
    }

    public static String createPhoneNumber5(int[] numbers) {
        // Your code here!

//         List<String> nn = Collections.singletonList(Arrays.stream(numbers)
//                 .mapToObj(s -> "+some" + s)
//                 .collect(Collectors.joining()));
//         String str = nn.toString();

         String str =  Arrays.toString(numbers)
                 .substring(1,(Arrays.toString(numbers).length()-1))
                 .replace(", ","")
                 .replace("1", "(1")
                 .replace("3", "3) ")
                 .replace("6", "6-");
        return str;

    }
}