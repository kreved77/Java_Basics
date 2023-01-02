package CodewarsCom;

/*
https://www.codewars.com/kata/517abf86da9663f1d2000003
*/

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ConvertString_toCamelCase {
    public static void main(String[] args) {
//        String phrase = "The-Stealth-Warrior";
//        String phrase = "The_Stealth_Warrior";
//        String phrase = "the_Stealth_Warrior";
//        String phrase = "the-Stealth-Warrior";
        String phrase = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
//        String phrase = "river_Street_side_up_south_left_down";
//        String phrase = "";
        System.out.println(toCamelCase(phrase));
        System.out.println(toCamelCase2(phrase));
        System.out.println(toCamelCase3(phrase));
        System.out.println(toCamelCase4(phrase));
    }

    private static String toCamelCase(String s) {
        String result = "";
        if (s != null && !s.equals("")){
            for (int i = 0; i < s.length(); i++){
                result += s.substring(i,i+1).equals("_") || s.substring(i,i+1).equals("-") ? s.substring(++i,i+1).toUpperCase() : s.substring(i,i+1);
            }
        }
        return result;
    }

    private static String toCamelCase2(String s) {
        String result = "";
        List<String> sList = Arrays.stream(s.split("([-_])"))
                .toList();
        result = sList.get(0) + sList.stream().skip(1)
                .map(w -> Character.toUpperCase((char) w.charAt(0)) + w.substring(1))
                .collect(Collectors.joining());
        return result;
    }

    private static String toCamelCase3(String s) {
        String[] arr = s.split("[-_]+");
        return Arrays.stream(arr)
                .skip(1)
                .map(w -> w.substring(0,1).toUpperCase().concat(w.substring(1)))
                .reduce(arr[0], String::concat);
    }

    private static String toCamelCase4(String s) {

        return Pattern.compile("[-|_](.)").matcher(s)
                .replaceAll(w -> w.group(1).toUpperCase());
    }
}
