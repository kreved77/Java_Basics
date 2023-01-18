package CodewarsCom;

import org.junit.Test;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/*
https://www.codewars.com/kata/513e08acc600c94f01000001
*/

public class ConvertRGBToHex {

// VER_1
    public static String rgb(int r, int g, int b) {
        String result = "";
        result += r <= 0 ? "00" : r >= 255 ? "FF" : r <= 15 ? "0" + Integer.toHexString(r) : Integer.toHexString(r);
        result += g <= 0 ? "00" : g >= 255 ? "FF" : g <= 15 ? "0" + Integer.toHexString(g) : Integer.toHexString(g);
        result += b <= 0 ? "00" : b >= 255 ? "FF" : b <= 15 ? "0" + Integer.toHexString(b) : Integer.toHexString(b);
        System.out.printf("For input: (%d, %d, %d) -> %s \n",r,g,b,result.toUpperCase());
        return result.toUpperCase();
    }


// VER_2
/*
    public static String rgb(int r, int g, int b) {
//        if(r <= 0) r = 0;
//        if(r >= 255) r = 255;

//        r = (r > 0) ? (r < 255) ? r : 255 : 0;
//        g = (g > 0) ? (g < 255) ? g : 255 : 0;
//        b = (b > 0) ? (b < 255) ? b : 255 : 0;

        r = (r <= 0) ? 0 : (r >= 255) ? 255 : r;
        g = (g <= 0) ? 0 : (g >= 255) ? 255 : g;
        b = (b <= 0) ? 0 : (b >= 255) ? 255 : b;

        return String.format("%02X%02X%02X", r, g, b);
    }
*/


// VER_3
/*
    public static String rgb(int r, int g, int b) {

        return Stream.of(r, g, b)
                .map(i -> Math.max(0, i))
                .map(i -> Math.min(255, i))
                .map(i -> String.format("%02X", i))
                .collect(Collectors.joining());
    }
*/


// Test DATA
    @Test
    public void sampleTests() {
        assertEquals("For input: (0, 0, 0)", "000000", ConvertRGBToHex.rgb(0, 0, 0));
        assertEquals("For input: (1, 2, 3)", "010203", ConvertRGBToHex.rgb(1, 2, 3));
        assertEquals("For input: (255, 255, 255)", "FFFFFF", ConvertRGBToHex.rgb(255, 255, 255));
        assertEquals("For input: (254, 253, 252)", "FEFDFC", ConvertRGBToHex.rgb(254, 253, 252));
        assertEquals("For input: (-20, 275, 125)", "00FF7D", ConvertRGBToHex.rgb(-20, 275, 125));
    }
    @Test
    public void randomTests() {
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomR = random.nextInt(455) - 100;
            int randomG = random.nextInt(455) - 100;
            int randomB = random.nextInt(455) - 100;

            String toHexRandomR = toHex(randomR);
            String toHexRandomG = toHex(randomG);
            String toHexRandomB = toHex(randomB);

            assertEquals(String.format("For input: (%d, %d, %d)",randomR,randomG,randomB), toHexRandomR + toHexRandomG + toHexRandomB, ConvertRGBToHex.rgb(randomR, randomG, randomB));
        }
    }
    private static String toHex(int c) {
        if (c < 0) c = 0;
        if (c > 255) c = 255;

        String cHex = Integer.toHexString(c);
        if (cHex.length() == 1) {
            cHex = "0" + cHex;
        }

        return cHex.toUpperCase();
    }
}
