package CodewarsCom;

import java.util.*;
import java.util.stream.IntStream;

import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

/*
https://www.codewars.com/kata/523f5d21c841566fde000009
*/

public class ArrayDiff {
    public static void main(String[] args) {
        sampleTests();
        randomTests();
    }

// Test DATA
    @Test
    public static void sampleTests() {
        assertArrayEquals(new int[] {2}, arrayDiff(new int [] {1,2}, new int[] {1}));
        assertArrayEquals(new int[] {2,2}, arrayDiff(new int [] {1,2,2}, new int[] {1}));
        assertArrayEquals(new int[] {1}, arrayDiff(new int [] {1,2,2}, new int[] {2}));
        assertArrayEquals(new int[] {1,2,2}, arrayDiff(new int [] {1,2,2}, new int[] {}));
        assertArrayEquals(new int[] {}, arrayDiff(new int [] {}, new int[] {1,2}));
    }
    @Test
    public static void randomTests() {
        Random rnd = new Random();

        for (int i = 0; i < 100; i++) {
            int[] arr1 = IntStream.range(0, rnd.nextInt(100)).map(x -> rnd.nextInt(25)).toArray();
            int[] arr2 = IntStream.range(0, rnd.nextInt(100)).map(x -> rnd.nextInt(25)).toArray();

            int[] expected = solution(arr1, arr2);
            int[] actual = arrayDiff(arr1, arr2);

            assertArrayEquals(expected, actual);
        }
    }
    private static int[] solution(int[] a, int[] b) {
        return IntStream.of(a).filter(x -> IntStream.of(b).noneMatch(y -> y == x)).toArray();
    }


// VER_1
    public static int[] arrayDiff(int[] a, int[] b) {
        // Your code here
        System.out.println("a=" + Arrays.toString(a));
        System.out.println("b=" + Arrays.toString(b));

        if ( (a == null || a.length == 0) && (b == null || b.length == 0) ) return null;
        else if ( b == null || b.length == 0 ) return a;

        List<Integer> list = new ArrayList<>();
        for(int x : a){
            if (!Arrays.stream(b).anyMatch(y -> y == x)) list.add(x);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);

        System.out.println("result=" + Arrays.toString(result));
        return result;
    }
}
