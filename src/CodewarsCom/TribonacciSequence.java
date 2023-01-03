package CodewarsCom;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/*
https://www.codewars.com/kata/556deca17c58da83c00002db
*/
public class TribonacciSequence {

    private TribonacciSequence variabonacci;

    @Before
    public void setUp() throws Exception {
        variabonacci = new TribonacciSequence();
    }

    @After
    public void tearDown() throws Exception {
        variabonacci = null;
    }

    private static double precision = 1e-10;

    public static void main(String[] args) {
        sampleTests();
    }

// Test DATA
    @Test
    public static void sampleTests() {
        assertArrayEquals(new double []{}, tribonacci(new double []{300,200,100},0), precision);
        assertArrayEquals(new double []{1}, tribonacci(new double []{1,1,1},1), precision);
        assertArrayEquals(new double []{1,1,1}, tribonacci(new double []{1,1,1},3), precision);
        assertArrayEquals(new double []{1,1,1,3}, tribonacci(new double []{1,1,1},4), precision);
        assertArrayEquals(new double []{0,0,0,0,0,0,0,0,0,0}, tribonacci(new double []{0,0,0},10), precision);
        assertArrayEquals(new double []{1,1,1,3,5,9,17,31,57,105}, tribonacci(new double []{1,1,1},10), precision);
        assertArrayEquals(new double []{0,0,1,1,2,4,7,13,24,44}, tribonacci(new double []{0,0,1},10), precision);
        assertArrayEquals(new double []{0,1,1,2,4,7,13,24,44,81}, tribonacci(new double []{0,1,1},10), precision);
        assertArrayEquals(new double []{1,2,3,6,11,20,37,68,125,230}, tribonacci(new double []{1,2,3},10), precision);
        assertArrayEquals(new double []{3,2,1,6,9,16,31,56,103,190}, tribonacci(new double []{3,2,1},10), precision);
        assertArrayEquals(new double []{0.5,0.5,0.5,1.5,2.5,4.5,8.5,15.5,28.5,52.5,96.5,177.5,326.5,600.5,1104.5,2031.5,3736.5,6872.5,12640.5,23249.5,42762.5,78652.5,144664.5,266079.5,489396.5,900140.5,1655616.5,3045153.5,5600910.5,10301680.5}, tribonacci(new double []{0.5,0.5,0.5},30), precision);

    }

// VER_1
//    public static double[] tribonacci(double[] s, int n) {
//        // hackonacci me
//        double[] result = new double[n];
//        if (n >= 1) result[0] = s[0];
//        if (n >= 2) result[1] = s[1];
//        if (n >= 3) {
//            result[2] = s[2];
//            for (int i = 3; i < n; i++){
//                result[i] = result[i-1] + result[i-2] + result[i-3];
//            }
//        }
////        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
//        return result;
//    }

// VER_2
    public static double[] tribonacci(double[] s, int n) {
        // hackonacci me
        double[] result = new double[n];
        result = Arrays.copyOf(s, n);
//        for (int i = 0; i < n && i < 3; i++) result[i] = s[i];
        for (int i = 3; i < n; i++){
            result[i] = result[i-1] + result[i-2] + result[i-3];
        }
//        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
        return result;
    }

// VER_3
//    public static double[] tribonacci(double[] s, int n) {
//        // hackonacci me
//        double[] result = new double[n];
//        for (int i = 0; i < n; i++){
//            result[i] = (i < 3) ? s[i] : result[i-1] + result[i-2] + result[i-3];
//        }
////        System.out.println(Arrays.stream(result).boxed().collect(Collectors.toList()));
//        return result;
//    }
}
