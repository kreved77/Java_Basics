package CodewarsCom;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


// https://www.softwaretestinghelp.com/remove-element-from-array-java/#

public class MatrixDeterminantTry {

    public static void main(String[] args){
//        Integer[][] matrix = {{1,2},{3,4}};               //   -2
//        Integer[][] matrix = {{1,3},{7,5}};               //  -16
//        Integer[][] matrix = {{3,8},{4,6}};               //  -14
//        Integer[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};   //  0
        Integer[][] matrix = {{6,1,1},{4,-2,5},{2,8,7}};   //  -306
//        Integer[][] matrix = new Integer[2][2];
        System.out.println("NEW Array task is: " + Arrays.stream(matrix).map(i -> Arrays.stream(i).toList()).toList());

//        testDelete(matrix);

        int result = FindDeterminant(matrix);
        System.out.println("Result determinant is: " + result);
    }


    private static int FindDeterminant(Integer[][] matrix) {

        // check if the array is empty or index is out of bounds
        if (matrix == null || matrix.length == 0) {
            System.out.println("No matrix");
            return 1;
        }
        if (matrix.length == 1) {
            System.out.println("matrix length = 1");
            return matrix[0][0];
        }

        int result = 0;
        int i = 0;
        int sign = 1;
        while (i < matrix.length) {
            Integer[][] newMatrix = removeRowColumn(matrix, 0, i);
            int determinant = FindDeterminant(newMatrix);
            result += sign * matrix[0][i] * determinant;
            System.out.println("determinant=" + determinant + " || result=" + result);
            i++;
            sign *= -1;
        }

        return result;
    }

    private static Integer[][] removeRowColumn(Integer[][] intArray, int indexRow, int indexCol) {
        // check if the array is empty or index is out of bounds
        if (intArray == null || indexRow < 0 || indexCol < 0 | indexRow >= intArray.length | indexCol >= intArray[indexRow].length) {
//            throw new RuntimeException("Non-existing indexes - no removal operation can be performed!");
            System.out.println("Non-existing indexes - no removal operation can be performed!");
            return intArray;
        }
        if (intArray.length == 0 ) {
//            throw new RuntimeException("Array is empty!");
            System.out.println("Array is empty");
            return intArray;
        }

        // create an array to hold elements after deletion
        Integer[][] newArray = new Integer[intArray.length - 1][intArray.length - 1];
        int row = 0;
        System.out.println("Array after deleting an element [" + indexRow + "][" + indexCol + "]: ");
        for (int i = 0; i < intArray.length; i++) {
            if (i != indexRow) {

                // copy elements from original array from beginning till index into copyArray
                System.arraycopy(intArray[i], 0, newArray[row], 0, indexCol);

                // copy elements from original array from index+1 till end into copyArray
                System.arraycopy(intArray[i], indexCol + 1, newArray[row], indexCol, intArray.length - indexCol - 1);

                // display the copied array after deletion
                System.out.println("  " + Arrays.toString(newArray[row]));

                row++;
            }
        }

        return newArray;
    }

/**

 // example of copy array
 //
 //        // define the array of integers
 //        int[] intArray = { 10,20,30,40,50 };
 //
 //        // display the original array
 //        System.out.println("Original Array: " + Arrays.toString(intArray));
 //
 //        // index at which the element is to be deleted
 //        int index = 2;
 //
 //        // check if the array is empty or index is out of bounds
 //        if (intArray == null || index < 0  || index >= intArray.length) {
 //            System.out.println("No removal operation can be performed!!");
 //        }
 //
 //        // create an array to hold elements after deletion
 //        int[] copyArray = new int[intArray.length - 1];
 //
 //        // copy elements from original array from beginning till index into copyArray
 //        System.arraycopy(intArray, 0, copyArray, 0, index);
 //
 //        // copy elements from original array from index+1 till end into copyArray
 //        System.arraycopy(intArray, index + 1, copyArray, index, intArray.length - index - 1);
 //
 //        // display the copied array after deletion
 //        System.out.println("Array after deleting an element: "
 //                + Arrays.toString(copyArray));

 **/

    // TESTS
    private static void testDelete(Integer[][] data) {
        int r = 1;
        int c = 1;
//        for (Integer[] r : data)
//            r[c] = 0;
//        System.out.println(Arrays.stream(data).map(i -> Arrays.stream(i).toList()).toList());

        Integer[][] tempData = removeRowColumnTest(data, r, c);
        System.out.println(Arrays.stream(tempData).map(i -> Arrays.stream(i).toList()).toList());
    }


    private static Integer[][] removeRowColumnTest(Integer[][] data, int r, int c) {
        if (data == null || r < 0 || c < 0 || r >= data.length || c >= data[r].length) {
//            throw new RuntimeException("non-existing indexes");
            System.out.println("non-existing indexes");
            return data;
        }

        // convert array to List
        List<List<Integer>> arrayList = Arrays.stream(data)
                .map(i -> Arrays.stream(i).collect(Collectors.toList()))
                .collect(Collectors.toList());

        // remove row and columns from List
        arrayList.remove(r);
        int length = data.length-1;
        while (--length > -1)
            arrayList.get(length).remove(c);
        System.out.println(arrayList);

//        Integer[][] tempData = new Integer[0][0];
        Integer[][] tempData = new Integer[data.length-1][data.length-1];

//        return arrayList.stream().mapToObj(i -> i.stream().mapToInt(Integer::intValue).toArray()).toArray();
//        return arrayList.stream().map(i -> i.stream().toList()).toArray();
//        return arrayList.stream().mapToInt(Integer::intValue).toArray();
        return tempData;
//        return data;
    }

}