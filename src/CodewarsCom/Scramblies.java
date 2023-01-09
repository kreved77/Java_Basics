package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/55c04b4cc56a697bb0000048
*/

public class Scramblies {
    public static void main(String[] args) {
        sampleTests();
        largeTest();
    }

// Test DATA
    private static void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }
    @Test
    public static void sampleTests() {
        testing(Scramblies.scramble("rkqodlw","world"), true);
        testing(Scramblies.scramble("cedewaraaossoqqyt","codewars"),true);
        testing(Scramblies.scramble("katas","steak"),false);
        testing(Scramblies.scramble("scriptjavx","javascript"),false);
        testing(Scramblies.scramble("scriptingjava","javascript"),true);
        testing(Scramblies.scramble("scriptsjava","javascripts"),true);
        testing(Scramblies.scramble("javscripts","javascript"),false);
        testing(Scramblies.scramble("aabbcamaomsccdd","commas"),true);
        testing(Scramblies.scramble("commas","commas"),true);
        testing(Scramblies.scramble("sammoc","commas"),true);
    }
    @Test
    public static void largeTest() {
        String s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10_000);
        String s2 = "zyxcba".repeat(9_000);
        testing(Scramblies.scramble(s1, s2), true);
    }


// VER_1
//    public static boolean scramble(String str1, String str2) {
//        boolean result = true;
//        Set<String> set = new HashSet<>();
//        for (int i = 0; i < str2.length(); i++){
//            String letter = str2.substring(i,i+1);
//            if (!set.contains(letter)){
//                set.add(letter);
//                Pattern p = Pattern.compile(letter);
//                Matcher m1 = p.matcher(str1);
//                Matcher m2 = p.matcher(str2);
//                int countHas = 0;
//                int countNeed = 0;
//                while (m1.find()) countHas++;
//                while (m2.find()) countNeed++;
////             System.out.println(letter + ": need=" + countNeed + ", find=" + countHas);
//                if (countNeed > countHas) return false;
//            }
//        }
////             System.out.println("===> " + result);
//        return result;
//    }


// VER_2
//    public static boolean scramble(String str1, String str2) {
//        int[] letterFreq = new int[26];
//
//        for (int i = 0; i < str1.length(); i++) {
//            letterFreq[str1.charAt(i) - 'a']++;
//        }
//
//        for (int i = 0; i < str2.length(); i++) {
//            if (--letterFreq[str2.charAt(i) - 'a'] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }


// VER_3
//    public static boolean scramble(String str1, String str2) {
//
//        Map<String, Long> str1Map = Stream.of(str1.split("")).collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));
//        Map<String, Long> str2Map = Stream.of(str2.split("")).collect(Collectors.groupingBy(letter -> letter, Collectors.counting()));
//
//        for(Map.Entry<String, Long> entry : str2Map.entrySet()){
//            System.out.println(entry + " (" + entry.getKey() + ", " + entry.getValue() + ")");
//            if(str1Map.get(entry.getKey()) == null || str1Map.get(entry.getKey()) < entry.getValue()) return false;
//        }
//        return true;
//    }


// VER_4
/*    https://www.programiz.com/java-programming/library/hashmap/merge  */
//
//    public static boolean scramble(String str1, String str2) {
//        Map<Character, Integer> hm1 = new HashMap<>();
//        Map<Character, Integer> hm2 = new HashMap<>();
//        for (char c : str1.toCharArray()) hm1.merge(c, 1, (oldValue, n) -> oldValue + n);
//        for (char c : str2.toCharArray()) hm2.merge(c, 1, (oldValue, n) -> oldValue + n);
//        for (char c : hm2.keySet()) if (hm2.get(c) > hm1.getOrDefault(c, 0)) return false;
//        return true;
//    }


// VER_5
    public static boolean scramble(String str1, String str2) {
        Map<Character, Integer> hmap = new HashMap<>();
        for (char c : str1.toCharArray()) hmap.merge(c, 1, Integer::sum);
        for (char c : str2.toCharArray()) hmap.merge(c, -1, (oldValue, n) -> oldValue + n);
        for (char c : hmap.keySet()) if (hmap.get(c) < 0) return false;
        return true;
    }
}
