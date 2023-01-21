package CodewarsCom;

import java.util.*;
import java.util.stream.IntStream;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/*
https://www.codewars.com/kata/554ca54ffa7d91b236000023
*/

public class EnoughIsEnough {


// VER_1
    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        System.out.println(Arrays.toString(elements) + " / " + maxOccurrences);

        Map<Integer, Integer> hm = new HashMap<>();
        for (int e : elements){
            hm.merge(e, 1, (oldValue, n) -> oldValue + n);
        }

        int[] result = new int[elements.length];
        int maxIndex = 0;
        for (int e : elements){
//            System.out.println("hm.get(e) = " + hm.get(e));
            if (Math.min(hm.get(e), maxOccurrences) > 0) {
                hm.merge(e, -1, (oldValue, n) -> Math.min(oldValue, maxOccurrences) + n);
                result[maxIndex++] = e;
            }
        }

        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(Arrays.stream(result).limit(maxIndex).toArray()));
        return Arrays.stream(result).limit(maxIndex).toArray();
    }



// Test DATA
    @Test
    public void deleteNth() throws Exception {
        doTest(new int[] { 20, 37,5, 21 }, new int[] { 20, 37, 20, 21 }, 1 );
        doTest(new int[] { 1, 1, 3, 3, 7, 2, 2, 2 }, new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3 );
        doTest(new int[] { 1, 2, 3, 1, 1, 2, 2, 3, 3, 4, 5 }, new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3 );
        doTest(new int[] { 1, 1, 1, 1, 1 }, new int[] { 1, 1, 1, 1, 1 }, 5 );
        doTest(new int[] { }, new int[] { }, 5 );
    }


    private void doTest(int[] expected, int[] numbers, int count) {
        String msg = String.format("Incorrect answer for: elements=%s, maxOccurrences=%d\n", Arrays.toString(numbers), count);
        assertArrayEquals(msg, expected, EnoughIsEnough.deleteNth(numbers, count));
    }

    @Test
    public void random() throws Exception {
        Random random = new Random();
        Map<Integer, Integer> cache = new HashMap<>();
        for ( int i = 0; i < 10; i++ ) {
            int maxOccurrences = random.nextInt( 10 );
            int size = random.nextInt( 100 );
            int[] testData = IntStream.generate( () -> random.nextInt( size ) ).limit( size ).toArray();
            int[] copyOfTestData = Arrays.copyOf( testData, testData.length );

            cache.clear();
            int[] expected = Arrays.stream( copyOfTestData )
                    .filter( el -> cache.merge( el, 1, (a, b) -> a + b ) <= maxOccurrences )
                    .toArray();

            doTest(expected, testData, maxOccurrences);
        }
    }

}
