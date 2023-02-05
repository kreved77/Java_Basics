package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/56a5d994ac971f1ac500003e
*/

public class LongestConsecutiveStrings {


// VER_1
    public static String longestConsec(String[] strarr, int k) {
        List<String> list = new ArrayList<>(Arrays.asList(strarr));
        String result = "";
        for (int i = 0; i <= list.size() - k; i++){
            String str = "";
            for (int j = 0; j < k; j++) {
                str += list.get(i+j);
            }
            result = (result.length() < str.length()) ? str : result;
        }
        return result;
    }


// VER_2
//    public static String longestConsec(String[] strarr, int k) {
//        if (k <= 0) {
//            return "";
//        }
//
//        return IntStream.rangeClosed(0, strarr.length - k)
//                .mapToObj(i -> Arrays.stream(strarr, i, i + k).collect(Collectors.joining()))
//                .max(Comparator.comparingInt(String::length))
//                .orElse("");
//    }


// VER_3
//    public static String longestConsec(String[] strarr, int k) {
//        return (strarr.length > 0 && k > 0 && k <= strarr.length) ?
//                IntStream.rangeClosed(0, strarr.length - k)
//                        .mapToObj(i -> IntStream.range(0, k)
//                                .mapToObj(j -> strarr[i + j])
//                                .collect(Collectors.joining()))
//                        .sorted((s1, s2) -> Integer.compare(s2.length(), s1.length()))
//                        .findFirst()
//                        .get()
//                : "";
//    }



// Test DATA
    @Test
    public void test() {
        System.out.println("longestConsec Fixed Tests");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail"}, 2), "abigailtheta");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1), "oocccffuucccjjjkkkjyyyeehh");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {}, 3), "");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"itvayloxrp","wkppqsztdkmvcuwvereiupccauycnjutlv","vweqilsfytihvrzlaodfixoyxvyuyvgpck"}, 2), "wkppqsztdkmvcuwvereiupccauycnjutlvvweqilsfytihvrzlaodfixoyxvyuyvgpck");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"wlwsasphmxx","owiaxujylentrklctozmymu","wpgozvxxiu"}, 2), "wlwsasphmxxowiaxujylentrklctozmymu");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"zone", "abigail", "theta", "form", "libe", "zas"}, -2), "");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 3), "ixoyx3452zzzzzzzzzzzz");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 15), "");
        assertEquals(LongestConsecutiveStrings.longestConsec(new String[] {"it","wkppv","ixoyx", "3452", "zzzzzzzzzzzz"}, 0), "");
    }

}
