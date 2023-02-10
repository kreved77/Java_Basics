package CodewarsCom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/*
https://www.codewars.com/kata/5287e858c6b5a9678200083c
*/

public class NarcissisticNumber {

// VER_1
//    public static boolean isNarcissistic(int number) {
//        // TODO replace with your code
//        int result = 0;
//        String str = number + "";
//        int n = str.length()-1;
//        while (n >= 0) {
//            result += Math.pow(Integer.valueOf(str.substring(n, n+1)), str.length());
////            result += Math.pow(Character.digit(str.charAt(n), 10), str.length());
//            n--;
//        }
//        return (number == result);
//    }

// VER_2
    public static boolean isNarcissistic(int number) {
        // TODO replace with your code
        int result = 0;
        String str = String.valueOf(number);

        for(char digit : str.toCharArray())
            result += Math.pow(Integer.parseInt(String.valueOf(digit)), str.length());
        return (number == result);
    }


// Test DATA
    @Test
    public void fixedTests() {
        assertTrue("153 is narcissistic", NarcissisticNumber.isNarcissistic(153));
        assertTrue("1634 is narcissistic", NarcissisticNumber.isNarcissistic(1634));
        assertFalse("112 is not narcissistic", NarcissisticNumber.isNarcissistic(112));
        assertFalse("10 is not narcissistic", NarcissisticNumber.isNarcissistic(10));
        assertFalse(Integer.MAX_VALUE + " is not narcissistic", NarcissisticNumber.isNarcissistic(Integer.MAX_VALUE));
    }
}
