package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

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
    public static boolean scramble(String str1, String str2) {
        boolean result = true;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < str2.length(); i++){
            String letter = str2.substring(i,i+1);
            if (!set.contains(letter)){
                set.add(letter);
                Pattern p = Pattern.compile(letter);
                Matcher m1 = p.matcher(str1);
                Matcher m2 = p.matcher(str2);
                int countHas = 0;
                int countNeed = 0;
                while (m1.find()) countHas++;
                while (m2.find()) countNeed++;
//             System.out.println(letter + ": need=" + countNeed + ", find=" + countHas);
                if (countNeed > countHas) return false;
            }
        }
//             System.out.println("===> " + result);
        return result;
    }

}
