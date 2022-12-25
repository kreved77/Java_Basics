package CodewarsCom;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/5390bac347d09b7da40006f6
*/

public class JadenCasingStrings {
    public static void main(String[] args) {

        // Test DATA
//        String quote = "most trees are blue";
//        String quote = "mOsT tReEs aRe bLUe";
//        String quote = "";
//        String quote = null;
//        String quote = "   aa a  an   a most trEEs are blue and very beautiful, and a super joy!";
        String quote = "aa a  an   a most trEEs are blue and very beautiful, and a super joy!";

        System.out.println(toJadenCase(quote));
        System.out.println(toJadenCase2(quote));
        System.out.println(toJadenCase3(quote));
    }

    public static String toJadenCase(String phrase) {
        // TODO put your code below this comment
        if (phrase == null  || phrase.isEmpty()) return null;

        String result = "";
        phrase = phrase.toLowerCase();

        for (int i = 0; i < phrase.length(); i++) {
            int indexSpace = phrase.substring(i,phrase.length()).indexOf(" ");
//            System.out.println("indexSpace= " + indexSpace);
            if (indexSpace > 0) {
                result = result + phrase.substring(i, i + 1).toUpperCase() + phrase.substring(i + 1, i + indexSpace) + " ";
//                System.out.println("result= " + result);
                i = i + indexSpace;
            } else if (indexSpace == 0) {
            } else {
                result = result + phrase.substring(i, i+1).toUpperCase() + phrase.substring(i+1);
                i = phrase.length();
            }
        }

        return result;
    }

    public static String toJadenCase2(String phrase) {
        // TODO put your code below this comment

        if(phrase == null || phrase.isEmpty()) return null;

        String result = "";
        for (String word : phrase.toLowerCase().split("\\s+")){
            result += " " + word.substring(0,1).toUpperCase() + word.substring(1);
        }

        return result.substring(1);
    }

    public static String toJadenCase3(String phrase) {
        // TODO put your code below this comment
        if (phrase == null || phrase.isEmpty()) return null;

        return Arrays.stream(phrase.split("\\s+"))      // \\s+ is a regular expression for one or more spaces
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));

    }
}
