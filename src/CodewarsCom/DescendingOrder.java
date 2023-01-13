package CodewarsCom;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/5467e4d82edf8bbf40000155
*/

public class DescendingOrder {

// Test DATA
    @Test
    public void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }
    @Test
    public void test_02() {
        assertEquals(521, DescendingOrder.sortDesc(215));
    }
    @Test
    public void test_03() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
    @Test
    public void test_04() {
        assertEquals(2110, DescendingOrder.sortDesc(1021));
    }


// VER_2
//    public static int sortDesc(final int num) {
//        //Your code
//        String[] digits = String.valueOf(num).split("");
//        Arrays.sort(digits, Collections.reverseOrder());
////        System.out.println("Sort+Rev: " + Arrays.toString(digits));
//        return Integer.parseInt(String.join("", digits));
//    }


// VER_1
    public static int sortDesc(final int num) {
        //Your code
        if (num == 0) return 0;

        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);
//        System.out.println("Sorted  : " + Arrays.toString(digits));

        char[] digitsRev = new char[digits.length];
        for (int i = 0; i < digits.length ; i++){
            digitsRev[digits.length-1 - i] = digits[i];
        }
//        System.out.println("Sort+Rev: " + Arrays.toString(digitsRev));

        return Integer.parseInt(new String(digitsRev));
    }


// VER_1_long
//    public static int sortDesc(final int num) {
//        //Your code
//        System.out.println("Input   : " + num);
//        if (num == 0) return 0;
//
////        int[] intTab = String.valueOf(num).chars().map(Character::getNumericValue).sorted().toArray();
////        System.out.println(" intTab=" + Arrays.toString(intTab));
//
//        String number = String.valueOf(num);
//        char[] digits1 = number.toCharArray();
//        Arrays.sort(digits1);
//        System.out.println("Sorted  : " + Arrays.toString(digits1));
//
//        int len = digits1.length;
//        char[] digits2 = new char[len];
//        for (int i = 0; i < digits1.length ; i++){
//            len--;
//            digits2[len] = digits1[i];
//        }
//        System.out.println("Reversed: " + Arrays.toString(digits2));
//
//
////        int[] arr = new int[len];
////        for (int i = 0; i < digits1.length; i++){
////            System.out.println(digits1[digits1.length - 1 - i]);
////            arr[i] = Character.getNumericValue(digits1[digits1.length - 1 - i]);
////        }
////        System.out.println(Arrays.toString(arr));
//
//        int result = Integer.parseInt(new String(digits2));
//        return result;
//    }
}
