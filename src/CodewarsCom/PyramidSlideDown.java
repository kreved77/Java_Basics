package CodewarsCom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/551f23362ff852e2ab000037
*/

public class PyramidSlideDown {

// VER_3 (real longestSlideDown)
    public static int longestSlideDown(int[][] pyramid) {

        for (int i = pyramid.length - 2; i >= 0 ; i--){
            int index = 0;
            while (index < pyramid[i].length) {
                pyramid[i][index] += Math.max(pyramid[i+1][index], pyramid[i+1][index+1]);
//                System.out.printf("  add [%d][%d] = %d\n", i, index, pyramid[i][index]);
                index++;
            }
        }

        System.out.println(pyramid[0][0]);
        return pyramid[0][0];
    }


// VER_2 (bad - it counts the single path only:
//      takes the first value
//      -> go in the row below and sum the greater of two values
//      -> then (under that value) checks two values which is greater and sum it
//      -> go under it ...)

//    public static int longestSlideDown(int[][] pyramid) {
//        int result = pyramid[0][0];
//        int index = 0;
//        for (int i = 1; i < pyramid.length; i++){
//
//            System.out.println(" [" + i + "][" + index + "]: " + pyramid[i][index] + " | or | " + pyramid[i][index+1] + " (next)");
//            result += (pyramid[i][index] > pyramid[i][index+1]) ? pyramid[i][index] : pyramid[i][++index];
//            System.out.println("    add: " + pyramid[i][index] + " | result=" + result);
//
////         if (pyramid[i][index] >= pyramid[i][index+1]) {
////           result += pyramid[i][index];
////         } else {
////           result += pyramid[i][index+1];
////           index++;
////         }
//
//        }
//        return result;
//    }


// VER_1 (bad - counts the sum of max values in each row)
//    public static int longestSlideDown(int[][] pyramid) {
//        int result = pyramid[0][0];
//        for (int i = 1; i < pyramid.length; i++){
//            int val = Arrays.stream(pyramid[i]).max().getAsInt();
//            result += val;
//            System.out.println("  add: " + val + " | result=" + result);
//        }
//        System.out.println(result);
//        return result;
//    }



// Test DATA
/*
                                   [[75],
                                  [95, 64],
                                [17, 47, 82],
                              [18, 35, 87, 10],
                            [20, 4,  82, 47, 65],
                          [19, 1, 23,  75, 3,  34],
                        [88,  2, 77, 73,  7, 63, 67],
                      [99, 65,  4, 28,  6, 16, 70, 92],
                    [41, 41, 26, 56, 83, 40, 80, 70, 33],
                  [41, 48, 72, 33, 47, 32, 37, 16, 94, 29],
                [53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14],
              [70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57],
            [91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48],
          [63, 66,  4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31],
         [4, 62, 98, 27, 23,  9, 70, 98, 73, 93, 38, 53, 60,  4, 23]]
*/
    @Test
    public void test() {
        int[][] test = new int[][]{{75},
                {95, 64},
                {17, 47, 82},
                {18, 35, 87, 10},
                {20, 4, 82, 47, 65},
                {19, 1, 23, 75, 3, 34},
                {88, 2, 77, 73, 7, 63, 67},
                {99, 65, 4, 28, 6, 16, 70, 92},
                {41, 41, 26, 56, 83, 40, 80, 70, 33},
                {41, 48, 72, 33, 47, 32, 37, 16, 94, 29},
                {53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14},
                {70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57},
                {91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48},
                {63, 66, 4, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31},
                {4, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 4, 23},
        };
        assertEquals(1074, PyramidSlideDown.longestSlideDown(test));
    }
    @Test
    public void test2() {
        int[][] test = new int[][] {{3}, {7, 4}, {2, 4, 6}, {8, 5, 9, 3}};
        assertEquals(23, PyramidSlideDown.longestSlideDown(test));
    }
}
