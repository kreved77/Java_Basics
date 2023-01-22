package CodewarsCom;

import java.util.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/545cedaa9943f7fe7b000048
*/

public class DetectPangram {

// VER_2
    public boolean pangramChecker(String sentence){
//        char c = '\u05B0';        // - Еврейская точка sheva: U+05B0
//        System.out.println("symbol " + c + " : isLetter=" + Character.isLetter(c) + " | isAlphabetic=" + Character.isAlphabetic(c));
        return sentence.chars()
                .filter(Character::isLetter)
//                .filter(Character::isAlphabetic)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }

// VER_1
//    public boolean pangramChecker(String sentence){
//        System.out.println(sentence);
//        Set<Character> hs = new HashSet<>();
//        String alp = "abcdefghijklmnopqrstuvwxyz";
//        for (char c : alp.toCharArray()) {
//            hs.add(c);
//        }
//        for (char c : sentence.toLowerCase().toCharArray()) {
//            if (hs.contains(c)) hs.remove(c);
//        }
//        System.out.println(hs);
//        return hs.isEmpty();
////        if (hs.isEmpty()) return true;
////        return false;
//    }



// Test DATA
    @Test
    public void test() {
        assertEquals(true, pangramChecker("The quick brown fox jumps over the lazy dog."));
        assertEquals(false, pangramChecker("You shall not pass!"));
        assertEquals(true, pangramChecker("Cwm fjord bank glyphs vext quiz"));
        assertEquals(true, pangramChecker("Pack my box with five dozen liquor jugs."));
        assertEquals(true, pangramChecker("How quickly daft jumping zebras vex."));
        assertEquals(true, pangramChecker("ABCD45EFGH,IJK,LMNOPQR56STUVW3XYZ"));
        assertEquals(false, pangramChecker("abcdefghijklmopqrstuvwxyz"));
        assertEquals(false, pangramChecker("A pangram is a sentence that contains every single letter of the alphabet at least once."));
    }
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private char[] shuffle(char[] a) {
        for (int i = 0; i < a.length; i++) {
            int j = (int)(Math.random() * a.length);
            char t = a[i];
            a[i] = a[j];
            a[j] = t;
        }
        return a;
    }
    @Test
    public void randomizedTests() {
        for (int trial = 1; trial <= 10; trial++) {
            int wordBreaks = (int)(Math.random() * 8 + 1);
            char[] arr = new char[wordBreaks];
            Arrays.fill(arr, ' ');
            String spaces = new String(arr), sentence = "", missing = "";
            switch ( (int)(Math.random() * 3) ) {
                case 0: // non-pangram
                    //System.out.println("non-pangram");
                    arr = Arrays.copyOf(shuffle(alphabet.toCharArray()), alphabet.length());
                    int removals = (int)(Math.random() * 15 + 1);
                    sentence = new String(arr, 0, 26 - removals);
                    missing = new String(arr, sentence.length(), removals);
                    break;
                case 1: // exact pangram
                    //System.out.println("exact pangram");
                    sentence = alphabet;
                    break;
                case 2: // pangram w/extras
                    //System.out.println("pangram w/extras");
                    char[] extras = new char[(int)(Math.random() * 15) + 1];
                    for (int i = 0; i < extras.length; i++)
                        extras[i] = alphabet.charAt((int)(Math.random() * 26));
                    sentence = alphabet.concat(new String(extras));
                    break;
            }
            sentence = (new String(shuffle(sentence.concat(spaces).toCharArray()))).replaceAll("\\s\\s*"," ").trim();
//            System.out.format("Test #%2d: \"%s\"\n", trial, sentence);
            String failMsg = String.format("\"%s\" is %sa pangram.\n%s",
                    sentence,
                    (missing.length() > 0 ? "not " : ""),
                    (missing.length() > 0 ? "Missing " + missing + "\n" : ""));
            assertEquals(failMsg, 0 == missing.length(), pangramChecker(sentence));
        }
    }
}
