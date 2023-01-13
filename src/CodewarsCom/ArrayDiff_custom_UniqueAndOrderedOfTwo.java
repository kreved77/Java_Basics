package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/*
 This is customVersion : returns Only Unique and Ordered values of Two Arrays

https://www.codewars.com/kata/523f5d21c841566fde000009
*/

public class ArrayDiff_custom_UniqueAndOrderedOfTwo {
    public static void main(String[] args) {
//        customUniqueAndOrderedOfTwoTests();
        customRandomTests();
    }

// Test DATA custom
    @Test
    public static void customUniqueAndOrderedOfTwoTests() {
        assertArrayEquals(new int[] {4, 10, 12, 16, 20, 21, 24}, arrayDiff_UniqueAndOrderedOfTwo(new int [] {12, 10, 13, 12, 14, 11, 22, 6, 9, 0, 2, 1, 13, 7, 22, 8, 10, 20, 17, 17, 7, 17, 22, 16, 12, 13, 13, 4, 14, 11, 10, 0, 23, 15, 15, 11, 3, 6, 19, 0, 5, 1, 19, 22, 19, 14, 9, 7, 12, 22}, new int[] {15, 21, 9, 8, 14, 1, 14, 0, 24, 11, 23, 0, 0, 13, 21, 14, 11, 14, 2, 0, 7, 21, 3, 19, 22, 6, 2, 9, 21, 17, 11, 22, 5, 7, 9, 2, 19}));
        assertArrayEquals(new int[] {4, 10, 12, 16, 20, 21, 24, 55, 66, 77, 88, 555, 5555, 7777}, arrayDiff_UniqueAndOrderedOfTwo(new int [] {12, 10, 13, 12, 14, 11, 22, 6, 9, 0, 2, 1, 13, 7, 22, 8, 10, 20, 17, 7777, 55, 555, 5555, 17, 7, 17, 22, 16, 12, 13, 13, 4, 14, 11, 10, 0, 23, 15, 15, 11, 3, 6, 19, 0, 5, 1, 19, 22, 19, 14, 9, 7, 12, 22}, new int[] {15, 21, 9, 8, 14, 1, 14, 0, 24, 11, 23, 0, 0, 13, 21, 14, 11, 14, 2, 0, 7, 21, 3, 19, 22, 6, 2, 9, 21, 17, 11, 22, 77, 66, 88, 5, 7, 9, 2, 19}));
    }
    @Test
    public static void customRandomTests() {
        Random rnd = new Random();

        for (int i = 0; i < 5; i++) {
            int[] arr1 = IntStream.range(1, rnd.nextInt(10,50)).map(x -> rnd.nextInt(30)).toArray();
            int[] arr2 = IntStream.range(1, rnd.nextInt(10, 50)).map(x -> rnd.nextInt(30)).toArray();

            int[] expected = customSolution(arr1, arr2);
            int[] actual = arrayDiff_UniqueAndOrderedOfTwo(arr1, arr2);

            assertArrayEquals(expected, actual);
        }
    }
    private static int[] customSolution(int[] a, int[] b) {
        System.out.println("************\n ORIGINAL a : " + Arrays.toString(a));
        System.out.println(" ORIGINAL b : " + Arrays.toString(b));

        a = IntStream.of(a).distinct().sorted().toArray();
        b = IntStream.of(b).distinct().sorted().toArray();
//        a = Arrays.stream(a).distinct().sorted().toArray();
//        Arrays.sort(b);

        System.out.println("NEW sorted + unique A : " + Arrays.toString(a));
        System.out.println("NEW sorted + unique B : " + Arrays.toString(b));


        // merge a and b to new array, then sort
        int n = a.length + b.length;
        Integer[] mergedArr = new Integer[n];
        int index = 0;
        for (int value : a){
            mergedArr[index] = value;
            index++;
        }
        for (int value : b){
            mergedArr[index] = value;
            index++;
        }
        Arrays.sort(mergedArr);

        ArrayList<Integer> list =  new ArrayList<>();
        Collections.addAll(list, mergedArr);

        System.out.println("***** MERGED list size: " + list.size());
        System.out.println(" _START_ data: " + list.toString());

        // if some value has a pair - both should be removed
        for (int i = list.size()-2; i >= 0 ; i--) {
            if (list.get(i) == list.get(i+1)) {
//                System.out.println(" del = " + list.get(i));
                list.remove(i+1);
                list.remove(i);
                i--;
                System.out.println(" MOD list data: " + list.toString());
            }
        }

        int[] finalArr = list.stream().mapToInt(i -> i).toArray();
//        int[] finalArr = list.stream().mapToInt(Integer::intValue).toArray();

        System.out.println("WAIT answer: " + Arrays.toString(finalArr));
        return finalArr;
    }


// customVersion: returns Only Unique and Ordered values of Two Arrays
    public static int[] arrayDiff_UniqueAndOrderedOfTwo(int[] a, int[] b) {
        // Your code here
        System.out.println(" == customVersion: returns Only Unique and Ordered values of Two Arrays == ");
        Arrays.sort(a);
        Arrays.sort(b);
//        System.out.println("SORTED a=" + Arrays.toString(a));
//        System.out.println("SORTED b=" + Arrays.toString(b));

//        if ( (a == null || a.length == 0) && (b == null || b.length == 0) ) return null;
//        else if ( b == null || b.length == 0 ) return a;

        List<Integer> list = new ArrayList<>();
        int lastMax = Math.min(a[0], b[0]);
        int i = 0;
        int j = 0;

        if (a[0] != b[0]) list.add(Math.min(a[0],b[0]));
        while (i < a.length && j < b.length){

//            System.out.println(" new >>> a[i]=" + a[i] + " | b[j]=" + b[j]);
            if (lastMax < a[i]  &&  a[i] < b[j]) {
                list.add(a[i]);
//                System.out.println(" | add(a[" + i + "])=" + a[i]);
                lastMax = Math.max(lastMax, a[i]);
                i++;
            } else if (lastMax < b[j]  &&  b[j] < a[i]) {
                list.add(b[j]);
//                System.out.println(" | add(b[" + j + "])=" + b[j]);
                lastMax = Math.max(lastMax, b[j]);
                j++;
            } else if (lastMax == a[i]  &&  a[i] < b[j]) {
                i++;
            } else if (lastMax == b[j]  &&  b[j] < a[i]) {
                j++;
            } else if (a[i] == b[j]){
                lastMax = Math.min(a[i], b[j]);
                i++;
                j++;
            }
        }

//        System.out.println(" NEXT STEP ");
        if (j == b.length) {
            while ( i < a.length){
                if (a[i] > lastMax) {
                    list.add(a[i]);
//                    System.out.println(" | add(a[" + i + "])=" + a[i]);
                    lastMax = a[i];
                }
                i++;
            }
        }
        if (i == a.length) {
            while ( j < b.length){
                if (b[j] > lastMax) {
                    list.add(b[j]);
//                    System.out.println(" | add(b[" + j + "])=" + b[j]);
                    lastMax = b[j];
                }
                j++;


                /*
                list.add(b[j]);
//                System.out.println(" | add(b[" + j + "])=" + b[j]);
                j++;
//                j = (j < b.length) ? j+1 : j;
                */
            }
        }

        int[] result = new int[list.size()];
        for (int n = 0; n < list.size(); n++)
            result[n] = list.get(n);

        System.out.println(" GET answer: " + Arrays.toString(result));
        return result;
    }

}
