package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.stream.*;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/5324945e2ece5e1f32000370
*/

public class SumStringsAsNumbers {


// VER_3
    public static String sumStrings(String a, String b) {
        a = a.replaceAll("^[0]*", "");
        b = b.replaceAll("^[0]*", "");

        List<Integer> result = new ArrayList<>();
        int maxL = Math.max(a.length(), b.length());
        int sum = 0;
//        System.out.println("a=" + a + " | b=" +b + " | maxL=" +maxL);
        for (int i = 1; i <= maxL; i++){
            if (i <= a.length())
                sum += Integer.valueOf(a.substring(a.length()-i, a.length()-i+1));
            if (i <= b.length())
                sum += Integer.valueOf(b.substring(b.length()-i, b.length()-i+1));
            if (sum <= 9)
                result.add(0, sum);
            else
                result.add(0, sum % 10);

            sum = sum / 10;
        }
        if (sum != 0)
            result.add(0, sum);

        return result.stream().map(Object::toString)
                .collect(Collectors.joining(""));
    }


// VER_2 (works but long)
//    public static String sumStrings(String a, String b) {
//        a = a.replaceAll("^[0]*", "");
//        b = b.replaceAll("^[0]*", "");
//
//        if (a=="" && b=="") return "";
//        if (a=="") return b;
//        if (b=="") return a;
//
//        List<Long> result = new ArrayList<>();
//        int minL = Math.min(a.length(), b.length());
//        System.out.println("a=" + a + " | b=" +b + " | minL=" +minL);
//
//        Long sum = 0L;
//        Long prev = 0L;
//        for (int i = 1; i <= minL; i++){
//            sum = Long.valueOf(a.substring(a.length()-i, a.length()-i+1)) + Long.valueOf(b.substring(b.length()-i, b.length()-i+1)) + prev;
////     System.out.println("sum=" + sum);
//            if (sum > 9) {
//                prev = sum / 10;
//                sum = sum % 10;
//            } else prev = 0L;
//            result.add(0, sum);
//        }
//
//        if (a.length() > b.length()) {
//            for (int i = minL+1; i <= a.length(); i++){
//                sum = Long.valueOf(a.substring(a.length()-i, a.length()-i+1)) + prev;
//                result.add(0, sum);
//                prev = 0L;
//            }
//        }
//        if (a.length() < b.length()) {
//            for (int i = minL+1; i <= b.length(); i++){
//                sum = Long.valueOf(b.substring(b.length()-i, b.length()-i+1)) + prev;
//                result.add(0, sum);
//                prev = 0L;
//            }
//        }
//        if (prev != 0) result.add(0, prev);
//
//        return result.stream().map(Object::toString)
//                .collect(Collectors.joining(""));
//    }


// VER_1 (bad - Long/Integer range exception)
//    public static String sumStrings(String a, String b) {
//        a = a.replaceAll("^[0]*", "");
//        b = b.replaceAll("^[0]*", "");
//
//        if (a=="" && b=="") return "";
//        if (a=="") return b;
//        if (b=="") return a;
//
//        List<Long> result = new ArrayList<>();
//        int minL = Math.min(a.length(), b.length());
//        System.out.println("a=" + a + " | b=" +b + " | minL=" +minL);
//
//        Long sum = 0L;
//        Long prev = 0L;
//        for (int i = 1; i <= minL; i++){
//            sum = Long.valueOf(a.substring(a.length()-i, a.length()-i+1)) + Long.valueOf(b.substring(b.length()-i, b.length()-i+1)) + prev;
////            System.out.println("sum=" + sum);
//            if (sum > 9) {
//                prev = sum / 10;
//                sum = sum % 10;
//            } else prev = 0L;
//            result.add(0, sum);
//        }
//
//  // from here - Long/Integer range exception
//        if (a.length() > b.length()) {
//            sum = Long.parseLong(a.substring(0, a.length()-minL)) + Long.valueOf(prev);
//            result.add(0, sum);
//            prev = 0L;
//        }
//        if (a.length() < b.length()) {
//            sum = Long.parseLong(b.substring(0, b.length()-minL)) + Long.valueOf(prev);
//            result.add(0, sum);
//            prev = 0L;
//        }
//        if (prev != 0) result.add(0, prev);
//
//        return result.stream().map(Object::toString)
//                .collect(Collectors.joining(""));
//
////        return String.join(", ", result);     // for String type
//
////        return (Long.valueOf(a) + Long.valueOf(b))+"";
//    }



// Test DATA
    @Test
    public void test() {
        assertEquals("", SumStringsAsNumbers.sumStrings("", ""));
        assertEquals("123", SumStringsAsNumbers.sumStrings("123", ""));
        assertEquals("579", SumStringsAsNumbers.sumStrings("123", "456"));
        assertEquals("8670", SumStringsAsNumbers.sumStrings("00103", "08567"));
        assertEquals("4732645148990", SumStringsAsNumbers.sumStrings("04731866636287", "778512703"));
        assertEquals("33108439251581655732", SumStringsAsNumbers.sumStrings("57028276230172", "0033108382223305425560"));
        assertEquals("63043630186641032007853", SumStringsAsNumbers.sumStrings("063043630185887805333271", "753226674582"));
    }
    Random r = new Random();
    public String randomNums() {
        int l = r.nextInt(30) + 3;
        String s = "";
        for (int i = 0; i < l; i++) {
            s += r.nextInt(9);
        }
        return s;
    }
    @Test
    public void randomTests() {
        for (int i =0; i < 50; i++) {
            String s = randomNums();
            String s2 = randomNums();
//            assertEquals(solve(s, s2), SumStringsAsNumbers.sumStrings(s, s2), String.format("Incorrect answer for inputs:\na=\"%s\"\nb=\"%s\"\n", s, s2));
            assertEquals(solve(s, s2), SumStringsAsNumbers.sumStrings(s, s2));
        }
    }
    public String solve(String s, String s2) {
        String result = "";
        s2 = "0".repeat(s.length() < s2.length() ? 0: s.length() - s2.length())+s2;
        s = "0".repeat(s2.length() < s.length() ? 0: s2.length() - s.length())+s;
        int remainder = 0;
        for (long i = s.length()-1; i >= 0; i--) {
            int n = Integer.parseInt(s.charAt((int) i) + "");
            n += Integer.parseInt(s2.charAt((int) i) + "");
            n += remainder;
            remainder = n/10;
            result = n%10 + result;
        }
        result = remainder == 0 ? result: remainder + result;
        while (result.startsWith("0")) {
            result = result.substring(1, result.length());
        }
//        System.out.println("++ result=" + result);
        return result;
    }
}
