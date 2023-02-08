package CodewarsCom;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/5679aa472b8f57fb8c000047
*/

public class EqualSidesOfAnArray {

// VER_1
    public static int findEvenIndex(int[] arr) {
        System.out.println("NEW " + Arrays.toString(arr));
        int leftSum = 0;
        int rightSum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length; i++) {
            rightSum -= arr[i];
            if (leftSum == rightSum) return i;
            leftSum += arr[i];
        }
        return -1;
    }



// Test DATA
    @Test
    public void test() {
        assertEquals(3,EqualSidesOfAnArray.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
        assertEquals(1,EqualSidesOfAnArray.findEvenIndex(new int[] {1,100,50,-51,1,1}));
        assertEquals(-1,EqualSidesOfAnArray.findEvenIndex(new int[] {1,2,3,4,5,6}));
        assertEquals(3,EqualSidesOfAnArray.findEvenIndex(new int[] {20,10,30,10,10,15,35}));
        assertEquals(-1,EqualSidesOfAnArray.findEvenIndex(new int[] {-8505, -5130, 1926, -9026}));
        assertEquals(1,EqualSidesOfAnArray.findEvenIndex(new int[] {2824, 1774, -1490, -9084, -9696, 23094}));
        assertEquals(6,EqualSidesOfAnArray.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
        assertEquals(-1, EqualSidesOfAnArray.findEvenIndex(new int[] {8, 8}));
        assertEquals(0, EqualSidesOfAnArray.findEvenIndex(new int[] {8, 0}));
        assertEquals(1, EqualSidesOfAnArray.findEvenIndex(new int[] {0, 8}));
        assertEquals(0, EqualSidesOfAnArray.findEvenIndex(new int[] {7, 3, -3}));
        assertEquals(0, EqualSidesOfAnArray.findEvenIndex(new int[] {8}));
        assertEquals(0, EqualSidesOfAnArray.findEvenIndex(new int[] {0,0,0,0,0}));
    }
}
