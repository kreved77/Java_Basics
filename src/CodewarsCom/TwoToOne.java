package CodewarsCom;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/5656b6906de340bd1b0000ac
*/

public class TwoToOne {

// VER_3
    public static String longest (String s1, String s2) {

        return (s1 + s2).chars()
                .mapToObj(e -> String.valueOf((char) e))
                .distinct()
                .sorted()
                .collect(Collectors.joining());
    }

// VER_2
//    public static String longest (String s1, String s2) {
//
//        String[] result = Arrays.stream((s1 + s2).split(""))
//                .distinct()
//                .sorted()
//                .toArray(String[]::new);
//        System.out.println("unique: " + Arrays.toString(result));
//
//        return String.join("", result);
//    }

// VER_1
//    public static String longest (String s1, String s2) {
//        String merge = s1 + s2;
//
//
//        String[] cArr = String.valueOf(merge).split("");
//        Arrays.sort(cArr);
////         System.out.println("Sort+Rev1: " + Arrays.toString(cArr));
//
//        String[] result = Arrays.stream(cArr)
//                .distinct()
//                .toArray(String[]::new);
////         System.out.println("unique: " + Arrays.toString(result));
//
//        return String.join("", result);
//    }



// Test DATA
    @Test
    public void test() {
        System.out.println("longest Fixed Tests");
        assertEquals("aehrsty", TwoToOne.longest("aretheyhere", "yestheyarehere"));
        assertEquals("abcdefghilnoprstu", TwoToOne.longest("loopingisfunbutdangerous", "lessdangerousthancoding"));
        assertEquals("acefghilmnoprstuy", TwoToOne.longest("inmanylanguages", "theresapairoffunctions"));
        assertEquals("abcxyz", TwoToOne.longest("xyaabbbc", "xxyyzaab"));
    }
}
