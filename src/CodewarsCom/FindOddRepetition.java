package CodewarsCom;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/54da5a58ea159efa38000836
*/

public class FindOddRepetition {


// VER_1
    public static int findIt(int[] a) {
        Set<Integer> mySet = new HashSet<>();
        for (int n : a) {
            if (!mySet.contains(n)) mySet.add(n);
            else mySet.remove(n);
        }
//         System.out.println("HashSet contains: " + mySet);
//     Object[] myArr = mySet.toArray();
//     return Integer.valueOf(myArr[0].toString());
        return (Integer) mySet.toArray()[0];
    }


// VER_2
//    public static int findIt(int[] a) {
//        int odd = 0;
//
//        for (int i : a) {
//            odd ^= i;
//        }
//
//        return odd;
//    }


// Test DATA
    @Test
    public void findTest() {
        assertEquals(5, FindOddRepetition.findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, FindOddRepetition.findIt(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, FindOddRepetition.findIt(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, FindOddRepetition.findIt(new int[]{10}));
        assertEquals(10, FindOddRepetition.findIt(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, FindOddRepetition.findIt(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}
