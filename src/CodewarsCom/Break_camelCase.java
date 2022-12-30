package CodewarsCom;

import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/5208f99aee097e6552000148
*/

public class Break_camelCase {
    public static void main(String[] args) {
        String phrase = "camelCasing";
//        String phrase = "camelCasingKNnogesaohInfsohoGnfpJtmfsaoihIfsEhise";
//        String phrase = "";
        System.out.println(camelCase(phrase));
        System.out.println(camelCase2(phrase));
        System.out.println(camelCase3(phrase));
        System.out.println(camelCase4(phrase));
    }

    private static String camelCase(String input) {
        String result = "";
        if (input != null && !input.equals("")){
            for (int i = 0; i < input.length(); i++){
//                Character c = input.charAt(i);
                if (Character.isUpperCase(input.charAt(i))){
                    result = result + " ";
                }
//                result = result + input.substring(i,i+1).toLowerCase();
                result = result + input.charAt(i);
            }
        }
        return result;
    }

    private static String camelCase2(String input) {
        String result = "";
        if (input != null && !input.equals("")){
            for (int i = 0; i < input.length(); i++){
                result += Character.isUpperCase(input.charAt(i)) ? " " + input.charAt(i) : input.charAt(i);
            }
        }
        return result;
    }

    private static String camelCase3(String input) {
        String result = "";
        if (input != null && !input.equals("")){
            result = input.replaceAll("([A-Z])", " $1");
        }
        return result;
    }

    private static String camelCase4(String input) {
        String result = "";
        if (input != null && !input.equals("")){
            result = input.chars()
                    .mapToObj(letter -> Character.isUpperCase(letter) ? " " + String.valueOf((char) letter) : String.valueOf((char) letter))
                    .collect(Collectors.joining());

        }
        return result;
    }
}
