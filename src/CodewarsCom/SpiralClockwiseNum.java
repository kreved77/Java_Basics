package CodewarsCom;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

/*
https://www.codewars.com/kata/536a155256eb459b8700077e
*/
public class SpiralClockwiseNum {


// VER_1
//    private enum Dir {RIGHT, DOWN, LEFT, UP}
    public static int[][] createSpiral(int n) {
        int[][] result = new int[n][n];
        int num = 1;        // current number
        int lastNum = n * n;
        int h = 0;              // index height int[h][ ]
        int w = 0;              // index  width int[ ][w]
        int top = 0;            // index height up   (min)
        int bottom = n - 1;     // index height down (max)
        int left = 0;           // index  width left  (min)
        int right = n - 1;      // index  width right (max)
        char dir = 'r';         // index move direction r→, d↓, l←, u↑
//        Dir direction = Dir.RIGHT;         // index move direction r→, d↓, l←, u↑
        while (num <= lastNum) {
            result[h][w] = num;
            switch (dir) {
                case 'r':
                    w++;
                    if (w==right) {
                        dir = 'd';
                        top++;
                    }
                    break;
                case 'd':
                    h++;
                    if (h==bottom) {
                        dir = 'l';
                        right--;
                    }
                    break;
                case 'l':
                    w--;
                    if (w==left) {
                        dir = 'u';
                        bottom--;
                    }
                    break;
                case 'u':
                    h--;
                    if (h==top) {
                        dir = 'r';
                        left++;
                    }
                    break;
            }
            num++;
        }
        printArray(result);
        return result;
    }

    private static void printArray(int[][] result) {
        int maxValue = Arrays.stream(result[result.length/2]).max().getAsInt();
//        int maxValue = result.length * result.length;
        System.out.print("NEW (maxValue="+ maxValue +")\n");
        for (int[] row : result) {
            for (int i : row) {
            // with Zero's
//                if (maxValue > 1000)        System.out.printf("%04d ", i);
//                else if (maxValue > 100)    System.out.printf("%03d ", i);
//                else if (maxValue > 10)     System.out.printf("%02d ", i);
//                else                        System.out.printf("%01d ", i);
            // without Zero's
                if (maxValue > 1000)        System.out.printf("%5d", i);
                else if (maxValue > 100)    System.out.printf("%4d", i);
                else if (maxValue > 10)     System.out.printf("%3d", i);
                else                        System.out.printf("%2d", i);
            }
            System.out.print("\n");
        }
    }


// VER_2
//    public int[][] createSpiral(int N) {
//        if (N < 1)
//            return new int[][]{};
//
//        SpiralArray spiralArray = new SpiralArray(N);
//        int[][] ints = new int[N][N];
//
//        ints[0][0] = 1;
//        for (int i = 2; i <= N * N; i++) {
//            spiralArray.goClockwise();
//            ints[spiralArray.getX()][spiralArray.getY()] = i;
//        }
//
//        return ints;
//    }
//
//    private static class SpiralArray {
//        private final int dim;
//        private int y;
//        private int x;
//        private int topOffset;
//        private int leftOffset;
//        private int rightOffset;
//        private int bottomOffset;
//
//        private enum Direction {RIGHT, DOWN, LEFT, UP}
//
//        private Direction direction;
//
//        public SpiralArray(int N) {
//            this.topOffset = 0;
//            this.leftOffset = 0;
//            this.rightOffset = 0;
//            this.bottomOffset = 0;
//            this.dim = N;
//            this.y = 0;
//            this.x = 0;
//            this.direction = Direction.RIGHT;
//        }
//
//        public void goClockwise() {
//            switch (direction) {
//                case RIGHT:
//                    y++;
//                    if (y == dim - 1 - rightOffset) {
//                        direction = Direction.DOWN;
//                        topOffset++;
//                    }
//                    break;
//                case DOWN:
//                    x++;
//                    if (x == dim - 1 - bottomOffset) {
//                        direction = Direction.LEFT;
//                        rightOffset++;
//                    }
//                    break;
//                case LEFT:
//                    y--;
//                    if (y == leftOffset) {
//                        direction = Direction.UP;
//                        bottomOffset++;
//                    }
//                    break;
//                case UP:
//                    x--;
//                    if (x == topOffset) {
//                        direction = Direction.RIGHT;
//                        leftOffset++;
//                    }
//                    break;
//            }
//        }
//
//        public int getY() {
//            return y;
//        }
//
//        public int getX() {
//            return x;
//        }
//    }



// Test DATA
    @Test
    public void should_test_spiral() {
        int[][] expected = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}};

        assertArrayEquals(expected, SpiralClockwiseNum.createSpiral(3));
    }

//    TheClockwiseSpiral spiral = new TheClockwiseSpiral();

    private static int[][] check7894(int N) {
        int[][] a = new int[N][N];
        int[] steps = {0, 1, 0, -1};
        int turn = 0;

        int c = 1;
        int i = 0;
        int j = 0;
        int passed = 0;

        while (N > 0) {
            a[i][j] = c;

            if ((c - passed) % N == 0) {
                passed += N;
                if (turn % 2 == 0)
                    N--;
                turn++;
            }

            i += steps[(turn + 4) % 4];
            j += steps[(turn + 5) % 4];
            c++;
        }
        return a;
    }
    @Test
    public void randomized_30_tests() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int n = random.nextInt(50);
            int[][] expected = check7894(n);
            Assert.assertArrayEquals(expected, SpiralClockwiseNum.createSpiral(n));
        }
    }
}
