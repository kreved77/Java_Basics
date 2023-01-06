package CodewarsCom;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

/*
https://www.codewars.com/kata/515de9ae9dcfc28eb6000001
*/

public class SplitStrings {
    public static void main(String[] args) {
        testEvenString();
        testOddString();
    }

// Test DATA
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

    public static String[] solution(String s) {
        //Write your code here
        int n = s.length() / 2 + s.length() % 2;
        String[] sArr = new String[n];
        for (int i = 0; i < n; i++){
            sArr[i] = s.substring(2*i).length() >= 2 ? s.substring(2*i,2*i+2) : s.substring(2*i) + "_";
        }
        return sArr;
    }
}
