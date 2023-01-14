package CodewarsCom;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/54ba84be607a92aa900000f1
*/

public class Isograms {

// Test DATA
    @Test
    public void FixedTests() {
        assertEquals(true, Isograms.isIsogram("Dermatoglyphics"));
        assertEquals(true, Isograms.isIsogram("isogram"));
        assertEquals(false, Isograms.isIsogram("moose"));
        assertEquals(false, Isograms.isIsogram("isIsogram"));
        assertEquals(false, Isograms.isIsogram("aba"));
        assertEquals(false, Isograms.isIsogram("moOse"));
        assertEquals(true, Isograms.isIsogram("thumbscrewjapingly"));
        assertEquals(true, Isograms.isIsogram(""));
    }


// VER_1
    public static boolean  isIsogram(String str) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            charSet.add(Character.toLowerCase(str.charAt(i)));
        }
//        System.out.println(str);

        return (str.length() == charSet.size());
    }


// VER_2
//    public static boolean  isIsogram(String str) {
//        return str.length() == str.toLowerCase().chars().distinct().count();
//    }

}
