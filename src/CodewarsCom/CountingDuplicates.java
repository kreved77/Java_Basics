package CodewarsCom;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1
*/

public class CountingDuplicates {

// VER_1
//    public static int duplicateCount(String text) {
//        System.out.println(text);
//        text = text.toLowerCase();
//
//        Set<String> hs = new HashSet<>();
//
//        for (String s : text.split("")){
//            if (text.indexOf(s) != text.lastIndexOf(s)) hs.add(s);
//        }
//
//        return hs.size();
//    }


// VER_2
    public static int duplicateCount(String text) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            map.put(c, map.containsKey(c) ? 1 : 0);
//            map.put(c, map.containsKey(c) ? map.get(c).intValue()+1 : 0);
        }
//        map.forEach((k,v) -> System.out.printf("letter '%s' = %d \n", k, v));

        return (int) map.values().stream().filter(e -> e > 0).count();
    }


// VER_3
//    public static int duplicateCount(String text) {
//        System.out.println(text);
//
//        Long result = text.toLowerCase().chars()
//                         .mapToObj(i -> i)
//                         .collect(Collectors.groupingBy(
//                             Function.identity(),
//                             Collectors.counting()
//                         ))
//
//                         .values()
//                         .stream()
//                         .filter(x -> x > 1)
//                         .count();
//
//        System.out.println(result);
//        return result.intValue();
//    }



// Test DATA
    @Test
    public void sampleTests() {
        assertEquals(0, CountingDuplicates.duplicateCount(""));
        assertEquals(0, CountingDuplicates.duplicateCount("abcde"));
        assertEquals(1, CountingDuplicates.duplicateCount("abcdeaa"));
        assertEquals(2, CountingDuplicates.duplicateCount("abcdeaB"));
        assertEquals(2, CountingDuplicates.duplicateCount("Indivisibilities"));
        assertEquals(0, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyz"));
        assertEquals(2, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzaaAb"));
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
        assertEquals(26, CountingDuplicates.duplicateCount("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"));
    }
}
