package CodewarsCom;

import org.junit.jupiter.api.*;

import java.util.*;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/*
https://www.codewars.com/kata/534e01fbbb17187c7e0000c6
//    ○◙▬∎⓿⌗◊▫▪░▓█⬛
    Preview for n=7:
        1 1 1 1 1 1 1
        0 0 0 0 0 0 1
        1 1 1 1 1 0 1
        1 0 0 0 1 0 1
        1 0 1 1 1 0 1
        1 0 0 0 0 0 1
        1 1 1 1 1 1 1
*/
public class SpiralClockwisePath {


// VER_2 (works fine already)
    public static int[][] spiralize(int n) {
        int[][] result = new int[n][n];
        for (int[] row : result)
            Arrays.fill(row, 0);

        int[][] steps = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int top = 0;            // index height up   (min)
        int right = n;      // index  width right (max)
        int bottom = n;     // index height down (max)
        int left = 0;           // index  width left  (min)
        int turn = 0;           // move direction →, ↓, ←, ↑

        int h = 0;                        // start index height int[h][ ]
        int w = 0;                        // start index  width int[ ][w]
        final int offset = 2;             // offset to next path

        while (top <= bottom && left < right) {
            do {
                result[h][w] = 1;
                h += steps[turn][0];
                w += steps[turn][1];
            } while (h >= top   && h < bottom
                    &&  w >= left  && w < right);

            if (turn == 0) {
                top = top + offset;
                w--;
                h++;
            } else if (turn == 1) {
                right = right - offset;
                w--;
                h--;
            } else if (turn == 2) {
                bottom = bottom - offset;
                w++;
                h--;
            } else if (turn == 3) {
                left = left + offset;
                w++;
                h++;
            }
            turn = ++turn % 4;
        }

        if (n > 0)
            printArray(result);

        return result;
    }

// VER_1 (need improve)
//    private enum Dir {RIGHT, DOWN, LEFT, UP}
//    public static int[][] spiralize(int n) {
//        int[][] result = new int[n][n];
//        for (int[] row : result)
//            Arrays.fill(row, 1);
//        int[][] steps = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
//        int[] limits = new int[]{0, n-1, n-1, 0};       // index limits for {top, right, bottom, left}
//        int turn = 0;                                   // move direction →, ↓, ←, ↑
//
//        int h = 1;                  // start index height int[h][ ]
//        int w = 0;                  // start index  width int[ ][w]
//        final int offset = 2;             // offset to next path
//
//        while (limits[0] != limits[2] && limits[1] != limits[3]) {
//            do {
//                result[h][w] = 0;
//                h += steps[turn][0];
//                w += steps[turn][1];
//            } while (h >= limits[0]
//                    && w < limits[1]
//                    && h < limits[2]
//                    && w > limits[3]);
////            limits[turn] = (turn == 0 || turn == 3) ? limits[turn] + offset : limits[turn] - offset;
//            if (turn == 0 || turn == 3) {
//                limits[turn] = limits[turn] + offset;
//                w = turn == 0 ? --w : ++w;
//                h = turn == 0 ? ++h : h;
//            } else {
//                limits[turn] = limits[turn] - offset;
//                h = turn == 1 ? --h : h;
//                w = turn == 1 ? --w : w;
//            }
//            turn = ++turn % 4;
////            h += steps[turn][0];
////            w += steps[turn][1];
//            System.out.print("(next iteration)\n");
//            printArray(result);
//        }
//        System.out.print("FINAL RESULT\n");
////        System.out.println(" h=" + h + " w=" + w + " || t=" + top + " r=" + right + " b=" + bottom + " l=" + left);
//
//        printArray(result);
//        return result;
//    }

    private static void printArray(int[][] result) {
        System.out.print("FINAL RESULT for n=" + result[0].length + ":\n");
        for (int[] row : result) {
            for (int i : row) {
//                System.out.print(i + " ");
                if (i == 0) System.out.print("▫");
                if (i == 1) System.out.print("█");
            }
            System.out.print("\n");
        }
    }



// Test DATA
    @Test
    @Disabled
    public void should_test_spiral() {
        int[][] expected = new int[][]{
                {1,1,1,1,1},
                {0,0,0,0,1},
                {1,1,1,0,1},
                {1,0,0,0,1},
                {1,1,1,1,1}};

        assertArrayEquals(expected, SpiralClockwisePath.spiralize(5));
    }
    @BeforeAll
    static void setupThis(){
        System.out.println("NEW TESTS");
    }

    @Test
    public void test5through50() {
        IntStream.rangeClosed(5, 50).forEach(this::test);
    }

    @Test
    public void test100() {
        test(100);
    }

    private void test(int n) {
        int[][] expected = $Spiralizor.spiralize(n);
        int[][] actual = SpiralClockwisePath.spiralize(n);
        assertArrayEquals("Test for n = " + n, expected, actual);
    }

    private final static class $Spiralizor {

        private static int[][] spiralize(int n) {
            int[][] ary = IntStream.range(0, n)
                    .mapToObj(i -> IntStream.range(0, n)
                            .map(j -> {
                                int min = Math.min(Math.min(i, j), Math.min(n - i - 1, n - j - 1));
                                return j == min && i == min + 1 ? min % 2 : 1 - min % 2;
                            })
                            .toArray())
                    .toArray(int[][]::new);
            if (n % 2 == 0) {
                ary[n / 2][n / 2 - 1] = 0;
            }
            return ary;
        }

    }
}
