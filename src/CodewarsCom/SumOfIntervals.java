package CodewarsCom;

import java.util.*;
import java.util.stream.IntStream;

/*
https://www.codewars.com/kata/52b7ed099cdc285c300001cd
*/

public class SumOfIntervals {


// VER_3
    public static int sumIntervals(int[][] intervals) {
        if (intervals == null || intervals.length < 1) return 0;

        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        int flagLastMax = intervals[0][0];
        int result = 0;

        for (int[] interval : intervals){
            if (flagLastMax < interval[1]){
//                System.out.println(" • current = " + Arrays.toString(interval) + " | flagLastMax = " + flagLastMax + " -> " + interval[1]);
                result += interval[1] - Math.max(interval[0], flagLastMax);
                flagLastMax = interval[1];
            }
        }
//        System.out.println("===> result=" + result);
        return result;
    }


// VER_2
//    public static int sumIntervals(int[][] intervals) {
//        // TO DO: implement this method
//        BitSet neg = new BitSet();      // neg - for negatives, pos - for positives:
//        BitSet pos = new BitSet();
//        for (int[] arr : intervals) {
////          System.out.println("new " + Arrays.toString(arr));
//            if (arr[1] < 0 ) {
//                neg.set(Math.abs(arr[1]),Math.abs(arr[0]));
////              System.out.println("neg=" + neg.cardinality());
//            } else if (0 < arr[0]) {
//                pos.set(arr[0],arr[1]);
////              System.out.println("pos=" + pos.cardinality());
//            } else {        // case if (arr[0] <= 0 && 0 <= arr[1])
//                neg.set(0,Math.abs(0 - arr[0]));
//                pos.set(0,arr[1]);
////              System.out.println("neg=" + neg.cardinality() + " / pos=" + pos.cardinality());
//            }
//        }
////        System.out.println("result ==> " + neg.cardinality() + pos.cardinality());
//        return neg.cardinality() + pos.cardinality();
//    }


// VER_1 (has problems: timeOut , OutOfMemoryError)
//    public static int sumIntervals(int[][] intervals) {
//        // TO DO: implement this method
//         return intervals == null ? 0 : (int) Arrays.stream(intervals)
//             .flatMapToInt(interval -> IntStream.range(interval[0], interval[1]))
//             .distinct()
//             .count();
//
//    }

}