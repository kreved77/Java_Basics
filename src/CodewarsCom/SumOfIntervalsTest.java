package CodewarsCom;

import org.junit.Test;
import java.util.*;

import static java.util.stream.Collectors.joining;
import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/52b7ed099cdc285c300001cd
*/

public class SumOfIntervalsTest {
//    public static void main(String[] args) {
//        staticTests();
//    }

    private int[][] shuffle(int[][] a) {
        List<int[]> list = new ArrayList<>(a.length);
        Collections.addAll(list, a);
        Collections.shuffle(list);
        return list.toArray(new int[a.length][2]);
    }

    private int shuffleAndSumIntervals(int[][] arg) {
        return SumOfIntervals.sumIntervals(shuffle(arg));
    }

    @Test
    public void shouldHandleEmptyIntervals() {
        assertEquals(0, SumOfIntervals.sumIntervals(new int[][]{}));
        assertEquals(0, shuffleAndSumIntervals(new int[][]{{4, 4}, {6, 6}, {8, 8}}));
    }

    @Test
    public void shouldAddDisjoinedIntervals() {
        assertEquals(9, shuffleAndSumIntervals(new int[][]{{1, 2}, {6, 10}, {11, 15}}));
        assertEquals(11, shuffleAndSumIntervals(new int[][]{{4, 8}, {9, 10}, {15, 21}}));
        assertEquals(7, shuffleAndSumIntervals(new int[][]{{-1, 4}, {-5, -3}}));
        assertEquals(78, shuffleAndSumIntervals(new int[][]{{-245, -218}, {-194, -179}, {-155, -119}}));
    }

    @Test
    public void shouldHandleLargeIntervals() {
        assertEquals(2_000_000_000, SumOfIntervals.sumIntervals(new int[][]{{-1_000_000_000, 1_000_000_000}}));
        assertEquals(100_000_030, SumOfIntervals.sumIntervals(new int[][]{{0, 20}, {-100_000_000, 10}, {30, 40}}));
    }

    @Test
    public void shouldAddAdjacentIntervals() {
        assertEquals(54, shuffleAndSumIntervals(new int[][]{{1, 2}, {2, 6}, {6, 55}}));
        assertEquals(23, shuffleAndSumIntervals(new int[][]{{-2, -1}, {-1, 0}, {0, 21}}));
    }

    @Test
    public void shouldAddOverlappingIntervals() {
        assertEquals(7, shuffleAndSumIntervals(new int[][]{{1, 4}, {7, 10}, {3, 5}}));
        assertEquals(6, shuffleAndSumIntervals(new int[][]{{5, 8}, {3, 6}, {1, 2}}));
        assertEquals(19, shuffleAndSumIntervals(new int[][]{{1, 5}, {10, 20}, {1, 6}, {16, 19}, {5, 11}}));
    }

    @Test
    public void shouldHandleMixedIntervals() {
        assertEquals(13, shuffleAndSumIntervals(new int[][]{{2, 5}, {-1, 2}, {-40, -35}, {6, 8}}));
        assertEquals(1234, shuffleAndSumIntervals(new int[][]{{-7, 8}, {-2, 10}, {5, 15}, {2000, 3150}, {-5400, -5338}}));
        assertEquals(158, shuffleAndSumIntervals(new int[][]{{-101, 24}, {-35, 27}, {27, 53}, {-105, 20}, {-36, 26},}));
    }

    @Test
    public void shouldHandleSmallRandomIntervals() {
        randomTests(1, 20, -500, 500, 1, 20);
    }

    @Test
    public void shouldHandleLargeRandomIntervals() {
        randomTests(20, 200, -1_000_000_000, 1_000_000_000, 1_000_000, 10_000_000);
    }

    private void randomTests(int minN, int maxN, int minX, int maxX, int minW, int maxW) {
        for (int i = 0; i < 100; i++) {
            final var seq = generateRandomSeq(minN, maxN, minX, maxX, minW, maxW);
            final String msg = String.format("testing: %s%n", stringifyInterval(seq));
            final int expected = expect(seq);
            final int actual = SumOfIntervals.sumIntervals(seq);
            assertEquals(msg, expected, actual);
        }
    }

    private int[][] generateRandomSeq(int minN, int maxN, int minX, int maxX, int minW, int maxW) {
        final Random rnd = new Random();
        final int total = rnd.nextInt(maxN - minN + 1) + minN;
        final int[][] intervals = new int[total][2];
        for (int i = 0; i < total; i++) {
            final int width = rnd.nextInt(maxW - minW + 1) + minW;
            final int x = rnd.nextInt(maxX - minX - width + 1) + minX;
            intervals[i][0] = x;
            intervals[i][1] = x + width;
        }
        return intervals;
    }

    private String stringifyInterval(int[][] i) {
        return Arrays.stream(i).map(Arrays::toString).collect(joining(", "));
    }

    private int expect(int[][] intervals) {
        if (intervals == null) return 0;
        int[][] sortedIntervals = Arrays.stream(intervals)
                .filter(i -> i.length == 2 && i[0] < i[1])
                .sorted((a, b) -> {
                    int diff = a[0] - b[0];
                    return diff != 0 ? diff : b[1] - a[1];
                })
                .toArray(int[][]::new);
        if (sortedIntervals.length == 0) return 0;
        int lastHi = sortedIntervals[0][0], sum = 0;
        for (int[] interval : sortedIntervals) {
            if (interval[1] <= lastHi) {
                continue;
            }
            if (interval[0] >= lastHi) {
                sum += interval[1] - interval[0];
            } else {
                sum += interval[1] - lastHi;
            }
            lastHi = interval[1];
        }
        return sum;
    }
}