package CodewarsCom;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/54b42f9314d9229fd6000d9c
*/

public class DuplicateEncoder {

// VER_5
//    static String encode(String word) {
//        return word.toLowerCase()
//                .chars()
//                .mapToObj(i -> String.valueOf((char)i))
//                .map(i -> word.toLowerCase().indexOf(i) == word.toLowerCase().lastIndexOf(i) ? "(" : ")")
//                .collect(Collectors.joining());
//    }


// VER_4
//    static String encode(String word) {
//        final Map<Integer, Long> frequencies = word.codePoints()
//                .map(Character::toLowerCase)
//                .boxed()
//                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        return word.codePoints()
//                .map(Character::toLowerCase)
//                .mapToObj(i -> frequencies.get(i) > 1 ? ")" : "(")
//                .collect(Collectors.joining());
//    }


// VER_3
    static String encode(String word){
        word = word.toLowerCase();
        String result = "";
        for (char c : word.toCharArray()) {
            if (word.chars().filter(ch -> ch == c).count() > 1) {
                result += ")";
            } else {
                result += "(";
            }
        }
        return result;
    }


// VER_2
//    static String encode(String word) {
//        word = word.toLowerCase();
//        String result = "";
//        for (int i = 0; i < word.length(); i++) {
//            char c = word.charAt(i);
//            if (word.indexOf(c) == word.lastIndexOf(c)) {
//                result += "(";
//            } else {
//                result += ")";
//            }
//        }
//        return result;
//    }


// VER_1 (long and bad)
//    static String encode(String word){
//        word = word.toLowerCase();
//        String result = word;
//        Set<String> cSet = new HashSet<>();
//        String c;
//        System.out.println(word + " = new word | word.length()=" + word.length());
//        for (int i = 0; i < word.length(); i++) {
//            c = String.valueOf(word.charAt(i));
//            int ci = word.codePointAt(i);
////            System.out.println(i + " step | next c=" + c + " | int=" + ci);
//            if (!cSet.contains(c)) {
//                cSet.add(c);
//                int count = 0;
////                System.out.println("new c=" + c);
//                for (int j = i; j < word.length(); j++){
//                    if (word.substring(j, j+1).equals(c)){
//                        count++;
////                        System.out.println(count + " add c=" + c);
//                    }
//                }
//
////                System.out.println(count + " of c=" + c);
//                if (c.equals("(")) c = "\\(";
//                if (c.equals(")")) c = "\\)";
//                if (c.equals("[")) c = "\\[";
//                if (c.equals("]")) c = "\\]";
//                if (c.equals("{")) c = "\\{";
//                if (c.equals("}")) c = "\\}";
//                if (c.equals("?")) c = "\\?";
//                if (c.equals("$")) c = "\\$";
//                if (c.equals("&")) c = "\\&";
//                if (c.equals("#")) c = "\\#";
//                if (c.equals("^")) c = "\\^";
//                if (c.equals("+")) c = "\\+";
//                if (c.equals("*")) c = "\\*";
//                if (c.equals("/")) c = "\\/";
//                if (c.equals("|")) c = "\\|";
//                if (ci == 92) {
//                    result = result.substring(0, i) + "~" + result.substring(i+1);
//                } else {
//                    if (count > 1) {
//                        result = result.replaceAll(c, "!");
////                        System.out.println(" >1 change");
//                    } else {
//                        result = result.replaceAll(c, "~");
////                        System.out.println(" =1 change");
//                    }
//                }
//            }
//        }
//        result = result
//                .replaceAll("~", "(")
//                .replaceAll("!", ")");
//
//        System.out.println("result = " + result);
//        return result;
//    }



// Test DATA
    @Test
    public void test() {
        assertEquals(")()())()(()()(", DuplicateEncoder.encode("Prespecialized"));
        assertEquals("))))())))",DuplicateEncoder.encode("   ()(   "));
        assertEquals("))(((",DuplicateEncoder.encode("VV+=>"));
    }

    public String makeWord(){
        String testWord = "";
        String charSet = "abcdefghijklMNOPQRSTUVWXYZ1234567890)(*&^% `<>?/}{+=";
        Random r = new Random();
        for (int i = 0; i < r.nextInt(10)+1; i++){
            testWord = testWord += charSet.charAt(r.nextInt(charSet.length()));
        }
        return testWord;
    }
    String e(String word){
        word = word.toLowerCase();
        String result = "";
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (word.lastIndexOf(ch) == word.indexOf(ch)){
                result = result.concat("(");
            } else {
                result = result.concat(")");
            }}
        return result;
    }
    @Test
    public void randomTest() {

        String[] randomTests = {makeWord(), makeWord(),makeWord(),makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord(),
                makeWord(), makeWord(), makeWord(), makeWord(), makeWord(), makeWord()};

        for (String test : randomTests) {
            assertEquals(e(test), DuplicateEncoder.encode(test));
        }

        assertEquals(")()))()))))()(", DuplicateEncoder.encode("Supralapsarian"));
        assertEquals(")))))(",DuplicateEncoder.encode(" ( ( )"));
        assertEquals("((((", DuplicateEncoder.encode("walk"));
        assertEquals("))))))", DuplicateEncoder.encode("Hannah"));
        assertEquals("))(", DuplicateEncoder.encode("$$\\"));
        assertEquals("(", DuplicateEncoder.encode("|"));
    }

}
