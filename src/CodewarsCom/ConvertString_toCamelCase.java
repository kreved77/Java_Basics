package CodewarsCom;

/*
https://www.codewars.com/kata/517abf86da9663f1d2000003
*/

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
}
