package CodewarsCom;

import org.junit.Test;

import java.util.*;
import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/5266876b8f4bf2da9b000362
*/

/*
examples:
        []                                -->  "no one likes this"
        ["Peter"]                         -->  "Peter likes this"
        ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
        ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
        ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
*/

public class whoLikesIt {
    public static void main(String[] args) {
        staticTests();
    }

// Test DATA
    @Test
    public static void staticTests() {
        assertEquals("no one likes this", whoLikesIt());
        assertEquals("Peter likes this", whoLikesIt("Peter"));
        assertEquals("Jacob and Alex like this", whoLikesIt("Jacob", "Alex"));
        assertEquals("Max, John and Mark like this", whoLikesIt("Max", "John", "Mark"));
        assertEquals("Alex, Jacob and 2 others like this", whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }


// VER_2
    public static String whoLikesIt(String... names) {
        //Do your magic here
        String[] resultFormat = {"no one likes this",
                "_ likes this",
                "_ and _ like this",
                "_, _ and _ like this",
                "_, _ and # others like this"};
        String result = resultFormat[Math.min(names.length, 4)];
        for (int i = 0; i < Math.min(names.length, 4); i++) {
            result = result.replaceFirst("_", names[i])
                           .replaceFirst("#", String.valueOf(names.length - 2));
        }
        return result;
    }


// VER_1_final
//    public static String whoLikesIt(String... names) {
//        //Do your magic here
//        switch (names.length){
//            case 0: return "no one likes this";
//            case 1: return names[0] + " likes this";
//            case 2: return String.format("%s and %s like this", names[0], names[1]);
//            case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
//            default: return String.format("%s, %s and %d others like this", names[0], names[1], (names.length-2));
//        }
//    }

    // VER_1_1
//    public static String whoLikesIt(String... names) {
//        //Do your magic here
////        System.out.println(names.length);
////        System.out.println(Arrays.toString(names));
//        String result = "";
//        switch (names.length){
//            case 0 -> result = "no one likes this";
//            case 1 -> result = names[0] + " likes this";
//            case 2 -> result = String.format("%s and %s like this", names[0], names[1]);
//            case 3 -> result = String.format("%s, %s and %s like this", names[0], names[1], names[2]);
//            default -> result = String.format("%s, %s and %d others like this", names[0], names[1], (names.length-2));
//        }
////        System.out.println("===> " + result);
//        return result;
//    }
}
