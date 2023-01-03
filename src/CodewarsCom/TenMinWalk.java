package CodewarsCom;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.awt.*;
import java.util.List;

/*
https://www.codewars.com/kata/54da539698b8a2ad76000228
*/
public class TenMinWalk {
    public static void main(String[] args) {
        Test();
    }

// Test DATA
    @Test
    public static void Test() {
        assertEquals("Should return true", true, TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return true", true, TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','s','s'}));
        assertEquals("Should return true", true, TenMinWalk.isValid(new char[] {'e','w','e','w','n','s','n','s','e','w'}));
        assertEquals("Should return true", true, TenMinWalk.isValid(new char[] {'n','s','e','w','n','s','e','w','n','s'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'w'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w','n','s','e','w'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','s'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','n'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s','n','s'}));
        assertEquals("Should return false", false, TenMinWalk.isValid(new char[] {'e','e','e','w','n','s','n','s','e','w'}));
    }

// VER_1
    public static boolean isValid(char[] walk) {
        // Insert brilliant code here
        int w = 0;
        int h = 0;
        boolean result = false;
        if (walk.length == 10) {
            for (int i = 0; i < walk.length; i++){
                w = walk[i] == 'n' ? ++w :
                    walk[i] == 's' ? --w : w;
                h = walk[i] == 'e' ? ++h :
                    walk[i] == 'w' ? --h : h;
            }
            result = (w == 0 && h == 0) ? true : false;
        }
//        System.out.println("walk.length=" + walk.length + " | w=" + w + ", h=" + h + " | " + result);
        return result;
    }


// VER_2
//    public static boolean isValid(char[] walk) {
//        // Insert brilliant code here
//        int w = 0, h = 0;
//        boolean result = false;
//        if (walk.length == 10) {
//            for (char c : walk){
//                switch (c) {
//                    case 'n' -> w++;
//                    case 's' -> w--;
//                    case 'e' -> h++;
//                    case 'w' -> h--;
//                }
//            }
//            result = (w == 0 && h == 0) ? true : false;
//        }
////        System.out.printf("%n walk.length=" + walk.length + " | w=" + w + ", h=" + h + " | " + result);
//        return result;
//    }

// VER_3
//    public static boolean isValid(char[] walk) {
//        // Insert brilliant code here
//        Point point = new Point(0,0);
//        for (char c : walk) {
//            switch (c) {
//                case 'n' -> point.translate(0,1);
//                case 's' -> point.translate(0,-1);
//                case 'e' -> point.translate(1,0);
//                case 'w' -> point.translate(-1,0);
//            }
//        }
//        return walk.length == 10 && point.equals(new Point(0,0));
//    }

// VER_4
//    public static boolean isValid(char[] walk) {
//        // Insert brilliant code here
//        String s = new String(walk);
//        return s.chars().count() == 10
//                && s.chars().filter(p -> p == 'n').count() == s.chars().filter(p -> p == 's').count()
//                && s.chars().filter(p -> p == 'e').count() == s.chars().filter(p -> p == 'w').count();
//    }
}
