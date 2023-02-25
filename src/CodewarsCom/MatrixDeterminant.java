package CodewarsCom;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/52a382ee44408cea2500074c

A 1x1 matrix |a| has determinant a.

A 2x2 matrix [ [a, b], [c, d] ] or
|a  b|
|c  d|
has determinant: a*d - b*c.

For the 3x3 case, [ [a, b, c], [d, e, f], [g, h, i] ] or
|a b c|
|d e f|
|g h i|
the determinant is: a * det(a_minor) - b * det(b_minor) + c * det(c_minor)
where det(a_minor) refers to taking the determinant of the 2x2 matrix created by crossing out the row and column in which the element a occurs:
|- - -|
|- e f|
|- h i|
Note the alternation of signs.
*/

public class MatrixDeterminant {


// VER_2
    public static int determinant(int[][] matrix) {

        // check if the array is empty
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        if (matrix.length == 1) {
            return matrix[0][0];
        }

        int result = 0;
        int i = 0;
        int sign = 1;
        while (i < matrix.length) {
            int[][] newMatrix = removeRowColumn(matrix, i);
            int determinant = determinant(newMatrix);
            result += sign * matrix[0][i] * determinant;
            i++;
            sign *= -1;
        }

        return result;
    }

    private static int[][] removeRowColumn(int[][] intArray, int indexCol) {
        // check if the array is empty or index is out of bounds
        if (intArray == null || indexCol < 0 | indexCol >= intArray[0].length) {
            throw new RuntimeException("Non-existing indexes - no removal operation can be performed!");
        }
        if (intArray.length == 0 ) {
            throw new RuntimeException("Array is empty!");
        }

        // create an array to hold elements after deletion
        int[][] newArray = new int[intArray.length - 1][intArray.length - 1];
        int row = 0;
        for (int i = 1; i < intArray.length; i++) {
            // copy elements from original array from beginning till index into copyArray
            System.arraycopy(intArray[i], 0, newArray[row], 0, indexCol);

            // copy elements from original array from index+1 till end into copyArray
            System.arraycopy(intArray[i], indexCol + 1, newArray[row], indexCol, intArray.length - indexCol - 1);

            row++;
        }

        return newArray;
    }


// VER_1
//    public static int determinant(int[][] matrix) {
//        return FindDeterminant(matrix);
//    }
//
//
//    private static int FindDeterminant(int[][] matrix) {
//
//        // check if the array is empty
//        if (matrix == null || matrix.length == 0) {
//            return 1;
//        }
//        if (matrix.length == 1) {
//            return matrix[0][0];
//        }
//
//        int result = 0;
//        int i = 0;
//        int sign = 1;
//        while (i < matrix.length) {
//            int[][] newMatrix = removeRowColumn(matrix, 0, i);
//            int determinant = FindDeterminant(newMatrix);
//            result += sign * matrix[0][i] * determinant;
//            i++;
//            sign *= -1;
//        }
//
//        return result;
//    }
//
//    private static int[][] removeRowColumn(int[][] intArray, int indexRow, int indexCol) {
//        // check if the array is empty or index is out of bounds
//        if (intArray == null || indexRow < 0 || indexCol < 0 | indexRow >= intArray.length | indexCol >= intArray[indexRow].length) {
////            throw new RuntimeException("Non-existing indexes - no removal operation can be performed!");
//            System.out.println("Non-existing indexes - no removal operation can be performed!");
//            return intArray;
//        }
//        if (intArray.length == 0 ) {
////            throw new RuntimeException("Array is empty!");
//            System.out.println("Array is empty");
//            return intArray;
//        }
//
//        // create an array to hold elements after deletion
//        int[][] newArray = new int[intArray.length - 1][intArray.length - 1];
//        int row = 0;
//        for (int i = 0; i < intArray.length; i++) {
//            if (i != indexRow) {
//
//                // copy elements from original array from beginning till index into copyArray
//                System.arraycopy(intArray[i], 0, newArray[row], 0, indexCol);
//
//                // copy elements from original array from index+1 till end into copyArray
//                System.arraycopy(intArray[i], indexCol + 1, newArray[row], indexCol, intArray.length - indexCol - 1);
//
//                row++;
//            }
//        }
//
//        return newArray;
//    }



// Test DATA
    private static int[][][] matrix = { {{1}},
                                        {{1, 3}, {2,5}},
                                        {{2,5,3}, {1,-2,-1}, {1, 3, 4}}};

    private static int[] expected = {1, -1, -20};

    private static String[] msg = {"Determinant of a 1 x 1 matrix yields the value of the one element",
            "Should return 1 * 5 - 3 * 2 == -1 ",
            ""};

    @Test
    public void sampleTests() {
        for (int n = 0 ; n < expected.length ; n++)
            assertEquals(msg[n], expected[n], MatrixDeterminant.determinant(matrix[n]));
    }
    private static int[][][] matrix2 = { {{5}},
            {{4, 6}, {3,8}},
            {{2,4,2},{3,1,1},{1,2,0}},
            {{6,1,1}, {4,-2,5}, {2, 8, 7}},
            {{2,4,-3}, {1,8,7}, {2, 3, 5}},
            {{1, 2, 3, 4}, {5, 0, 2, 8}, {3,5,6,7},{2,5,3,1}},
            {{2,5,3,6,3}, {17,5,7,4,2}, {7,8,5,3,2}, {9,4,-6,8,3}, {2,-5,7,4,2}},
            {{1, 2, 4, 0, 9},{2, 3, 4, 1, 1},{6, 7, 3, 9, 3},{2, 0, 3, 0, 2},{4, 5, 2, 3, 1}},
            {{2, 4, 5, 3, 1, 2},{2, 4, 7, 5, 3, 2},{1, 1, 0, 2, 3, 1},{1, 3, 9, 0, 3, 2},{1, 1, 2, 2, 4, 1},{0, 0, 4, 1, 2, 3}},
            {{3, 2, 1, 4, 0, 1},{1, 2, 3, 1, 9, 1},{0, 2, 1, 1, 9, 0},{8, 2, 1, 0, 2, 3},{2, 3, 4, 0, 1, 2},{2, 1, 0, 0, 1, 1}}};

    private static int[] expected2 = {5, 14, 10, -306, 113, 24, 2060, 1328, 88, -536};

    private static String[] msg2 = {"Determinant of a 1 x 1 matrix yields the value of the one element",
            "Should return 4*8 - 3*6, i.e. 14",
            "Should return the determinant of [[2,4,2],[3,1,1],[1,2,0]], i.e. 10",
            "Another 3 x 3 matrix",
            "Another 3 x 3 matrix",
            "A 4x4 matrix",
            "A 5x5 matrix" ,
            "Another 5x5 matrix",
            "",
            ""};

    @Test
    public void moreTests() {
        for (int n = 0 ; n < expected2.length ; n++)
            assertEquals(msg2[n], expected2[n], MatrixDeterminant.determinant(matrix2[n]));
    }

}
