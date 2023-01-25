package CodewarsCom;

/*
https://www.codewars.com/kata/57eb8fcdf670e99d9b000272
*/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HighestScoringWord {

// VER_2
//    public static String high(String s) {
//        return Arrays.stream(s.split(" "))
//                .max(Comparator.comparingInt(
//                        a -> a.chars()
//                                .map(i -> i - 96)
//                                .sum()
//                ))
//                .get();
//    }

// VER_1
    public static String high(String s) {
        String[] sArr = s.split(" ");
//        System.out.println("=== NEW string=" + Arrays.toString(sArr));
        int sumMax = 0;
        int indexMax = 0;
        for (int i = 0; i < sArr.length; i++){
//            System.out.println("  new word = " + sArr[i]);
            int sum = 0;
            for (Integer c : sArr[i].chars().toArray()){
                sum += c - 96;      // for (char) 'a' code is 97
            }
//            System.out.println("       sum = " + sum);
            indexMax = (sum > sumMax) ? i : indexMax;
            sumMax = (sum > sumMax) ? sum : sumMax;
        }
//        System.out.println("=== Result is: " + sArr[indexMax]);

        return sArr[indexMax];
    }



// Test DATA
    @Test
    public void sampleTests() {
        assertEquals("taxi", high("man i need a taxi up to ubud"));
        assertEquals("volcano", high("what time are we climbing up to the volcano"));
        assertEquals("semynak", high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", high("aa b"));
        assertEquals("b", high("b aa"));
        assertEquals("bb", high("bb d"));
        assertEquals("d", high("d bb"));
        assertEquals("aaa", high("aaa b"));
    }
    // Reference implmenetation for random tests
    private static String _high(String s) {
        return Stream.of(s.split(" "))
                .sorted(Comparator.comparing((String a) -> a.chars().map(b -> b - 96).sum()).reversed())
                .findFirst().get();
    }
    @Test
    public void randomTests() {
        String chars = "      abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();

        for (int i = 0; i < 100; ++i) {
            String test = IntStream.range(10, random.nextInt(201))
                    .mapToObj(x -> Character.toString(chars.charAt(random.nextInt(chars.length()))))
                    .collect(Collectors.joining()).trim().replaceAll("\\s+", " ");

            String expected = _high(test);
            String actual = high(test);

            assertEquals(expected, actual);
        }
    }
}
