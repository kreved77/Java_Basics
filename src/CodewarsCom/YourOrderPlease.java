package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/55c45be3b2079eccff00010f
*/

public class YourOrderPlease {

// VER_1
    public static String order(String words) {

        String[] result = words.split(" ");
        System.out.println(result.length);
        for (String s : words.split(" ")){
            for (Character c : s.toCharArray()){
                if (!Character.isLetter(c))
                    result[Character.getNumericValue(c)-1] = s;
            }
        }

        return Arrays.stream(result).collect(Collectors.joining(" "));
    }



// Test DATA
    @Test
    public void test() {
        assertEquals("", YourOrderPlease.order(""));
        assertEquals("Thi1s is2 3a T4est", YourOrderPlease.order("is2 Thi1s T4est 3a"));
        assertEquals("Fo1r the2 g3ood 4of th5e pe6ople", YourOrderPlease.order("4of Fo1r pe6ople g3ood th5e the2"));
    }
}
