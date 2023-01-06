package CodewarsCom;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

/*
https://www.codewars.com/kata/515de9ae9dcfc28eb6000001
*/

public class SplitStrings {
    public static void main(String[] args) {
        testEvenString();
        testOddString();
        randomTests();
    }

// Test DATA
    private static final String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890    ";
    private static final Random rand = new Random();
    private static char randomChar() {
        return alphabet.charAt(rand.nextInt(alphabet.length()));
    }

    @Test
    public static void randomTests() {
        for (int trial = 1; trial <= 10; trial++) {
            String[] expected = new String[rand.nextInt(21)];
            for (int i = 0; i < expected.length; i++)
                expected[i] = "" + randomChar() + randomChar();
            if ( 0 < expected.length && rand.nextBoolean() )
                expected[expected.length-1] = randomChar() + "_";
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < expected.length; i++)
                sb.append(expected[i]);
            assertEquals(Arrays.toString(expected),
                    Arrays.toString(solution(sb.toString().replace("_$", ""))));
        }
    }
    @Test
    public static void testEvenString() {
        String s = "abcdef";
        String s1 = "HelloWorld";
        assertEquals("Should handle even string","[ab, cd, ef]", Arrays.toString(solution(s)));
        assertEquals("Should handle even string","[He, ll, oW, or, ld]", Arrays.toString(solution(s1)));
    }
    @Test
    public static void testOddString() {
        String s = "abcde";
        String s1 = "LovePizza";
        assertEquals("Should handle odd string","[ab, cd, e_]", Arrays.toString(solution(s)));
        assertEquals("Should handle odd string","[Lo, ve, Pi, zz, a_]", Arrays.toString(solution(s1)));
    }

// VER_1
    public static String[] solution(String s) {
        //Write your code here
        int n = s.length() / 2 + s.length() % 2;
        String[] sArr = new String[n];
        for (int i = 0; i < n; i++){
            sArr[i] = s.substring(2*i).length() >= 2 ? s.substring(2*i,2*i+2) : s.substring(2*i) + "_";
        }
        System.out.println(Arrays.stream(sArr).collect(Collectors.joining()));
        System.out.println(Arrays.stream(sArr).toList());
//        System.out.println(Arrays.toString(sArr));
        return sArr;
    }

// VER_2
//    public static String[] solution(String s) {
//        //Write your code here
//        s = (s.length() % 2 == 0) ? s : s + "_";
////        System.out.println(Arrays.stream(s.split("(?<=\\G.{2})")).collect(Collectors.toList()));
//        return s.split("(?<=\\G.{2})");
//    }
}
