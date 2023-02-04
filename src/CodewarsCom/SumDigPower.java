package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static org.junit.Assert.*;

/*
https://www.codewars.com/kata/5626b561280a42ecc50000d1
*/

public class SumDigPower {


// VER_1
    public static List<Long> sumDigPow(long a, long b) {
//        System.out.print("\n NEW : ");
        List<Long> list = new ArrayList<>();
        for (long i = a; i <= b; i++){
            long num = i;
            long sum = 0;
            int power = String.valueOf(i).length();
            while (sum < i && power > 0) {
                if (num >= 10) {
                    sum += Math.pow((num % 10), power--);
                    num /= 10;
                } else {
                    sum += Math.pow(num, power--);
                }
            }
            if (i == sum && power == 0) list.add(i);
//            if (i == sum && power == 0) {
//                list.add(i);
//                System.out.print(i + ", ");
//            }
        }
        return list;
    }


// VER_2
//    public static List<Long> sumDigPow(long a, long b) {
//        return LongStream.rangeClosed(a, b)
//                .filter(i -> isValid(i))
//                .boxed()
//                .collect(Collectors.toList());
//    }
//    private static boolean isValid(long x){
//        String value = Long.toString(x);
//        return IntStream.range(0, value.length())
//                .mapToDouble(i -> Math.pow(Character.getNumericValue(value.charAt(i)), i + 1))
//                .sum() == x;
//    }



// Test DATA
    private static void testing(long a, long b, long[] res) {
        assertEquals(Arrays.toString(res),
                Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
    }
    @Test
    public void test() {
        System.out.println("Basic Tests");
        testing(1, 10, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        testing(1, 100, new long[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 89});
        testing(10, 100,  new long[] {89});
        testing(90, 100, new long[] {});
        testing(90, 150, new long[] {135});
        testing(50, 150, new long[] {89, 135});
        testing(10, 150, new long[] {89, 135});
    }
    private static int sumPowerDigitsSol(long num) {
        String s = Long.toString(num, 10); int result = 0;
        for (int i = 0; i < s.length(); i++)
            result += Math.pow(Character.digit(s.charAt(i), 10), i+1);
        return result;
    }
    private static List<Long> sumDigPowSol(long a, long b) {
        List<Long> res = new ArrayList<Long>();
        long nb = a;
        while (nb <= b) {
            if (sumPowerDigitsSol(nb) == nb)
                res.add(nb);
            nb++;
        }
        return res;
    }
    private static int randint(Random rnd, int min, int max) {
        int randomNumber = rnd.nextInt(max - min) + min;
        return randomNumber;
    }
    private static void wTests1()
    {
        for (int i = 0; i < 35; i++) {
            Random rnd = new Random();
            long a = randint(rnd, 100, 500);
            long b = randint(rnd, 1000, 3000);
            assertEquals(Arrays.toString(sumDigPowSol(a, b).toArray()),
                    Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
        }
    }
    @Test
    public void tests1() {
        System.out.println("Random Tests 1 ****");
        wTests1();
    }
    private static void wTests2()
    {
        for (int i = 0; i < 15; i++) {
            Random rnd = new Random();
            long a = randint(rnd, 10, 999);
            long b = randint(rnd, 1100, 3000);
            assertEquals(Arrays.toString(sumDigPowSol(a, b).toArray()),
                    Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
        }
    }
    @Test
    public void tests2() {
        System.out.println("Random Tests 2 ****");
        wTests2();
    }
    private static void wTests3()
    {
        for (int i = 0; i < 10; i++) {
            Random rnd = new Random();
            long a = randint(rnd, 2620000, 2640000);
            long b = randint(rnd, 2647000, 2648000);
            assertEquals(Arrays.toString(sumDigPowSol(a, b).toArray()),
                    Arrays.toString(SumDigPower.sumDigPow(a, b).toArray()));
        }
    }
    @Test
    public void tests3() {
        System.out.println("Random Tests 3 ****");
        wTests3();
    }
}